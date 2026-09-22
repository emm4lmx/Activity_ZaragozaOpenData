public class Monument {

    //atributos
    private String title;
    private String horario;
    private Geometry geometry;

    //constructor vacío necesario para Jackson
    public Monument(){}

    //getters y setters
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
