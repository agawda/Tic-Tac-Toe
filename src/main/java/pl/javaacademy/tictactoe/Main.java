package pl.javaacademy.tictactoe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Choose starting mark ('X' or 'O')");
        Marks startingMark = null;
        while (startingMark == null) {
            try {
                Scanner scanner = new Scanner(System.in);
                String userMark = String.valueOf(scanner.nextLine());
                startingMark = Marks.valueOf(userMark);
            } catch (IllegalArgumentException e) {
                System.out.println("You put wrong mark, try again");
            }
        }

        System.out.println("You selected: " + startingMark);
    }
}
