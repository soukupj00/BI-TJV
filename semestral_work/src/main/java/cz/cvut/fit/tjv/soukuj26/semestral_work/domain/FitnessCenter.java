package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Domain type Fitness center. Its primary key is idFitnessCenter
 */
@Entity(name = "Tjv_fitness_center")
public class FitnessCenter implements Serializable { //Serializable may be used by ObjectInputStream and ObjectOutputStream
    /**
     * primary key of FitnessCenter
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_fitness_center")
    private Integer idFitnessCenter;

    /**
     * Multiple fitness centers can be on same address
     */
    @ManyToOne
    @JoinColumn(name = "fitness_center_address")
    private Address address;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private TypeOfFitnessCenter type;

    public FitnessCenter() {
    }

    /**
     * Store given name and type in the instance
     * @param name cannot be null
     * @param type cannot be null
     * @throws NullPointerException if given name or type is null
     */
    public FitnessCenter(String name, TypeOfFitnessCenter type) {
        this.name = Objects.requireNonNull(name);
        this.type = Objects.requireNonNull(type);
    }

    public FitnessCenter(String aaa) {
        this.name = aaa;
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

    /**
     * Compare this and another instance of FitnessCenter
     *
     * @param o other fitness center to compare
     * @return true if other instance is also FC and has the same attributes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FitnessCenter that = (FitnessCenter) o;
        return Objects.equals(getName(), that.getName()) && getType() == that.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType());
    }

    @Override
    public String toString() {
        return "Fitness_center{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
