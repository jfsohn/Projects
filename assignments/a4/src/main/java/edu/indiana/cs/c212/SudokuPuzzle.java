package edu.indiana.cs.c212;

import java.util.Scanner;

/*
 An object of this class represents a sudoku puzzle with a grid,
 which here is implemented as a 2-dimensional array of ints
 in the range 0 to BOX_SIZE * BOX_SIZE (which equals PUZZLE_SIZE),
 where 0 represents a blank (i.e. to show that the cell is empty).
 (note: BOX_SIZE must be at least 2, and for normal sudoku, BOX_SIZE = 3,
 but it can also be 4, but for BOX_SIZE >= 5, depth-first search is too
 slow.)

 in sudoku, a particular cell can legally hold a particular value:
 if the value is an empty cell's value (i.e. it's 0)
 or if it's a legal digit value (i.e. it's in the range 1 to PUZZLE_SIZE)
 and neither its row, nor column, nor box has the same value.

 this class is responsible for nine methods:

 five are used by SudokuSolver:
 public void fetch()
 public void show()
 public boolean hasEmptyCell()
 public SudokuCell getEmptyCell()
 public int getEmptyValue()

 four are used by class SudokuCell:
 public boolean isEmptyValue(int value)
 public boolean isDigitValue(int value)
 public int get(int row, int column)
 public void set(int row, int column, int value)
 */
class SudokuPuzzle {
	public static final int BOX_SIZE = 2;
	public static final int PUZZLE_SIZE = BOX_SIZE * BOX_SIZE;
	public static final int ROW_COUNT = PUZZLE_SIZE;
	public static final int COLUMN_COUNT = PUZZLE_SIZE;

	// where the puzzle will be stored
	private int[][] grid;

	// make space for a puzzle
	public SudokuPuzzle() {
		grid = new int[ROW_COUNT][COLUMN_COUNT];
	}

	// report whether a particular value is an empty cell value
	public boolean isEmptyValue(int value) {
		return (value == getEmptyValue());
	}

	// report whether a particular value is a legal digit value
	public boolean isDigitLegal(int value) {
		return ((value >= 1) && (value <= PUZZLE_SIZE));
	}

	// report the value that represents an empty cell's value
	public int getEmptyValue() {
		return 0;
	}

	// report a particular cell's value
	public int get(int row, int column) {
		return grid[row][column];
	}

	// set a particular cell's value
	public void set(int row, int column, int value) {
		grid[row][column] = value;
	}

	// report whether this puzzle has an empty cell
	public boolean hasEmptyCell() {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int column = 0; column < COLUMN_COUNT; column++) {
				if (isEmpty(row, column))
					return true;
			}
		}
		return false;
	}

	// return an empty cell
	public SudokuCell getEmptyCell() {
		for (int row = 0; row < ROW_COUNT; row++) {
			for (int column = 0; column < COLUMN_COUNT; column++) {
				if (isEmpty(row, column))
					return new SudokuCell(this, row, column);
			}
		}

		// if we're here, no empty cell was found (so puzzle solved)
		return null;
	}
	
	public int[][] getPuzzle(){
		return grid;
	}

	// read the puzzle into the grid
	public void fetch() {
		// this is a very simple fetcher. it will crash if input doesn't
		// fit.
		// each value must be in the range 0 to PUZZLE_SIZE,
		// and the format must be right (i.e. PUZZLE_SIZExPUZZLE_SIZE)
		// note: a more sophisticated fetcher might also fetch from a
		// file
		// or from the web, and should check for various exceptions.
		// note: for true defensive programming, it might also check that
		// the entered puzzle is itself valid ...

		// for simplicity, this just reads from a keyboard and checks
		// nothing
		Scanner reader = new Scanner(System.in);

		System.out.println("please enter a sudoku puzzle:");
		/*
		 * for (int row = 0; row < PUZZLE_SIZE; row++) { for (int column = 0;
		 * column < PUZZLE_SIZE; column++) { int input = reader.nextInt(); if
		 * (isEmptyValue(input) || isDigitValue(input)) { grid[row][column] =
		 * input; } } }
		 */

		// quick hack test cases
		int[][] knownSolvablePuzzle1 = { // a 4x4 (i.e. BOX_SIZE = 2)
				{ 1, 0, 3, 0 }, { 0, 0, 0, 4 }, { 2, 0, 0, 0 }, { 0, 1, 0, 3 } };
		int[][] knownSolvablePuzzle2 = { // a 4x4 (i.e. BOX_SIZE = 2)
				{ 0, 0, 1, 0 }, { 0, 3, 0, 4 }, { 3, 0, 4, 0 }, { 0, 2, 0, 0 } };
		int[][] knownSolvablePuzzle3 = { // a 4x4 (i.e. BOX_SIZE = 2)
				{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int[][] knownSolvablePuzzle4 = { // a known easy one
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
		int[][] knownSolvablePuzzle5 = { // another known easy one
				{ 0, 6, 0, 1, 0, 4, 0, 5, 0 }, { 0, 0, 8, 3, 0, 5, 6, 0, 0 },
				{ 2, 0, 0, 0, 0, 0, 0, 0, 1 }, { 8, 0, 0, 4, 0, 7, 0, 0, 6 },
				{ 0, 0, 6, 0, 0, 0, 3, 0, 0 }, { 7, 0, 0, 9, 0, 1, 0, 0, 4 },
				{ 5, 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 7, 2, 0, 6, 9, 0, 0 },
				{ 0, 4, 0, 5, 0, 8, 0, 7, 0 } };
		int[][] knownSolvablePuzzle6 = { // a known hard one
				{ 4, 0, 0, 0, 0, 0, 8, 0, 5 }, { 0, 3, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 7, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 0, 0, 6, 0 },
				{ 0, 0, 0, 0, 8, 0, 4, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 6, 0, 3, 0, 7, 0 }, { 5, 0, 0, 2, 0, 0, 0, 0, 0 },
				{ 1, 0, 4, 0, 0, 0, 0, 0, 0 } };
		int[][] knownSolvablePuzzle7 = { // a completely blank
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int[][] knownUnsolvablePuzzle1 = { // a completely blank
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0 } };
		int[][] knownUnsolvablePuzzle2 = { // a 4x4 (i.e. BOX_SIZE = 2)
				{ 1, 0, 1, 0 }, { 0, 0, 0, 4 }, { 2, 0, 0, 0 }, { 0, 1, 0, 3 } };

		grid = knownUnsolvablePuzzle2;

		System.out.println("here's what i think you told me...");
		show();
	}

	// display this sudoku puzzle
	public void show() {
		printLine();
		for (int row = 0; row < ROW_COUNT; row++) {
			System.out.print('|');
			for (int column = 0; column < COLUMN_COUNT; column++) {
				if (isEmpty(row, column))
					System.out.print(' ');
				else
					System.out.print(grid[row][column]);
				System.out.print(' ');
			}
			System.out.println('|');
		}
		printLine();
	}

	// display a line
	private void printLine() {
		for (int column = 0; column < (2 * COLUMN_COUNT) + 2; column++)
			System.out.print('-');
		System.out.println();
	}

	// report whether a particular cell is empty
	private boolean isEmpty(int row, int column) {
		return isEmptyValue(grid[row][column]);
	}
}