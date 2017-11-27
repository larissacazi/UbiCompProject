package zimmermann.larissa.elderlylife.Structure;

import java.util.List;

/**
 * Created by laris on 27/11/2017.
 */

public class UserPathListResponse {
    private List<UserPath> paths;

    public UserPathListResponse(List<UserPath> paths) {
        this.paths = paths;
    }

    public List<UserPath> getPaths() {
        return paths;
    }

    public void setPaths(List<UserPath> paths) {
        this.paths = paths;
    }
}
