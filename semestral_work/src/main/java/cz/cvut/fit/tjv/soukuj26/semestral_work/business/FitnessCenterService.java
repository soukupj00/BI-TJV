package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Business logic operations related to FitnessCenter domain type.
 */
@Component
public class FitnessCenterService {

    public FitnessCenterService() {}

    public void create(FitnessCenter fitnessCenter) throws Exception {
        if (Objects.equals(fitnessCenter.getName(), "fitko")) {
            throw new Exception();
        }
    }

    public void update(FitnessCenter fitnessCenter) throws Exception {
        if (Objects.equals(fitnessCenter.getName(), "fitko")) {
            throw new Exception();
        }

    }

    public FitnessCenter read (String name) throws Exception {
        if (Objects.equals(name, "fitko")) {
            return new FitnessCenter(name);
        }
        throw new Exception();
    }

    public Collection<FitnessCenter> readAll () {
        List<FitnessCenter> tmp = new ArrayList<>();
        FitnessCenter a = new FitnessCenter("aaa");
        FitnessCenter b = new FitnessCenter("bbb");
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
