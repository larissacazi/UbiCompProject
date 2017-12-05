package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 05/12/2017.
 */

public class UserType {
    int id;
    String type;

    public UserType() {
    }

    public UserType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
