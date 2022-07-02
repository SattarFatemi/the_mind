package request;

public class JoinTable {
    public final String authToken;
    public final String nameOfTable;

    public JoinTable(String authToken, String nameOfTable) {
        this.authToken = authToken;
        this.nameOfTable = nameOfTable;
    }
}
