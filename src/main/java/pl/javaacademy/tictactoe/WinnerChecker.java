package pl.javaacademy.tictactoe;

import java.util.List;

/*
 * Do more generalizations
 */
class WinnerChecker {
    //TODO: it's possible to win the game horizontally and vertically, but diagonals don't work

    GameState findWinner(Board board) {

        Mark winnerMark = Mark.EMPTY;
        List<Mark> markList;
        int tmpRow = 1;
        int tmpColumn = 1;

        while (winnerMark == Mark.EMPTY && tmpRow < 4) {
            markList = board.getMarksFromRow(tmpRow);
            if (sameMarksInList(markList)) {
                winnerMark = markList.get(0);
            }
            tmpRow++;
        }

        while (winnerMark == Mark.EMPTY && tmpColumn < 4) {
            markList = board.getMarksFromColumn(tmpColumn);
            if (sameMarksInList(markList)) {
                winnerMark = markList.get(0);
            }
            tmpColumn++;
        }
        return selectGameState(winnerMark);
    }

    private boolean sameMarksInList(List<Mark> marks) {
        return marks.stream().allMatch(marks.get(0)::equals);
    }

    private GameState selectGameState(Mark winnerMark) {

        switch (winnerMark) {
            case O:
                return GameState.O_WIN;
            case X:
                return GameState.X_WIN;
            default:
                return GameState.NO_WINNER;
        }
    }
}
