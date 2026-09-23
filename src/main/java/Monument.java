/**
 * represents a single monument as returned by the API.
 * each field corresponds to a property of a monument in the JSON.
 */

public class Monument {

    //each field corresponds to a JSON property of a monument    ç
    private String title;
    private String horario;

    //typed as Geometry because it is a nested object inside "monuments"    ç
    private Geometry geometry;

    /**
     *empty constructor required by Jackson for deserialization.
     */
    public Monument(){}

    //getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public Geometry getGeometry() {
        return geometry;
    }
    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }
}
