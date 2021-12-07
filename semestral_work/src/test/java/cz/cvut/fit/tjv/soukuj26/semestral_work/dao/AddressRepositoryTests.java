package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AddressRepositoryTests {

    @Autowired
    AddressJpaRepository addressJpaRepository;

    @Test
    public void testCreateReadDelete() {
        Address address = new Address("praha", "dejvicka", "666 06", 12);

        addressJpaRepository.save(address);

        Iterable<Address> addresses = addressJpaRepository.findAll();
        Assertions.assertThat(addresses).isNotEmpty();

        addressJpaRepository.deleteAll();

        /*
            instances of address are present in the database, thankfully this test does not remove them
            from the main database, but cannot assert that database is empty, as shows next assertion
         */

        Iterable<Address> addressesAfterDelete = addressJpaRepository.findAll();
        // instances in database that are present outside of this test
        Assertions.assertThat(addressesAfterDelete).isNotEmpty();
    }
}
