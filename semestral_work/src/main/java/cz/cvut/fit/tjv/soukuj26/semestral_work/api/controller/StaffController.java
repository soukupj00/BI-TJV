package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.StaffConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.StaffDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.exception.NoEntityFoundException;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.StaffService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.Staff;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
public class StaffController {
    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/staff")
    public Collection<StaffDto> all() {
        return StaffConverter.fromModelMany(staffService.readAll());
    }

    @GetMapping("/staff/{id}")
    public StaffDto one(@PathVariable String id) {
        try {
            return StaffConverter.fromModel(staffService.read(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/staff")
    public StaffDto newStaff(@RequestBody StaffDto newStaff) {
        try {
            Staff staffModel = StaffConverter.toModel(newStaff);
            this.staffService.create(staffModel);
            return StaffConverter.fromModel(staffModel);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/staff/{id}")
    StaffDto updateStaff(@RequestBody StaffDto staffDto, @PathVariable String id) {
        try {
            StaffConverter.fromModel(staffService.read(id));
            Staff staff = StaffConverter.toModel(staffDto);
            staffService.update(staff);
            return StaffConverter.fromModel(staff);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/staff/{id}")
    public void deleteStaff(@PathVariable String id) {
        try {
            StaffConverter.fromModel(staffService.read(id));
            staffService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
