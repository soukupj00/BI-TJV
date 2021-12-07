package cz.cvut.fit.tjv.soukuj26.semestral_work.app;


import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.AddressController;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.FitnessCenterController;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.StaffController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FitnessCenterAppTests {

    @Autowired
    AddressController addressController;
    @Autowired
    FitnessCenterController fitnessCenterController;
    @Autowired
    StaffController staffController;

    @Test
    public void contextLoadTests() {
        Assertions.assertThat(addressController).isNotNull();
        Assertions.assertThat(fitnessCenterController).isNotNull();
        Assertions.assertThat(staffController).isNotNull();
    }
}
