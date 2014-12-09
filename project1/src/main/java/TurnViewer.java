import javax.swing.JPanel;

import edu.indiana.cs.c212.gameMechanics.PlayerColor;

import java.util.Observer;
import java.util.Observable;
import java.lang.Object;
import java.awt.Graphics;
import java.awt.JComponent;
import java.awt.Polygon;

public class TurnViewer extends JPanel implements Observer{
	PlayerColor player;
	GameRunner game;
	Polygon poly;
	super.paintComponent(g);
}
	private boolean isRed(){
		if(player.equals(PlayerColor.RED) 
	 }
	private boolean isBlue(){
		if(player.equals(PlayerColor.BLUE)	
		}
	
	public void paintComponent(Graphics g){
    if(player.equals(PlayerColor.RED)) {
	poly.addPoint(100,100);
    poly.addPoint(150,150);
    poly.addPoint(50, 150);
    g.drawPolygon(poly);
    }
    if(player.equals(PlayerColor.BLUE)){
	   g.drawLine(0, 0, 100, 100); 
    }
}

 public void update(Object o, Object arg){	 

 }
}

public void repaint(){
	paintComponent();
}
