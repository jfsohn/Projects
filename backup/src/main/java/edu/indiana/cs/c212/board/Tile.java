package edu.indiana.cs.c212.board;
import java.awt.Point;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class Tile{
	private PlayerColor color; 
	private Point p;

	

	public Tile(PlayerColor color, Point p){
		this.p = p;
		this.color = color;
	}

	public Tile(Tile t){
		this.p = new Point(t.getPoint());
		this.color = t.getColor();
		
	}
	

	public PlayerColor getColor() {
		return color;
	}
	
	public int getX() {
		return p.x;
	}
	
	public int getY() {
		return p.y;
	}

	public void setColor(PlayerColor color) {
		this.color = color;
	}


	public Point getPoint() {
		return p;
	}
	
	public boolean equals(Object object){
		if (object.getClass().equals(this.getClass())){
			Tile t = (Tile) object;
			return (t.getColor().equals(color) && t.getPoint().equals(p));
		} else {
			return false;
		}
	}
	
	public String toString(){
		return p.toString() +  " " + color.toString();
	}




}
