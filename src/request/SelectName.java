package request;

public class SelectName {
    public final String authToken;
    public final String nameOfUser;

    public SelectName(String authToken, String nameOfUser) {
        this.authToken = authToken;
        this.nameOfUser = nameOfUser;
    }
}
