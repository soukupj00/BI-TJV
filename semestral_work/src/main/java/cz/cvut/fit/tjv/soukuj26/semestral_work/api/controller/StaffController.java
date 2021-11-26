package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.StaffConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.StaffDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.exception.NoEntityFoundException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.FitnessCenterService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.StaffService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
public class StaffController {
    private final StaffService staffService;
    private final FitnessCenterService fitnessCenterService;

    public StaffController(StaffService staffService, FitnessCenterService fitnessCenterService) {
        this.staffService = staffService;
        this.fitnessCenterService = fitnessCenterService;
    }

    @GetMapping("/staff")
    public Collection<StaffDto> all() {
        return StaffConverter.fromModelMany(staffService.readAll());
    }

    @GetMapping("/staff/{id}")
    public StaffDto one(@PathVariable Integer id) {
        try {
            return StaffConverter.fromModel(staffService.readById(id).orElseThrow(NoEntityFoundException::new));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/staff/fitness_center/{fc_name}")
    public Collection<StaffDto> staffByFitnessName(@PathVariable String fc_name) {
        return StaffConverter.fromModelMany(staffService.findAllByFC(fc_name));
    }

    @PostMapping("/staff")
    public StaffDto newStaff(@RequestBody StaffDto newStaff) {
        try {
            Staff staffModel = StaffConverter.toModel(newStaff);
            staffService.create(staffModel);
            return StaffConverter.fromModel(staffModel);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Not all attributes provided in request.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Staff with these attributes already exists in the database.");
        }
    }

    @PutMapping("/staff/{id}")
    StaffDto updateStaff(@RequestBody StaffDto staffDto, @PathVariable Integer id) {
        try {
            Optional<Staff> staff = staffService.readById(id);

            if (staff.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Staff with given ID does not exist in the database.");
            }

            //add relation to fitness center with given id
            if (staffDto.getIdFitnessCenter() != null) {
                Optional<FitnessCenter> fitnessCenter = fitnessCenterService.readById(staffDto.getIdFitnessCenter());

                if (fitnessCenter.isEmpty()) {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fitness center with given ID does not exist in the database.");
                }

                fitnessCenter.get().addStaff(staff.get());
            }
            //TODO give personal number?
            //update attributes of staff member
            staff.get().setPersonalNumber(staffDto.getPersonalNumber());
            staff.get().setName(staffDto.getName());
            staff.get().setLanguage(staffDto.getLanguage());
            staff.get().setSalary(staffDto.getSalary());

            staffService.update(staff.get());
            return StaffConverter.fromModel(staff.get());
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Not all attributes provided in request.");
        }
    }

    @DeleteMapping("/staff/{id}")
    public void deleteStaff(@PathVariable Integer id) {
        try {
            StaffConverter.fromModel(staffService.readById(id).orElseThrow(NoEntityFoundException::new));
            staffService.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Staff with given ID does not exist in the database.");
        }
    }
}
