package cz.cvut.fit.tjv.soukuj26.semestral_work.api.dtos;

public class AddressDto {

    private String city;

    private String street;

    private String postalCode;

    private Integer houseNumber;

    private Integer idAddress;

    public AddressDto() {
    }

    public AddressDto(String city, String street, String postalCode, Integer houseNumber, Integer idAddress) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.idAddress = idAddress;
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

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }
}
