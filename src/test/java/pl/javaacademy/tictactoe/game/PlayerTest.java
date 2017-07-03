package pl.javaacademy.tictactoe.game;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class PlayerTest {
    @DataProvider(name = "playerNamesOk")
    public Object[][] names() {
        return new Object[][]{
                {"Robert", "Robert"},
                {"kate", "kate"}
        };
    }

    @DataProvider(name = "playerNamesNotOk")
    public Object[][] namesNotOk() {
        return new Object[][]{
                {"Kate", "kate"},
                {"robert", "rob"}
        };
    }

    @DataProvider(name = "symbolsOk")
    public Object[][] symbolsOk() {
        return new Object[][]{
                {Mark.X},
                {Mark.O}
        };
    }

    @DataProvider(name = "playerScore")
    public Object[][] playerScoresOk() {
        return new Object[][]{
                {3},
                {4}
        };
    }

    @Test(dataProvider = "playerNamesOk")
    public void testPlayerNameInitializedCorrectly(String actual, String expected) {
        Player player = new Player(actual);
        assertEquals(player.getPlayerName(), expected);
    }

    @Test(dataProvider = "playerNamesNotOk")
    public void testPlayerNameDoesNotIgnoreLetterCase(String actual, String expected) {
        Player player = new Player(actual);
        assertNotEquals(player.getPlayerName(), expected);
    }

    @Test(dataProvider = "symbolsOk")
    public void testPlayerSymbolsOk(Mark actual) {
        Player player = new Player("");
        player.setMark(actual);
        assertEquals(player.getMark(), actual);
    }

    @Test(dataProvider = "playerScore")
    public void testPlayerScoreOk(Integer actual) {
        Player player = new Player("");
        player.setScore(actual);
        assertEquals(player.getScore(), actual);
    }
}
