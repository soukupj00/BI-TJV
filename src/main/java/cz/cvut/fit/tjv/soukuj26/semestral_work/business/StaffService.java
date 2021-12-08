package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.business.exceptions.EntityStateException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.dao.StaffJpaRepository;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

/**
 * Business logic operations related to Staff domain type.
 */
@Component
public class StaffService extends AbstractCrudService<Integer, Staff, StaffJpaRepository> {


    protected StaffService(StaffJpaRepository repository) {
        super(repository);
    }
    FitnessCenterService fitnessCenterService;

    @Override
    protected boolean exists(Staff entity) {
        return repository.existsById(entity.getIdStaff());
    }

    //Finds all staff members in fitness center with given name
    public Collection<Staff> findAllByFC (String name) {
        return repository.findDistinctByMyFitnessCenters_NameEquals(name);
    }

    @Override
    public void create(Staff entity) throws EntityStateException {
        super.create(entity);
    }

    @Override
    public Optional<Staff> readById(Integer id) {
        return super.readById(id);
    }

    @Override
    public Collection<Staff> readAll() {
        return super.readAll();
    }

    @Override
    public void update(Staff entity) throws EntityStateException {
        super.update(entity);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }
}
