package request;

public class NewTable {
    public final String authToken;
    public final String nameOfTable;
    public final int capacity;

    public NewTable(String authToken, String nameOfTable, int capacity) {
        this.authToken = authToken;
        this.nameOfTable = nameOfTable;
        this.capacity = capacity;
    }
}
