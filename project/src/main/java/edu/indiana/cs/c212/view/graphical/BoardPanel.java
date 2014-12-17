package edu.indiana.cs.c212.view.graphical;

import java.util.Observer;
import java.awt.event.*;

import edu.indiana.cs.c212.board.Board;

import java.awt.Point;
import java.awt.Toolkit;
import java.util.Observable;
import java.awt.BasicStroke;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Polygon;

import javax.swing.BoxLayout;

public class BoardPanel extends JPanel implements ActionListener, Observer{
	private Board board;
	private int boardSize;
	private int alpha;
	private int beta;
	private Graphics graphics;
	final int r = 25;
	private ArrayList<HexTile> hexTiles = new ArrayList<HexTile>();
	private Point botRightHexOrigin;
	private Point topRightHexOrigin;
	private Point botLeftHexOrigin;

	public BoardPanel(Board board){
		this.board = board;
		boardSize = board.getSize();
		alpha = new HexTile(30, 30, r, board.getTileAt(0, 0)).getAlpha();
		beta = new HexTile(30, 30, r, board.getTileAt(0, 0)).getBeta();
		addHexes();
		board.addObserver(this);
	}
	
	private void addHexes(){
		System.out.println("drawing hexes");
		for (int x = 0; x < boardSize; x++){
			for (int y = 0; y < boardSize; y++){
				HexTile newTile = new HexTile(x, y, r, board.getTileAt(x, y));
				add(newTile);
				hexTiles.add(newTile);
				newTile.addActionListener(this);
				if (x == boardSize - 1 && y == boardSize -1){ //bottom right corner
					botRightHexOrigin = new Point(newTile.getX(), newTile.getY());
				} else if(x == 0 && y == boardSize - 1){ //bottom left corner
					botLeftHexOrigin = new Point(newTile.getX(), newTile.getY());
				} else if(x == boardSize - 1 && y == 0){ //top right corner
					topRightHexOrigin = new Point(newTile.getX(), newTile.getY());
				}
			}
		}
		requestFocus();
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("registered click");
	    HexTile tile = (HexTile) e.getSource();
	    MoveEvent move = new MoveEvent(new Point(tile.getBoardX(),
	            tile.getBoardY()), 0);
	    for (AWTEventListener l : Toolkit.getDefaultToolkit()
	            .getAWTEventListeners()) {
	        l.eventDispatched(move);
	    }
	}
	
	public void update(Observable o, Object obj){
		repaint(); //repaint only works in this context
	}
	
	public void updateTiles(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(50, 10, topRightHexOrigin.x - 50, 40); //top red goal
		g.fillRect(botLeftHexOrigin.x, botLeftHexOrigin.y, botRightHexOrigin.x - botLeftHexOrigin.x, 40); //bottom red goal
		g.setColor(Color.BLUE);
		
		Polygon blueGoalL = new Polygon();
		blueGoalL.addPoint(50, 50);
		blueGoalL.addPoint(botLeftHexOrigin.x, botLeftHexOrigin.y);
		blueGoalL.addPoint(botLeftHexOrigin.x - 40, botLeftHexOrigin.y);
		blueGoalL.addPoint(10, 50);
		g.fillPolygon(blueGoalL); //left blue goal
		
		Polygon blueGoalR = new Polygon();
		blueGoalR.addPoint(topRightHexOrigin.x, topRightHexOrigin.y);
		blueGoalR.addPoint(botRightHexOrigin.x, botRightHexOrigin.y);
		blueGoalR.addPoint(botRightHexOrigin.x + 40, botRightHexOrigin.y);
		blueGoalR.addPoint(topRightHexOrigin.x + 40, topRightHexOrigin.y);
		g.fillPolygon(blueGoalR); //right blue goal
		
		for (int i = 0; i < hexTiles.size(); i++){
			hexTiles.get(i).paint(g);
		}
	}
	

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		updateTiles(g);
		System.out.println("paintComponent called on boardPanel");
	}
}
