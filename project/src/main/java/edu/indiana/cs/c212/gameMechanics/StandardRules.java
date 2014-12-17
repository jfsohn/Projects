package edu.indiana.cs.c212.gameMechanics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;
import java.util.Set;
import java.util.HashSet;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.exceptions.InvalidMoveException;
import edu.indiana.cs.c212.players.Player;

public class StandardRules implements Rules {
	private Board board;
	protected Player red;
	protected Player blue;
	private int moveCount;
	
	Queue<Player> playersQ = new LinkedList<Player>(); //this contains the Player objects
	
	public StandardRules(Board board, Player red, Player blue){
		this.board = board;
		this.red = red;
		this.blue = blue;
		playersQ.add(red);
		playersQ.add(blue);
	}

	@Override
	public Queue<Player> getPlayers() {
		return playersQ;
	}
	
	public int getMoveCount(){
		return moveCount;
	}

	public Board getBoard() { //this getter isn't necessary except to test setIsCrawlable
		return board;
	}
	
	@Override
	public PlayerColor checkForWins() {
		LoseByConnectingRules lose = new LoseByConnectingRules(board, red, blue);
		return lose.checkForWins();
	}

	@Override
	public boolean isLegalMove(Move m) {
		int x = m.getX();
		int y = m.getY();
		if (x < 0 || y < 0 || x >= board.getSize() || y >= board.getSize()){
			return false;
		} else {
			String c = board.getTileAt(x, y).getColor().toString();//convert target tile to color string
			return (c != "RED" && c != "BLUE"); //test if that tile is colored already
		}
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
		return playersQ.peek();
	}

	@Override
	public void makeMove(Move m) throws InvalidMoveException {
		if (isLegalMove(m)){
			board.makeMove(m, playersQ.peek().getColor());
			moveCount++;
		} else {
			throw new InvalidMoveException("Not valid", m, 0);
		}
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
		return starting;
	}
	*/
	
	//returns false if no tiles in adjacent are crawblable
	public static boolean isSetCrawlable(Set<Tile> adjacent, PlayerColor color, Set<Tile> crawled){
		for (Tile t : adjacent){
			if (t.getColor().equals(color) && !crawled.contains(t)){
				return true;
			}
		}
		return false;
	}

	//accepts board, the game board; start, the start tile; goal, the goal tile;
		//color, the player in question's color;, and crawled, a set of tiles that have been crawled
		public static boolean tileCrawl(Board board, Tile start, Tile goal, 
				PlayerColor color, Set<Tile> crawled){
			while (true){
				//System.out.println("currently on " + start.toString());
				crawled.add(start); //add t to the crawled set
				Set<Tile> adjacent; //create a set called adjacent
				adjacent = board.getNeighbors(start); //set the adjacent set to include every adjacent tile
				//System.out.println("Crawled: ");
				//printTileSet(crawled);
				//System.out.println("Adjacent: ");
				//printTileSet(adjacent);
				if (!isSetCrawlable(adjacent, color, crawled)){ //if none of the adjacent tiles are Crawlable,start and goal are not connected
					//System.out.println("set is not crawlable");
					return false;
				} else {
					//System.out.println("set is crawlable");
					if (adjacent.isEmpty()){
						return true;
					} else {
						for (Tile t : adjacent){ //for each in tile in adjacent
							if (t.equals(goal)){ //if the tile equals the goal tile
								//System.out.println("true");
								return true; //the tiles are connected
							} else if (!crawled.contains(t) && t.getColor().equals(color)){ //if the tile has not been crawled and is of the same color as the Player's color
								start = t;
							}
						}
					}
				}
			}
		}
	
	public static boolean areTilesConnected(Board board, Tile start, Tile goal, PlayerColor color){
		Set<Tile> crawl = new HashSet<Tile>();
		return tileCrawl(board, start, goal, color, crawl);
	}

	//prints out the Tile's .toString() method for each tile in an ArrayList	
	public static void printTileArray(ArrayList<Tile> array){
		if (array.isEmpty()){
			System.out.println("array is empty");
		}
		for (Tile t : array){
			System.out.println(t.toString());
		}
	}

	//prints on the Tile's .toString() method for each tile in a Set	
	public static void printTileSet(Set<Tile> tSet){
		Tile[] tArray;
		int setSize = tSet.size();
		tArray = tSet.toArray(new Tile[setSize]);
		for (int i = 0; i < tArray.length; i++){
			System.out.println(tArray[i].toString());
		}
	}
}
