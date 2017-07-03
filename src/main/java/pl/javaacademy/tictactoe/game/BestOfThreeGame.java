package pl.javaacademy.tictactoe.game;

import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.MarkInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

public class BestOfThreeGame implements Game {
    private Board board;
    private GameInitializer gameInitializer;
    private Players players;
    private PlayerSelector playerSelector;
    private UserCommunication<Mark> markInput;
    private UserCommunication<Integer> integerInput;

    public BestOfThreeGame() {
        this.markInput = new MarkInput();
        this.integerInput = new IntegerInput();
        this.gameInitializer = new GameInitializer();
        this.players = new Players();
    }

    @Override
    public void initialize() {
        //TODO: create classes which print messages to users
        gameInitializer.init();
        this.board = gameInitializer.board;
        this.players = gameInitializer.players;
        this.playerSelector = new PlayerSelector(gameInitializer.startingMark);
        board.displayBoard();
    }
    @Override
    public void play() {
        Play play;
        for (int i = 0; i < 3; i++) {
            //TODO: yes, this is ugly as hell :<
            play = new Play(new Board(new BoardSize(3, 3)), gameInitializer.startingMark);
            Mark winner = play.runTheGame();
            assignScores(winner);
        }
        System.out.printf("%s won.", players.getPlayerWithBetterScore());
    }

    private void assignScores(Mark winningMark) {
        if(winningMark.equals(Mark.EMPTY)) players.addBothPlayersScoreOnePoint();
        else players.addPlayerScoreThreePoints(winningMark);
    }

    private class GameInitializer {
        Board board;
        Mark startingMark;
        Players players;

        void init() {
            //TODO: get names from players
            Player player1 = new Player("Ab", Mark.X);
            Player player2 = new Player("Cd", Mark.O);
            this.players = new Players();
            this.players.addPlayer(player1);
            this.players.addPlayer(player2);
            System.out.println("Which symbol should start? X or O: ");
            startingMark = markInput.read();
            System.out.printf("You chose %s.\n\n", startingMark);
//            System.out.println("Board width: ");
            Integer width = 3; //integerInput.read();
//            System.out.println("Board height: ");
            Integer height = 3; //integerInput.read();
            //TODO: ask for the winning condition
            BoardSize boardSize = new BoardSize(width, height);
            System.out.println(boardSize.toString());
            board = new Board(boardSize);
        }
    }
}
