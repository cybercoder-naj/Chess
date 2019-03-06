package com.nishant.games.chess.pieces;

import com.nishant.games.chess.game.Player;
import com.nishant.games.chess.game.Point;

import java.util.ArrayList;
import java.util.List;

import static com.nishant.games.chess.game.Board.*;

/**
 * Action taken when player chooses a bishop to play.
 *
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class Bishop extends Pieces {

    public Bishop(Point currentPoint, Player player) {
        super(currentPoint, player);
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Point> getMoves() {
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

    @Override
    public String getPieceConstant() {
        return BISHOP;
    }
}
