package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import java.io.Serializable;
import java.util.Objects;

public class Staff implements Serializable {

    private Integer personalNumber; //unique
    private String name;
    private String language;
    private Integer salary;

    public Staff() {
    }

    public Staff(String name) {
        this.name = Objects.requireNonNull(name);
    }

    public Staff(Integer personalNumber, String name, String language, Integer salary) {
        this.personalNumber = Objects.requireNonNull(personalNumber);
        this.name = Objects.requireNonNull(name);
        this.language = Objects.requireNonNull(language);
        this.salary = Objects.requireNonNull(salary);
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
