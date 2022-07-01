package Client;

import Response.BurntCards;
import Response.Deck;
import Response.GameState;
import Response.Lobby;
import com.google.gson.JsonArray;

import java.io.DataInputStream;

public class ServerListener implements Runnable{
    private final Client client;
    private DataInputStream dis;

    public ServerListener(Client client) {
        this.client = client;
        dis = this.client.getDis();
    }

    @Override
    public void run() {

    }

    private void responseHandler(JsonArray array) {
        String type = array.get(0).getAsString();

        if (type.equals(BurntCards.class.toString())) {

        } else if (type.equals(Deck.class.toString())) {

        } else if (type.equals(GameState.class.toString())) {

        } else if (type.equals(Lobby.class.toString())) {

        }

        // TODO fill if and else ifs
    }
}
