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
		int size = board.getSize();
		//set the red and blue goals as tiles for reference
		Tile rG1 = board.getTileAt(3, 0);
		Tile rG2 = board.getTileAt(3, size);
		Tile bG1 = board.getTileAt(0, 3);
		Tile bG2 = board.getTileAt(size, 3);
		//check if the goal tiles are connected
		if (areTilesConnected(board, rG1, rG2, red.getColor())){
			return red.getColor();
		} else if(areTilesConnected(board, bG1, bG2, blue.getColor())){
			return blue.getColor();
		} else {
			return null;
		}
	}
}