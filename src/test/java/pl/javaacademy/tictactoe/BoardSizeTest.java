package pl.javaacademy.tictactoe;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoardSizeTest {

    @DataProvider(name = "boardCorrectDataProvider")
    public static Object[][] correctProvider(){
        return new Object[][]{
                {3, 3, 7},
                {1, 1, 1},
                {6, 1, 1}
        };
    }

    @DataProvider(name = "boardWrongDataProvider")
    public static Object[][] wrongProvider(){
        return new Object[][]{
                {3, 3, 17},
                {1, 1, 15},
                {10, 10, 694}
        };
    }

    @Test(dataProvider = "boardCorrectDataProvider")
    public void testFieldIsInBoardCheckerWithCorrectData(int width, int height, int field){
        String message = String.format("Field %d is not in board: %dx%d size\n", field, width, height);
        assertTrue(new BoardSize(width, height).isFieldOnBoard(field), message);
    }

    @Test(dataProvider = "boardWrongDataProvider")
    public void testFieldIsInBoardCheckerWithWrongData(int width, int height, int field){
        String message = String.format("Field %d is in board: %dx%d size\n", field, width, height);
        assertFalse(new BoardSize(width, height).isFieldOnBoard(field), message);
    }
}
