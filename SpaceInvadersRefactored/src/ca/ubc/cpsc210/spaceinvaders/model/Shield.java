package ca.ubc.cpsc210.spaceinvaders.model;

import java.awt.*;

/**
 * Created by Arthur Desktop on 2016-04-11.
 */
public class Shield extends Sprite {

    private static final int SIZE_X = 80;
    private static final int SIZE_Y = 5;
    private static final int SHIELD_Y = SIGame.HEIGHT - 80;
    private static final Color COLOR = new Color(100, 222, 116);
    private int health;

    // Constructs a shield
    public Shield(int x, int health) {
        super (x, SHIELD_Y, SIZE_X, health*SIZE_Y);
        this.health = health;
    }

    @Override
    public void draw(Graphics g) {
        Color savedCol = g.getColor();
        g.setColor(COLOR);
        g.fillRect(getX() - SIZE_X / 2, getY() - SIZE_Y / 2, SIZE_X, health*SIZE_Y);
        g.setColor(savedCol);
    }

    public void decHealth() {
        this.health--;
    }

    public int getHealth() {
        return health;
    }
}
