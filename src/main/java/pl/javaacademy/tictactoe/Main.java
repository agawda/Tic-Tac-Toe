package pl.javaacademy.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Marks startingMark = null;
        System.out.println("Choose starting mark ('X' or 'O')");
        Scanner scanner = new Scanner(System.in);
        while (startingMark == null) {
            try {
                String userMark = String.valueOf(scanner.nextLine());
                startingMark = Marks.valueOf(userMark);
            } catch (IllegalArgumentException e) {
                System.out.println("You put wrong mark, try again");
            }
        }

        System.out.println("You selected: " + startingMark);

        Integer boardSize = null;
        System.out.println("Please type size of board");
        while (boardSize == null) {
            try {
                String userSize = String.valueOf(scanner.nextLine());
                boardSize = Integer.valueOf(userSize);
            } catch (NumberFormatException e) {
                System.out.println("You put wrong value, please try again");
            }
        }

        System.out.println("Selected board size: " + boardSize);
    }
}
