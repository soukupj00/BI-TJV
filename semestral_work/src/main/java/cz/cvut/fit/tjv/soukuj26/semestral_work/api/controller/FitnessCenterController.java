package cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter.FitnessCenterConverter;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.FitnessCenterDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.business.FitnessCenterService;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@RestController
public class FitnessCenterController {
    private final FitnessCenterService fitnessCenterService;

    public FitnessCenterController(FitnessCenterService fitnessCenterService) {
        this.fitnessCenterService = fitnessCenterService;
    }

    @GetMapping("/fitness_centers")
    public Collection<FitnessCenterDto> all() {
        return FitnessCenterConverter.fromModelMany(fitnessCenterService.readAll());
    }

    @GetMapping("/fitness_centers/{id}")
    public FitnessCenterDto one(@PathVariable String id) {
        try {
            return FitnessCenterConverter.fromModel(fitnessCenterService.read(id));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/fitness_centers")
    public FitnessCenterDto newAddress(@RequestBody FitnessCenterDto fitnessCenterDto) {
        try {
            FitnessCenter fitnessCenterModel = FitnessCenterConverter.toModel(fitnessCenterDto);
            fitnessCenterService.create(fitnessCenterModel);
            return FitnessCenterConverter.fromModel(fitnessCenterModel);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/fitness_centers/{id}")
    FitnessCenterDto updateFitnessCenter(@RequestBody FitnessCenterDto fitnessCenterDto, @PathVariable String id) {
        try {
            FitnessCenterConverter.fromModel(fitnessCenterService.read(id));
            FitnessCenter fitnessCenter = FitnessCenterConverter.toModel(fitnessCenterDto);
            this.fitnessCenterService.update(fitnessCenter);
            return FitnessCenterConverter.fromModel(fitnessCenter);
        } catch (NullPointerException n) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/fitness_centers/{id}")
    public void deleteFitnessCenter(@PathVariable String id) {
        try {
            FitnessCenterConverter.fromModel(fitnessCenterService.read(id));
            fitnessCenterService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
