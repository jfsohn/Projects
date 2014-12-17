package edu.indiana.cs.c212.gameMechanics;

import java.util.Collection;
import java.util.Random;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.players.Player;

import java.util.List;


public class RandomPlayerMove extends StandardRules {

	public RandomPlayerMove(Board board, Player red, Player blue) {
		super(board, red, blue);
		// TODO Auto-generated constructor stub
	}
	public Player nextTurn() {
		Random rand = new Random();
        int randInt = rand.nextInt(9);
		
        
		if (randInt < 5){		
			playersQ.clear();
            playersQ.add(blue);
            playersQ.add(red);
   }  else {
		playersQ.clear();
		playersQ.add(red);
		playersQ.add(blue);
	}
	return playersQ.peek();
	}
}
