package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FitnessCenterJpaRepository extends JpaRepository<FitnessCenter, Integer> {
    /**
     * Find all fitness centers where given staff member works at
     * @param idStaff id of staff member
     * @return Collection of fitness centers
     */
    @Query("select distinct t from tjv_fitness_center t join t.staffInFC staffInFC where staffInFC.idStaff = ?1")
    Collection<FitnessCenter> findAllFitnessCentersByStaffId(Integer idStaff);
}