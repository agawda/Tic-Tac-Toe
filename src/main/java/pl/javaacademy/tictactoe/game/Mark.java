package pl.javaacademy.tictactoe.game;

//TODO: for now it's public, but I'll come up with something later (errors in MarkInput class)
//toString and valueOf
public enum Mark {
    X, O, EMPTY;

    public static Mark getOppositeMark(Mark mark) {
        if(mark.equals(X)) return O;
        return X;
    }
}
