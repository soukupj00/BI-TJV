package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Business logic operations related to Address domain type.
 */
@Component
public class AddressService {

    public AddressService() {}

    public void create(Address address) throws Exception {
        if (Objects.equals(address.getCity(), "praha")) {
            throw new Exception();
        }
    }

    public void update(Address address) throws Exception {
        if (Objects.equals(address.getCity(), "praha")) {
            throw new Exception();
        }

    }

    public Address read (String city) throws Exception {
        if (Objects.equals(city, "praha")) {
            return new Address(city);
        }
        throw new Exception();
    }

    public Collection<Address> readAll () {
        List<Address> tmp = new ArrayList<>();
        Address a = new Address("brno");
        Address b = new Address("praha");
        tmp.add(a);
        tmp.add(b);
        return tmp;
    }

    public void delete(String city) throws Exception {
        if (Objects.equals(city, "praha")) {
            throw new Exception();
        }
    }
}
