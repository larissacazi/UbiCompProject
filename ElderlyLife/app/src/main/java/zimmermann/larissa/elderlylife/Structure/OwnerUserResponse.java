package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 27/11/2017.
 */

public class OwnerUserResponse {

    private int id;
    private User user;
    private String occupation;
    private UserType userType;
    private String phone;

    public OwnerUserResponse(int id, User user, String occupation, UserType userType, String phone) {
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
