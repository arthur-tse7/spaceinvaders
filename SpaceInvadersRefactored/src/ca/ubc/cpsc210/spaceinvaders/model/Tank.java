package ca.ubc.cpsc210.spaceinvaders.model;

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Represents a tank
public class Tank extends Sprite {

	public int DX = 2;
	private static final int SIZE_X = 15;
	private static final int SIZE_Y = 8;
	private static final int TANK_Y = SIGame.HEIGHT - 40;
	private static final Color COLOR = new Color(250, 128, 20);

	private int direction;
	private Timer t;
	
	// Constructs a tank
	// Effects: tank is located at position (x, TANK_Y)
	public Tank(int x) {
		super(x, TANK_Y, SIZE_X, SIZE_Y);
		direction = 1;
	}
	
	// Faces tank to the right
	// modifies: this
	// effects: tank is facing right
	public void faceRight() {
		direction = 1;
	}
	
	// Faces tank to the left
	// modifies: this
	// effects: tank is facing left
	public void faceLeft() {
		direction = -1;
	}

	public int getDX() {
		return DX;
	}

	@Override
	public void move() {
		x = x + direction * DX;
		
		super.move();
	}

	@Override
	public void draw(Graphics g) {
		Color savedCol = g.getColor();
		g.setColor(COLOR);
		g.fillRect(getX() - SIZE_X / 2, getY() - SIZE_Y / 2, SIZE_X, SIZE_Y);
		g.setColor(savedCol);
	}

	public void powerUp() {
		t = new Timer(30000, new PowerUpEndTimer());
		t.setRepeats(false);
		t.start();
		DX = DX * 2;
	}

	private class PowerUpEndTimer implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			DX = DX / 2;
			t.stop();
		}
	}
}
