package edu.indiana.cs.c212;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;
import java.lang.reflect.Field;

import javax.swing.JLabel;

import org.junit.Test;

public class MagnetTest {

	@Test
	public void testGetWord() {
		Magnet m = new Magnet("Name");
		assertEquals("Name", m.getWord());
	}

	@Test
	public void testGetOrigin() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Magnet m = new Magnet("octocat");
		Class<?> magnetClass = m.getClass();
		Field originField = magnetClass.getDeclaredField("origin");
		originField.setAccessible(true);
		Point origin = (Point) originField.get(m);
		
		assertEquals(origin, m.getOrigin());
	}

	@Test
	public void testGetTextLabel() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
	      Magnet m = new Magnet("octocat");
	        assertEquals("octocat", m.getTextLabel().getText());
	}

	@Test
	public void testGetWidth() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
	      Magnet m = new Magnet("octocat");
	        Class<?> magnetClass = m.getClass();
	        Field widthField = magnetClass.getDeclaredField("width");
	        widthField.setAccessible(true);
	        int width = (Integer) widthField.get(m);
	        assertEquals(width, m.getWidth());
	}

	@Test
	public void testGetHeight() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	      Magnet m = new Magnet("octocat");
	        Class<?> magnetClass = m.getClass();
	        Field heightField = magnetClass.getDeclaredField("height");
            heightField.setAccessible(true);
            int height = (Integer) heightField.get(m);
            assertEquals(height, m.getHeight());
	}

	@Test
	public void testGetRectangle() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
	      Magnet m = new Magnet("octocat");
	        Class<?> magnetClass = m.getClass();
	        Field rectField = magnetClass.getDeclaredField("rectangle");
	        rectField.setAccessible(true);
	        Rectangle rect = (Rectangle) rectField.get(m);
	        assertEquals(rect, m.getRectangle());
	}

	@Test
	public void testGetOffset() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	      Magnet m = new Magnet("octocat");
	        Class<?> magnetClass = m.getClass();
	        Field offsetField = magnetClass.getDeclaredField("offset");
	        offsetField.setAccessible(true);
	        Point offset = (Point) offsetField.get(m);
	        
	        assertEquals(offset, m.getOffset());
	}

	
	public void testSetOffset() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Magnet m = new Magnet("octocat");
		m.setOffset(new Point(40, 3));
		Class<?> magnetClass = m.getClass();
		Field originField = magnetClass.getDeclaredField("origin");
        originField.setAccessible(true);
        Point origin = (Point) originField.get(m);
        
        Field offsetField = magnetClass.getDeclaredField("offset");
        offsetField.setAccessible(true);
        Point offset = (Point) offsetField.get(m);
		
		assertEquals(new Point(40 - origin.x, 3 - origin.y), offset);
	}

}
