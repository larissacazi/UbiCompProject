package zimmermann.larissa.elderlylife.Structure;

import java.util.List;

/**
 * Created by laris on 27/11/2017.
 */

public class AppUsersListResponse {
    private List<AppUser> appUsers;

    public AppUsersListResponse(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }
}
