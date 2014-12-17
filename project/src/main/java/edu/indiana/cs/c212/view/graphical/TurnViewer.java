package edu.indiana.cs.c212.view.graphical;

import javax.swing.*;
import java.util.Observer;
import java.util.Observable;
import java.awt.Graphics;
import java.awt.Color;

import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.players.Player;
import edu.indiana.cs.c212.gameMechanics.GameRunner;

public class TurnViewer extends JPanel implements Observer{
	private boolean isRed = true;
	private PlayerColor pColor;
	private GameRunner game;
	
	public TurnViewer(PlayerColor pColor, GameRunner game){
		this.pColor = pColor;
		this.game = game;
		
		
		game.addObserver(this); //add the TurnViewer to the observable array of observers
		//setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		JLabel turnLabel = new JLabel("Current turn: ");
		this.add(turnLabel);
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (isRed){
			g.setColor(java.awt.Color.RED);
			g.fillOval(25, 25, 50, 50);
		} else {
			g.setColor(Color.BLUE);
			g.fillOval(25, 25, 50, 50);
		}
	}
	
	//this is called when the observable's notifyObservers method is called
	public void update(Observable o, Object arg){
		Player pC = (Player) arg;
		isRed = pC.getColor().equals(PlayerColor.RED);
		repaint();
	}
}
