package client;

import response.BurntCards;
import response.Deck;
import response.GameState;
import response.Lobby;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.DataInputStream;
import java.io.IOException;

public class ServerListener implements Runnable{
    private final Client client;
    private DataInputStream dis;

    public ServerListener(Client client) {
        this.client = client;
        dis = this.client.getDis();
    }

    @Override
    public void run() {
        try {
            while (true) {
                try {
                    String responseMessage = dis.readUTF();
                    responseHandler(responseMessage);
                } catch (IOException e) {
                    System.out.println("------- error: Couldn't readUTF!");
                }
            }
        } catch (Exception exception) {
            System.out.println("while loop ended with catch of exception!");
        }
    }

    private void responseHandler(String responseMessage) {
        JsonArray array = new Gson().fromJson(responseMessage, JsonArray.class);
        String type = array.get(0).getAsString();

        if (type.equals(BurntCards.class.toString())) {

        } else if (type.equals(Deck.class.toString())) {

        } else if (type.equals(GameState.class.toString())) {

        } else if (type.equals(Lobby.class.toString())) {

        }

        // TODO fill if and else ifs
    }
}
