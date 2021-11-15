package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Domain type Staff. Its primary key is idStaff
 */
@Entity(name = "Tjv_staff")
public class Staff implements Serializable {
    /**
     * primary key of Staff
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_staff")
    private Integer idStaff;

    @Column(name = "personal_number", nullable = false, unique = true)
    private Integer personalNumber; //unique across Tjv_staff

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "salary", nullable = false)
    private Integer salary;

    /**
     * Store given attributes in the instance
     * @param personalNumber cannot be null
     * @param name cannot be null
     * @param language cannot be null
     * @param salary cannot be null
     * @throws NullPointerException if any attribute is null
     */
    public Staff(Integer personalNumber, String name, String language, Integer salary) {
        this.personalNumber = Objects.requireNonNull(personalNumber);
        this.name = Objects.requireNonNull(name);
        this.language = Objects.requireNonNull(language);
        this.salary = Objects.requireNonNull(salary);
    }

    //TODO should not be here
    public Staff(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public Staff() {
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    /**
     * Compares this and another instance of Staff by personalNumber
     * @param o other Staff to compare
     * @return true if personalNumbers are same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(getPersonalNumber(), staff.getPersonalNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalNumber());
    }

    @Override
    public String toString() {
        return "Staff{" +
                "personalNumber=" + personalNumber +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", salary=" + salary +
                '}';
    }
}
