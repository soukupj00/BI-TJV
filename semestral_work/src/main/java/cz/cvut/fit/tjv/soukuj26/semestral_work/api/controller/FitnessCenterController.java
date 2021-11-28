package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.FitnessCenterConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.StaffConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.FitnessCenterDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.exception.NoEntityFoundException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.AddressService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.FitnessCenterService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.StaffService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
public class FitnessCenterController {
    private final FitnessCenterService fitnessCenterService;
    private final AddressService addressService;
    private final StaffService staffService;

    public FitnessCenterController(FitnessCenterService fitnessCenterService, AddressService addressService, StaffService staffService) {
        this.fitnessCenterService = fitnessCenterService;
        this.addressService = addressService;
        this.staffService = staffService;
    }

    @GetMapping("/fitness_centers")
    public Collection<FitnessCenterDto> readAll() {
        return FitnessCenterConverter.fromModelMany(fitnessCenterService.readAll());
    }

    @GetMapping("/fitness_centers/{id}")
    public FitnessCenterDto readOne(@PathVariable Integer id) {
        try {
            return FitnessCenterConverter.fromModel(fitnessCenterService.readById(id).orElseThrow(NoEntityFoundException::new));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Returns collection with all fitness centers where staff member with given ID works
     * @param staff_id given ID
     * @return collection of fitness centers
     */
    @GetMapping("/fitness_centers/staff/{staff_id}")
    public Collection<FitnessCenter> readAllByStaffId (@PathVariable Integer staff_id) {
        try {
            StaffConverter.fromModel(staffService.readById(staff_id).orElseThrow(NoEntityFoundException::new));
            return fitnessCenterService.findByStaffId(staff_id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Staff with given ID does not exist in the database.");
        }
    }

    @PostMapping("/fitness_centers")
    public FitnessCenterDto newAddress(@RequestBody FitnessCenterDto fitnessCenterDto) {
        try {
            Address address = addressService.readById(fitnessCenterDto.getIdAddress()).orElseThrow(NoEntityFoundException::new);
            FitnessCenter fitnessCenterModel = FitnessCenterConverter.toModel(fitnessCenterDto);
            fitnessCenterModel.setAddress(address);
            fitnessCenterService.create(fitnessCenterModel);
            return FitnessCenterConverter.fromModel(fitnessCenterModel);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Not all attributes provided in request.");
        } catch (NoEntityFoundException f) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot create fitness center with address ID that is not present in database.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Fitness center with these attributes already exists in the database.");
        }
    }

    @PutMapping("/fitness_centers/{id}")
    FitnessCenterDto updateFitnessCenter(@RequestBody FitnessCenterDto fitnessCenterDto, @PathVariable Integer id) {
        try {
            Optional<FitnessCenter> fitnessCenter = fitnessCenterService.readById(id);
            Optional<Address> address = addressService.readById(fitnessCenterDto.getIdAddress());

            if (fitnessCenter.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fitness center with given ID does not exist in the database.");
            }
            if (address.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address with given ID does not exist in the database.");
            }

            //update all attributes
            fitnessCenter.get().setName(fitnessCenterDto.getName());
            fitnessCenter.get().setType(fitnessCenterDto.getType());
            fitnessCenter.get().setAddress(address.get());

            fitnessCenterService.update(fitnessCenter.get());
            return FitnessCenterConverter.fromModel(fitnessCenter.get());
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Not all attributes provided in request.");
        }
    }

    @DeleteMapping("/fitness_centers/{id}")
    public void deleteFitnessCenter(@PathVariable Integer id) {
        try {
            FitnessCenterConverter.fromModel(fitnessCenterService.readById(id).orElseThrow(NoEntityFoundException::new));
            fitnessCenterService.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fitness center with give ID does not exist in the database.");
        }
    }
}
