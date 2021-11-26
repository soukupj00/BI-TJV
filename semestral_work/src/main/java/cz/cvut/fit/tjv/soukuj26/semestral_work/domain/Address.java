package cz.cvut.fit.tjv.soukuj26.semestral_work.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Domain type Address. Its primary key is idAddress
 */
@Entity(name = "tjv_address")
public class Address implements Serializable {
    /**
     * primary key of Address
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_address")
    private Integer idAddress = 0;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "house_number")
    private Integer houseNumber;

    /**
     * Store given parameters in the instance
     * @param city cannot be null
     * @param street cannot be null
     * @param postalCode cannot be null
     * @param houseNumber can be null
     * @throws NullPointerException if city, street or postalCode is null
     */
    public Address(String city, String street, String postalCode, Integer houseNumber) {
        this.city = Objects.requireNonNull(city);
        this.street = Objects.requireNonNull(street);
        this.postalCode = Objects.requireNonNull(postalCode);
        this.houseNumber = houseNumber;
    }

    public Address() {

    }

    public Integer getIdAddress() {
        return idAddress;
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
     * Compare this and another instance of Address
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
                "idAddress=" + idAddress +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", houseNumber=" + houseNumber +
                '}';
    }
}
