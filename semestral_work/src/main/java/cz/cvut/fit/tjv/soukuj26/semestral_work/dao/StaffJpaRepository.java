package cz.cvut.fit.tjv.soukuj26.semestral_work.dao;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StaffJpaRepository extends JpaRepository<Staff, Integer> {

    /**
     * Finds all staff members in database that work in fitness center with given name in "name"
     * @param name given name
     * @return Collection of staff members
     */
    @Query(nativeQuery = true, value = "select s.id_staff from tjv_staff s where exists" +
            " (select f from tjv_fitness_center f where s.id_fitness_center=f.id_fitness_center and f.name = :name) ")
    //@Query("select f.staffInFC from tjv_fitness_center f where f.name =:name")
    Collection<Staff> findByFitnessCenterName(String name);
}