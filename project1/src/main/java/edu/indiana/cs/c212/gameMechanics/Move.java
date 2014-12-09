package edu.indiana.cs.c212.gameMechanics;

public class Move {
	private int x;
	private int y;
	
	public Move(int x, int y) {
		this.x = x; //initializer
		this.y = y; //initializer
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public String toString() {
		return "Move: (x= "+ x +" , y= "+ y +")";
	
    //SAME AS
	//@Override
	//public String toString() {
		//return "Move: ("+ x + "," + y + ")";
	}
	

}
