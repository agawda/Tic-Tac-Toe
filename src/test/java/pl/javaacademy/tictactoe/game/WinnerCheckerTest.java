package pl.javaacademy.tictactoe.game;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WinnerCheckerTest {

    private WinnerChecker checker;
    private Board board;

    //it doesn't work with intellij, lol
//    @BeforeMethod(groups = "3x3board")
//    public void setUpWinnerCheckerWinningSequence3() {
//        this.checker = new WinnerChecker(new Winn ingSequence(3));
//    }

    @BeforeGroups(groups = "3x3board")
    public void before3x3Group() {
        board = new Board(new BoardSize(3, 3));
    }

    @BeforeGroups(groups = "4x6board")
    public void before4x6Group() {
        board = new Board(new BoardSize(4, 6));
    }

    @BeforeGroups(groups = "4x4board")
    public void before4x4Group() {
        board = new Board(new BoardSize(4, 4));
    }

    @BeforeGroups(groups = "5x5board")
    public void before5x5Group() {
        board = new Board(new BoardSize(5, 5));
    }

    @DataProvider(name = "5x5ascending")
    public Object[][] ascending5x5Data() {
        return new Object[][]{
                {11, 7, 3},
                {17, 13, 9},
                {23, 19, 15},
                {16, 12, 8}
        };
    }

    @DataProvider(name = "5x5descending")
    public Object[][] descending5x5Data() {
        return new Object[][]{
                {1, 7, 13},
                {12, 18, 24},
                {13, 19, 25},
                {7, 13, 19},
                {11, 17, 23},
                {8, 14, 20}
        };
    }

    // region 3x3board tests
    @Test(groups = "3x3board")
    public void shouldFindNoWinnerForEmptyBoard() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        this.board = new Board(new BoardSize(3, 3));
        // When
        GameState state = checker.findWinner(board);
        // Then
        assertEquals(state, GameState.NO_WINNER);
    }

    @Test(groups = "3x3board")
    public void shouldFindWinnerInFirstRow() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Mark.X);
        board.updateBoard(2, Mark.X);
        board.updateBoard(3, Mark.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3board")
    public void shouldFindWinnerInFirstColumn() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Mark.X);
        board.updateBoard(4, Mark.X);
        board.updateBoard(7, Mark.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3board")
    public void shouldFindWinnerInSecondRow() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Mark.X);
        board.updateBoard(2, Mark.O);
        board.updateBoard(3, Mark.O);
        board.updateBoard(4, Mark.X);
        board.updateBoard(5, Mark.X);
        board.updateBoard(6, Mark.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3board")
    public void shouldFindWinnerInSecondColumn() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Mark.X);
        board.updateBoard(4, Mark.O);
        board.updateBoard(7, Mark.O);
        board.updateBoard(2, Mark.X);
        board.updateBoard(5, Mark.X);
        board.updateBoard(8, Mark.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "3x3board")
    public void shouldFindWinnerWithEmptyFieldsOnBoard() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(7, Mark.O);
        board.updateBoard(8, Mark.O);
        board.updateBoard(9, Mark.O);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.O_WIN);
    }

    @Test(groups = "3x3board")
    public void shouldFindColumnWinnerWithEmptyFieldsOnBoard() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        board.updateBoard(3, Mark.O);
        board.updateBoard(6, Mark.O);
        board.updateBoard(9, Mark.O);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.O_WIN);
    }

    @Test(groups = "3x3board")
    public void shouldFindNoWinnerInFilledBoard() {

        // Given
        this.checker = new WinnerChecker(new WinningSequence(3));
        board = new Board(new BoardSize(3, 3));
        board.updateBoard(1, Mark.O);
        board.updateBoard(2, Mark.X);
        board.updateBoard(3, Mark.X);
        board.updateBoard(4, Mark.X);
        board.updateBoard(5, Mark.O);
        board.updateBoard(6, Mark.O);
        board.updateBoard(7, Mark.O);
        board.updateBoard(8, Mark.O);
        board.updateBoard(9, Mark.X);

        // When
        GameState state = checker.findWinner(board);

        // Then
        assertEquals(state, GameState.NO_WINNER);
    }

    @Test(groups = "3x3board")
    public void shouldReturnWinningMarkDiagonalCase() {
        this.checker = new WinnerChecker(new WinningSequence(3));
        board.updateBoard(1, Mark.X);
        board.updateBoard(5, Mark.X);
        board.updateBoard(9, Mark.X);

        GameState state = checker.findWinner(board);

        assertEquals(state, GameState.X_WIN);
    }
    // endregion

    @Test(groups = "4x4board")
    public void shouldReturnWinningMark4x4() {
        this.checker = new WinnerChecker(new WinningSequence(3));
        board.updateBoard(2, Mark.X);
        board.updateBoard(3, Mark.X);
        board.updateBoard(4, Mark.X);

        GameState state = checker.findWinner(board);

        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "4x6board")
    public void shouldReturnWinningMarkFirstRow() {
        this.checker = new WinnerChecker(new WinningSequence(4));
        board.updateBoard(1, Mark.X);
        board.updateBoard(2, Mark.X);
        board.updateBoard(3, Mark.X);
        board.updateBoard(4, Mark.X);

        GameState state = checker.findWinner(board);

        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "4x6board")
    public void shouldNotReturnWinningMarkFirstRow() {
        this.checker = new WinnerChecker(new WinningSequence(4));
        board.updateBoard(2, Mark.X);
        board.updateBoard(3, Mark.O);
        board.updateBoard(4, Mark.X);

        GameState state = checker.findWinner(board);

        assertEquals(state, GameState.NO_WINNER);
    }

    @Test(groups = "4x6board")
    public void shouldReturnWinningMarkSecondColumn() {
        this.checker = new WinnerChecker(new WinningSequence(4));
        board.updateBoard(6, Mark.X);
        board.updateBoard(10, Mark.X);
        board.updateBoard(14, Mark.X);
        board.updateBoard(18, Mark.X);

        GameState state = checker.findWinner(board);

        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "4x6board")
    public void shouldReturnWinningMarkSecondColumnFirstRow() {
        this.checker = new WinnerChecker(new WinningSequence(4));
        board.updateBoard(2, Mark.X);
        board.updateBoard(6, Mark.X);
        board.updateBoard(10, Mark.X);
        board.updateBoard(14, Mark.X);

        GameState state = checker.findWinner(board);

        assertEquals(state, GameState.X_WIN);
    }

    @Test(groups = "4x6board")
    public void shouldReturnDiagonalAscendingWinFourthRow() {
        this.checker = new WinnerChecker(new WinningSequence(4));
        board.updateBoard(13, Mark.X);
        board.updateBoard(10, Mark.X);
        board.updateBoard(7, Mark.X);
        board.updateBoard(4, Mark.X);

        GameState gameState = checker.findWinner(board);

        assertEquals(gameState, GameState.X_WIN);
    }

    @Test(groups = "4x6board")
    public void shouldReturnDiagonalDescendingWinFirstRow() {
        this.checker = new WinnerChecker(new WinningSequence(4));
        board.updateBoard(1, Mark.X);
        board.updateBoard(6, Mark.X);
        board.updateBoard(11, Mark.X);
        board.updateBoard(16, Mark.X);

        GameState gameState = checker.findWinner(board);

        assertEquals(gameState, GameState.X_WIN);
    }

    @Test(groups = "4x6board")
    public void shouldReturnDiagonalDescendingWin() {
        this.checker = new WinnerChecker(new WinningSequence(4));
        board.updateBoard(5, Mark.X);
        board.updateBoard(10, Mark.X);
        board.updateBoard(15, Mark.X);
        board.updateBoard(20, Mark.X);

        GameState gameState = checker.findWinner(board);

        assertEquals(gameState, GameState.X_WIN);
    }

    @Test(groups = "5x5board", dataProvider = "5x5descending")
    public void shouldReturnDiagonal5x5Descending(int first, int second, int third) {
        this.checker = new WinnerChecker(new WinningSequence(3));
        board.updateBoard(first, Mark.X);
        board.updateBoard(second, Mark.X);
        board.updateBoard(third, Mark.X);

        GameState gameState = checker.findWinner(board);

        assertEquals(gameState, GameState.X_WIN);
    }

    @Test(groups = "5x5board", dataProvider = "5x5ascending")
    public void shouldReturnDiagonal5x5AscendingWin(int first, int second, int third) {
        this.checker = new WinnerChecker(new WinningSequence(3));
        board.updateBoard(first, Mark.X);
        board.updateBoard(second, Mark.X);
        board.updateBoard(third, Mark.X);

        GameState gameState = checker.findWinner(board);

        assertEquals(gameState, GameState.X_WIN);
    }
}
