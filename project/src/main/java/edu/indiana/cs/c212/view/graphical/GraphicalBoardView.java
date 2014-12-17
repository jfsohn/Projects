package edu.indiana.cs.c212.view.graphical;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;	
import java.io.File;

import edu.indiana.cs.c212.gameMechanics.GameRunner;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;
import edu.indiana.cs.c212.board.Board;

public class GraphicalBoardView extends JFrame implements ActionListener{
private static final int DEFAULT_SIZE = 800;
	
	private PlayerChoicePanel pCPRed;
	private PlayerChoicePanel pCPBlue;
	private BoardSetupPanel numPicker;
	private BoardPanel boardPanel;
	private boolean startButtClicked = false;
	
	private GraphicalBoardView(){
		//set the frame's parameters
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(100, 100); //offset so not hanging off screen
		setResizable(false); 
		setMinimumSize(new Dimension(800, 800));
		setMaximumSize(new Dimension(800, 800));
		setTitle("Trails"); //give it a cool name
		getContentPane().setLayout(new BorderLayout()); //set the layout to Border

		//give the JFrame an icon
		String path = new File("").getAbsolutePath();
		ImageIcon icon = new ImageIcon(path + "/src/main/java/edu/indiana/cs/c212/view/graphical/Hexagon.png");
		setIconImage(icon.getImage());
		
		JPanel start = getStartButton();
		add(start, BorderLayout.SOUTH);
		
		JPanel optsPanel = getOptionsPanel(); //get the player chooser and boardsize picker
		add(optsPanel, BorderLayout.CENTER); //add them all to the center
		
		setVisible(true);
		pack();
	}
	
	public static Runnable setup(){
		return new Runnable(){
			public void run(){
				GraphicalBoardView gBV = new GraphicalBoardView();
			}
		};
	}
	
	public void actionPerformed(java.awt.event.ActionEvent e){
		if (!startButtClicked){ //only run this code block if this is the first click
			startButtClicked = true;
			String redType = pCPRed.getPlayerType();
			String blueType = pCPBlue.getPlayerType();
			int boardSize = numPicker.getBoardSize();
			GameRunner game = new GameRunner(boardSize, redType, blueType, "Random");
			
			TurnViewer turnViewer = new TurnViewer(PlayerColor.RED, game);//construct a turnViewer
			add(turnViewer, BorderLayout.WEST); //add a turnViewer to the frame
			
			revalidate();
			pack();

			BoardPanel boardPanel = setBoardPanel(game.getBoard()); //instantiate the board

			boardPanel.setSize(new Dimension(560, 380));
			add(boardPanel, BorderLayout.CENTER);
			boardPanel.setLocation(100, 200);
			
			Thread t = new Thread(game); //create a new thread to encapsulate gameRunner
			t.start(); //start the game logic thread
			
			System.out.println("boardPanel width=" + boardPanel.getWidth() + "px and height=" + boardPanel.getHeight() + "px at x=" + boardPanel.getX() + " and  y=" + boardPanel.getY());
		}
	}

	//create a start button
	private JPanel getStartButton(){
		JPanel start = new JPanel();
		JButton startButt = new JButton("START");
		JLabel startButtLabel = new JLabel("Click to begin the game");
		startButtLabel.setHorizontalAlignment(JLabel.CENTER); //align center
		startButt.setBackground(Color.GREEN);
		
		//set the dimensions
		startButt.setPreferredSize(new Dimension(400, 50));
		
		//set all the GUI stuff
		start.setLayout(new BoxLayout(start, BoxLayout.Y_AXIS));
		start.add(startButtLabel);
		start.add(startButt);
		
		//add an ActionListener
		startButt.addActionListener(this);

		return start;
	}
	
	private BoardPanel setBoardPanel(Board board){
		BoardPanel boardPanel = new BoardPanel(board);;
		return boardPanel;
	}
	
	private JPanel getOptionsPanel(){
		JPanel optsPanel = new JPanel();
		//instantiate all the necessary JPanels
		pCPRed = new PlayerChoicePanel("Red");
		pCPBlue = new PlayerChoicePanel("Blue");
		numPicker = new BoardSetupPanel();
		
		//pCPRed.setMaximumSize(new Dimension(400, 150));
		//pCPBlue.setMaximumSize(new Dimension(400, 150));
		//numPicker.setMaximumSize(new Dimension(400, 150));
		
		//set and layout and arrange all the panels within the layout
		//add all the things
		optsPanel.add(pCPRed);
		optsPanel.add(pCPBlue);
		optsPanel.add(numPicker);
		
		return optsPanel;
	}
	
}

