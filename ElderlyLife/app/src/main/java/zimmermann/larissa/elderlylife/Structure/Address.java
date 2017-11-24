package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 23/11/2017.
 */

public class Address {
    private String street;
    private int number;
    private String neighbor;
    private String state;
    private String country;
    private String zipcode;

    public Address(String street, int number, String neighbor, String state, String country, String zipcode) {
        this.street = street;
        this.number = number;
        this.neighbor = neighbor;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(String neighbor) {
        this.neighbor = neighbor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
