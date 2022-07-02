package request;

public class SelectName {
    public final String authToken;
    public final String selectedName;

    public SelectName(String authToken, String selectedName) {
        this.authToken = authToken;
        this.selectedName = selectedName;
    }
}
