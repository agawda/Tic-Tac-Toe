package pl.javaacademy.tictactoe.game;

class WinningSequence extends NumberWrapper{

    private int length;

    WinningSequence(int length) {
        this.length = length;
    }

    int intValue() {
        return length;
    }
}
