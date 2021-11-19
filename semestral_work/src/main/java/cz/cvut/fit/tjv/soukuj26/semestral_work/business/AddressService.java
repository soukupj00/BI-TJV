package cz.cvut.fit.tjv.soukuj26.semestral_work.business;

import cz.cvut.fit.tjv.soukuj26.semestral_work.business.exceptions.EntityStateException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.dao.AddressJpaRepository;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Business logic operations related to Address domain type.
 */
@Component
public class AddressService extends AbstractCrudService<Integer, Address, AddressJpaRepository> {

    protected AddressService(AddressJpaRepository repository) {
        super(repository);
    }

    @Override
    protected boolean exists(Address entity) {
        return repository.existsById(entity.getIdAddress());
    }

    @Override
    public void create(Address entity) throws EntityStateException {
        super.create(entity);
    }

    @Override
    public Optional<Address> readById(Integer id) {
        return super.readById(id);
    }

    @Override
    public Collection<Address> readAll() {
        return super.readAll();
    }

    @Override
    public void update(Address entity) throws EntityStateException {
        super.update(entity);
    }

    @Override
    public void deleteById(Integer id) {
        super.deleteById(id);
    }
}
