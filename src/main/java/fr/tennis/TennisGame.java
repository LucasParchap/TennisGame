package fr.tennis;

public class TennisGame {
    private TennisPlayer player1;
    private TennisPlayer player2;

    public TennisGame(String player1FirstName, String player1LastName, String player2FirstName, String player2LastName) {
        this.player1 = new TennisPlayer(1, player1FirstName, player1LastName);
        this.player2 = new TennisPlayer(2, player2FirstName, player2LastName);
    }
    public void pointWonBy(String playerName) {
        if (player1.toString().equals(playerName)) {
            player1.winPoint();
        } else if (player2.toString().equals(playerName)) {
            player2.winPoint();
        }
    }
    public String getScore() {

        if (player1.getPoints() >= 4 && player1.getPoints() >= player2.getPoints() + 2) {
            return "Win for " + player1;
        }
        if (player2.getPoints() >= 4 && player2.getPoints() >= player1.getPoints() + 2) {
            return "Win for " + player2;
        }
        return translateScore(player1.getScore()) + "-" + translateScore(player2.getScore());
    }

    private String translateScore(TennisScore score) {
        switch (score) {
            case LOVE:
                return "love";
            case FIFTEEN:
                return "15";
            case THIRTY:
                return "30";
            case FORTY:
                return "40";
            default:
                return "";
        }
    }
    public void resetGame() {
        player1.resetScore();
        player2.resetScore();
    }
}
