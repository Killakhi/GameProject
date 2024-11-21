package Engine.Battle;

public class PartyStats {
    public static PartyStats INSTANCE = new PartyStats();

    public static FriendlyStats PLAYER = new FriendlyStats();
    public static FriendlyStats MAYA = new FriendlyStats();
    public static FriendlyStats DAMION = new FriendlyStats();

    public static FriendlyStats statsForTurn(int turn) {
        switch (turn) {
            case 0:
                return PLAYER;
            case 1:
                return MAYA;
            case 2:
                return DAMION;
            default:
                return null;
        }
    }
}
