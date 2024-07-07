package fr.tennis;

public class TennisPlayer {
    private int playerNumber;
    private String firstName;
    private String lastName;
    private int points;

    public TennisPlayer(int playerNumber, String firstName, String lastName) {
        this.playerNumber = playerNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.points = 0;
    }

    public TennisScore getScore() {
        return TennisScore.fromPoints(points);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void winPoint() {
        this.points++;
    }
    public void losePoint() {
        this.points--;
    }

    public void resetScore() {
        this.points = 0;
    }
    public int getPoints() { return points; }

    public int getPlayerNumber() {
        return playerNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
