package com.nishant.games.chess.game;

import com.nishant.games.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is the Player class.
 * It has only 2 instances, player1 and player2 used in the <I>Start.java</I>.
 *
 * <br><br>It has an array of Pieces of size 16. It contains all the instances of the Piece.
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class Player {

    private String player;

    private Pieces[] pieces = new Pieces[16];

    public Player(String player) {
        this.player = player;
        setPieces();
    }

    private void setPieces() {
        if (player.equals(Board.PLAYER_1)) {
            pieces[0] = new Pawn(new Point(6, 0), this);
            pieces[1] = new Pawn(new Point(6, 1), this);
            pieces[2] = new Pawn(new Point(6, 2), this);
            pieces[3] = new Pawn(new Point(6, 3), this);
            pieces[4] = new Pawn(new Point(6, 4), this);
            pieces[5] = new Pawn(new Point(6, 5), this);
            pieces[6] = new Pawn(new Point(6, 6), this);
            pieces[7] = new Pawn(new Point(6, 7), this);
            pieces[8] = new Rook(new Point(7, 0), this);
            pieces[9] = new Knight(new Point(7, 1), this);
            pieces[10] = new Bishop(new Point(7, 2), this);
            pieces[11] = new Queen(new Point(7, 3), this);
            pieces[12] = new King(new Point(7, 4), this);
            pieces[13] = new Bishop(new Point(7, 5), this);
            pieces[14] = new Knight(new Point(7, 6), this);
            pieces[15] = new Rook(new Point(7, 7), this);
        } else {
            pieces[0] = new Pawn(new Point(1, 0), this);
            pieces[1] = new Pawn(new Point(1, 1), this);
            pieces[2] = new Pawn(new Point(1, 2), this);
            pieces[3] = new Pawn(new Point(1, 3), this);
            pieces[4] = new Pawn(new Point(1, 4), this);
            pieces[5] = new Pawn(new Point(1, 5), this);
            pieces[6] = new Pawn(new Point(1, 6), this);
            pieces[7] = new Pawn(new Point(1, 7), this);
            pieces[8] = new Rook(new Point(0, 0), this);
            pieces[9] = new Knight(new Point(0, 1), this);
            pieces[10] = new Bishop(new Point(0, 2), this);
            pieces[11] = new Queen(new Point(0, 3), this);
            pieces[12] = new King(new Point(0, 4), this);
            pieces[13] = new Bishop(new Point(0, 5), this);
            pieces[14] = new Knight(new Point(0, 6), this);
            pieces[15] = new Rook(new Point(0, 7), this);
        }
    }

    public Pieces getPiece(Point point) {
        for (Pieces piece : pieces)
            if (piece.isAlive() && piece.getCurrentPoint().equals(point))
                return piece;
        return null;
    }

    public King getKing() {
        return (King) pieces[12];
    }

    public List<Point> getMoves() {
        List<Point> moves = new ArrayList<>();
        for(Pieces p : pieces)
            if (p.isAlive())
                moves.addAll(p.getMoves());
        return moves;
    }

    public String getPlayer() {
        return player;
    }

    public void killPiece(Pieces piece) {
        for (int i = 0; i < 16; i++) {
            if (pieces[i].isAlive() && pieces[i].equals(piece)) {
                pieces[i].kill();
                break;
            }
        }
    }

    public void revive(Pieces piece) {
        for (int i =0;i<16;i++) {
            if(!pieces[i].isAlive() && pieces[i].equals(piece)) {
                pieces[i].revive();
                break;
            }
        }
    }

    public void promotePawn(Pieces piece) {
        Board.board[piece.getCurrentPoint().getX()][piece.getCurrentPoint().getY()] = piece.getPieceConstant() + getPlayer();
        for (int i = 0; i < 16; i++) {
            if(pieces[i].getCurrentPoint().equals(piece.getCurrentPoint()))
                pieces[i] = piece;
        }
    }
}