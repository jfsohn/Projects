package edu.indiana.cs.c212.board;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.gameMechanics.Move;
import java.awt.Point;
import java.util.Set;
import java.util.HashSet;

public class SimpleGameBoard extends AbstractGameBoard{
	//private int size;
	private Tile[][] grid;
	//directions stores arrays of the relative x and y for adjacent tiles
	private static int[][] directions = new int[][]{
			{0, 1}, {0, -1}, {-1, 0}, {-1, 1}, {1, -1}, {1, 0}
	};
	
	private static Tile northGoal;
	private static Tile southGoal;
	private static Tile eastGoal;
	private static Tile westGoal;
	
	public SimpleGameBoard (int size){
		this.size = size;
		grid = new Tile[size][size];
		northGoal = new Tile(PlayerColor.RED, new Point(0, -1));//these lines instantiate the goal Tiles
		westGoal = new Tile(PlayerColor.BLUE, new Point(-1, 0));
		southGoal = new Tile(PlayerColor.RED, new Point(0, size));
		eastGoal = new Tile(PlayerColor.BLUE, new Point(size, 0));
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid.length; y++){
				Point p = new Point(x,y);
				grid[x][y] = new Tile(PlayerColor.BLANK, p);
			}
		}		
	}
	
	//this constructor instantiates a SGB with new objects
	public SimpleGameBoard (SimpleGameBoard board){
		this.size = board.size;
		grid = new Tile[size][size];
		northGoal = new Tile(PlayerColor.RED, new Point(0, -1));//these lines instantiate the goal Tiles
		westGoal = new Tile(PlayerColor.BLUE, new Point(-1, 0));
		southGoal = new Tile(PlayerColor.BLUE, new Point(0, size));
		eastGoal = new Tile(PlayerColor.BLUE, new Point(size, 0));
		for (int x = 0; x < grid.length; x++){
			for (int y = 0; y < grid.length; y++){
				Point p = new Point(x,y);
				grid[x][y] = new Tile(PlayerColor.BLANK, p);
			}
		}		
	}

	//sets the Tile at m.getPoint() to color. makeMove in StandardRules should call this nmethod and throw the InvalidMoveException if necessary`
	public void makeMove(Move m, PlayerColor color){
			grid[m.getX()][m.getY()].setColor(color);
			setChanged();
			notifyObservers(grid);
	}
	
	//returns True if the tile can be used in a move and False if the tile is off the board or a goal tile	
	public boolean isOnBoard(int x , int y){
		return !(x > size || y > size || x < 0 || y < 0);
	}

	//returns the tile at the given index of grid. Should handle goal tiles specially	
	public Tile getTileAt(int x, int y){
		if ( x > size + 1 || y > size + 1 || x < -1 || y < -1) {
			return null;
		} else  if (x == -1){ //if the coordinates point to the red goal tile
			return westGoal;
		} else if (y == -1){ //or blue tile
			return northGoal;
		} else if (y == size){ //or blue tile
			return southGoal;
		} else if (x == size){ //or blue tile
			return eastGoal;
		} else {
			return grid[x][y]; //else return the index of grid
		}
	}
	
	public  Set<Tile> getNeighbors(Tile start){ //clean this up later	
		Point start1 = start.getPoint(); //casting start to a Point
		int tX = start1.x; //setting the coordinates to ints for easier comparison
		int tY = start1.y;
		Set<Tile> adjacent = new HashSet<Tile>();
		
		//if the start tile is in the goal, all tiles in the row/column next to it are considered adjacent
		if (tX == -1){
			for (int i = 0; i < getSize(); i++){
				Tile t = getTileAt(0, i);
				adjacent.add(t);
			}
			return adjacent;
		} else if(tY == -1){
			for (int i = 0; i < getSize(); i++){
				Tile t = getTileAt(i, 0);
				adjacent.add(t);
			}
			return adjacent;
		} else if(tY == getSize()){ //if the start tile is on the other goal, return all in the row/column adjacent
			for (int i = 0; i < getSize(); i++){
				Tile t = getTileAt(i, getSize() - 1);
				adjacent.add(t);
			}
			return adjacent;
		} else if (tX == getSize()){
			for (int i = 0; i < getSize(); i++){
				Tile t = getTileAt(getSize() - 1, i);
				adjacent.add(t);
			}
			return adjacent;
		}
		if (tX == 0){//if tile is adjacent to the blue goal
			adjacent.add(westGoal);
		}
		if (tX == size - 1){//if tile is adjacent to the blue goal
			adjacent.add(eastGoal);
		}
		if (tY == size - 1){//if tile is adjacent to the blue goal
			adjacent.add(southGoal);
		}
		if (tY == 0){//if tile is adjacent to the blue goal
			adjacent.add(northGoal);
		}
		if (tX != -1 && tX != size && tY != -1 && tY != size){
			//if the tile is not on a goal, return every tile in valid directions
			for (int i = 0; i < directions.length; i++){
				if (isOnBoard( tX + directions[i][0], tY + directions[i][1])){
					Tile t = getTileAt(tX + directions[i][0], tY + directions[i][1]);
					adjacent.add(t);
				}
			}
		}
		return adjacent;
	}
}
