package cz.cvut.fit.tjv.soukuj26.semestral_work.integration;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.AddressController;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.AddressConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.AddressDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.AddressService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AddressIntegrationTests {

    @Autowired
    AddressController addressController;

    @Autowired
    AddressService addressService;

    final String city = "new york";

    @Test
    public void testCreateRead() {

        AddressDto addressDto = new AddressDto(city, "wall street", "234 56", null, null);

        AddressDto addressResult = addressController.newAddress(addressDto);
        AddressDto addressInDatabase = addressController.one(addressResult.getIdAddress());

        //Address with give id has he same city as we provided
        Assertions.assertThat(addressInDatabase).matches(address -> Objects.equals(address.getCity(), city));

        addressController.deleteAddress(addressResult.getIdAddress());
    }
}
