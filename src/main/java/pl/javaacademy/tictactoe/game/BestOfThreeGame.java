package pl.javaacademy.tictactoe.game;

import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.MarkInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

public class BestOfThreeGame implements Game {
    private GameInitializer gameInitializer;
    private Players players;
    private PlayerSelector playerSelector;
    private UserCommunication<Mark> markInput;
    private UserCommunication<Integer> integerInput;
    private Mark currentMark;

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
        this.players = gameInitializer.players;
        this.currentMark = gameInitializer.startingMark;
        this.playerSelector = new PlayerSelector(currentMark);

    }
    @Override
    public void play() {
        Play play;
        for (int i = 0; i < 3; i++) {
            //TODO: yes, this is ugly as hell :<
            play = new Play(new Board(new BoardSize(gameInitializer.width, gameInitializer.height)), currentMark, gameInitializer.winningSequence);
            Mark winner = play.runTheGame();
            assignScores(winner);
            currentMark = Mark.getOppositeMark(currentMark);
            this.playerSelector = new PlayerSelector(currentMark);
            System.out.println("====================================================");
            System.out.println("New game.");
            System.out.println("====================================================");
        }
        //TODO: name?
        System.out.printf("%s won.", players.getPlayerWithBetterScore());
    }

    private void assignScores(Mark winningMark) {
        if(winningMark.equals(Mark.EMPTY)) players.addBothPlayersScoreOnePoint();
        else players.addPlayerScoreThreePoints(winningMark);
    }

    private class GameInitializer {
        Mark startingMark;
        Players players;
        WinningSequence winningSequence;
        int width;
        int height;

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
            System.out.println("Board width: ");
            width = integerInput.read();
            System.out.println("Board height: ");
            height = integerInput.read();
            System.out.println("Enter winning sequence length: ");
            int winSeq = integerInput.read();
            winningSequence = new WinningSequence(winSeq);
        }
    }
}
