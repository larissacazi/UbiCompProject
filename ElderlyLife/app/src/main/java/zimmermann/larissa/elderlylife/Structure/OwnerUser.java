package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 27/11/2017.
 */

public class OwnerUser {

    private int id;
    private User user;
    private String occupation;
    private int userType = 1;
    private String phone;

    public OwnerUser(int id, User user, String occupation, int userType, String phone) {
        this.id = id;
        this.user = user;
        this.occupation = occupation;
        this.userType = userType;
        this.phone = phone;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
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
}
