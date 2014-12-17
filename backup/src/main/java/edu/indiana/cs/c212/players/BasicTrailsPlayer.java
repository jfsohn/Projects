package edu.indiana.cs.c212.players;

import edu.indiana.cs.c212.board.*;
import edu.indiana.cs.c212.gameMechanics.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class BasicTrailsPlayer extends AbstractPlayer {
	private boolean xAxis;
	
	public BasicTrailsPlayer(PlayerColor color){
		super(color);
		xAxis = color.equals(PlayerColor.BLUE);
	}
	
	@Override
	public Move getMove(Board board, List<Move> validMoves){
		int size = board.getSize();
		if (validMoves.size() >= size * size){ //if this is the first turn of the game
			return new Move(size - 1, 0); //make a move in the top right corner
		} else if (validMoves.size() >= size * size - 1){ //if this is the second turn of the game
			if (board.getTileAt(size -1, 0).getColor().equals(PlayerColor.BLUE)){ //if the top right tile has already been taken
				return new Move(size - 2, 0); //make a move to the left of the top right corner
			} else { //if red didn't take the top right corner
				return new Move(size - 1, 0); //make our top right corner move
			}
		}
		
		Tile startTile = getStartTile(board); //find the start tile that we should connect our move to
		System.out.println(startTile.toString());
		StandardRules rules = new StandardRules(board, new SimpleRandom(PlayerColor.RED), new SimpleRandom(PlayerColor.BLUE)); //rules will only be used for the areTilesConnected method
		List<Tile> moves = getAllMoves(board);
		Tile greatestMove = getGreatestYValueTile(moves, startTile, rules, board); //find the value of those tiles with the greatest Y value
		
		Set<Tile> greatestTileNeighborsSet = board.getNeighbors(greatestMove); // create a set of neighbors to the greatestYValue Tile
		List<Tile> greatestTileNeighborsList = new ArrayList<Tile>(); //instantiate a list
		greatestTileNeighborsList.addAll(greatestTileNeighborsSet); //add all tiles in the set collection to the list
		Tile greatestNeighbor = getGreatestYValueNeighbor(greatestTileNeighborsList, rules, board); //return the greatest Y value of neighbor tiles that is blank
		System.out.println("greatest Y value tile is " + greatestMove.toString());
		
		
		System.out.println("moving to " + greatestMove.toString());
		return new Move(greatestNeighbor.getX(), greatestNeighbor.getY()); //return the tile with the greatest y value
	}
	
	private Tile getStartTile(Board board){
		for (int x = board.getSize() - 1; x > 0; x--){
			if (board.getTileAt(x, 0).getColor().equals(this.color)){
				return board.getTileAt(x, 0);
			}
		}
		return null;
	}
	
	private List<Tile> getAllMoves(Board board){
		List<Tile> moves = new ArrayList<Tile>(); //construct a list to hold our tiles
		for (int x = 0; x < board.getSize(); x++){
			for (int y = 0; y < board.getSize(); y++){
				if (board.getTileAt(x, y).getColor().equals(PlayerColor.RED)){
					moves.add(board.getTileAt(x, y));
				}
			}
		}
		return moves;
	}
	
	public static Tile getGreatestYValueTile(List<Tile> tiles, Tile startTile, StandardRules rules, Board board){
		Tile greatest = tiles.get(0);
		for (int i = 0; i < tiles.size(); i++){
			if (tiles.get(i).getY() > greatest.getY() //if the tile has a greater y value than the current greatest
					&& rules.areTilesConnected(board, startTile, tiles.get(i), tiles.get(i).getColor())){ //and the tile is crawlable from the start tile
				greatest = tiles.get(i); //set the value of greatest to the tile that has a greater y value
			}
		}
		return greatest;
	}
	
	private static Tile getGreatestYValueNeighbor(List<Tile> tiles, StandardRules rules, Board board){
		System.out.println("neighbors are");
		Tile greatest = tiles.get(0);
		//Tile greatest = getBackupTile(tiles, board);
		for (int i = 0; i < tiles.size(); i++){
			if (tiles.get(i).getY() > greatest.getY() //TODO start with a valid blank tile	
					&& tiles.get(i).getColor().equals(PlayerColor.BLANK)){ //if the tile has a greater y value than the current greatest
				System.out.println("comparing " + tiles.get(i).toString());
				greatest = tiles.get(i); //then set that blank tile with greates y value to greatest
			}
		}
		return greatest;
	}
	
	//this method checks for a safe tile to move to in case none of the neighbor tiles are valid
	private static Tile getBackupTile(List<Tile> tiles, Board board){
		for (int i = 0; i < tiles.size(); i++){
			if (tiles.get(i).getColor().equals(PlayerColor.BLANK)){
				return tiles.get(i);
			}
		}
		for (int x = 0; x < board.getSize(); x++){
			for (int y = 0; y < board.getSize(); y++){
				if (board.getTileAt(x, y).getColor().equals(PlayerColor.BLANK)){
					return board.getTileAt(x, y);
				}
			}
		}
		return null;
	}
	
	/*
	@Override
	public Move getMove(Board board, List<Move> validMoves){
		int size = board.getSize();
		if (validMoves.size() == 1){//if only one valid move exists, make that move
			return validMoves.get(0);
	}
		
		int i = size - 1;
		for (int x = 0; x < size; x++){
			if (board.getTileAt(x, i).getColor().equals(PlayerColor.BLUE)){ //if the rightmost tile at the level of the cursor is blank,
				for (int foo = i; foo < size - i; foo++){
					if (board.getTileAt(x, i).getColor().equals(PlayerColor.BLANK)){
						i = foo;
						return new Move(x, foo);
					}
				}
			} else if (board.getTileAt(x, i).getColor().equals(PlayerColor.BLANK)){
				return new Move(x, i);
			}
		}
	}
	*/
	
	@Override
	public String getName(){
		return "BasicTrailsPlayer";
	}
}
