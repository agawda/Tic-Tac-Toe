package pl.javaacademy.tictactoe.game;

import pl.javaacademy.tictactoe.io.IntegerInput;
import pl.javaacademy.tictactoe.io.MarkInput;
import pl.javaacademy.tictactoe.io.UserCommunication;

public class BestOfThreeGame implements Game {
    private Board board;
    private GameInitializer gameInitializer;
    private PlayerSelector playerSelector;
    private UserCommunication<Mark> markInput;
    private UserCommunication<Integer> integerInput;

    public BestOfThreeGame() {
        this.markInput = new MarkInput();
        this.integerInput = new IntegerInput();
        this.gameInitializer = new GameInitializer();
    }

    @Override
    public void initialize() {
        //TODO: create classes which print messages to users
        gameInitializer.init();
        this.board = gameInitializer.board;
        this.playerSelector = new PlayerSelector(gameInitializer.startingMark);
        board.displayBoard();
    }
    @Override
    public void play() {
        int moveCounter = 1;
        WinnerChecker winnerChecker = new WinnerChecker();
        while (winnerChecker.findWinner(board).equals(GameState.NO_WINNER) && moveCounter < 10) {
            Mark currentPlayerMark = playerSelector.getPlayerForMove(moveCounter);
            System.out.println(String.format("Player %s, please select field(1-9)", String.valueOf(currentPlayerMark)));
            Integer selectedField = integerInput.read();
            while (!board.isFieldSuitable(selectedField)) {
                System.out.println("Field is occupied or not on board, please select another one");
                selectedField = integerInput.read();
            }
            System.out.println("You selected: " + selectedField);

            board.updateBoard(selectedField, currentPlayerMark);
            board.displayBoard();
            moveCounter++;
        }
    }

    private class GameInitializer {
        Board board;
        Mark startingMark;

        void init() {
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
