package zimmermann.larissa.elderlylife.Structure;

import java.util.List;

/**
 * Created by laris on 05/12/2017.
 */

public class TagList {
    private List<Tag> data;

    public TagList(List<Tag> data) {
        this.data = data;
    }

    public List<Tag> getData() {
        return data;
    }

    public void setData(List<Tag> data) {
        this.data = data;
    }
}
