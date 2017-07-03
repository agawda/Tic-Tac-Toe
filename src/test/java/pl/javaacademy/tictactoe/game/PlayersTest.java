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
        players.addPlayerScoreOnePoint(Mark.O);
        assertEquals(java.util.Optional.of(players.getPlayerScore(Mark.X)), java.util.Optional.of(3));
        assertEquals(java.util.Optional.of(players.getPlayerScore(Mark.O)), java.util.Optional.of(1));
        assertEquals(players.getPlayerWithBetterScore(), Mark.X);
    }
}
