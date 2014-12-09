package edu.indiana.cs.c212.players;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.view.graphical.MoveEvent;

import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.AWTEvent;
import java.util.List;
import java.awt.Point;

public class PointAndClickPlayer extends AbstractPlayer implements AWTEventListener{
	private Player player;
	private Point point;
	
	public PointAndClickPlayer(Player player){
		super(player.getColor());
		this.player = player;
	}
	
	@Override
	public String getName(){
		return player.getName();
	}
	
	public Move getMove(Board board, List<Move> legalMoves){
		Toolkit.getDefaultToolkit().addAWTEventListener(this, AWTEvent.MOUSE_EVENT_MASK);
		return legalMoves.get(0); //TODO fix this
	}
	
	public void eventDispatched(AWTEvent event){
		MoveEvent move = (MoveEvent) event.getSource();
		//point = event.point;
	}
}
