package pl.javaacademy.tictactoe;

enum Mark {
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
