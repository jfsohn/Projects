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
	private GameRunner gameView;
	private BoardPanel boardPanel;
	private boolean startButtClicked = false;
	
	private GraphicalBoardView(){
		//set the frame's parameters
		setSize(new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocation(100, 100); //offset so not hanging off screen
		setResizable(false); 
		setMinimumSize(new Dimension(800, 900));
		setTitle("Trails"); //give it a cool name
		getContentPane().setLayout(new BorderLayout()); //set the layout to Box
		//give the JFrame an icon
		String path = new File("").getAbsolutePath();
		ImageIcon icon = new ImageIcon(path + "/src/main/java/edu/indiana/cs/c212/view/graphical/Hexagon.png");
		setIconImage(icon.getImage());
		
		JPanel optsPanel = getOptionsPanel(); //get the player chooser and boardsize picker
		add(optsPanel, BorderLayout.NORTH); //add them all to the center
		
		JPanel start = getStartButton();
		add(start, BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}
	
	public static Runnable setup(){
		return new Runnable(){
			public void run(){
				GraphicalBoardView gBV = new GraphicalBoardView();
			}
		};
	}
	
	public void actionPerformed(java.awt.event.ActionEvent e){
		
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
		start.setLayout(new BorderLayout());
		start.add(startButtLabel, BorderLayout.NORTH);
		start.add(startButt, BorderLayout.SOUTH);
		
		//add an ActionListener
		startButt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){ //this coded block is called by the listener
				if (!startButtClicked){
					startButtClicked = true;
					String redType = pCPRed.getPlayerType();
					String blueType = pCPBlue.getPlayerType();
					int boardSize = numPicker.getBoardSize();
					GameRunner game = new GameRunner(boardSize, redType, blueType, "StandardRules");
					gameView = game;
					TurnViewer turnViewer = new TurnViewer(PlayerColor.RED, game);//construct a turnViewer
					
					add(turnViewer, BorderLayout.EAST); //add a turnViewer to the frame
					BoardPanel boardPanel = setBoardPanel(); //draw the board
					
					//add(boardPanel, BorderLayout.CENTER);
					boardPanel.setSize(new Dimension(552, 380));
					
					JPanel test = new JPanel();
					add(test, BorderLayout.CENTER);
					test.add(boardPanel);

					//boardPanel.setLocation(0, 200);
					Thread t = new Thread(game);
					t.start();
				}
			}
		});
		

		return start;
	}
	
	private BoardPanel setBoardPanel(){
		boardPanel = new BoardPanel(gameView.getBoard(), getGraphics());
		//boardPanel.setSize(new Dimension(600, 600));
		return boardPanel;
		//boardPanel.setLocation(0, 200);
	}
	
	//create an instructions panel
	private JPanel getInstructions(){
		JPanel instructsPanel = new JPanel();
		//JLabel instructions = new JLabel("Enter the desired settings for the game");
		//make the font bigger
		//Font font = instructions.getFont();
		//instructions.setFont(new Font(font.getName(), Font.PLAIN, 14));
		
		//instructsPanel.add(instructions, BorderLayout.SOUTH);
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
		
		//JPanel instructsPanel = getInstructions();
		
		pCPRed.setMaximumSize(new Dimension(400, 150));
		pCPBlue.setMaximumSize(new Dimension(400, 150));
		numPicker.setMaximumSize(new Dimension(400, 150));
		
		//set and layout and arrange all the panels within the layout
		//add all the things
		//optsPanel.add(instructsPanel);
		optsPanel.add(pCPRed);
		optsPanel.add(pCPBlue);
		optsPanel.add(numPicker);
		
		return optsPanel;
	}
	
}

