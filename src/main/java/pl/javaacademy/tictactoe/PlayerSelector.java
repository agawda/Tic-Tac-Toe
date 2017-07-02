package pl.javaacademy.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
/*
 * As it was said on public review move methods to enum classes
 */
class PlayerSelector {

    private Mark startingPlayerMark;
    private Mark secondPlayerMark;

    PlayerSelector(Mark startingPlayerMark) {
        this.startingPlayerMark = startingPlayerMark;
        this.secondPlayerMark = getSecondPlayerMark();
    }

    Mark getPlayerForMove(int moveId) {
        return moveId % 2 == 0 ? secondPlayerMark : startingPlayerMark;
    }

    private Mark getSecondPlayerMark() {
        //TODO: move this to Mark enum
        ArrayList<Mark> allMarks = new ArrayList<>(Arrays.asList(Mark.values()));
        allMarks.remove(startingPlayerMark);
        allMarks.remove(Mark.EMPTY);
        return allMarks.get(0);
    }
}
