import java.util.List;

public class MonumentResponse {

    //atributos del json principal
    //numero total de monumentos que tiene el API
    private int totalCount;
    //indice desde que empieza
    private int start;
    //numero de elementos que devuelve la petición
    private int rows;
    //array que tiene los monumentos
    private List<Monument> result;

    //constructor vacío necesario para Jackson
    public MonumentResponse() {}

    //getters y setters
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }

    public int getRows() {
        return rows;
    }
    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<Monument> getResult() {
        return result;
    }
    public void setResult(List<Monument> monuments) {
        this.result = monuments;
    }
}
