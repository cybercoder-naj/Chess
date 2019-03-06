package com.nishant.games.chess.game;

/**
 * This class is the most important because it handles the Points on the Board.
 * It has the x and y coordinate ranging from 0 - 7.
 * <br><br>It has overriden the <code>public boolean equals(Object o)</code>
 * to check for x amd y coordinate equality.
 *
 * @author NISHANT
 * @since 20-12-2018
 * @version 1.0
 */
public class Point {

    private int x;

    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point p = (Point) o;
            return p.x == this.x && p.y == this.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}