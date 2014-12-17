package edu.indiana.cs.c212.players;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.view.graphical.MoveEvent;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.AWTEvent;
import java.util.List;
import java.awt.Point;
import java.util.logging.Handler;
import java.util.Timer;
import java.util.TimerTask;

public class PointAndClickPlayer extends AbstractPlayer implements AWTEventListener{
	private PlayerColor color;
	private Point point = new Point(0, 0);
	private boolean clicked = false;
	
	public PointAndClickPlayer(PlayerColor player){
		super(player);
		
		this.color = player;
	}
	
	@Override
	public String getName(){
		return "PointAndClickPlayer";
	}
	
	public Move getMove(Board board, List<Move> legalMoves){
		Toolkit.getDefaultToolkit().addAWTEventListener(this, 0);
		while (!clicked){
			try {
				Thread.currentThread().sleep(2);
			} catch(InterruptedException ex){
				System.out.println("sleep interrupted");
			}
		}
		Move m = new Move(point.x, point.y);
		if (legalMoves.contains(m)){
			Toolkit.getDefaultToolkit().removeAWTEventListener(this);
			System.out.println("returning move");
			clicked = false;
			return new Move(point.x, point.y);
		} else {
			System.out.println("invalid move");
			clicked = false;
			return getMove(board, legalMoves);
		}
	}
	
	public void eventDispatched(AWTEvent event){
		point = (Point) event.getSource();
		clicked = true;
		System.out.println("point and click player receives " + point.toString());
	}
}