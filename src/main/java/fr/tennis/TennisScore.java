package fr.tennis;

public enum TennisScore {

        LOVE(0),
        FIFTEEN(1),
        THIRTY(2),
        FORTY(3);

    private final int points;

    TennisScore(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public static TennisScore fromPoints(int points) {
        for (TennisScore score : values()) {
            if (score.getPoints() == points) {
                return score;
            }
        }
        throw new IllegalArgumentException("Invalid points: " + points);
    }
}
