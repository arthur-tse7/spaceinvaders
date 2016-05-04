package ca.ubc.cpsc210.spaceinvaders.model;

import java.awt.*;

/**
 * Created by Arthur Desktop on 2016-05-03.
 */

// Represents a powerup
public class PowerUp extends Sprite {
    private int type;

    public static final int DY = 1;
    public static final int RADIUS = 15;
    private static final Color COLOR = new Color(184, 188, 54);

    // Constructor
    // Effects: powerup is at position (x, y, type)
    public PowerUp(int x, int y, int type) {
        super(x, y, RADIUS, RADIUS);
        this.type = type;
    }

    @Override
    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(COLOR);
        g.fillOval(getX() - RADIUS / 2, getY() - RADIUS / 2, RADIUS, RADIUS);
        g.setColor(savedCol);
    }

    @Override
    public void move() {
        y = y + DY;

        super.move();
    }

    // Has invader collided with another sprite?
    // Effects: returns true if this Invader has collided with other Sprite; false otherwise
    public boolean collidedWith(Sprite other) {
        Rectangle thisBoundingRect = new Rectangle(getX() - getWidth() / 2, getY() - getHeight() / 2, getWidth(), getHeight());
        Rectangle otherBoundingRect = new Rectangle(other.getX() - other.getWidth() / 2, other.getY() - other.getHeight() / 2,
                other.getWidth(), other.getHeight());
        boolean hit = thisBoundingRect.intersects(otherBoundingRect);
        return hit;
    }
}
