package pl.javaacademy.tictactoe.game;

//TODO: for now it's public, but I'll come up with something later (errors in MarkInput class)
public enum Mark {
    X, O, EMPTY;

    public static String getStringFromMark(Mark mark) {
        if(mark.equals(X)) return "X";
        if(mark.equals(O)) return "O";
        return " ";
    }

    public static Mark getMarkFromString(String mark) {
        if(mark.equals("X")) return X;
        if(mark.equals("O")) return O;
        return EMPTY;
    }

    public static Mark getOppositeMark(Mark mark) {
        if(mark.equals(X)) return O;
        return X;
    }
}
