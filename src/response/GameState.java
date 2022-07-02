package response;

import java.util.ArrayList;

public class GameState {
    public final ArrayList<String> playersNames;
    public final ArrayList<Integer> numberOfCardsInHand;
    public final int cardOnTheTable;

    public GameState(ArrayList<String> playersNames, ArrayList<Integer> numberOfCardsInHand, int cardOnTheTable) {
        this.playersNames = playersNames;
        this.numberOfCardsInHand = numberOfCardsInHand;
        this.cardOnTheTable = cardOnTheTable;
    }
}
