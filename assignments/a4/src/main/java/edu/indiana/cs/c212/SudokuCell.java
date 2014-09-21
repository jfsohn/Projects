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

 */
class SudokuCell {
	private int boxSize;
	private int rowCount;
	private int columnCount;

	// which sudoku puzzle this cell belongs to
	private static SudokuPuzzle puzzle;
	// which row and column (of cells) this cell is in
	private int row, column;
	// which row and column (of boxes) this cell is in
	private int boxRow, boxColumn;

	// make space for this cell
	public SudokuCell(SudokuPuzzle currentPuzzle, int row, int column) {
		if(row < currentPuzzle.getPuzzleSize() && column < currentPuzzle.getPuzzleSize()
				&& row >= 0 && column >= 0){
			puzzle = currentPuzzle;
			this.boxSize = puzzle.getBoxSize();
			this.rowCount = boxSize * boxSize;
			this.columnCount = boxSize * boxSize;
			this.row = row;
			this.column = column;
			this.boxRow = (row / boxSize) * boxSize;
			this.boxColumn = (column / boxSize) * boxSize;
		}
		else{
			this.row = -1;
			this.column = -1;
		}
	}

	// change this cell to store the given value
	public void insert(int value) {
		puzzle.set(row, column, value);
	}

	// report whether this cell can legally hold the given value.
	public boolean isLegalToInsert(int value, SudokuPuzzle currentPuzzle) {
		puzzle = currentPuzzle;
		if(this.row == -1 || this.column == -1){
			return false;
		}
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
		//FIXME
		for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
			if ((columnIndex != column)	&& (puzzle.get(row, columnIndex) == digit)) {
				return false;
			}
		}
		return true;
		//
	}

	// report whether this cell's column has the given digit
	private boolean isLegalForColumn(int digit) {
		//FIXME
		for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
			if ((rowIndex != row) && (puzzle.get(rowIndex, column) == digit)) {
				return false;
			}
		}
		return true;
		//
	}

	// report whether this cell's box has the given digit
	private boolean isLegalForBox(int digit) {
		
		//FIXME
		for (int r = 0; r < boxSize; r++) {
			for (int c = 0; c < boxSize; c++) {
				int cellRow = boxRow + r;
				int cellColumn = boxColumn + c;
				if (((cellRow != row) || (cellColumn != column)) && (puzzle.get(cellRow, cellColumn) == digit)) {
					return false;
				}
			}
		}
		return true;
		//
	}
}
