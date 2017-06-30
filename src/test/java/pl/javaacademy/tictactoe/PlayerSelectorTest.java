package pl.javaacademy.tictactoe;

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
        PlayerSelector selector = new PlayerSelector(Marks.X);

        // When
        Marks player = selector.getPlayerForMove(moveId);

        // Then
        assertEquals(player, Marks.X);
    }

    @Test(dataProvider = "EvenNumbersProvider")
    public void shouldReturnSecondMarkForEvenTurn(int moveId) {

        // Given
        PlayerSelector selector = new PlayerSelector(Marks.O);

        // When
        Marks player = selector.getPlayerForMove(moveId);

        // Then
        assertEquals(player, Marks.X);
    }
}
