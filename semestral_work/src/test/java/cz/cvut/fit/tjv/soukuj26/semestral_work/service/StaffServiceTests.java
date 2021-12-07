package cz.cvut.fit.tjv.soukuj26.semestral_work.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import cz.cvut.fit.tjv.soukuj26.semestral_work.business.StaffService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.dao.StaffJpaRepository;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StaffServiceTests {

    @InjectMocks
    StaffService staffService;

    @Mock
    StaffJpaRepository staffJpaRepository;

    @Test
    public void testFindAllStaff() {
        List<Staff> list = new ArrayList<>();
        Staff staff1 = new Staff(987,"david", "czech", 19999);
        Staff staff2 = new Staff(986,"pepa", "english", 23000);
        Staff staff3 = new Staff(989,"peter", "slovak", 15000);

        list.add(staff1);
        list.add(staff2);
        list.add(staff3);

        when(staffJpaRepository.findAll()).thenReturn(list);

        Collection<Staff> staffList = staffService.readAll();
        assertEquals(3, staffList.size());
        verify(staffJpaRepository, times(1)).findAll();
    }

    @Test
    public void testCreateStaff() {
        Staff staff = new Staff(1000,"petr", "czech", 18000);
        staffService.create(staff);
        verify(staffJpaRepository, times(1)).save(staff);


    }

}
