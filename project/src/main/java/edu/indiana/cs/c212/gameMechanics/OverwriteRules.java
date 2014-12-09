package edu.indiana.cs.c212.gameMechanics;

import edu.indiana.cs.c212.board.*;
import edu.indiana.cs.c212.players.*;

import java.util.ArrayList;

public class OverwriteRules extends StandardRules{
	
	public OverwriteRules(Board board, Player red, Player blue){
		super(board, red, blue);
	}
	
	@Override
	public boolean isLegalMove(Move m){
		PlayerColor color = getBoard().getTileAt(m.getX(), m.getY()).getColor();
		
		return (!PlayerColor.BLUE.equals(getPlayers().peek().getColor()) || !PlayerColor.RED.equals(getPlayers().peek().getColor()) || 
				color.equals(PlayerColor.BLANK));
	}
	
	@Override
	public ArrayList<Move> getLegalMoves(Player player){
		ArrayList<Move> moves = new ArrayList<Move>();
		PlayerColor c = player.getColor();
		int size = getBoard().getSize();
		
		for (int x = 0; x < size; x++){
			for (int y = 0; y < size; y++){
				Tile t = getBoard().getTileAt(x, y);
				if (!t.getColor().equals(c)){
					Move m = new Move(x, y);
					moves.add(m);
				}
			}
		}
		
		return moves;
	}
	
}
