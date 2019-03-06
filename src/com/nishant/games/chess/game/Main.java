package com.nishant.games.chess.game;

/**
 * This is the class where everything starts.
 * Use the main method from this class to start the program.
 *
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Board.setInitialBoard();

        Start start = new Start();
        while (true) {
            start.start();
            if(!hasWon(start)) {
                Board.displayBoard();
                if(start.getCounter()%2==0) System.out.println("\nPLAYER 2 HAS WON\n");
                else System.out.println("\nPLAYER 1 HAS WON\n");
                break;
            }
        }
    }

    private static boolean hasWon(Start start) {
        return !((start.getCounter()%2==0 && start.getPlayer1().getMoves().size()==0) || (start.getCounter()%2==1 && start.getPlayer2().getMoves().size()==0));
    }
}