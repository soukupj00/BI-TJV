package cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.AddressDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;

import java.util.ArrayList;
import java.util.Collection;

public class AddressConverter {

    public static Address toModel(AddressDto userDto) {
        return new Address(userDto.getCity(), userDto.getStreet(), userDto.getPostalCode(), userDto.getHouseNumber());
    }

    public static AddressDto fromModel(Address address) {
        return new AddressDto(address.getCity(), address.getStreet(), address.getPostalCode(), address.getHouseNumber(), address.getIdAddress());
    }

    public static Collection<Address> toModelMany(Collection<AddressDto> addressDtos) {
        Collection<Address> addresses = new ArrayList<>();
        addressDtos.forEach((a) -> addresses.add(toModel(a)));
        return addresses;
    }

    public static Collection<AddressDto> fromModelMany(Collection<Address> addresses) {
        Collection<AddressDto> addressDtos = new ArrayList<>();
        addresses.forEach((a) -> addressDtos.add(fromModel(a)));
        return addressDtos;
    }
}
