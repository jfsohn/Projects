package edu.indiana.cs.c212.gameMechanics;

import java.util.ArrayList;
import java.util.Queue;

import edu.indiana.cs.c212.exceptions.InvalidMoveException;
import edu.indiana.cs.c212.players.Player;

public class StandardRules implements Rules {

	@Override
	public Queue<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerColor checkForWins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLegalMove(Move m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player nextTurn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getNextPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makeMove(Move m) throws InvalidMoveException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Move> getLegalMoves(Player player) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static boolean areTilesConnected(Board board, Tile start, Tile goal, PlayerColor color)
      {
		return false;
      }
}
