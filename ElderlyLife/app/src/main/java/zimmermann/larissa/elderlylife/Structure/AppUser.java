package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 27/11/2017.
 */

public class AppUser {
    private int id;
    private User user;
    private int userType = 2;
    private String phone;
    private Address residentialAddress;

    public AppUser(int id, User user, int userType, String phone, Address residentialAddress) {
        this.id = id;
        this.user = user;
        this.userType = userType;
        this.phone = phone;
        this.residentialAddress = residentialAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserType() {
        return userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(Address residentialAddress) {
        this.residentialAddress = residentialAddress;
    }
}
