package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Member;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StaffJpaRepository extends JpaRepository<Staff, Integer> {
    Collection<Staff> findAllByMyFitnessCenters_Name(String fitnessCenterName);
}
