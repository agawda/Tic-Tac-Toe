package pl.javaacademy.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardSizeTest {

    @DataProvider(name = "boardCorrectDataProvider")
    public static Object[][] correctProvider() {
        return new Object[][]{
                {3, 3, 7},
                {1, 1, 1},
                {6, 1, 1}
        };
    }

    @DataProvider(name = "boardWrongDataProvider")
    public static Object[][] wrongProvider() {
        return new Object[][]{
                {3, 3, 17},
                {1, 1, 15},
                {10, 10, 694}
        };
    }

    @DataProvider(name = "calcNumberOfFieldsDataProvider")
    public static Object[][] noOfFieldsDataProvider() {
        return new Object[][]{
                {3, 3},
                {1, 1},
                {10, 10}
        };
    }

    @Test(dataProvider = "boardCorrectDataProvider")
    public void testFieldIsInBoardCheckerWithCorrectData(int width, int height, int field) {
        String message = String.format("Field %d is not in board: %dx%d size\n", field, width, height);
        assertTrue(new BoardSize(width, height).isFieldOnBoard(field), message);
    }

    @Test(dataProvider = "boardWrongDataProvider")
    public void testFieldIsInBoardCheckerWithWrongData(int width, int height, int field) {
        String message = String.format("Field %d is in board: %dx%d size\n", field, width, height);
        assertFalse(new BoardSize(width, height).isFieldOnBoard(field), message);
    }

    @Test(dataProvider = "calcNumberOfFieldsDataProvider")
    public void shouldReturnCorrectNumberOfFields(int width, int height) {
        String message = String.format("Error during calculating no. of fields on %dx%d size\n", width, height);
        assertEquals(new BoardSize(width, height).getNumberOfFields(), width * height, message);

    }

    @Test
    public void shouldReturnAllFieldsNumberToCheckFromFirstRow() {

        BoardSize boardSize = new BoardSize(3, 3);
        List<Integer> indexesList = boardSize.getHorizontalIndexes(1);

        assertEquals(Integer.valueOf(1), indexesList.get(0));
        assertEquals(Integer.valueOf(2), indexesList.get(1));
        assertEquals(Integer.valueOf(3), indexesList.get(2));
    }

    @Test
    public void shouldReturnAllFieldsNumberToCheckFromSecondRow() {

        BoardSize boardSize = new BoardSize(3, 3);
        List<Integer> indexesList = boardSize.getHorizontalIndexes(2);

        assertEquals(Integer.valueOf(4), indexesList.get(0));
        assertEquals(Integer.valueOf(5), indexesList.get(1));
        assertEquals(Integer.valueOf(6), indexesList.get(2));
    }

    @Test
    public void shouldReturnAllFieldsNumberToCheckFromThirdRow() {

        BoardSize boardSize = new BoardSize(3, 3);
        List<Integer> indexesList = boardSize.getHorizontalIndexes(3);

        assertEquals(Integer.valueOf(7), indexesList.get(0));
        assertEquals(Integer.valueOf(8), indexesList.get(1));
        assertEquals(Integer.valueOf(9), indexesList.get(2));
    }

    @Test
    public void shouldReturnAllFieldsNumberToCheckFromNotSquareBoard() {

        BoardSize boardSize = new BoardSize(4, 8);
        List<Integer> indexesList = boardSize.getHorizontalIndexes(6);

        assertEquals(Integer.valueOf(21), indexesList.get(0));
        assertEquals(Integer.valueOf(22), indexesList.get(1));
        assertEquals(Integer.valueOf(23), indexesList.get(2));
        assertEquals(Integer.valueOf(24), indexesList.get(3));
    }

    @Test
    public void shouldReturnAllFieldsNumberToCheckFromFirstColumn() {

        BoardSize boardSize = new BoardSize(3, 3);
        List<Integer> indexesList = boardSize.getVerticalIndexes(1);

        assertEquals(Integer.valueOf(1), indexesList.get(0));
        assertEquals(Integer.valueOf(4), indexesList.get(1));
        assertEquals(Integer.valueOf(7), indexesList.get(2));
    }

    @Test
    public void shouldReturnAllFieldsNumberToCheckFromSecondColumn() {

        BoardSize boardSize = new BoardSize(3, 3);
        List<Integer> indexesList = boardSize.getVerticalIndexes(2);

        assertEquals(Integer.valueOf(2), indexesList.get(0));
        assertEquals(Integer.valueOf(5), indexesList.get(1));
        assertEquals(Integer.valueOf(8), indexesList.get(2));
    }

    @Test
    public void shouldReturnAllFieldsNumberToCheckFromThirdColumn() {

        BoardSize boardSize = new BoardSize(3, 3);
        List<Integer> indexesList = boardSize.getVerticalIndexes(3);

        assertEquals(Integer.valueOf(3), indexesList.get(0));
        assertEquals(Integer.valueOf(6), indexesList.get(1));
        assertEquals(Integer.valueOf(9), indexesList.get(2));
    }

    @Test
    public void shouldReturnListWithVerticalIndexesOfRectangleBoard() {

        BoardSize boardSize = new BoardSize(4, 8);
        List<Integer> indexesList = boardSize.getVerticalIndexes(3);

        assertEquals(Integer.valueOf(3), indexesList.get(0));
        assertEquals(Integer.valueOf(7), indexesList.get(1));
        assertEquals(Integer.valueOf(11), indexesList.get(2));
        assertEquals(Integer.valueOf(15), indexesList.get(3));
        assertEquals(Integer.valueOf(19), indexesList.get(4));
        assertEquals(Integer.valueOf(23), indexesList.get(5));
        assertEquals(Integer.valueOf(27), indexesList.get(6));
        assertEquals(Integer.valueOf(31), indexesList.get(7));
    }
}
