package cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.StaffDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;

import java.util.ArrayList;
import java.util.Collection;

public class StaffConverter {

    public static Staff toModel(StaffDto staffDto) {
        return new Staff(staffDto.getPersonalNumber(), staffDto.getName(), staffDto.getLanguage(), staffDto.getSalary());
    }

    public static StaffDto fromModel(Staff staff) {
        return new StaffDto(staff.getPersonalNumber(), staff.getName(), staff.getLanguage(), staff.getSalary());
    }

    public static Collection<Staff> toModelMany(Collection<StaffDto> staffDtos) {
        Collection<Staff> staff = new ArrayList<>();
        staffDtos.forEach((s) -> staff.add(toModel(s)));
        return staff;
    }

    public static Collection<StaffDto> fromModelMany(Collection<Staff> staff) {
        Collection<StaffDto> staffDtos = new ArrayList<>();
        staff.forEach((s) -> staffDtos.add(fromModel(s)));
        return staffDtos;
    }
}
