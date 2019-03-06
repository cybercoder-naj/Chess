package com.nishant.games.chess.pieces;

import com.nishant.games.chess.game.Player;
import com.nishant.games.chess.game.Point;

import java.util.ArrayList;
import java.util.List;

import static com.nishant.games.chess.game.Board.*;

/**
 * Action taken when player chooses a queen to play.
 *
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class Queen extends Pieces {
    public Queen(Point currentPoint, Player player) {
        super(currentPoint, player);
    }

    @Override
    public List<Point> getMoves() {
        List<Point> availableMoves = new ArrayList<>();
        List<Point> rook = getRookMoves();
        List<Point> bishop = getBishopMoves();
        availableMoves.addAll(rook);
        availableMoves.addAll(bishop);
        return availableMoves;
    }

    @Override
    public String getPieceConstant() {
        return QUEEN;
    }

    @SuppressWarnings("Duplicates")
    private List<Point> getBishopMoves() {
        List<Point> availableMoves = new ArrayList<>();
        int x = currentPoint.getX(), y = currentPoint.getY();
        while (x < 7 && y < 7 && isEmpty(x + 1, y + 1)) {
            doMove(new Point(x + 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y + 1));
            undoMove(EMPTY);
            x++;
            y++;
        }

        if (x < 7 && y < 7 && !player.getPlayer().equals(board[x + 1][y + 1].substring(1))) {
            String piece = board[x + 1][y + 1];
            doMove(new Point(x + 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y + 1));
            undoMove(piece);
        }

        x = currentPoint.getX();
        y = currentPoint.getY();

        while (x < 7 && y > 0 && isEmpty(x + 1, y - 1)) {
            doMove(new Point(x + 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y - 1));
            undoMove(EMPTY);
            x++;
            y--;
        }

        if (x < 7 && y > 0 && !player.getPlayer().equals(board[x + 1][y - 1].substring(1))) {
            String piece = board[x + 1][y - 1];
            doMove(new Point(x + 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y - 1));
            undoMove(piece);
        }

        x = currentPoint.getX();
        y = currentPoint.getY();

        while (x > 0 && y < 7 && isEmpty(x - 1, y + 1)) {
            doMove(new Point(x - 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y + 1));
            undoMove(EMPTY);
            x--;
            y++;
        }

        if (x > 0 && y < 7 && !player.getPlayer().equals(board[x - 1][y + 1].substring(1))) {
            String piece = board[x - 1][y + 1];
            doMove(new Point(x - 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y + 1));
            undoMove(piece);
        }

        x = currentPoint.getX();
        y = currentPoint.getY();

        while (x > 0 && y > 0 && isEmpty(x - 1, y - 1)) {
            doMove(new Point(x - 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y - 1));
            undoMove(EMPTY);
            x--;
            y--;
        }

        if (x > 0 && y > 0 && !player.getPlayer().equals(board[x - 1][y - 1].substring(1))) {
            String piece = board[x - 1][y - 1];
            doMove(new Point(x - 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y - 1));
            undoMove(piece);
        }

        return availableMoves;
    }

    @SuppressWarnings("Duplicates")
    public List<Point> getRookMoves() {
        int x = currentPoint.getX(), y = currentPoint.getY();
        List<Point> availableMoves = new ArrayList<>();
        while (x < 7 && isEmpty(x + 1, y)) {
            doMove(new Point(x + 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y));
            undoMove(EMPTY);
            x++;
        }

        if (x < 7 && !player.getPlayer().equals(board[x + 1][y].substring(1))) {
            String piece = board[x + 1][y];
            doMove(new Point(x + 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y));
            undoMove(piece);
        }

        x = currentPoint.getX();

        while (x > 0 && isEmpty(x - 1, y)) {
            doMove(new Point(x - 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y));
            undoMove(EMPTY);
            x--;
        }

        if (x > 0 && !player.getPlayer().equals(board[x - 1][y].substring(1))) {
            String piece = board[x - 1][y];
            doMove(new Point(x - 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y));
            undoMove(piece);
        }

        x = currentPoint.getX();

        while (y < 7 && isEmpty(x, y + 1)) {
            doMove(new Point(x, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y + 1));
            undoMove(EMPTY);
            y++;
        }

        if (y < 7 && !player.getPlayer().equals(board[x][y + 1].substring(1))) {
            String piece = board[x][y + 1];
            doMove(new Point(x, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y + 1));
            undoMove(piece);
        }

        y = currentPoint.getY();

        while (y > 0 && isEmpty(x, y - 1)) {
            doMove(new Point(x, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y - 1));
            undoMove(EMPTY);
            y--;
        }

        if (y > 0 && !player.getPlayer().equals(board[x][y - 1].substring(1))) {
            String piece = board[x][y - 1];
            doMove(new Point(x, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y - 1));
            undoMove(piece);
        }

        return availableMoves;
    }
}
