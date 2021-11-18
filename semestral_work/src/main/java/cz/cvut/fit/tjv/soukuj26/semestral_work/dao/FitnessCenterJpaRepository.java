package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Address;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Member;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface FitnessCenterJpaRepository extends JpaRepository<FitnessCenter, Integer> {
    FitnessCenter findByAddress(Address address);

    FitnessCenter findByMembersInFC(Member member);

    FitnessCenter findByStaffInFC(Staff staff);
}