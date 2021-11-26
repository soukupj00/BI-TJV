package cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos;

import cz.cvut.fit.tjv.soukuj26.semestral_work.domain.TypeOfFitnessCenter;

import java.io.Serializable;

/**
 * Domain type Fitness center
 */
public class FitnessCenterDto implements Serializable { //Serializable may be used by ObjectInputStream and ObjectOutputStream

    private String name;

    private TypeOfFitnessCenter type;

    private Integer idAddress;

    private Integer idFitnessCenter;

    public FitnessCenterDto() {
    }

    public FitnessCenterDto(String name, Integer type, Integer idAddress) {
        this.name = name;
        this.type = TypeOfFitnessCenter.fromInteger(type);
        this.idAddress = idAddress;
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

    public Integer getIdFitnessCenter() {
        return idFitnessCenter;
    }

    public void setIdFitnessCenter(Integer idFitnessCenter) {
        this.idFitnessCenter = idFitnessCenter;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }
}
