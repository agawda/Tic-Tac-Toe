package pl.javaacademy.tictactoe.game;

import java.util.List;

/*
 * Do more generalizations
 */
class WinnerChecker {
    private Mark winnerMark;
    private Integer winningSequence;

    WinnerChecker() {
        this.winnerMark = Mark.EMPTY;
    }

    GameState findWinner(Board board) {

        List<Mark> markList;
        this.winningSequence = board.getWinningSequence();
        //TODO: remove magic numbers
        int tmpRow = 1;
        int tmpColumn = 1;

        //TODO: finish the rest of the checkers, maybe extract classes
        markList = board.getMarksFromRow(tmpRow);
        while (winnerMark == Mark.EMPTY && tmpRow <= board.getHeight()) {
            for(int i = 0; i <= board.getWidth() - winningSequence; i++) {
                List<Mark> actualMarks = cutMarksList(markList, i);
                if (sameMarksInList(actualMarks)) {
                    winnerMark = actualMarks.get(0);
                    return selectGameState(winnerMark);
                }
            }
            tmpRow++;
        }

        //TODO: write a function which checks for consecutive marks
        while (winnerMark == Mark.EMPTY && tmpColumn < 4) {
            markList = board.getMarksFromColumn(tmpColumn);
            boolean win = sameMarksInList(markList);
            if (win) {
                winnerMark = markList.get(0);
                return selectGameState(winnerMark);
            }
            tmpColumn++;
        }

        markList = board.getMarksDiagonalDescending();
        if(sameMarksInList(markList)) winnerMark = markList.get(0);

        markList = board.getMarksDiagonalAscending();
        if(sameMarksInList(markList)) winnerMark = markList.get(0);

        return selectGameState(winnerMark);
    }

    Mark getWinnerMark() {
        return winnerMark;
    }

    private List<Mark> cutMarksList(List<Mark> marks, int startingIndex) {
        return marks.subList(startingIndex, startingIndex + winningSequence);
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
