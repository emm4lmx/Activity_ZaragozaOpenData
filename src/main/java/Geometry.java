import java.util.List;

public class Geometry {
    //representa el objeto geometry de cada monument

    //atributos de geometry (array) (los del json)
    private String type;
    //porque coordinates es un array de doubles
    private List<Double> coordinates;

    //constructor vacío necesario para Jackson
    public Geometry(){}

    //getters y setters
    public String getType(){return this.type;}
    public void setType(String type) {this.type = type;}

    public List<Double> getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    //getters para la longitud y latitud (encapsulacion dentro de la clase)
    public double getLongitud(){
        //devuelve la primera coordenada del array (longitud)
        return coordinates.get(0);
    }
    public double getLatitud(){
        //devuelve la sengunda coordenada del array (latitud)
        return coordinates.get(1);
    }

}
