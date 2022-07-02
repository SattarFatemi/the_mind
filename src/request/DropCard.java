package request;

public class DropCard {
    public final String authToken;
    public final int cardNumber;

    public DropCard(String authToken, int cardNumber) {
        this.authToken = authToken;
        this.cardNumber = cardNumber;
    }
}
