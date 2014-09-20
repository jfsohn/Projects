package edu.indiana.cs.c212;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

import org.junit.Before;
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
	@Before
	public void setUp() throws Exception {

	}
	
	@Test
	public void SudokuTest1(){
		
	}
	
}
