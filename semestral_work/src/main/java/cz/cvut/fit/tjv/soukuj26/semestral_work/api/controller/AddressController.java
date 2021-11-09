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

    @GetMapping("/addresses")
    public Collection<AddressDto> all() {
        return AddressConverter.fromModelMany(addressService.readAll());
    }

    @PostMapping("/addresses")
    public AddressDto newAddress(@RequestBody AddressDto newAddress) {
        Address addressModel = AddressConverter.toModel(newAddress);
        try {
            this.addressService.create(addressModel);
            addressModel = this.addressService.read(addressModel.getCity());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return AddressConverter.fromModel(addressModel);
    }

    @GetMapping("/addresses/{id}")
    public AddressDto one(@PathVariable String id) {
        try {
            return AddressConverter.fromModel(addressService.read(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/addresses/{id}")
    AddressDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable String id) {
        try {
            addressService.read(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Address address = AddressConverter.toModel(addressDto);
        try {
            this.addressService.update(address);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return addressDto;
    }

    @DeleteMapping("/addresses/{id}")
    public void deleteAddress(@PathVariable String id) {
        try {
            addressService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
