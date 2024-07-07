package fr.tennis;

import java.util.Random;

public class TennisApp
{
    public static void main( String[] args )
    {

        TennisGame game = new TennisGame("Lucas", "Parchap", "Gaël", "Monfils");
        Random random = new Random();

        while (true) {

            if (random.nextBoolean()) {
                game.pointWonBy("Lucas Parchap");
            } else {
                game.pointWonBy("Gaël Monfils");
            }

            String currentScore = game.getScore();
            System.out.println("Score: " + currentScore);

            if (currentScore.startsWith("Win for")) {
                System.out.println(currentScore);
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
