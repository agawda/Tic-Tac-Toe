package pl.javaacademy.tictactoe.game;

public class ServerGame implements Game {
    Players players;
    Board board;
    WinnerChecker winnerChecker;

    @Override
    public void initialize() {
        this.players = new Players();
    }

    @Override
    public void play() {
        this.board = new Board(new BoardSize(3, 3));
        this.winnerChecker = new WinnerChecker(new WinningSequence(3));
    }

    public void setPlayer(String name, Mark mark) {
        players.addPlayer(new Player(name, mark));
    }

    public String displayBoard() {
        return board.toString();
    }

    public void updateBoard(Integer field, Mark mark) {
        board.updateBoard(field, mark);
    }

    public boolean isFieldTaken(Integer field) {
        return board.isFieldSuitable(field);
    }

    public GameState checkWin() {
        return winnerChecker.findWinner(board);
    }


}
