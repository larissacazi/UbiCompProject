package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 23/11/2017.
 */

public class Address {
    private int id;
    private String zipcode;
    private String street;
    private int number;
    private String neighbor;
    private String city;
    private String state;
    private String country;
    private Point point;

    public Address() {
    }

    public Address(int id, String street, int number, String neighbor, String city, String state, String country, String zipcode, Point point) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.neighbor = neighbor;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.point = point;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
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
