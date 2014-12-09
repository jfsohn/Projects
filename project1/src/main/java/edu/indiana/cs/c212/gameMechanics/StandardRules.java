package edu.indiana.cs.c212.gameMechanics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.exceptions.InvalidMoveException;
import edu.indiana.cs.c212.players.Player;

public class StandardRules implements Rules {
	private Board board;
	private Player red;
	private Player blue;
	private Player current = red;
	Queue<Player> playersQ = new LinkedList<Player>();
	
	public StandardRules(Board board, Player red, Player blue){
		this.board = board;
		this.red = red;
		this.blue = blue;
		playersQ.add(red);
		playersQ.add(blue);
		System.out.println(playersQ.peek().getColor().toString());
	}

	@Override
	public Queue<Player> getPlayers() {
		return playersQ;
	}

	@Override
	public PlayerColor checkForWins() {
		//if (LoseByConnectingRules)
		return null;
	}

	@Override
	public boolean isLegalMove(Move m) {
		ArrayList<Move> moves = getLegalMoves(playersQ.peek());
		System.out.println(moves.size());
		for (int i = 0; i < moves.size(); i++){
				if (moves.get(i) == m){
					return true;
				}
		}
		return false;
	}

	@Override
	public Player nextTurn() {
		if (playersQ.peek() == red){
			playersQ.clear();
			playersQ.add(blue);
			playersQ.add(red);
		} else {
			playersQ.clear();
			playersQ.add(red);
			playersQ.add(blue);
		}
		return playersQ.peek();
	}

	@Override
	public Player getNextPlayer() {
		if (current == blue){
			return red;
		} else {
			return blue;
		}
	}

	@Override
	public void makeMove(Move m) throws InvalidMoveException {
		if (isLegalMove(m)){
			board.makeMove(m, red.getColor());
		}/* else {
			throw new InvalidMoveException("Not valid", m, 0);
		}
		*/
	}

	@Override
	public ArrayList<Move> getLegalMoves(Player player) {
		int size = board.getSize();
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		for (int x = 0; x < size; x++){
			for (int y = 0; y < size; y++){
				if (board.getTileAt(x, y).getColor() == PlayerColor.valueOf("BLANK")){
					Move m = new Move(x, y);
					legalMoves.add(m);
				}
			}
		}
		return legalMoves;
	}
	
	public static boolean isOnBoard(Board board, int x , int y){
		return !(x > board.getSize() || y > board.getSize() || x < 0 || y < 0);
	}
	
	/*
	public static ArrayList<Tile> startingTiles (Board board, PlayerColor color){
		ArrayList<Tile> starting = new ArrayList<Tile>();
		if (color.toString() == "BLUE"){
			for (int i = 0; i < board.getSize(); i++){
				if (board.getTileAt(board.getSize() - 1, i).getColor() == color){
					starting.add()
				}
			}
		}
	}
	*/
	
	public static ArrayList<Tile> adjacentTiles(Board board, Tile start, PlayerColor color){ //clean this up later
		Point start1 = start.getPoint(); //casting start to a Point
		int tX = start1.x;
		int tY = start1.y;
		ArrayList<Tile> adjacent = new ArrayList<Tile>();//construct arraylist to hold adjacent tiles
		
		//if the start tile is off in the goal, all tiles in the row/column next to it are considered adjacent
		if (tX == -1 && color.toString() == "BLUE"){
			for (int i = 0; i < board.getSize(); i++){
				Tile t = board.getTileAt(0, i);
				adjacent.add(t);
			}
			return adjacent;
		} else if(tY == -1 && color.toString() == "RED"){
			for (int i = 0; i < board.getSize(); i++){
				Tile t = board.getTileAt(i, 0);
				adjacent.add(t);
			}
			return adjacent;
		} else if(tY == board.getSize() && color.toString() == "RED"){ //if the start tile is on the other goal, return all in the row/column adjacent
			for (int i = 0; i < board.getSize(); i++){
				Tile t = board.getTileAt(i, board.getSize() - 1);
				adjacent.add(t);
			}
			return adjacent;
		} else if (tX == board.getSize() && color.toString() == "BLUE"){
			for (int i = 0; i < board.getSize(); i++){
				Tile t = board.getTileAt(board.getSize() - 1, i);
				adjacent.add(t);
			}
			return adjacent;
		}
		
		if (isOnBoard(board, tX, tY + 1)){
			if (board.getTileAt(tX, tY + 1).getColor() == color){
				adjacent.add(board.getTileAt(tX, tY + 1));
			}
		}
		if (isOnBoard(board, tX, tY - 1)){
			if (board.getTileAt(tX, tY - 1).getColor() == color){
				adjacent.add(board.getTileAt(tX, tY - 1));
			}
		}
		if (isOnBoard(board, tX + 1, tY - 1)){
			if (board.getTileAt(tX + 1, tY - 1).getColor() == color){
				adjacent.add(board.getTileAt(tX + 1, tY - 1));
			}
		}
		if (isOnBoard(board, tX + 1, tY)){
			if (board.getTileAt(tX + 1, tY).getColor() == color){
				adjacent.add(board.getTileAt(tX + 1, tY));
			}
		}
		if (isOnBoard(board, tX - 1, tY)){
			if (board.getTileAt(tX - 1, tY).getColor() == color){
				adjacent.add(board.getTileAt(tX - 1, tY));
			}
		}
		if (isOnBoard(board, tX - 1, tY + 1)){
			if (board.getTileAt(tX - 1, tY + 1).getColor() == color){
				adjacent.add(board.getTileAt(tX - 1, tY + 1));
			}
		}
		return adjacent;
	}
	
	public static boolean tileCrawl(Board board, Tile start, Tile goal, PlayerColor color, ArrayList<Tile> crawled){
		ArrayList<Tile> adjacent = new ArrayList<Tile>();
		adjacent = adjacentTiles(board, start, color);
		for (Tile t : adjacent){
			if (t == goal){
				return true;
			} else {
				crawled.add(t);
				tileCrawl(board, t, goal, color, crawled);
			}
		}
		return false;
	}
	
	
	public static boolean areTilesConnected(Board board, Tile start, Tile goal, PlayerColor color){
		ArrayList<Tile> crawl = new ArrayList<Tile>();
		return tileCrawl(board, start, goal, color, crawl);
		/*
		Point start1 = start.getPoint(); //casting start to a Point
		int tX = start1.x;
		int tY = start1.y;
		Point goal1 = goal.getPoint();
		int gX = goal1.x;
		int gY = goal1.y;
		return ((tX == gX && ((tY == (gY - 1)) || (tY == (gY + 1)))) //checks if tile is above or below
				|| (tY == gY && (tX == (gX - 1) || (tX == (gX + 1)))) //check for tile left above and right up
				|| ((tX == (gX + 1)) && (tY == (gY - 1))) //check for tile right and below
				|| ((tX == (gX - 1)) && (tY == (gY + 1)))); //check for tile left and up
	*/
	
	}
	
	

}