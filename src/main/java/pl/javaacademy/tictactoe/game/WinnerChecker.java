package pl.javaacademy.tictactoe.game;

import java.util.List;

/*
 * Do more generalizations
 */
//TODO: create interface, classes and use polymorphism to check if the game is finished
class WinnerChecker {
    private Mark winnerMark;
    private WinningSequence winningSequence;

    WinnerChecker(WinningSequence winningSequence) {
        this.winningSequence = winningSequence;
        this.winnerMark = Mark.EMPTY;
    }

    GameState findWinner(Board board) {
        List<Mark> markList;
        //TODO: remove magic numbers
        int tmpRow = 1;
        int tmpColumn = 1;

        //TODO: extract classes
        while (winnerMark == Mark.EMPTY && tmpRow <= board.getHeight()) {
            markList = board.getMarksFromRow(tmpRow);
            for (int i = 0; i <= board.getWidth() - winningSequence.intValue(); i++) {
                List<Mark> actualMarks = cutMarksList(markList, i);
                if (sameMarksInList(actualMarks)) {
                    winnerMark = actualMarks.get(0);
                    return selectGameState(winnerMark);
                }
            }
            tmpRow++;
        }
        int limit = board.getHeight() * board.getWidth() - winningSequence.intValue() * board.getWidth() + 1;
        while (tmpColumn <= board.getWidth()) {
            markList = board.getMarksFromColumn(tmpColumn);
            for (int i = 0; i <= limit; i += board.getWidth()) {
                List<Mark> actualMarks = cutMarksList(markList, i / board.getWidth());
                if (sameMarksInList(actualMarks)) {
                    winnerMark = actualMarks.get(0);
                    return selectGameState(winnerMark);
                }
            }
            tmpColumn++;
        }

        //descending
        for (int i = 0; i <= board.getWidth() - winningSequence.intValue(); i++) {
            for (int j = 0; j <= board.getHeight() - winningSequence.intValue(); j++) {
                markList = board.getMarksDiagonalDescending(j * board.getWidth() + i + 1);
                List<Mark> actualMarks = cutMarksList(markList, 0);
                if (sameMarksInList(actualMarks)) {
                    winnerMark = markList.get(0);
                    return selectGameState(winnerMark);
                }
            }
        }

        //ascending
        //TODO: change to vertical and horizontal limit
        for (int i = winningSequence.intValue() - 1; i < board.getWidth(); i++) {
            for (int j = 0; j <= board.getHeight() - winningSequence.intValue(); j++) {
                markList = board.getMarksDiagonalAscending(j * board.getWidth() + i + 1);
                List<Mark> actualMarks = cutMarksList(markList, 0);
                if (sameMarksInList(actualMarks)) {
                    winnerMark = markList.get(0);
                    return selectGameState(winnerMark);
                }
            }
        }

        return selectGameState(winnerMark);
    }

    Mark getWinnerMark() {
        return winnerMark;
    }

    private List<Mark> cutMarksList(List<Mark> marks, int startingIndex) {
        return marks.subList(startingIndex, startingIndex + winningSequence.intValue());
    }

    private boolean sameMarksInList(List<Mark> marks) {
        return marks.stream().allMatch(m -> m == marks.get(0) && m != Mark.EMPTY && m != null);
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
