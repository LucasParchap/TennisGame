Feature: Tennis Game Scoring
  Rule: Basic Point Scoring
        The scoring system is rather simple:
        Each player can have either of these points in one game: “love”, “15”, “30”, “40”.
        If you have 40 and you win the point, you win the game.

    Scenario Outline: Verify basic various scores in a tennis game
      Given the score is <score1>-<score2>
      Then the displayed score should be "<expectedScore>"

      Examples:
        | score1 | score2 | expectedScore |
        | 0      | 0      | love-love     |
        | 0      | 1      | love-15       |
        | 1      | 0      | 15-love       |
        | 3      | 0      | 40-love       |
        | 2      | 1      | 30-15         |
        | 1      | 2      | 15-30         |
        | 2      | 3      | 30-40         |
        | 3      | 2      | 40-30         |
        | 3      | 2      | 40-30         |

    Scenario: Player wins a game
      Given the score is "love-all"
      When player "Lucas Parchap" wins 4 points
      Then the score should be "Win for Lucas Parchap"

  Rule: Verify special scoring rules in a tennis game
        If both have 40 the players are “deuce”.
        If the game is in deuce, the winner of a point will have advantage.
        If the player with advantage wins the ball he wins the game.
        If the player without advantage wins they are back at deuce.

    Scenario Outline: Verify special scoring rules in a tennis game
      Given the score is <score1>-<score2>
      When player "Lucas Parchap" wins 1 point
      Then the displayed score should be "<expectedScore>"

      Examples:
        | score1 | score2 | expectedScore           |
        | 2      | 3      | deuce                   |
        | 3      | 3      | Advantage Lucas Parchap |


    Scenario: Players reach deuce
      Given the score is 3-3
      Then the displayed score should be "deuce"


    Scenario: Players reach deuce
      Given the score is 3-3
      Then the displayed score should be "deuce"

    Scenario: Player reaches advantage
      Given the score is 4-3
      Then the displayed score should be "Advantage Lucas Parchap"