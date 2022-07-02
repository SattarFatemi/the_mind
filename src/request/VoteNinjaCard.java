package request;

public class VoteNinjaCard {
    public final String authToken;
    public final boolean agree;

    public VoteNinjaCard(String authToken, boolean agree) {
        this.authToken = authToken;
        this.agree = agree;
    }
}
