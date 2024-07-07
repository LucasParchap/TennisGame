package fr.tennis;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class TennisGameSteps {
    private TennisGame game;

    @Given("the score is {int}-{int}")
    public void the_score_is(int score1, int score2) {
        game = new TennisGame("Lucas", "Parchap", "Gaël", "Monfils");
        setPlayerScore("Lucas Parchap", score1);
        setPlayerScore("Gaël Monfils", score2);
    }

    @Then("the displayed score should be {string}")
    public void the_displayed_score_should_be(String expectedScore) {
        assertEquals(expectedScore, game.getScore());
    }

    private void setPlayerScore(String player, int points) {
        for (int i = 0; i < points; i++) {
            game.pointWonBy(player);
        }
    }

    @Given("the score is {string}")
    public void the_score_is(String score) {
        game = new TennisGame("Lucas", "Parchap", "Gaël", "Monfils");
        if (score.equals("love-all")) {
            game.resetGame();
        }
    }
    @When("player {string} wins {int} points")
    public void player_wins_points(String player, int points) {
        for (int i = 0; i < points; i++) {
            game.pointWonBy(player);
        }
    }

    @Then("the score should be {string}")
    public void the_score_should_be(String expectedScore) {
        assertEquals(expectedScore, game.getScore());
    }
}
