import java.util.List;

/**
 * represents the top-level JSON response returned by the monuments API.
 */
public class MonumentResponse {

    //attributes of the main JSON object
    //total number of monuments available in the API.
    private int totalCount;

    //index at which the current page starts.
    private int start;

    //number of elements returned by this request
    private int rows;

    //list containing the monuments for this page
    private List<Monument> result;

    /**
     * empty constructor required by Jackson for deserialization.
     */
    public MonumentResponse() {}

    //getters and setters
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
