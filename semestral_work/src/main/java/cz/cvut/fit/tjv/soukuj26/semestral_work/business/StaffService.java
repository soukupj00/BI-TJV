package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Business logic operations related to Staff domain type.
 */
@Component
public class StaffService {

    public StaffService() {}

    public void create(Staff staff) throws Exception {
        if (Objects.equals(staff.getName(), "adam")) {
            throw new Exception();
        }
    }

    public void update(Staff staff) throws Exception {
        if (Objects.equals(staff.getName(), "adam")) {
            throw new Exception();
        }

    }

    public Staff read (String name) throws Exception {
        if (Objects.equals(name, "gert")) {
            return new Staff(name);
        }
        throw new Exception();
    }

    public Collection<Staff> readAll () {
        List<Staff> tmp = new ArrayList<>();
        Staff a = new Staff("pepa");
        Staff b = new Staff("david");
        tmp.add(a);
        tmp.add(b);
        return tmp;
    }

    public void delete(String name) throws Exception {
        if (Objects.equals(name, "david")) {
            throw new Exception();
        }
    }
}
