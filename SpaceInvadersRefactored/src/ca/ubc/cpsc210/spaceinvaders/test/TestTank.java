package ca.ubc.cpsc210.spaceinvaders.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.spaceinvaders.model.SIGame;
import ca.ubc.cpsc210.spaceinvaders.model.Tank;


public class TestTank extends TestSprite {

	private Tank tnk;
	@Before
	public void runBefore() {
		sprite = new Tank(XLOC);
		tnk = (Tank) sprite;
	}

	@Test
	public void testGetY() {
		assertEquals(SIGame.HEIGHT - 40, sprite.getY());
	}

	@Test
	public void testUpdate() {
		final int NUM_UPDATES = 8;

		sprite.move();
		assertEquals(XLOC + tnk.getDX(), tnk.getX());

		for(int count = 1; count < NUM_UPDATES; count++) {
			sprite.move();
		}

		assertEquals(XLOC + NUM_UPDATES * tnk.getDX(), sprite.getX());
	}

	@Test
	public void testFlipDirection() {
		tnk.move();
		assertEquals(XLOC + tnk.getDX(), tnk.getX());
		tnk.faceLeft();
		tnk.move();
		assertEquals(XLOC, tnk.getX());
		tnk.faceRight();
		tnk.move();
		assertEquals(XLOC + tnk.getDX(), tnk.getX());
	}

	@Test
	public void testLeftBoundary() {
		tnk.faceLeft();
		for(int count = 0; count < SIGame.WIDTH / 2 / tnk.getDX() + 1; count++)
			tnk.move();
		assertEquals(0, tnk.getX());
		tnk.move();
		assertEquals(0, tnk.getX());
	}

	@Test
	public void testRightBoundary() {
		tnk.faceRight();
		for(int count = 0; count < SIGame.WIDTH / 2 / tnk.getDX() + 1; count++)
			tnk.move();
		assertEquals(SIGame.WIDTH, tnk.getX());
		tnk.move();
		assertEquals(SIGame.WIDTH, tnk.getX());
	}
}
