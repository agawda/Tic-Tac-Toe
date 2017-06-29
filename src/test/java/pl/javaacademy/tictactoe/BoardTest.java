package pl.javaacademy.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.javaacademy.tictactoe.common.Marks;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardTest {

    private Board board;

    //TODO: When different size board will be allowed upgrade test
    @DataProvider(name = "boardCorrectDataProvider")
    public static Object[][] correctDataProvider() {
        return new Object[][]{
                {3, 3, 5},
                {3, 3, 9},
                {3, 3, 1}
        };
    }

    @DataProvider(name = "boardWrongDataProvider")
    public static Object[][] wrongDataProvider() {
        return new Object[][]{
                {3, 3, 10},
                {3, 3, 98},
                {3, 3, 41}
        };
    }

    @Test(dataProvider = "boardCorrectDataProvider")
    public void shouldReturnTrueForSuitableFields(int width, int height, int field) {

        // Given
        String message = String.format("Field %d is not suitable for board with size: %dx%d", field, width, height);

        // When
        board = new Board(new BoardSize(width, height));

        // Then
        assertTrue(board.isFieldSuitable(field), message);
    }

    @Test(dataProvider = "boardCorrectDataProvider")
    public void shouldReturnFalseForOccupiedFields(int width, int height, int field) {

        // Given
        String message = String.format("Field %d not suitable for board with size: %dx%d", field, width, height);

        // When
        board = new Board(new BoardSize(width, height));

        Stream<Integer> fieldIds = IntStream.range(1, 10).boxed(); //generate numbers 1-9
        fieldIds.forEach(integer -> board.updateBoard(integer, Marks.X));

        // Then
        assertFalse(board.isFieldSuitable(field), message);
    }

    @Test(dataProvider = "boardWrongDataProvider")
    public void shouldReturnFalseForFieldsNotOnBoard(int width, int height, int field) {

        // Given
        String message = String.format("Field %d is suitable for board with size: %dx%d", field, width, height);

        // When
        board = new Board(new BoardSize(width, height));

        // Then
        assertFalse(board.isFieldSuitable(field), message);
    }
}
