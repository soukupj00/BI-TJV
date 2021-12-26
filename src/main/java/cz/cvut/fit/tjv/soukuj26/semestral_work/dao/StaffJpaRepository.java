package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StaffJpaRepository extends JpaRepository<Staff, Integer> {

    /**
     * Finds all staff members in database that work in fitness center with given id
     * @param idFitnessCenter given id
     * @return Collection of staff members
     */
    Collection<Staff> findByMyFitnessCenters_IdFitnessCenterEquals(int idFitnessCenter);

}