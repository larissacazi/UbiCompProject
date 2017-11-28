package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 27/11/2017.
 */

public class UserPath {
    private int id; //User id
    private String date;
    private Address address;

    public UserPath(int id, String date, Address address) {
        this.id = id;
        this.date = date;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
