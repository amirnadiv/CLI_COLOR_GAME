package com.amirnadiv;

import java.util.Scanner;

public class Main {

    public static void startGame() throws Exception {
        System.out.println("STARTING THE GAME !!! ");

        try {

            ColorBoard board = new ColorBoard(18,21);
            board.print();

            for(int i = 0; i < board.getNumberOfTurns() ; i++) {
                System.out.printf("Turn "+(i+1)+" of "+board.getNumberOfTurns()+ "turns");
                System.out.printf("\n");
                Square newColor = null;

                while(newColor == null) {
                    System.out.println("Please enter b(blue) or g(green) or r(red) or y(yellow) to PLAY THE GAME AND PRESS ENTER BUTTON ! ");
                    Scanner scan = new Scanner(System.in);
                    newColor = Square.getByString(scan.nextLine());
                    if(newColor == null) {
                        System.out.println("INVALID INPUT ENTERED");
                    }
                }

                board.change(newColor);
                board.print();
            }

            if(board.hasWon()) {
                System.out.println("YOU WIN !!! CONGRATS !!! :-) ");
            } else {
                System.out.println("GAME OVER - SORRY  :-( ");
            }

        } catch (Throwable err) {
            System.out.println(err);
            System.exit(1);
        }

        System.exit(0);
    }

    public static void main(String[] args) throws Exception {
        startGame();
    }
}
