package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FitnessCenterJpaRepository extends JpaRepository<FitnessCenter, Integer> {

    /**
     * Find all fitness centers where given staff member works at
     * @param staffId id of staff member
     * @return Collection of fitness centers
     */
    Collection<FitnessCenter> findByStaffInFC_idStaff(Integer staffId);
}