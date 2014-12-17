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

	public BoardPanel(Board board, Graphics g){
		setBackground(Color.BLACK);
		this.board = board;
		graphics = g;
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
		repaint();
		System.out.println("boardPanel updated");
	}
	
	public void updateTiles(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(50, 10, 308, 40); //top red goal
		g.fillRect(204, 316, 308, 40); //bottom red goal
		g.setColor(Color.BLUE);
		
		Polygon blueGoalL = new Polygon();
		blueGoalL.addPoint(50, 50);
		blueGoalL.addPoint(204, 316);
		blueGoalL.addPoint(164, 316);
		blueGoalL.addPoint(10, 50);
		g.fillPolygon(blueGoalL); //left blue goal
		
		Polygon blueGoalR = new Polygon();
		blueGoalR.addPoint(358, 50);
		blueGoalR.addPoint(512, 316);
		blueGoalR.addPoint(552, 316);
		blueGoalR.addPoint(398, 50);
		g.fillPolygon(blueGoalR); //right blue goal
		
		System.out.println(g.toString());
		for (int i = 0; i < hexTiles.size(); i++){
			hexTiles.get(i).paint(g);
		}
		System.out.println("updated tiles ");
	}
	

	public void paintComponent(Graphics g){
		updateTiles(g);
		System.out.println("paintComponent called on boardPanel");
	}
}
