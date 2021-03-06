package edu.indiana.cs.c212;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * For more details please make sure to check out the wiki. It has detailed instructions
 * about how to complete the assignment.
 */

public class ColoredSquares extends JPanel {
	static JPanel controlPanel;

	private Random randomNumberGenerator = new Random();


	/**
	 * Constructor to set the size of window
	 */
	public ColoredSquares() {
		Dimension dimension = new Dimension(300, 300);
		this.setPreferredSize(dimension);
	}

	/****************************************************************************
	 * Instance Methods
	 ****************************************************************************/

	/**
	 * painting method on the JPanel
	 */
	@Override
	public void paintComponent(Graphics g) {
		this.setBackground(BACKGROUND_COLOR);

		
		
		// find number of rows and columns by 300/30
		/* Add just two missing lines (two `for-loops', one inside the other) to this paint() method. (Number the
		 * rows and columns counting from zero.) And to do that, all you really need to know is that you can access 
		 * the variables 'numberOfRows' and 'numberOfColumns' from inside the paint() method. 
		 */
		int row;
		row = 0;
		int numberofRows=10;
		int numberofCols=10;
		Graphics2D tablet2D = (Graphics2D) g;
		while (row<10) {
			int col=0;
			while (col<10){
				drawBlock(tablet2D,row,col);
				col++;  }
			row++;}





		// call drawBlock method to draw squares of required size on JPanel





		
		//	drawBlock(tablet2D, row, column);
	}
	
	// call drawBlock method to draw squares of required size on JPanel
	private void drawBlock(Graphics2D tablet, int row, int column) {
		int xOrigin, yOrigin, width, height;
		Rectangle rectangle;
		tablet.setColor(makeRandomColor());
		tablet.fillRect(row*30,column*30,27,27);
		 tablet.setColor(Color.BLACK);
         tablet.drawRect(row*30,column*30,27,27);


	}

	private Color makeRandomColor() {
		Color color1= new Color (randomColorValue(),randomColorValue(),randomColorValue());
		return color1;
	}

	// this method generates random integer number between 0 (inclusive) and the specified value (exclusive)
	private int randomColorValue() {
		return randomNumberGenerator.nextInt(COLOR_RANGE);
	}

	// The entry main() method
	public static void main(String[] args) {
		JFrame frame = new JFrame("Colored Squares");

		ColoredSquares coloredSquares = new ColoredSquares();

		frame.setContentPane(coloredSquares);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); // "this" JFrame will be resized to pack all of its components
		frame.setResizable(true); // Sets whether this frame is resizable by the user.
		frame.setVisible(true); // show it
	}

	/**
	 * *************************************************************************
	 * Class constants
	 * **************************************************************************
	 */

	public static final int INNER_SQUARE_SIZE = 25; // pixels
	public static final int OUTLINE_THICKNESS = 1; // pixels
	public static final int BACKGROUND_THICKNESS = 3; // pixels
	public static final int OUTER_SQUARE_SIZE = INNER_SQUARE_SIZE + OUTLINE_THICKNESS * 2;
	public static final int BLOCK_SIZE = OUTER_SQUARE_SIZE+ BACKGROUND_THICKNESS;

	public static final Color BACKGROUND_COLOR = Color.CYAN;
	public static final Color OUTLINE_COLOR = Color.BLACK;

	public static final int COLOR_RANGE = 256;

}
