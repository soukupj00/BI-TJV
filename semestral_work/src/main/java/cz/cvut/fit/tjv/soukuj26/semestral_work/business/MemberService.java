package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.business.exceptions.EntityStateException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.dao.MemberJpaRepository;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Member;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Business logic operations related to Member domain type.
 */
@Component
public class MemberService extends AbstractCrudService<Integer, Member, MemberJpaRepository> {


    protected MemberService(MemberJpaRepository repository) {
        super(repository);
    }

    @Override
    protected boolean exists(Member entity) {
        return repository.existsById(entity.getIdMember());
    }

    //Finds all members in fitness center with given name
    public Collection<Member> findAllByFC (String name) {
        return repository.findAllByMyFitnessCenters_Name(name);
    }

    //Creates new entity and saves it in database
    @Override
    public void create(Member entity) throws EntityStateException {
        super.create(entity);
    }

    //Finds entity with given id
    @Override
    public Optional<Member> readById(Integer id) {
        return super.readById(id);
    }

    @Override
    public Collection<Member> readAll() {
        return super.readAll();
    }

    @Override
    public void update(Member entity) throws EntityStateException {
        super.update(entity);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }


}
