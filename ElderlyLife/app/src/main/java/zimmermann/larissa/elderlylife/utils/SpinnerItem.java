package zimmermann.larissa.elderlylife.utils;

/**
 * Created by laris on 05/12/2017.
 */

public class SpinnerItem {
    private String title;
    private boolean selected;

    public SpinnerItem(String title, boolean selected) {
        this.title = title;
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
