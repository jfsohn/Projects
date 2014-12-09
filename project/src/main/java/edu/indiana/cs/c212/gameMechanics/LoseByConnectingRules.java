package edu.indiana.cs.c212.gameMechanics;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.players.Player;
import edu.indiana.cs.c212.board.Tile;

public class LoseByConnectingRules extends StandardRules{
	
	private Board board;
	private Player red;
	private Player blue;
	
	public LoseByConnectingRules(Board board, Player red, Player blue){
		super(board, red, blue);
		this.red = red;
		this.blue = blue;
		this.board = board;
	}
	
	public PlayerColor checkForWins(){
		if (allTilesAreUsed()){
			return PlayerColor.RED; //return a default value if all tiles have been used
		}
		int size = board.getSize();
		//set the red and blue goals as tiles for reference
		Tile eastGoal = board.getTileAt(size, 0);
		Tile westGoal = board.getTileAt(-1, 0);
		Tile northGoal = board.getTileAt(0, -1);
		Tile southGoal = board.getTileAt(0, size);
		//check if the goal tiles are connected
		if (areTilesConnected(board, eastGoal, westGoal, red.getColor())){
			return red.getColor();
		} else if(areTilesConnected(board, northGoal, southGoal, blue.getColor())){
			return blue.getColor();
		} else if (areTilesConnected(board, eastGoal, westGoal, blue.getColor())){
			return red.getColor();
		} else if(areTilesConnected(board, northGoal, southGoal, red.getColor())){
			return blue.getColor();
		} else
			return null;
	}
	
	private boolean allTilesAreUsed(){
		for (int x = 0; x < board.getSize(); x++){
			for (int y = 0; y < board.getSize(); y++){
				if (board.getTileAt(x, y).getColor().equals(PlayerColor.BLANK)){
					return false;
				}
			}
		}
		return true;
	}
}