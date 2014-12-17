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

public class GraphicalBoardView extends JFrame implements ActionListener{
	private static final int DEFAULT_SIZE = 800;
	
	private PlayerChoicePanel pCPRed;
	private PlayerChoicePanel pCPBlue;
	private BoardSetupPanel numPicker;
	private Graphics graphics;
	private GameRunner gameView;
	private BoardPanel boardPanel;
	
	private GraphicalBoardView(){
		//set the frame's parameters
		setSize(new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(100, 100); //offset so not hanging off screen
		setResizable(true); 
		setMinimumSize(new Dimension(600, 700));
		setTitle("Trails"); //give it a cool name
		//setResizable(false); //shouldn't be resized by user
		getContentPane().setLayout(
			    new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
		); //set the layout to Box
		
		//give the JFrame an icon
		String path = new File("").getAbsolutePath();
		ImageIcon icon = new ImageIcon(path + "/src/main/java/edu/indiana/cs/c212/view/graphical/Hexagon.png");
		setIconImage(icon.getImage());
		
		JPanel optsPanel = getOptionsPanel(); //get the player chooser and boardsize picker
		add(optsPanel, BorderLayout.SOUTH); //add them all to the center
		optsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		pack();
		setVisible(true); //paint the JFrame
	}
	
	public static Runnable setup(){
		GraphicalBoardView gBV = new GraphicalBoardView();
		return new Runnable(){
			public void run(){
				
			}
		};
	}
	
	public void actionPerformed(java.awt.event.ActionEvent e){
		
	}

	//create a start button
	private JPanel getStartButton(){
		final int y = 50;
		JPanel start = new JPanel();
		JButton startButt = new JButton("START");
		JLabel startButtLabel = new JLabel("Click to begin the game");
		startButtLabel.setHorizontalAlignment(JLabel.CENTER); //align center
		startButt.setBackground(Color.GREEN);
		
		//set the dimensions
		//startButtLabel.setMinimumSize(new Dimension(300, y));
		startButtLabel.setPreferredSize(new Dimension(300, y));
		
		//startButt.setMinimumSize(new Dimension(400, 100));
		startButt.setPreferredSize(new Dimension(400, y));
		
		//add an ActionListener
		startButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ //this coded block is called by the listener
				String redType = pCPRed.getPlayerType();
				String blueType = pCPBlue.getPlayerType();
				int boardSize = numPicker.getBoardSize();
				GameRunner game = new GameRunner(boardSize, redType, blueType, "StandardRules");
				gameView = game;
				TurnViewer turnViewer = new TurnViewer(PlayerColor.RED, game);//construct a turnViewer
				//getContentPane().removeAll();//remove the options panels
				
				add(turnViewer, BorderLayout.EAST); //add a turnViewer to the frame
				pack();
				setBoardPanel(); //draw the board
				setSize(new Dimension(600, 700));
			}
		});
		
		//set all the GUI stuff
		start.setLayout(new BorderLayout());
		start.add(startButtLabel, BorderLayout.NORTH);
		start.add(startButt, BorderLayout.SOUTH);
		return start;
	}
	
	private void setBoardPanel(){
		graphics = getGraphics(); //get graphics needs to be after setVisible
		boardPanel = new BoardPanel(gameView.getBoard(), graphics);
		boardPanel.setMinimumSize(new Dimension(400, 300));
		boardPanel.setSize(new Dimension(400, 300));
		this.add(boardPanel, BorderLayout.NORTH);
	}
	
	//create an instructions panel
	private JPanel getInstructions(){
		JPanel instructsPanel = new JPanel();
		JLabel instructions = new JLabel("Enter the desired settings for the game");
		//make the font bigger
		Font font = instructions.getFont();
		instructions.setFont(new Font(font.getName(), Font.PLAIN, 14));
		
		instructsPanel.add(instructions, BorderLayout.SOUTH);
		//instructsPanel.setMinimumSize(new Dimension(DEFAULT_SIZE / 4, 600));
		instructsPanel.setPreferredSize(new Dimension(DEFAULT_SIZE / 4, 100));
		return instructsPanel;
	}
	
	private JPanel getOptionsPanel(){
		JPanel optsPanel = new JPanel();
		//instantiate all the necessary JPanels
		pCPRed = new PlayerChoicePanel("Red");
		pCPBlue = new PlayerChoicePanel("Blue");
		numPicker = new BoardSetupPanel();
		JPanel start = getStartButton();
		JPanel instructsPanel = getInstructions();
		
		pCPRed.setMaximumSize(new Dimension(400, 150));
		pCPBlue.setMaximumSize(new Dimension(400, 150));
		numPicker.setMaximumSize(new Dimension(400, 150));
		
		//set and layout and arrange all the panels within the layout
		optsPanel.setLayout(new BoxLayout(optsPanel, BoxLayout.PAGE_AXIS));
		//add all the things
		optsPanel.add(instructsPanel);
		optsPanel.add(pCPRed);
		optsPanel.add(pCPBlue);
		optsPanel.add(numPicker);
		optsPanel.add(start);
		
		return optsPanel;
	}
	
}

