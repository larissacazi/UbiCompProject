package zimmermann.larissa.elderlylife.Structure;

/**
 * Created by laris on 27/11/2017.
 */

public class Point {
    private String type = "Point";
    private double[] coordinates;


    public Point(String type, double[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }
}
