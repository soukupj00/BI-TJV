package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * Domain type Address. Its primary key is generated Id (Integer)
 */

public class Address implements Serializable {

    private String city;
    private String street;
    private String postalCode;
    private Integer houseNumber;

    public Address(String city, String street, String postalCode, Integer houseNumber) {
        this.city = Objects.requireNonNull(city);
        this.street = Objects.requireNonNull(street);
        this.postalCode = Objects.requireNonNull(postalCode);
        this.houseNumber = houseNumber;
    }

    public Address() {

    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Compare this and another instance of Address by name and type
     *
     * @param o other address to compare
     * @return true if other instance is also address and has the same attributes
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getCity(), address.getCity()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getPostalCode(), address.getPostalCode()) && Objects.equals(getHouseNumber(), address.getHouseNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCity(), getStreet(), getPostalCode(), getHouseNumber());
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
