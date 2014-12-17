package edu.indiana.cs.c212.view.graphical;

import javax.swing.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.event.*;

import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class HexTile extends JButton{
	private int x;
	private int y;
	private int radius;
	private Tile tile;
	private int alpha;
	private int beta;
	private Polygon shape;
	int yOffset = 50;
	int xOffset = 50;
	
	public HexTile(int xVal, int yVal, int radius, Tile tile){
		this.radius = radius;
		this.tile = tile;
		this.beta = ((int) ((int) Math.round(Math.cos(Math.toRadians(30)) * radius)));
		this.alpha = ((int) radius/2);
		this.x = xOffset + (xVal * radius * 2) + (beta * yVal) - (((radius - beta) * 2) * xVal);
		this.y = yOffset + (yVal * radius * 2) - (alpha * yVal);
		if (tile.getX() == 7 && (tile.getY() == 0 || tile.getY() == 7)){
			System.out.println("(" + x + ", " + y + ")");
		}
		shape = new Polygon();
		setPoints();
	}
	
	@Override
	public int getX(){
		return x;
	}
	
	@Override
	public int getY(){
		return y;
	}
	
	public int getBoardX(){
		return tile.getPoint().x;
	}
	
	public int getBoardY(){
		return tile.getPoint().y;
	}
	
	public int getAlpha(){
		return alpha;
	}
	
	public int getBeta(){
		return beta;
	}
	
	public boolean contains(int x, int y){
		return shape.contains(x, y);//uses the Polygon's .contains method
	}
	
	public boolean contains(Point p){
		return shape.contains(p.x, p.y);
	}
	
	@Override
	protected void processMouseEvent(MouseEvent e){
		if (contains(e.getX(), e.getY()) && e.getButton() == 1){
			super.processMouseEvent(e);
		}
	}
	
	//setPoints adds points to the Polygon shape as they are calculated
	private void setPoints(){
		for (int i = 0; i <= 6; i++){
			int pointX = (int)(x + radius * Math.cos(Math.toRadians(30) + i * 2 * Math.PI / 6));
			int pointY = (int)(y + radius * Math.sin(Math.toRadians(30) + i * 2 * Math.PI / 6));
			shape.addPoint(pointX, pointY);
		}
		shape.addPoint(shape.xpoints[0], shape.ypoints[0]);
	}

	
	public void setRadius(int newRadius){
		this.radius = newRadius;
		this.beta = ((int) Math.cos(Math.toRadians(30)) * radius);
		this.alpha = ((int) Math.sin(Math.toRadians(39)) * radius);
		setPoints();
	}
	
	@Override
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.drawPolygon(shape);
		if (tile.getColor().equals(PlayerColor.RED)){
			g.setColor(Color.RED);
		} else if(tile.getColor().equals(PlayerColor.BLUE)){
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.GRAY);
		}
		g.fillPolygon(shape);
	}
}
