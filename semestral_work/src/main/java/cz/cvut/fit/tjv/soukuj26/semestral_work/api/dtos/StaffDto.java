package cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos;

public class StaffDto {

    private Integer personalNumber;

    private String name;

    private String language;

    private Integer salary;

    private Integer idFitnessCenter;

    private Integer idStaff;

    public StaffDto() {
    }

    public StaffDto(Integer personalNumber, String name, String language, Integer salary, Integer idStaff) {
        this.personalNumber = personalNumber;
        this.name = name;
        this.language = language;
        this.salary = salary;
        this.idStaff = idStaff;
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

    public Integer getIdStaff() {
        return idStaff;
    }

    public Integer getIdFitnessCenter() {
        return idFitnessCenter;
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

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public void setIdFitnessCenter(Integer idFitnessCenter) {
        this.idFitnessCenter = idFitnessCenter;
    }
}
