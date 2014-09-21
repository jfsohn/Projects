package edu.indiana.cs.c212;

/*
 solve a sudoku puzzle. this is the entry class of 3 classes:
 SudokuSolver, SudokuPuzzle, and SudokuCell.

 */
class SudokuSolver {

	public static boolean canSolve(SudokuPuzzle puzzle) {
		//FIXME
		int puzzleSize = puzzle.getPuzzleSize();
		if (!puzzle.hasEmptyCell()) {
			// if we're here, the puzzle is solved
			return true;
		}

		// if we're here, the puzzle has at least one empty cell
		SudokuCell cell = puzzle.getEmptyCell();
		for (int digit = 1; digit <= puzzleSize; digit++) {
			if (cell.isLegalToInsert(digit, puzzle)) {
				// try digit in the cell
				cell.insert(digit);
				// with that choice, can we solve the rest of the puzzle?
				if (canSolve(puzzle)) {
					// yes, we can solve the rest of the puzzle
					return true;
				} else {
					// the choice failed somewhere down the line so unmake it.
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
		//
	}

	public static void main(String[] parameters) {
		SudokuPuzzle puzzle;
		puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(SudokuPuzzleContainer.knownSolvablePuzzle4);
		System.out.println("Here's the puzzle I'm trying to solve:");
		puzzle.show();

		if (canSolve(puzzle)) {
			System.out.println("And here's a solution:");
			puzzle.show();
		} else {
			System.out.println("This puzzle is unsolvable.");
		}
	}
}