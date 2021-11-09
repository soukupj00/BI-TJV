package cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.Views;
import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.TypeOfFitnessCenter;

import java.io.Serializable;

/**
 * Domain type Fitness center
 */
public class FitnessCenterDto implements Serializable { //Serializable may be used by ObjectInputStream and ObjectOutputStream

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private TypeOfFitnessCenter type;

    public FitnessCenterDto() {
    }

    public FitnessCenterDto(String name, TypeOfFitnessCenter type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfFitnessCenter getType() {
        return type;
    }

    public void setType(TypeOfFitnessCenter type) {
        this.type = type;
    }
}
