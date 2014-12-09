package edu.indiana.cs.c212.view.graphical;

import java.util.Observer;
import java.awt.event.*;

import edu.indiana.cs.c212.board.Board;

import java.awt.Point;
import java.awt.Toolkit;
import java.util.Observable;
import java.awt.BasicStroke;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
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
		//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); //not sure if this adds anything
		setVisible(true);
		this.graphics = g;
		this.board = board;
		boardSize = board.getSize();
		alpha = new HexTile(30, 30, r, board.getTileAt(0, 0)).getAlpha();
		beta = new HexTile(30, 30, r, board.getTileAt(0, 0)).getBeta();
		drawHexes();
	}
	
	private void drawHexes(){
		this.setVisible(true);
		System.out.println("drawing hexes");
		for (int x = 0; x < boardSize; x++){
			for (int y = 0; y < boardSize; y++){
				HexTile newTile = new HexTile(x, y, r, board.getTileAt(x, y));
				this.add(newTile);
				hexTiles.add(newTile);
				//newTile.paint(graphics);
				newTile.addActionListener(this);
			}
		}
		//updateTiles();
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
		if (obj.getClass().equals("AbstractGameBoard")){
			updateTiles();
		}
	}
	
	public void updateTiles(){
		System.out.println(graphics.toString());
		for (int i = 0; i < hexTiles.size(); i++){
			hexTiles.get(i).paint(graphics);	
		}
		System.out.println("updated tiles ");
	}
	
	public void paintComponent(Graphics g){
		System.out.println("paintComponent called on boardPanel");
		updateTiles();
	}
}
