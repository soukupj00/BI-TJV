package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import java.io.Serializable;
import java.util.Objects;

public class Member implements Serializable {

    private Integer personalNumber; //unique
    private String email;
    private String name;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Member(Integer personalNumber, String email, String name) {
        this.personalNumber = Objects.requireNonNull(personalNumber);
        this.email = Objects.requireNonNull(email);
        this.name = Objects.requireNonNull(name);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(getPersonalNumber(), member.getPersonalNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonalNumber());
    }

    @Override
    public String toString() {
        return "Member{" +
                "personalNumber=" + personalNumber +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
