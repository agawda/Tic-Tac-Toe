package pl.javaacademy.tictactoe.game;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlayersTest {
    @Test
    public void testPlayersBetterPlayerReturnedCorrectly() {
        Players players = new Players();
        players.addPlayer(new Player("A", Mark.X));
        players.addPlayer(new Player("B", Mark.O));
        players.addPlayerScoreThreePoints(Mark.X);
        assertEquals(java.util.Optional.of(players.getPlayerScore(Mark.X)), java.util.Optional.of(3));
        assertEquals(players.getPlayerWithBetterScore(), Mark.X);
    }

    @Test
    public void testAddScoreBothPlayers() {
        Players players = new Players();
        players.addPlayer(new Player("A", Mark.X));
        players.addPlayer(new Player("B", Mark.O));
        players.addBothPlayersScoreOnePoint();
        assertEquals(players.getPlayerWithBetterScore(), Mark.EMPTY);
    }
}
