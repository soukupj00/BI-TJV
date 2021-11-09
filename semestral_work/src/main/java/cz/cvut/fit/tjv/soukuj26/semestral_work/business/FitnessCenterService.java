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

    public FitnessCenter create(FitnessCenter fitnessCenter) throws Exception {
        if (Objects.equals(fitnessCenter.getName(), "fit")) {
            throw new Exception();
        }
        return new FitnessCenter(fitnessCenter.getName(), fitnessCenter.getType());
    }

    public FitnessCenter update(FitnessCenter fitnessCenter) throws Exception {
        if (Objects.equals(fitnessCenter.getName(), "fitko")) {
            return new FitnessCenter(fitnessCenter.getName(), fitnessCenter.getType());
        }
        throw new Exception();

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
        if (Objects.equals(city, "fitko")) {
            return;
        }
        throw new Exception();
    }
}
