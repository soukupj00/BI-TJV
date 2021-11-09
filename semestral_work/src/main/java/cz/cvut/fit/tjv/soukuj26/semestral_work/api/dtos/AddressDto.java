package cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos;

import com.fasterxml.jackson.annotation.JsonView;
import cz.cvut.fit.tjv.soukuj26.semestral_work.api.controller.Views;

public class AddressDto {

    @JsonView(Views.Public.class)
    private String city;

    @JsonView(Views.Public.class)
    private String street;

    @JsonView(Views.Public.class)
    private String postalCode;

    @JsonView(Views.Public.class)
    private Integer houseNumber;

    public AddressDto() {
    }

    public AddressDto(String city, String street, String postalCode, Integer houseNumber) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
}
