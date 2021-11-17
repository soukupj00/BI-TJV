package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfFitnessCenter type;

    /**
     * Multiple fitness centers can be on same address
     */
    @ManyToOne
    @JoinColumn(name = "fitness_center_address")
    private Address address;

    /**
     * Staff that work in this fitness center. Each staff can work in this place only once
     */
    @ManyToMany
    @JoinTable(name = "Tjv_fitness_center_staff",
               joinColumns = @JoinColumn(name = "id_fitness_center"),
               inverseJoinColumns = @JoinColumn(name = "id_staff")
              )
    private Set<Staff> staffInFC = new HashSet<>();

    /**
     * Members that are in club in this fitness center. Each member can be in club in this place only once
     */
    @ManyToMany
    @JoinTable(name = "Tjv_fitness_center_member",
               joinColumns = @JoinColumn(name = "id_fitness_center"),
               inverseJoinColumns = @JoinColumn(name = "id_member")
              )
    private Set<Member> membersInFC = new HashSet<>();

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

    public Collection<Staff> getStaffInFC() {
        return Collections.unmodifiableCollection(staffInFC);
    }

    /**
     * Add given staff among those who work in this fitness center.
     * @param staff staff to add
     * @throws NullPointerException if the staff is null
     */
    public void addStaff(Staff staff) {
        staffInFC.add(Objects.requireNonNull(staff));
    }

    public Collection<Member> getMembersInFC() {
        return Collections.unmodifiableCollection(membersInFC);
    }

    /**
     * Add given member among those who are in club in this fitness center.
     * @param member member to add
     * @throws NullPointerException if the member is null
     */
    public void addMember(Member member) {
        membersInFC.add(Objects.requireNonNull(member));
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
