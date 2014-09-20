package edu.indiana.cs.c212;

/*
 solve a sudoku puzzle. this is the entry class of 3 classes:
 SudokuSolver, SudokuPuzzle, and SudokuCell.

 this class is responsible for two methods:

 public boolean canSolve(SudokuPuzzle puzzle)
 public static void main(String[] parameters)

 and it depends on five methods in SudokuPuzzle and two methods in
 SudokuCell

 SudokuPuzzle:
 public void fetch()
 public void show()
 public boolean hasEmptyCell()
 public SudokuCell getEmptyCell()
 public int getEmptyValue()

 SudokuCell:
 public void insert(int value)
 public boolean isLegalToInsert(int value)
 */
class SudokuSolver {
	public static final int PUZZLE_SIZE = SudokuPuzzle.PUZZLE_SIZE;

	public static boolean canSolve(SudokuPuzzle puzzle) {
		if (!puzzle.hasEmptyCell()) {
			// if we're here, the puzzle is solved
			return true;
		}

		// if we're here, the puzzle has at least one empty cell
		SudokuCell cell = puzzle.getEmptyCell();
		for (int digit = 1; digit <= PUZZLE_SIZE; digit++) {
			if (cell.isLegalToInsert(digit)) {
				// try digit in the cell
				cell.insert(digit);

				// with that choice, can we solve the rest of the puzzle?
				if (canSolve(puzzle)) {
					// yes, we can solve the rest of the puzzle
					return true;
				} else {
					// no, the choice didn't work somewhere down the
					// line,
					// so unmake it
					cell.insert(puzzle.getEmptyValue());
				}
			}
			// else, the digit wasn't legal for this empty cell,
			// so, go try to find another digit to try
		}

		// if we're here, we've tried all digits in the empty cell
		// but nothing worked, so either the puzzle is unsolvable,
		// or some earlier choice was wrong, so backtrack up the tree
		return false;
	}

	public static void main(String[] parameters) {
		// name a puzzle
		SudokuPuzzle puzzle;
		// make space for the puzzle
		puzzle = new SudokuPuzzle();
		// read in a puzzle
		puzzle.fetch();

		if (canSolve(puzzle)) {
			System.out.println("solved the puzzle!");
			puzzle.show();
		} else {
			System.out.println("can't solve the puzzle");
		}
	}
}