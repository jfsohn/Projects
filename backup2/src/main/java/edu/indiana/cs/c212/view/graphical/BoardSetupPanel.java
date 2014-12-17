package edu.indiana.cs.c212.view.graphical;

import javax.swing.*;
import java.awt.*;

public class BoardSetupPanel extends JPanel{
	public static int DEFAULT_BOARD_SIZE = 8;
	public static int MIN_SUPPORTED_BOARD_SIZE = 4;
	public static int MAX_SUPPORTED_BOARD_SIZE = 10;
	
	private SpinnerModel numModel;
	private JSpinner sizeChooser;
	
	public BoardSetupPanel(){
		SpinnerModel numModel = new SpinnerNumberModel(DEFAULT_BOARD_SIZE, MIN_SUPPORTED_BOARD_SIZE,
														MAX_SUPPORTED_BOARD_SIZE, 1);
		sizeChooser = new JSpinner(numModel);
		JLabel spinnerLabel = new JLabel("Choose the board size");
		
		setLayout(new BorderLayout());
		add(spinnerLabel, BorderLayout.NORTH);
		add(sizeChooser, BorderLayout.SOUTH);
	}
	
	public int getBoardSize(){
		Number val =  (Integer) sizeChooser.getValue();
		return val.intValue();
	}
}
