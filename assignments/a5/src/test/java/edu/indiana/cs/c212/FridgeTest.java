package src.test.java.edu.indiana.cs.c212;

import static org.junit.Assert.*;
import src.main.java.edu.indiana.cs.c212.*;

import java.awt.Dimension;
import java.lang.reflect.Field;

import org.junit.Test;

public class FridgeTest {

	@Test
	public void testGetWidth() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
	      Fridge f = new Fridge();
	        Class<?> fridgeClass = f.getClass();
	        
	        Field sizeField = fridgeClass.getDeclaredField("size");
	        sizeField.setAccessible(true);
	        sizeField.set(f, new Dimension(30,15));
	        assertEquals(30, f.getWidth());
	}

	@Test
	public void testGetHeight() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Fridge f = new Fridge();
		Class<?> fridgeClass = f.getClass();
		
		Field sizeField = fridgeClass.getDeclaredField("size");
		sizeField.setAccessible(true);
		sizeField.set(f, new Dimension(30,15));
		assertEquals(15, f.getHeight());
		
	}

	@Test
	public void testGetPreferredSize() {
		Fridge f = new Fridge();
		Dimension d = Fridge.PREFERRED_SIZE;
		assertEquals(d, f.getPreferredSize());
	}

}
