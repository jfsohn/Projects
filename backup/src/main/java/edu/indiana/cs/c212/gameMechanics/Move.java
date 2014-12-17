package edu.indiana.cs.c212.gameMechanics;

import edu.indiana.cs.c212.board.Tile;

public class Move {
	private int x;
	private int y;
	
	public Move (int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public String toString(){
		return "Move: (" + x + ", " + y + ").";
	}
	
	public boolean equals(java.lang.Object o){
		OverwriteMove om = new OverwriteMove(0, 0);
		if (true
				//o.getClass().equals(this.getClass()) || o.getClass().equals(om.getClass())
				){
			Move m = (Move) o;
			return (m.getX() == this.getX() && m.getY() == this.getY());
		} else {
			return false;
		}
	}
	
}
