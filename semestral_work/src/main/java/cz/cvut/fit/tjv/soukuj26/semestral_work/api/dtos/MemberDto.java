package cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.Views;

public class MemberDto {

    @JsonView(Views.Internal.class)
    private Integer personalNumber;

    @JsonView(Views.Internal.class)
    private String email;

    @JsonView(Views.Public.class)
    private String name;

    public MemberDto() {
    }

    public MemberDto(Integer personalNumber, String email, String name) {
        this.personalNumber = personalNumber;
        this.email = email;
        this.name = name;
    }

    public Integer getPersonalNumber() {
        return personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setPersonalNumber(Integer personalNumber) {
        this.personalNumber = personalNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }
}
