package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MemberJpaRepository extends JpaRepository<Member, Integer> {
    Collection<Member> findAllByMyFitnessCenters_Name(String fitnessCenterName);
}
