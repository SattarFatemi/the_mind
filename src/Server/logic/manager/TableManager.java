package Server.logic.manager;

import Server.logic.models.Bot;
import Server.network.ClientHandler;

import java.util.ArrayList;

public class TableManager implements Runnable {

    private String nameOfTable;
    private ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private ArrayList<Bot> bots = new ArrayList<>();
    private int numberOfHeartCards;
    private int numberOfNinjaCards;

    public TableManager(String nameOfTable, int totalNumberOfPlayers, ArrayList<ClientHandler> clientHandlers) {
        this.nameOfTable = nameOfTable;
        this.clientHandlers = clientHandlers;
        this.numberOfHeartCards = totalNumberOfPlayers;
        this.numberOfNinjaCards = 3;
        for (int i = 0; i < totalNumberOfPlayers - clientHandlers.size(); i++) {
            Bot bot = new Bot();
            new Thread(bot).start();
            bots.add(bot);
        }
    }

    @Override
    public void run() {

    }
}
