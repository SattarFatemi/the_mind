package response;

import java.util.ArrayList;

public class Lobby {
    public final ArrayList<String> pendingTables;

    public Lobby(ArrayList<String> pendingTables) {
        this.pendingTables = pendingTables;
    }
}
