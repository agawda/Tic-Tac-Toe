package pl.javaacademy.tictactoe.game;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PlayerSelectorTest {

    @DataProvider(name = "OddNumbersProvider")
    public static Object[][] oddNumbersProvider() {
        return new Object[][]{
                {1},
                {9},
                {111},
        };
    }

    @DataProvider(name = "EvenNumbersProvider")
    public static Object[][] evenNumbersProvider() {
        return new Object[][]{
                {2},
                {8},
                {76},
        };
    }

    @Test(dataProvider = "OddNumbersProvider")
    public void shouldReturnStartingMarkForOddTurn(int moveId) {

        // Given
        PlayerSelector selector = new PlayerSelector(Mark.X);

        // When
        Mark player = selector.getPlayerForMove(moveId);

        // Then
        assertEquals(player, Mark.X);
    }

    @Test(dataProvider = "EvenNumbersProvider")
    public void shouldReturnSecondMarkForEvenTurn(int moveId) {

        // Given
        PlayerSelector selector = new PlayerSelector(Mark.O);

        // When
        Mark player = selector.getPlayerForMove(moveId);

        // Then
        assertEquals(player, Mark.X);
    }
}
