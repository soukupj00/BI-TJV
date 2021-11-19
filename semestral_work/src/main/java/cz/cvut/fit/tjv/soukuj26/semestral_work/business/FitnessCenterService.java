package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.business.exceptions.EntityStateException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.dao.FitnessCenterJpaRepository;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Jpa21Utils;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

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
     * Attempts to find fitness center that has member with given id
     * @param id of member
     * @return instance of fitness center / empty
     */
    public Optional<FitnessCenter> findByMemberId (Integer id) {
        return Optional.of(repository.findByMembersInFC_id(id));
    }

    /**
     * Attempts to find fitness center that has staff with given id
     * @param id of staff
     * @return instance of fitness center / empty
     */
    public Optional<FitnessCenter> findByStaffId (Integer id) {
        return Optional.of(repository.findByStaffInFC_id(id));
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

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }
}
