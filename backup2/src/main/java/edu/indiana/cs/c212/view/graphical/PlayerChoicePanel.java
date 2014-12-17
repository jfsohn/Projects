package edu.indiana.cs.c212.view.graphical;

import javax.swing.*;

import java.awt.*;

public class PlayerChoicePanel extends JPanel{
	private String[] playerTypes = {"CommandLine" , "SimpleRandom" , "Point and Click"};
	private JComboBox<String> playerChooser;
	
	public PlayerChoicePanel(String name){
		JLabel chooserName;
		if (name.contains("R")){
			chooserName = new JLabel("<html><b color='red'>" + name + "</b></html>");
		} else {
			chooserName = new JLabel("<html><b color='blue'>" + name + "</b></html>");
		}
		//make the font bigger
		Font font = chooserName.getFont();
		chooserName.setFont(new Font(font.getName(), Font.PLAIN, 16));
		
		chooserName.setHorizontalTextPosition(JLabel.CENTER);
		playerChooser = getChoicePanel();
		chooserName.setLabelFor(playerChooser);
		setLayout(new BorderLayout());
		add(playerChooser, BorderLayout.SOUTH);
		add(chooserName, BorderLayout.NORTH);
	}
	
	public JComboBox<String> getChoicePanel(){
		JComboBox<String> playerChooser = new JComboBox<String>(playerTypes);
		return playerChooser;
	}
	
	public String getPlayerType(){
		return String.valueOf(playerChooser.getSelectedItem());
	}
	
}
