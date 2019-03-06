package com.nishant.games.chess.pieces;

import com.nishant.games.chess.game.Player;
import com.nishant.games.chess.game.Point;

import java.util.ArrayList;
import java.util.List;

import static com.nishant.games.chess.game.Board.*;

/**
 * Action taken when player chooses a king to play.
 * It has an additional method to check if the king is at Check.
 *
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class King extends Pieces {
    public boolean hasMoved;
    public King(Point currentPoint, Player player) {
        super(currentPoint, player);
        hasMoved = false;
    }

    @SuppressWarnings("Duplicates")
    @Override
    public List<Point> getMoves() {
        int x = currentPoint.getX(), y = currentPoint.getY();
        List<Point> availableMoves = new ArrayList<>();
        if (x < 7 && isEmpty(x + 1, y)) {
            doMove(new Point(x + 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y));
            undoMove(EMPTY);
        }
        if (x > 0 && isEmpty(x - 1, y)) {
            doMove(new Point(x - 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y));
            undoMove(EMPTY);
        }
        if (y < 7 && isEmpty(x, y + 1)) {
            doMove(new Point(x, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y + 1));
            undoMove(EMPTY);
            if(player.getPlayer().equals(PLAYER_1)) {
                if (!player.getKing().isCheck() && y<6 && isEmpty(x, y+2) && currentPoint.equals(new Point(7, 4)) && !hasMoved && board[7][7].equals(ROOK+PLAYER_1)) {
                    Rook rook = (Rook)player.getPiece(new Point(7,7));
                    if(!rook.getHasMoved()) {
                        doMove(new Point(7, 6));
                        rook.doMove(new Point(7,5));
                    }
                    if(!player.getKing().isCheck()) availableMoves.add(new Point(7,6));
                    undoMove(EMPTY);
                    rook.undoMove(EMPTY);
                }
            }
            else if(!player.getKing().isCheck() && y<6 && isEmpty(x, y+2) && currentPoint.equals(new Point(0, 4)) && !hasMoved && board[0][7].equals(ROOK+PLAYER_1)) {
                Rook rook = (Rook)player.getPiece(new Point(0,7));
                if(!rook.getHasMoved()) {
                    doMove(new Point(0, 6));
                    rook.doMove(new Point(0,5));
                }
                if(!player.getKing().isCheck()) availableMoves.add(new Point(0,6));
                undoMove(EMPTY);
                rook.undoMove(EMPTY);
            }
        }
        if (y > 0 && isEmpty(x, y - 1)) {
            doMove(new Point(x, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y - 1));
            undoMove(EMPTY);
            if(player.getPlayer().equals(PLAYER_1)) {
                if (!player.getKing().isCheck() && y>1 &&isEmpty(x, y-2) && currentPoint.equals(new Point(7, 4)) && !hasMoved && board[7][0].equals(ROOK+PLAYER_1)) {
                    Rook rook = (Rook)player.getPiece(new Point(7,0));
                    if(!rook.getHasMoved()) {
                        doMove(new Point(7, 2));
                        rook.doMove(new Point(7,3));
                    }
                    if(!player.getKing().isCheck()) availableMoves.add(new Point(7,2));
                    undoMove(EMPTY);
                    rook.undoMove(EMPTY);
                }
            }
            else if(!player.getKing().isCheck() && y>1 && isEmpty(x, y-2) && currentPoint.equals(new Point(0, 4)) && !hasMoved && board[0][0].equals(ROOK+PLAYER_1)) {
                Rook rook = (Rook)player.getPiece(new Point(0,0));
                if(!rook.getHasMoved()) {
                    doMove(new Point(0, 2));
                    rook.doMove(new Point(0,3));
                }
                if(!player.getKing().isCheck()) availableMoves.add(new Point(0,2));
                undoMove(EMPTY);
                rook.undoMove(EMPTY);
            }
        }
        if (x < 7 && y < 7 && isEmpty(x + 1, y + 1)) {
            doMove(new Point(x + 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y + 1));
            undoMove(EMPTY);
        }
        if (x < 7 && y > 0 && isEmpty(x + 1, y - 1)) {
            doMove(new Point(x + 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y - 1));
            undoMove(EMPTY);
        }
        if (x > 0 && y < 7 && isEmpty(x - 1, y + 1)) {
            doMove(new Point(x - 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y + 1));
            undoMove(EMPTY);
        }
        if (x > 0 && y > 0 && isEmpty(x - 1, y - 1)) {
            doMove(new Point(x - 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y - 1));
            undoMove(EMPTY);
        }

        if (x < 7 && !isEmpty(x + 1, y) && !player.getPlayer().equals(board[x + 1][y].substring(1))) {
            String piece = board[x + 1][y];
            doMove(new Point(x + 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y));
            undoMove(piece);
        }
        if (x > 0 && !isEmpty(x - 1, y) && !player.getPlayer().equals(board[x - 1][y].substring(1))) {
            String piece = board[x - 1][y];
            doMove(new Point(x - 1, y));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y));
            undoMove(piece);
        }
        if (y < 7 && !isEmpty(x, y + 1) && !player.getPlayer().equals(board[x][y + 1].substring(1))) {
            String piece = board[x][y + 1];
            doMove(new Point(x, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y + 1));
            undoMove(piece);
        }
        if (y > 0 && !isEmpty(x, y - 1) && !player.getPlayer().equals(board[x][y - 1].substring(1))) {
            String piece = board[x][y - 1];
            doMove(new Point(x, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x, y - 1));
            undoMove(piece);
        }
        if (x < 7 && y < 7 && !isEmpty(x + 1, y + 1) && !player.getPlayer().equals(board[x + 1][y + 1].substring(1))) {
            String piece = board[x + 1][y + 1];
            doMove(new Point(x + 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y + 1));
            undoMove(piece);
        }
        if (x < 7 && y > 0 && !isEmpty(x + 1, y - 1) && !player.getPlayer().equals(board[x + 1][y - 1].substring(1))) {
            String piece = board[x + 1][y - 1];
            doMove(new Point(x + 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x + 1, y - 1));
            undoMove(piece);
        }
        if (x > 0 && y < 7 && !isEmpty(x - 1, y + 1) && !player.getPlayer().equals(board[x - 1][y + 1].substring(1))) {
            String piece = board[x - 1][y + 1];
            doMove(new Point(x - 1, y + 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y + 1));
            undoMove(piece);
        }
        if (x > 0 && y > 0 && !isEmpty(x - 1, y - 1) && !player.getPlayer().equals(board[x - 1][y - 1].substring(1))) {
            String piece = board[x - 1][y - 1];
            doMove(new Point(x - 1, y - 1));
            if (!player.getKing().isCheck()) availableMoves.add(new Point(x - 1, y - 1));
            undoMove(piece);
        }
        return availableMoves;
    }

    public boolean isCheck() {
        int x = currentPoint.getX(), y = currentPoint.getY();

        //Check whether there is a queen or bishop in way of the the king.
        while (x < 7 && y < 7 && isEmpty(x + 1, y + 1)) {
            x++;
            y++;
        }

        if (x < 7 && y < 7 && !player.getPlayer().equals(board[x + 1][y + 1].substring(1))
                && (board[x + 1][y + 1].substring(0, 1).equals(QUEEN) ||
                board[x + 1][y + 1].substring(0, 1).equals(BISHOP))) return true;

        x = currentPoint.getX();
        y = currentPoint.getY();

        while (x < 7 && y > 0 && isEmpty(x + 1, y - 1)) {
            x++;
            y--;
        }

        if (x < 7 && y > 0 && !player.getPlayer().equals(board[x + 1][y - 1].substring(1))
                && (board[x + 1][y - 1].substring(0, 1).equals(QUEEN) ||
                board[x + 1][y - 1].substring(0, 1).equals(BISHOP))) return true;

        x = currentPoint.getX();
        y = currentPoint.getY();

        while (x > 0 && y > 0 && isEmpty(x - 1, y - 1)) {
            x--;
            y--;
        }

        if (x > 0 && y > 0 && !player.getPlayer().equals(board[x - 1][y - 1].substring(1))
                && (board[x - 1][y - 1].substring(0, 1).equals(QUEEN) ||
                board[x - 1][y - 1].substring(0, 1).equals(BISHOP))) return true;

        x = currentPoint.getX();
        y = currentPoint.getY();

        while (x > 0 && y < 7 && isEmpty(x - 1, y + 1)) {
            x--;
            y++;
        }

        if (x > 0 && y < 7 && !player.getPlayer().equals(board[x - 1][y + 1].substring(1))
                && (board[x - 1][y + 1].substring(0, 1).equals(QUEEN) ||
                board[x - 1][y + 1].substring(0, 1).equals(BISHOP))) return true;

        x = currentPoint.getX();
        y = currentPoint.getY();


        //Check whether a queen or rook is in the way of the king.
        while (x < 7 && isEmpty(x + 1, y)) {
            x++;
        }

        if (x < 7 && !player.getPlayer().equals(board[x + 1][y].substring(1))
                && (board[x + 1][y].substring(0, 1).equals(QUEEN) ||
                board[x + 1][y].substring(0, 1).equals(ROOK))) return true;

        x = currentPoint.getX();

        while (x > 0 && isEmpty(x - 1, y)) {
            x--;
        }

        if (x > 0 && !player.getPlayer().equals(board[x - 1][y].substring(1))
                && (board[x - 1][y].substring(0, 1).equals(QUEEN) ||
                board[x - 1][y].substring(0, 1).equals(ROOK))) return true;

        x = currentPoint.getX();

        while (y < 7 && isEmpty(x, y + 1)) {
            y++;
        }

        if (y < 7 && !player.getPlayer().equals(board[x][y + 1].substring(1))
                && (board[x][y + 1].substring(0, 1).equals(QUEEN) ||
                board[x][y + 1].substring(0, 1).equals(ROOK))) return true;

        y = currentPoint.getY();

        while (y > 0 && isEmpty(x, y - 1)) {
            y--;
        }

        if (y > 0 && !player.getPlayer().equals(board[x][y - 1].substring(1))
                && (board[x][y - 1].substring(0, 1).equals(QUEEN) ||
                board[x][y - 1].substring(0, 1).equals(ROOK))) return true;

        x = currentPoint.getX();
        y = currentPoint.getY();

        //Checks if an opponent king is in the way of the king.
        if (x < 7 && y < 7 && !player.getPlayer().equals(board[x + 1][y + 1].substring(1))
                && board[x + 1][y + 1].substring(0, 1).equals(KING)) return true;
        if (x > 0 && y < 7 && !player.getPlayer().equals(board[x - 1][y + 1].substring(1))
                && board[x - 1][y + 1].substring(0, 1).equals(KING)) return true;
        if (x < 7 && y > 0 && !player.getPlayer().equals(board[x + 1][y - 1].substring(1))
                && board[x + 1][y - 1].substring(0, 1).equals(KING)) return true;
        if (x > 0 && y > 0 && !player.getPlayer().equals(board[x - 1][y - 1].substring(1))
                && board[x - 1][y - 1].substring(0, 1).equals(KING)) return true;
        if (x < 7 && !player.getPlayer().equals(board[x + 1][y].substring(1))
                && board[x + 1][y].substring(0, 1).equals(KING)) return true;
        if (x > 0 && !player.getPlayer().equals(board[x - 1][y].substring(1))
                && board[x - 1][y].substring(0, 1).equals(KING)) return true;
        if (y < 7 && !player.getPlayer().equals(board[x][y + 1].substring(1))
                && board[x][y + 1].substring(0, 1).equals(KING)) return true;
        if (y > 0 && !player.getPlayer().equals(board[x][y - 1].substring(1))
                && board[x][y - 1].substring(0, 1).equals(KING)) return true;

        //Checks if knight is in the way of the king.
        if (x < 7 && y < 6 && !player.getPlayer().equals(board[x + 1][y + 2].substring(1))
                && board[x + 1][y + 2].substring(0, 1).equals(KNIGHT)) return true;
        if (x > 0 && y < 6 && !player.getPlayer().equals(board[x - 1][y + 2].substring(1))
                && board[x - 1][y + 2].substring(0, 1).equals(KNIGHT)) return true;
        if (x < 6 && y > 0 && !player.getPlayer().equals(board[x + 1][y - 1].substring(1))
                && board[x + 1][y - 1].substring(0, 1).equals(KNIGHT)) return true;
        if (x < 6 && y < 7 && !player.getPlayer().equals(board[x + 2][y + 1].substring(1))
                && board[x + 2][y + 1].substring(0, 1).equals(KNIGHT)) return true;
        if (x < 7 && y > 1 && !player.getPlayer().equals(board[x + 1][y - 2].substring(1))
                && board[x + 1][y - 2].substring(0, 1).equals(KNIGHT)) return true;
        if (x > 0 && y > 1 && !player.getPlayer().equals(board[x - 1][y - 2].substring(1))
                && board[x - 1][y - 2].substring(0, 1).equals(KNIGHT)) return true;
        if (x > 1 && y > 0 && !player.getPlayer().equals(board[x - 2][y - 1].substring(1))
                && board[x - 2][y - 1].substring(0, 1).equals(KNIGHT)) return true;
        if (x > 1 && y < 7 && !player.getPlayer().equals(board[x - 2][y + 1].substring(1))
                && board[x - 2][y + 1].substring(0, 1).equals(KNIGHT)) return true;

        //Checks if pawn is in the way of the king.
        if(player.getPlayer().equals(PLAYER_1)) {
            if(x>0 && y>0 && !player.getPlayer().equals(board[x-1][y-1].substring(1))
                    && board[x-1][y-1].substring(0,1).equals(PAWN)) return true;
            return x > 0 && y < 7 && !player.getPlayer().equals(board[x - 1][y + 1].substring(1))
                    && board[x - 1][y + 1].substring(0, 1).equals(PAWN);
        }
        else {
            if(x<7 && y>0 && !player.getPlayer().equals(board[x+1][y-1].substring(1))
                    && board[x+1][y-1].substring(0,1).equals(PAWN)) return true;
            return x < 7 && y < 7 && !player.getPlayer().equals(board[x + 1][y + 1].substring(1))
                    && board[x + 1][y + 1].substring(0, 1).equals(PAWN);
        }
    }

    @Override
    public String getPieceConstant() {
        return KING;
    }
}
