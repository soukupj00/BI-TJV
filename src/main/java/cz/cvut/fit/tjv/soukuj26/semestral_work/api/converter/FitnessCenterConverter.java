package cz.cvut.fit.tjv.soukuj26.semestral_work.api.converter;

import cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos.FitnessCenterDto;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.FitnessCenter;

import java.util.ArrayList;
import java.util.Collection;

public class FitnessCenterConverter {
    public static FitnessCenter toModel(FitnessCenterDto fitnessCenterDto) {
        return new FitnessCenter(fitnessCenterDto.getName(), fitnessCenterDto.getType());
    }

    public static FitnessCenterDto fromModel(FitnessCenter fitnessCenter) {
        FitnessCenterDto toReturn = new FitnessCenterDto(fitnessCenter.getName(), fitnessCenter.getType().ordinal(), fitnessCenter.getAddress().getIdAddress());
        toReturn.setIdFitnessCenter(fitnessCenter.getIdFitnessCenter());
        return toReturn;
    }

    public static Collection<FitnessCenter> toModelMany(Collection<FitnessCenterDto> fitnessCenterDtos) {
        Collection<FitnessCenter> fitnessCenters = new ArrayList<>();
        fitnessCenterDtos.forEach((f) -> fitnessCenters.add(toModel(f)));
        return fitnessCenters;
    }

    public static Collection<FitnessCenterDto> fromModelMany(Collection<FitnessCenter> fitnessCenters) {
        Collection<FitnessCenterDto> fitnessCenterDtos = new ArrayList<>();
        fitnessCenters.forEach((f) -> fitnessCenterDtos.add(fromModel(f)));
        return fitnessCenterDtos;
    }
}
