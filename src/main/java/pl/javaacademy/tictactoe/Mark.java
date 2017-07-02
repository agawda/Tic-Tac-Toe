package pl.javaacademy.tictactoe;

enum Mark {
    X, O, EMPTY;

    public String getStringFromMark(Mark mark) {
        if(mark.equals(X)) return "X";
        if(mark.equals(O)) return "O";
        return " ";
    }

    public Mark getMarkFromString(String mark) {
        if(mark.equals("X")) return X;
        if(mark.equals("O")) return O;
        return EMPTY;
    }

    public Mark getOppositeMark(Mark mark) {
        if(mark.equals(X)) return O;
        return X;
    }
}
