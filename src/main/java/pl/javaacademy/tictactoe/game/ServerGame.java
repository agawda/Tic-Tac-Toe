package pl.javaacademy.tictactoe.game;

public class ServerGame implements Game {
    Players players;
    Board board;
    WinnerChecker winnerChecker;

    @Override
    public void initialize() {
        this.players = new Players();
        this.board = new Board(new BoardSize(3, 3));
        this.winnerChecker = new WinnerChecker(new WinningSequence(3));
    }

    @Override
    public void play() {

    }

    public void setPlayer(String name, Mark mark) {
        players.addPlayer(new Player(name, mark));
    }
}
