package edu.indiana.cs.c212.players;

import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.board.Board;

import java.util.List;

public abstract class AbstractPlayer implements Player{
	protected PlayerColor color;

	public AbstractPlayer(PlayerColor color){
		this.color = color;
	}

	public PlayerColor getColor(){
		return color;
	}

	public String getName(){
		return color.toString();
	}

	public Move getMove(Board board, List<Move> move){
		return new Move(0, 0);
	}
}
