package edu.indiana.cs.c212;

public class SudokuPuzzleContainer {
	
	public static final int[][] knownSolvablePuzzle1 = {
			{ 1, 0, 3, 0 }, { 0, 0, 0, 4 }, { 2, 0, 0, 0 }, { 0, 1, 0, 3 } };
	
	public static final int[][] knownSolvablePuzzle2 = {
			{ 0, 0, 1, 0 }, { 0, 3, 0, 4 }, { 3, 0, 4, 0 }, { 0, 2, 0, 0 } };
	
	public static final int[][] knownSolvablePuzzle3 = {
			{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
	
	public static final int[][] knownSolvablePuzzle4 = {
			{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
			{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
			{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
			{ 0, 6, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
			{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } };
	
	public static final int[][] knownSolvablePuzzle5 = {
			{ 0, 6, 0, 1, 0, 4, 0, 5, 0 }, { 0, 0, 8, 3, 0, 5, 6, 0, 0 },
			{ 2, 0, 0, 0, 0, 0, 0, 0, 1 }, { 8, 0, 0, 4, 0, 7, 0, 0, 6 },
			{ 0, 0, 6, 0, 0, 0, 3, 0, 0 }, { 7, 0, 0, 9, 0, 1, 0, 0, 4 },
			{ 5, 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 7, 2, 0, 6, 9, 0, 0 },
			{ 0, 4, 0, 5, 0, 8, 0, 7, 0 } };
	
	public static final int[][] knownSolvablePuzzle6 = {
			{ 4, 0, 0, 0, 0, 0, 8, 0, 5 }, { 0, 3, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 7, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 0, 0, 6, 0 },
			{ 0, 0, 0, 0, 8, 0, 4, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 6, 0, 3, 0, 7, 0 }, { 5, 0, 0, 2, 0, 0, 0, 0, 0 },
			{ 1, 0, 4, 0, 0, 0, 0, 0, 0 } };
	
	public static final int[][] knownSolvablePuzzle7 = {
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	public static final int[][] knownSolvablePuzzle8 = { 
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 9, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 3, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 13, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0 },
			{ 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
	
	public static final int[][] knownUnsolvablePuzzle1 = { 
			{ 1, 0, 0, 0, 0, 0, 7, 0, 3 }, { 0, 2, 0, 7, 0, 0, 0, 0, 0 },
			{ 0, 2, 0, 0, 6, 0, 8, 0, 0 }, { 0, 0, 5, 8, 0, 0, 0, 0, 1 },
			{ 0, 5, 9, 0, 0, 0, 1, 0, 0 }, { 0, 0, 1, 3, 0, 0, 6, 0, 0 },
			{ 0, 0, 0, 1, 0, 4, 3, 0, 0 }, { 0, 0, 0, 0, 0, 9, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 1 } };

	public static final int[][] knownUnsolvablePuzzle2 = { 
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 4, 5, 6, 7, 8, 9, 1, 2, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 7, 8, 9, 1, 2, 3, 4, 5, 6 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 3, 4, 5, 6, 7, 8, 9, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 5, 6, 7, 8, 9, 1, 0, 0, 0 } };
		
	public static final int[][] knownUnsolvablePuzzle3 = { 
			{ 1, 4, 7, 0, 0, 0, 0, 0, 1 }, { 6, 9, 3, 0, 0, 0, 0, 0, 0 },
			{ 2, 5, 8, 0, 0, 0, 0, 0, 0 }, { 7, 1, 4, 0, 0, 0, 0, 0, 0 },
			{ 3, 6, 9, 0, 0, 0, 0, 0, 0 }, { 8, 2, 5, 0, 0, 0, 0, 0, 0 },
			{ 4, 7, 1, 0, 0, 0, 0, 0, 0 }, { 9, 3, 6, 0, 0, 0, 0, 0, 0 },
			{ 5, 8, 2, 0, 0, 0, 0, 0, 0 } };
	
	public static final int[][] knownUnsolvablePuzzle4 = { 
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9 }, { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
			{ 7, 8, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public static final int[][] knownUnsolvablePuzzle5 = { 
			{ 1, 0, 2, 0 }, { 0, 0, 0, 2 }, { 2, 0, 0, 0 }, { 0, 0, 0, 3 } };
	
	public static final int[][] knownUnsolvablePuzzle6 = { 
			{ 1, 0, 3, 0 }, { 0, 0, 0, 2 }, { 2, 0, 0, 0 }, { 3, 2, 0, 0 } };
}