package edu.indiana.cs.c212;

/*
 An object of this class manages a particular cell of a sudoku puzzle.
 Its two main tasks are:
 -to insert a value into the cell it manages
 -to decide if it is legal to insert a given value in the cell it manages
 its cell can hold a given value only if:
 (1) the value is an empty cell value, or
 (2) the value is a legal digit value, and
 neither this cell's row, nor column, nor box has the same value

 this class is responsible for two methods:
 public void insert(int value)
 public boolean isLegalToInsert(int value)

 and it depends on four methods of class SudokuPuzzle:
 public boolean isEmptyValue(int value)
 public boolean isDigitValue(int value)
 public int get(int row, int column)
 public void set(int row, int column, int value)
 */
class SudokuCell {
	public static final int BOX_SIZE = SudokuPuzzle.BOX_SIZE;
	public static final int ROW_COUNT = SudokuPuzzle.ROW_COUNT;
	public static final int COLUMN_COUNT = SudokuPuzzle.COLUMN_COUNT;

	// which sudoku puzzle this cell belongs to
	private SudokuPuzzle puzzle;
	// which row and column (of cells) this cell is in
	private int row, column;
	// which row and column (of boxes) this cell is in
	private int boxRow, boxColumn;

	// make space for this cell
	public SudokuCell(SudokuPuzzle puzzle, int row, int column) {
		this.puzzle = puzzle;
		this.row = row;
		this.column = column;
		boxRow = (row / BOX_SIZE) * BOX_SIZE;
		boxColumn = (column / BOX_SIZE) * BOX_SIZE;
	}

	// change this cell to store the given value
	public void insert(int value) {
		puzzle.set(row, column, value);
	}

	// report whether this cell can legally hold the given value.
	public boolean isLegalToInsert(int value) {
		if (puzzle.isEmptyValue(value)) {
			return true;
		}
		if (!puzzle.isDigitLegal(value)) {
			return false;
		}
		return (isLegalForRow(value) && isLegalForColumn(value) && isLegalForBox(value));
	}

	// report whether this cell's row has the given digit
	private boolean isLegalForRow(int digit) {
		for (int columnIndex = 0; columnIndex < COLUMN_COUNT; columnIndex++) {
			if ((columnIndex != column)
					&& (puzzle.get(row, columnIndex) == digit)) {
				return false;
			}
		}

		return true;
	}

	// report whether this cell's column has the given digit
	private boolean isLegalForColumn(int digit) {
		for (int rowIndex = 0; rowIndex < ROW_COUNT; rowIndex++) {
			if ((rowIndex != row) && (puzzle.get(rowIndex, column) == digit)) {
				return false;
			}
		}

		return true;
	}

	// report whether this cell's box has the given digit
	private boolean isLegalForBox(int digit) {
		for (int r = 0; r < BOX_SIZE; r++) {
			for (int c = 0; c < BOX_SIZE; c++) {
				int cellRow = boxRow + r;
				int cellColumn = boxColumn + c;
				if (((cellRow != row) || (cellColumn != column))
						&& (puzzle.get(cellRow, cellColumn) == digit)) {
					return false;
				}
			}
		}
		return true;
	}
}
