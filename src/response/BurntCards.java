package response;

import java.util.ArrayList;

public class BurntCards {
    public final ArrayList<String> playersNames;
    public final ArrayList<ArrayList<Integer>> burntCards;

    public BurntCards(ArrayList<String> playersNames, ArrayList<ArrayList<Integer>> burntCards) {
        this.playersNames = playersNames;
        this.burntCards = burntCards;
    }
}
