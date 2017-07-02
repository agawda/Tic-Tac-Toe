package pl.javaacademy.tictactoe.game;

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
        return Mark.getOppositeMark(startingPlayerMark);
    }
}
