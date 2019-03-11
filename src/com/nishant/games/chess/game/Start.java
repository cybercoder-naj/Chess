package com.nishant.games.chess.game;

import com.nishant.games.chess.pieces.*;

import java.util.List;
import java.util.Scanner;

import static com.nishant.games.chess.game.Board.*;

/**
 * This class is the actual start of all the code. It takes all the inputs and coordinates the activity of the board.
 * It has also arranged for the facility of castling, undo move and pawn promotion.
 *
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class Start {

    private int counter = 0;

    private boolean hasCastled =false;

    private Player player1 = new Player(PLAYER_1);

    private Player player2 = new Player(PLAYER_2);

    private Scanner sc = new Scanner(System.in);

    private Pieces killedPiece;

    public int getCounter() {
        return counter;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    private Pieces piece;

    public void start() {
        displayBoard();
        if (counter % 2 == 0) System.out.println("It's Player 1's turn!\n");
        else System.out.println("It's Player 2's turn\n");
        if (counter > 0) System.out.println("Enter -1 to undo");

        System.out.print("Enter the x ordinate: ");
        int x = sc.nextInt();

        if (x == -1) {
            try {
                if (killedPiece != null) {
                    if (counter % 2 == 0) {
                        piece.undoMove(killedPiece.getPieceConstant() + player1.getPlayer());
                        player1.revive(killedPiece);
                    }
                    else {
                        piece.undoMove(killedPiece.getPieceConstant() + player2.getPlayer());
                        player2.revive(killedPiece);
                    }
                } else {
                    piece.undoMove(Board.EMPTY);
                    if(piece instanceof King) ((King) piece).hasMoved=false;
                    if(piece instanceof Rook) ((Rook)piece).hasMoved=false;
                    if(hasCastled) {
                        if(counter%2==1) {
                            if (board[7][5].equals(ROOK + PLAYER_1)) {
                                ((Rook)player1.getPiece(new Point(7, 5))).hasMoved=false;
                                player1.getPiece(new Point(7, 5)).undoMove(EMPTY);
                            }
                            else if (board[7][3].equals(ROOK + PLAYER_1)) {
                                ((Rook)player1.getPiece(new Point(7, 3))).hasMoved=false;
                                player1.getPiece(new Point(7, 3)).undoMove(EMPTY);
                            }
                        }
                        else {
                            if (board[0][5].equals(ROOK + PLAYER_2)) {
                                ((Rook)player2.getPiece(new Point(0, 5))).hasMoved=false;
                                player2.getPiece(new Point(0, 5)).undoMove(EMPTY);
                            }
                            else if (board[0][3].equals(ROOK + PLAYER_2)) {
                                ((Rook)player2.getPiece(new Point(0, 3))).hasMoved=false;
                                player2.getPiece(new Point(0, 3)).undoMove(EMPTY);
                            }
                        }
                    }
                }
            } catch (NullPointerException e) {
                System.out.println("\n\nYou can undo only once!\n");
                counter++;
            }
            counter--;
            start();
        }

        System.out.print("Enter the y ordinate: ");
        int y = sc.nextInt();

        if (isEmpty(x, y)) {
            System.out.println("Please choose a Piece!\n");
            start();
        }

        if (counter % 2 == 0) piece = player1.getPiece(new Point(x, y));
        else piece = player2.getPiece(new Point(x, y));

        if (piece == null) {
            System.out.println("Choose your own Piece!\n");
        } else {
            List<Point> moves = piece.getMoves();
            if(moves.size()==0) {
                System.out.println("\nThe piece does not have any moves.");
                start();
            }
            System.out.println("\nThese are the available moves");
            for (Point point : moves) {
                System.out.println(point);
            }
            System.out.print("\nEnter the x-ordinate: ");
            x = sc.nextInt();
            System.out.print("Enter the y-ordinate: ");
            y = sc.nextInt();


            if (moves.contains(new Point(x, y))) {
                if (!isEmpty(x, y)) {
                    piece.doMove(new Point(x, y));
                    if (counter % 2 == 0) {
                        killedPiece = player2.getPiece(new Point(x, y));
                        player2.killPiece(killedPiece);
                        hasCastled = false;
                        if(piece instanceof Pawn && piece.getCurrentPoint().getX()==0) {
                            System.out.print("What do you want to promote?" +
                                    "\n\n1)Rook" +
                                    "\n2)Knight" +
                                    "\n3)Bishop" +
                                    "\n4)Queen" +
                                    "\n\nEnter your choice: ");
                            pawnPromote(x, y, player1);
                        }
                    } else {
                        killedPiece = player1.getPiece(new Point(x, y));
                        player1.killPiece(killedPiece);
                        hasCastled = false;
                        if(piece instanceof Pawn && piece.getCurrentPoint().getX()==7) {
                            System.out.print("What do you want to promote?" +
                                    "\n\n1)Rook" +
                                    "\n2)Knight" +
                                    "\n3)Bishop" +
                                    "\n4)Queen" +
                                    "\n\nEnter your choice: ");
                            pawnPromote(x, y, player2);
                        }
                    }
                    counter++;
                } else {
                    killedPiece = null;
                    piece.doMove(new Point(x, y));
                    hasCastled = false;
                    if(piece instanceof King) {
                        if(counter%2==0 && x==7 && y==6) {
                            player1.getPiece(new Point(7,7)).doMove(new Point(7,5));
                            ((Rook)player1.getPiece(new Point(7,5))).hasMoved = true;
                            hasCastled = true;
                        }
                        if(counter%2==0 && x==7 && y==2) {
                            player1.getPiece(new Point(7,0)).doMove(new Point(7,3));
                            ((Rook)player1.getPiece(new Point(7,3))).hasMoved = true;
                            hasCastled = true;
                        }
                        if(counter%2==1 && x==0 && y==6) {
                            player2.getPiece(new Point(0,7)).doMove(new Point(0,5));
                            ((Rook)player2.getPiece(new Point(0,5))).hasMoved = true;
                            hasCastled = true;
                        }
                        if(counter%2==1 && x==0 && y==2) {
                            player2.getPiece(new Point(0,0)).doMove(new Point(0,3));
                            ((Rook)player2.getPiece(new Point(0,3))).hasMoved = true;
                            hasCastled = true;
                        }
                        ((King)piece).hasMoved = true;
                    }
                    if(piece instanceof Rook) ((Rook)piece).hasMoved = true;
                    if(piece instanceof Pawn && piece.getCurrentPoint().getX()==0) {
                        System.out.print("What do you want to promote?" +
                                "\n\n1)Rook" +
                                "\n2)Knight" +
                                "\n3)Bishop" +
                                "\n4)Queen" +
                                "\n\nEnter your choice: ");
                        pawnPromote(x, y, player1);
                    }
                    if(piece instanceof Pawn && piece.getCurrentPoint().getX()==7) {
                        System.out.print("What do you want to promote?" +
                                "\n\n1)Rook" +
                                "\n2)Knight" +
                                "\n3)Bishop" +
                                "\n4)Queen" +
                                "\n\nEnter your choice: ");
                        pawnPromote(x, y, player2);
                    }
                    counter++;
                }
            }
        }

        if ((counter % 2 == 0 && player2.getKing().isCheck())
                || (counter % 2 == 1 && player1.getKing().isCheck())) System.out.println("\n\nCHECK!!");


    }

    private void pawnPromote(int x, int y, Player player) {
        switch (sc.nextInt()) {
            case 1: player.promotePawn(new Rook(new Point(x, y), player1)); break;
            case 2: player.promotePawn(new Knight(new Point(x, y), player1)); break;
            case 3: player.promotePawn(new Bishop(new Point(x, y), player1)); break;
            case 4: player.promotePawn(new Queen(new Point(x, y), player1)); break;
        }
    }

    private boolean isEmpty(int x, int y) {
        return board[x][y].equals(EMPTY);
    }
}
