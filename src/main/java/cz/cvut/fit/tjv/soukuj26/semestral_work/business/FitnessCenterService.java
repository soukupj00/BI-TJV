package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.business.exceptions.EntityStateException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.dao.FitnessCenterJpaRepository;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Business logic operations related to FitnessCenter domain type.
 */
@Component
public class FitnessCenterService extends AbstractCrudService<Integer, FitnessCenter, FitnessCenterJpaRepository> {


    protected FitnessCenterService(FitnessCenterJpaRepository repository) {
        super(repository);
    }

    @Override
    protected boolean exists(FitnessCenter entity) {
        return repository.existsById(entity.getIdFitnessCenter());
    }

    /**
     * Attempts to find fitness center that has staff with given id
     * @param id of staff
     * @return instance of fitness center / empty
     */
    public Collection<FitnessCenter> findByStaffId (Integer id) {
        return repository.findAllFitnessCentersByStaffId(id);
    }

    @Override
    public void create(FitnessCenter entity) throws EntityStateException {
        super.create(entity);
    }

    @Override
    public Optional<FitnessCenter> readById(Integer id) {
        return super.readById(id);
    }

    @Override
    public Collection<FitnessCenter> readAll() {
        return super.readAll();
    }

    @Override
    public void update(FitnessCenter entity) throws EntityStateException {
        super.update(entity);
    }

    public void removeStaffRelation (Staff staff) {
        List<FitnessCenter> fitnessCenters = repository.findAll();
        for (FitnessCenter fitnessCenter : fitnessCenters) {
            fitnessCenter.removeStaff(staff);
        }
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }
}
