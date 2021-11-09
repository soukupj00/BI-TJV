package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.AddressConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.AddressDto;
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

    //Gets all addresses from TODO database
    @GetMapping("/addresses")
    public Collection<AddressDto> all() {
        return AddressConverter.fromModelMany(addressService.readAll());
    }

    //Gets AddressDTO with corresponding id from TODO database
    @GetMapping("/addresses/{id}")
    public AddressDto one(@PathVariable String id) {
        try {
            return AddressConverter.fromModel(addressService.read(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //Creates new address
    @PostMapping("/addresses")
    public AddressDto newAddress(@RequestBody AddressDto addressDto) {
        try {
            Address addressModel = AddressConverter.toModel(addressDto);
            this.addressService.create(addressModel);
            return AddressConverter.fromModel(addressModel);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    //Updates address with corresponding id
    @PutMapping("/addresses/{id}")
    public AddressDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable String id) {
        try {
            AddressConverter.fromModel(addressService.read(id));
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
    public void deleteAddress(@PathVariable String id) {
        try {
            AddressConverter.fromModel(addressService.read(id));
            addressService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
