package cz.cvut.fit.tjv.soukuj26.semestral_work.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.AddressController;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.AddressDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.AddressService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.FitnessCenterService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(AddressController.class)
public class AddressControllerTests {

    @MockBean
    AddressService addressService;

    @MockBean
    FitnessCenterService fitnessCenterService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testFindAll() throws Exception {
        Address address1 = new Address("praha", "strahovska", "408 80", 55);
        Address address2 = new Address("brno", "brnenska", "420 69", null);
        List<Address> addresses = List.of(address1, address2);

        Mockito.when(addressService.readAll()).thenReturn(addresses);

        mockMvc.perform(get("/addresses"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].city", Matchers.is("praha")))
                .andExpect(jsonPath("$[0].street", Matchers.is("strahovska")))
                .andExpect(jsonPath("$[1].city", Matchers.is("brno")))
                .andExpect(jsonPath("$[1].houseNumber", Matchers.is(Matchers.nullValue())));

        mockMvc.perform(get("/adrs")).andExpect(status().isNotFound());
    }
}
