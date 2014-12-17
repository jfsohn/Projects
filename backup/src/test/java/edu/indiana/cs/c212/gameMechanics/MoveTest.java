package edu.indiana.cs.c212.gameMechanics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class MoveTest {

	@Test(timeout = 100)
	public void testMove() {
		Move m = new Move(2, 3);
		assertNotNull(m);
	}

	@Test(timeout = 100)
	public void testGetX() {
		Move m = new Move(4, 3);
		assertEquals(4, m.getX());
	}

	@Test(timeout = 100)
	public void testGetY() {
		Move m = new Move(1, 2);
		assertEquals(2, m.getY());
	}

	@Test(timeout = 100)
	public void testEquals() {
		Move m = new Move(1, 2);
		Move m2 = new Move(1, 2);
		System.out.println("x:" + m.getX() + " & y: " + m.getY());
		System.out.println("x:" + m2.getX() + " & y: " + m2.getY());
		assertEquals("", m, m2);
	}
}
