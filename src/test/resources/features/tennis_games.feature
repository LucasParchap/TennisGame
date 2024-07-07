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

    Scenario: Player wins a game
      Given the score is "love-all"
      When player "Lucas Parchap" wins 4 points
      Then the score should be "Win for Lucas Parchap"
