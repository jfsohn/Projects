package edu.indiana.cs.c212.players;

import edu.indiana.cs.c212.board.*;
import edu.indiana.cs.c212.gameMechanics.*;

import java.util.Random;
import java.util.List;

public class SimpleRandom extends AbstractPlayer {
	
	public SimpleRandom(PlayerColor color){
		super(color);
	}
	
	public Move getMove(Board board, List<Move> moveList){
		System.out.println(moveList.size());
		Random rand = new Random();
		int randInt = rand.nextInt(moveList.size());
		return moveList.get(randInt);
	}
	
	public String getName(){
		return "Simple Random";
	}
}
