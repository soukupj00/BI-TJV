package cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.Views;

public class StaffDto {

    @JsonView(Views.Internal.class)
    private Integer personalNumber;

    @JsonView(Views.Public.class)
    private String name;

    @JsonView(Views.Public.class)
    private String language;

    @JsonView(Views.Internal.class)
    private Integer salary;

    public StaffDto() {
    }

    public StaffDto(Integer personalNumber, String name, String language, Integer salary) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.language = language;
        this.salary = salary;
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
}
