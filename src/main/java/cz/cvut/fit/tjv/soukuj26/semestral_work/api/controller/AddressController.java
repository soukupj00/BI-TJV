package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.AddressConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.AddressDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.exception.NoEntityFoundException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.AddressService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.FitnessCenterService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.Optional;

@RestController
public class AddressController {
    private final AddressService addressService;
    private final FitnessCenterService fitnessCenterService;

    public AddressController(AddressService addressService, FitnessCenterService fitnessCenterService) {this.addressService = addressService;
        this.fitnessCenterService = fitnessCenterService;
    }

    //Gets all addresses from database
    @GetMapping("/addresses")
    public Collection<AddressDto> all() {
        return AddressConverter.fromModelMany(addressService.readAll());
    }

    //Gets AddressDTO with corresponding id from database
    @GetMapping("/addresses/{id}")
    public AddressDto one(@PathVariable Integer id) {
        try {
            return AddressConverter.fromModel(addressService.readById(id).orElseThrow(NoEntityFoundException::new));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address with given ID was not found.");
        }
    }

    //Creates new address
    @PostMapping("/addresses")
    public AddressDto newAddress(@RequestBody AddressDto addressDto) {
        try {
            Address addressModel = AddressConverter.toModel(addressDto);
            addressService.create(addressModel);
            return AddressConverter.fromModel(addressModel);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Required attribute of address is missing.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Address with these attributes already exists in the database.");
        }
    }

    //Updates address with corresponding id
    @PutMapping("/addresses/{id}")
    public AddressDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable Integer id) {
        try {
            Optional<Address> address = addressService.readById(id);

            if (address.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address with given ID does not exist in the database.");
            }

            //update attributes of address
            address.get().setCity(addressDto.getCity());
            address.get().setStreet(addressDto.getStreet());
            address.get().setPostalCode(addressDto.getPostalCode());
            address.get().setHouseNumber(addressDto.getHouseNumber());

            addressService.update(address.get());
            return AddressConverter.fromModel(address.get());
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Required attribute of address is missing.");
        }
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        try {
            Address address = addressService.readById(id).orElseThrow(NoEntityFoundException::new);

            /*
            delete any fitness centers that are in relation with this address
            explanation: fitness centers cannot be present in database without proper address
             */
            if (!address.getMyFitnessCenters().isEmpty()) {
                for (FitnessCenter fitnessCenter : address.getMyFitnessCenters()) {
                    fitnessCenterService.deleteById(fitnessCenter.getIdFitnessCenter());
                }
            }

            addressService.deleteById(id);
        } catch (NoEntityFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Address with given ID does not exist in the database.");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot remove address and fitness center from database while staff is assigned to fitness center with this address.");
        }
    }
}
