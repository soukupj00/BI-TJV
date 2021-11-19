package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Domain type Member. Its primary key is idMember
 */
@Entity(name = "Tjv_member")
public class Member implements Serializable {
    /**
     * primary key of Member
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_member")
    private Integer idMember;

    @Column(name = "personal_number", nullable = false, unique = true)
    private Integer personalNumber; //unique across Tjv_member

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "membersInFC")
    private Set<FitnessCenter> myFitnessCenters;

    /**
     * Store given attributes in the instance
     * @param personalNumber cannot be null
     * @param email cannot be null
     * @param name cannot be null
     * @throws NullPointerException if any attribute is null
     */
    public Member(Integer personalNumber, String email, String name) {
        this.personalNumber = Objects.requireNonNull(personalNumber);
        this.email = Objects.requireNonNull(email);
        this.name = Objects.requireNonNull(name);
    }

    public Member() {
    }

    public Integer getIdMember() {
        return idMember;
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

    /**
     * Compares this and another instance of Member by personalNumber
     * @param o other Member to compare
     * @return true if personalNumbers are same
     */
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
