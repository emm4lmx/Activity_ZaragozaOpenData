import java.util.List;

/**
 * Represents the {@code geometry} object of each monument.
 * <p>
 * Mirrors the structure of the {@code geometry} property in the JSON
 * returned by the Zaragoza monuments API.
 */

public class Geometry {

    //attributes of geometry (array) (the ones from the JSON)
    private String type;

    //"coordinates" is an array of doubles
    private List<Double> coordinates;

    /**
     * Empty constructor required by Jackson for deserialization.
     */
    public Geometry(){}

    //getters and setters
    public String getType(){return this.type;}
    public void setType(String type) {this.type = type;}

    public List<Double> getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    //getters para la longitud y latitud (encapsulacion dentro de la clase)
    /**
     * returns the longitude (first coordinate of the array).
     * encapsulates the coordinate ordering inside this class so that callers do not need to know the internal estructure.
     * @return the longitude value
     */
    public double getLongitud(){
        return coordinates.get(0);
    }
    /**
     * returns the latitude (second coordinate of the array).
     * @return the latitude value
     */
    public double getLatitud(){
        return coordinates.get(1);
    }
}
