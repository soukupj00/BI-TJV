package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.AddressConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.AddressDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.exception.NoEntityFoundException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.AddressService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {this.addressService = addressService;}

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
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Entity with these attributes already exists in the database.");
        }
    }

    //Updates address with corresponding id
    @PutMapping("/addresses/{id}")
    public AddressDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable Integer id) {
        try {
            AddressConverter.fromModel(addressService.readById(id).orElseThrow(NoEntityFoundException::new));
            Address address = AddressConverter.toModel(addressDto);
            addressService.update(address);
            return AddressConverter.fromModel(address);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        try {
            AddressConverter.fromModel(addressService.readById(id).orElseThrow(NoEntityFoundException::new));
            addressService.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
