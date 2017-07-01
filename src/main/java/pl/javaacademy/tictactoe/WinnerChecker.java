package pl.javaacademy.tictactoe;

import java.util.List;

/*
 * Do more generalizations
 */
class WinnerChecker {
    //TODO: it's impossible to win the game atm

    GameState findWinner(Board board) {

        Marks winnerMark = Marks.EMPTY;
        List<Marks> marksList;
        int tmpRow = 1;
        int tmpColumn = 1;

        while (winnerMark == Marks.EMPTY && tmpRow < 4) {
            marksList = board.getMarksFromRow(tmpRow);
            if (sameMarksInList(marksList)) {
                winnerMark = marksList.get(0);
            }
            tmpRow++;
        }

        while (winnerMark == Marks.EMPTY && tmpColumn < 4) {
            marksList = board.getMarksFromColumn(tmpColumn);
            if (sameMarksInList(marksList)) {
                winnerMark = marksList.get(0);
            }
            tmpColumn++;
        }
        return selectGameState(winnerMark);
    }

    private boolean sameMarksInList(List<Marks> marks) {
        return marks.stream().allMatch(marks.get(0)::equals);
    }

    private GameState selectGameState(Marks winnerMark) {

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
