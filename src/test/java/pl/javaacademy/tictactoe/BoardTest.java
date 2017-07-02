package pl.javaacademy.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;
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
        fieldIds.forEach(integer -> board.updateBoard(integer, Mark.X));

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

    @Test
    public void shouldReturnMarksFromFirstRow() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Mark.X);
        board.updateBoard(2, Mark.X);
        board.updateBoard(3, Mark.O);

        // When
        List<Mark> readMarks = board.getMarksFromRow(1);

        // Then
        assertEquals(readMarks.get(0), Mark.X);
        assertEquals(readMarks.get(1), Mark.X);
        assertEquals(readMarks.get(2), Mark.O);
    }

    @Test
    public void shouldReturnMarksFromRow() {

        // Given
        board = new Board(new BoardSize(4, 5));
        board.updateBoard(9, Mark.X);
        board.updateBoard(10, Mark.X);
        board.updateBoard(11, Mark.O);
        board.updateBoard(12, Mark.O);

        // When
        List<Mark> readMarks = board.getMarksFromRow(3);

        // Then
        assertEquals(readMarks.get(0), Mark.X);
        assertEquals(readMarks.get(1), Mark.X);
        assertEquals(readMarks.get(2), Mark.O);
        assertEquals(readMarks.get(3), Mark.O);
    }

    @Test
    public void shouldReturnMarksFromFirstColumn() {

        // Given
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Mark.X);
        board.updateBoard(4, Mark.O);
        board.updateBoard(7, Mark.X);

        // When
        List<Mark> readMarks = board.getMarksFromColumn(1);

        // Then
        assertEquals(readMarks.get(0), Mark.X);
        assertEquals(readMarks.get(1), Mark.O);
        assertEquals(readMarks.get(2), Mark.X);
    }

    @Test
    public void shouldReturnMarksFromColumn() {

        // Given
        board = new Board(new BoardSize(4, 5));
        board.updateBoard(3, Mark.O);
        board.updateBoard(7, Mark.X);
        board.updateBoard(11, Mark.O);
        board.updateBoard(15, Mark.X);
        board.updateBoard(19, Mark.O);

        // When
        List<Mark> readMarks = board.getMarksFromColumn(3);

        // Then
        assertEquals(readMarks.get(0), Mark.O);
        assertEquals(readMarks.get(1), Mark.X);
        assertEquals(readMarks.get(2), Mark.O);
        assertEquals(readMarks.get(3), Mark.X);
        assertEquals(readMarks.get(4), Mark.O);
    }
}
