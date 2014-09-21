package edu.indiana.cs.c212;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class SudokuTest {
	
	int[][] knownSolvablePuzzle1 = {
			{ 1, 0, 3, 0 }, { 0, 0, 0, 4 }, { 2, 0, 0, 0 }, { 0, 1, 0, 3 } };
	
	int[][] knownSolvablePuzzle2 = {
			{ 0, 0, 1, 0 }, { 0, 3, 0, 4 }, { 3, 0, 4, 0 }, { 0, 2, 0, 0 } };
	
	int[][] knownSolvablePuzzle3 = {
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	
	int[][] knownSolvablePuzzle4 = {
			{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
			{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
			{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
			{ 0, 6, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
			{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
	
	int[][] knownSolvablePuzzle5 = {
			{ 0, 6, 0, 1, 0, 4, 0, 5, 0 }, { 0, 0, 8, 3, 0, 5, 6, 0, 0 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 1 }, { 8, 0, 0, 4, 0, 7, 0, 0, 6 },
			{ 0, 0, 6, 0, 0, 0, 3, 0, 0 }, { 7, 0, 0, 9, 0, 1, 0, 0, 4 },
			{ 5, 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 7, 2, 0, 6, 9, 0, 0 },
			{ 0, 4, 0, 5, 0, 8, 0, 7, 0 } };
	
	int[][] knownSolvablePuzzle6 = {
			{ 4, 0, 0, 0, 0, 0, 8, 0, 5 }, { 0, 3, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 7, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 0, 0, 6, 0 },
			{ 0, 0, 0, 0, 8, 0, 4, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 6, 0, 3, 0, 7, 0 }, { 5, 0, 0, 2, 0, 0, 0, 0, 0 },
			{ 1, 0, 4, 0, 0, 0, 0, 0, 0 } };
	
	int[][] knownSolvablePuzzle7 = {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	int[][] knownSolvablePuzzle8 = { 
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 3, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 13, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0 },
			{ 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	int[][] knownUnsolvablePuzzle1 = { 
			{ 1, 0, 0, 0, 0, 0, 7, 0, 3 }, { 0, 2, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 2, 0, 0, 6, 0, 8, 0, 0 }, { 0, 0, 5, 8, 0, 0, 0, 0, 1 },
			{ 0, 5, 9, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 3, 0, 0, 6, 0, 0 },
			{ 0, 0, 0, 1, 0, 4, 3, 0, 0 }, { 0, 0, 0, 0, 0, 9, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1 } };

	int[][] knownUnsolvablePuzzle2 = { 
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 7, 8, 9, 1, 2, 3, 4, 5, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 5, 6, 7, 8, 9, 1, 0, 0, 0 } };
		
	int[][] knownUnsolvablePuzzle3 = { 
			{ 1, 4, 7, 0, 0, 0, 0, 0, 1 }, { 6, 9, 3, 0, 0, 0, 0, 0, 0 },
			{ 2, 5, 8, 0, 0, 0, 0, 0, 0 }, { 7, 1, 4, 0, 0, 0, 0, 0, 0 },
			{ 3, 6, 9, 0, 0, 0, 0, 0, 0 }, { 8, 2, 5, 0, 0, 0, 0, 0, 0 },
			{ 4, 7, 1, 0, 0, 0, 0, 0, 0 }, { 9, 3, 6, 0, 0, 0, 0, 0, 0 },
			{ 5, 8, 2, 0, 0, 0, 0, 0, 0 } };
	
	int[][] knownUnsolvablePuzzle4 = { 
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
			{ 7, 8, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	int[][] knownUnsolvablePuzzle5 = { 
			{ 1, 0, 2, 0 }, { 0, 0, 0, 2 }, { 2, 0, 0, 0 }, { 0, 0, 0, 3 } };
	
	int[][] knownUnsolvablePuzzle6 = { 
			{ 1, 0, 3, 0 }, { 0, 0, 0, 2 }, { 2, 0, 0, 0 }, { 3, 2, 0, 0 } };

	int[][] solvedPuzzle1 = { 
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, 
			{ 7, 8, 9, 1, 2, 3, 4, 5, 6 }, { 2, 3, 4, 5, 6, 7, 8, 9, 1 },
			{ 5, 6, 7, 8, 9, 1, 2, 3, 4 }, { 8, 9, 1, 2, 3, 4, 5, 6, 7 }, 
			{ 3, 4, 5, 6, 7, 8, 9, 1, 2 }, { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
			{ 9, 1, 2, 3, 4, 5, 6, 7, 8 } };
	
	int[][] solvedPuzzle2 = {
			{1, 2, 3, 4}, {3, 4, 1, 2}, {2, 3, 4, 1}, {4, 1, 2, 3} };
	
	@Test (timeout = 5000)
	public void SudokuSolvableTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle1);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuSolvableTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle2);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuSolvableTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle3);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuSolvableTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle4);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuSolvableTest5(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle5);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuSolvableTest6(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle6);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuSolvableTest7(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle7);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	public void SudokuSolvableTest8(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		assertTrue(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuUnsolvableTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle1);
		assertFalse(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuUnsolvableTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle2);
		assertFalse(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuUnsolvableTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle3);
		assertFalse(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuUnsolvableTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle4);
		assertFalse(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuUnsolvableTest5(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle5);
		assertFalse(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void SudokuUnsolvableTest6(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle5);
		assertFalse(SudokuSolver.canSolve(puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForBoxTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle5);
		SudokuCell cell = new SudokuCell(puzzle, 3, 1);
		assertFalse(cell.isLegalToInsert(2, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForBoxTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle4);
		SudokuCell cell = new SudokuCell(puzzle, 6, 6);
		assertFalse(cell.isLegalToInsert(9, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForBoxTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle4);
		SudokuCell cell = new SudokuCell(puzzle, 0, 2);
		assertTrue(cell.isLegalToInsert(1, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForBoxTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle6);
		SudokuCell cell = new SudokuCell(puzzle, 1, 1);
		assertFalse(cell.isLegalToInsert(4, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForBoxTest5(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = new SudokuCell(puzzle, 15, 14);
		assertTrue(cell.isLegalToInsert(11, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForRowTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = new SudokuCell(puzzle, 3, 2);
		assertFalse(cell.isLegalToInsert(13, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForRowTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle3);
		SudokuCell cell = new SudokuCell(puzzle, 3, 8);
		assertFalse(cell.isLegalToInsert(4, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForRowTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle3);
		SudokuCell cell = new SudokuCell(puzzle, 4, 5);
		assertTrue(cell.isLegalToInsert(4, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForRowTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 1, 0);
		assertTrue(cell.isLegalToInsert(4, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForRowTest5(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle5);
		SudokuCell cell = new SudokuCell(puzzle, 0, 4);
		assertTrue(cell.isLegalToInsert(2, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForColumnTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 7, 3);
		assertFalse(cell.isLegalToInsert(7, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForColumnTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 1, 8);
		assertTrue(cell.isLegalToInsert(5, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForColumnTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = new SudokuCell(puzzle, 15, 14);
		assertTrue(cell.isLegalToInsert(11, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForColumnTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 1, 0);
		assertTrue(cell.isLegalToInsert(4, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isLegalForColumnTest5(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle4);
		SudokuCell cell = new SudokuCell(puzzle, 1, 7);
		assertFalse(cell.isLegalToInsert(7, puzzle));
	}
	
	@Test (timeout = 5000)
	public void emptyInsertionTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 1, 0);
		assertTrue(cell.isLegalToInsert(0, puzzle));
	}
	
	@Test (timeout = 5000)
	public void emptyInsertionTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = new SudokuCell(puzzle, 2, 8);
		assertTrue(cell.isLegalToInsert(0, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfBoundsInsertionTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 1, 5);
		assertFalse(cell.isLegalToInsert(0, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfBoundsInsertionTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = new SudokuCell(puzzle, -1, 14);
		assertFalse(cell.isLegalToInsert(0, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfBoundsInsertionTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = new SudokuCell(puzzle, 0, 16);
		assertFalse(cell.isLegalToInsert(0, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfBoundsInsertionTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle5);
		SudokuCell cell = new SudokuCell(puzzle, 9, 0);
		assertFalse(cell.isLegalToInsert(0, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfRangeInsertionTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 1, 3);
		assertFalse(cell.isLegalToInsert(-1, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfRangeInsertionTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle1);
		SudokuCell cell = new SudokuCell(puzzle, 1, 2);
		assertFalse(cell.isLegalToInsert(5, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfRangeInsertionTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle4);
		SudokuCell cell = new SudokuCell(puzzle, 6, 8);
		assertFalse(cell.isLegalToInsert(10, puzzle));
	}
	
	@Test (timeout = 5000)
	public void outOfRangeInsertionTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = new SudokuCell(puzzle, 13, 5);
		assertFalse(cell.isLegalToInsert(17, puzzle));
	}
	
	@Test (timeout = 5000)
	public void isEmptyValueTest1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle5);
		assertTrue(puzzle.isEmpty(1,4));
	}
	
	@Test (timeout = 5000)
	public void isEmptyValueTest2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle6);
		assertFalse(puzzle.isEmpty(6,7));
	}
	
	@Test (timeout = 5000)
	public void isEmptyValueTest3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle2);
		assertFalse(puzzle.isEmpty(2,2));
	}
	
	@Test (timeout = 5000)
	public void isEmptyValueTest4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		assertTrue(puzzle.isEmpty(3, 9));
	}
	
	@Test (timeout = 5000)
	public void hasEmptyCell1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		assertTrue(puzzle.hasEmptyCell());
	}
	
	@Test (timeout = 5000)
	public void hasEmptyCell2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(solvedPuzzle1);
		assertFalse(puzzle.hasEmptyCell());
	}
	
	@Test (timeout = 5000)
	public void hasEmptyCell3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		assertTrue(puzzle.hasEmptyCell());
	}
	
	@Test (timeout = 5000)
	public void hasEmptyCell4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(solvedPuzzle2);
		assertFalse(puzzle.hasEmptyCell());
	}
	
	@Test (timeout = 5000)
	public void getEmptyCell1(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(solvedPuzzle1);
		assertNull(puzzle.getEmptyCell());
	}
	
	@Test (timeout = 5000)
	public void getEmptyCell2(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(solvedPuzzle2);
		assertNull(puzzle.getEmptyCell());
	}
	
	@Test (timeout = 5000)
	public void getEmptyCell3(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownSolvablePuzzle8);
		SudokuCell cell = puzzle.getEmptyCell();
		int[][] grid = puzzle.getPuzzle();
		assertTrue(puzzle.isEmptyValue(grid[cell.getRow()][cell.getColumn()]));
	}
	
	@Test (timeout = 5000)
	public void getEmptyCell4(){
		SudokuPuzzle puzzle = new SudokuPuzzle();
		puzzle.setPuzzle(knownUnsolvablePuzzle4);
		SudokuCell cell = puzzle.getEmptyCell();
		int[][] grid = puzzle.getPuzzle();
		assertTrue(puzzle.isEmptyValue(grid[cell.getRow()][cell.getColumn()]));
	}
}
