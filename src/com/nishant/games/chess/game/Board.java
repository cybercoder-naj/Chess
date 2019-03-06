package com.nishant.games.chess.game;

/**
 * This is the Board class.
 * It contains all the Piece and Player constants that are to be used in the board.<br><br>
 *
 * The board is indexed from 0 - 7 on both sides.
 *
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class Board {
    public static final String PAWN = "P";
    public static final String ROOK = "R";
    public static final String KNIGHT = "N";
    public static final String BISHOP = "B";
    public static final String QUEEN = "Q";
    public static final String KING = "K";
    public static final String PLAYER_1 = "1";
    public static final String PLAYER_2 = "2";
    public static final String EMPTY = "-";
    public static String board[][] = new String[8][8];

    public static void setInitialBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = EMPTY;
            }
        }

        for (int i = 0; i < 8; i++) {
            board[1][i] = PAWN + PLAYER_2;
            board[6][i] = PAWN + PLAYER_1;
            switch (i) {
                case 0:
                    setPiece(i, ROOK);
                    break;

                case 1:
                    setPiece(i, KNIGHT);
                    break;

                case 2:
                    setPiece(i, BISHOP);
            }
        }

        board[0][3] = QUEEN + PLAYER_2;
        board[7][3] = QUEEN + PLAYER_1;
        board[0][4] = KING + PLAYER_2;
        board[7][4] = KING + PLAYER_1;
    }

    private static void setPiece(int i, String Piece) {
        board[0][i] = Piece + PLAYER_2;
        board[0][7 - i] = Piece + PLAYER_2;
        board[7][i] = Piece + PLAYER_1;
        board[7][7 - i] = Piece + PLAYER_1;
    }

    public static void displayBoard() {
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
}