package edu.indiana.cs.c212.gameMechanics;

import edu.indiana.cs.c212.view.graphical.GraphicalBoardView;
import edu.indiana.cs.c212.board.SimpleGameBoard;
import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.players.*;
import edu.indiana.cs.c212.view.textual.CommandLineView;
import edu.indiana.cs.c212.exceptions.*;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Observable;

public class GameRunner extends Observable implements Runnable{
	private static String red, blue, ruleSet;
	private Board board;
	private Rules rules;
	private Player redPlayer;
	private Player bluePlayer;
	
	public GameRunner(int boardSize, String red, String blue, String ruleSet){
		this.red = red;
		this.blue = blue;
		this.ruleSet = ruleSet;
		this.redPlayer = createPlayer(red, PlayerColor.RED);
		this.bluePlayer = createPlayer(blue, PlayerColor.BLUE);
		this.board = new SimpleGameBoard(boardSize);
		
		this.rules = createRules(ruleSet, board, redPlayer, bluePlayer);
	}
	
	public static List<String> getPlayersList(){
		List<String> pList = new ArrayList<String>();		
		pList.add("edu.indiana.cs.c212.players.PointAndClickPlayer");
		pList.add("edu.indiana.cs.c212.players.CommandLinePlayer");
		pList.add("edu.indiana.cs.c212.players.SimpleRandom");
		pList.add("edu.indiana.cs.c212.players.BasicTrailsPlayer");
		return pList;
	}
	
	public Board getBoard(){
		return board;
	}
	
	public Player getCurrentPlayer(){
		return rules.getPlayers().peek();
	}
	
	public static List<String> getRuleSets(){
		List<String> l = new ArrayList<String>();
		l.add("edu.indiana.cs.c212.gameMechanics.StandardRules");
		l.add("edu.indiana.cs.c212.gameMechanics.OverwriteRules");
		return l;
	}
	
	protected static Rules createRules(String ruleset, Board board, Player red, Player blue){
		Rules r;
		if (ruleset.contains("Overwrite")){
			r = new OverwriteRules(board, red, blue);
		} else {
			r = new StandardRules(board, red, blue);
		}
		return r;
	}
	
	protected static Player createPlayer(String playerType, PlayerColor color){
		Player p;
		if (playerType.contains("Random")){
			p = new SimpleRandom(color);
		} else if (playerType.contains("Basic")) {
			p = new BasicTrailsPlayer(color);
		}	else if (playerType.contains("Point")) {
				p = new PointAndClickPlayer(color);
		} else {
			p = new CommandLinePlayer(color);
		}
		System.out.println(p.getName());
		return p;
	}
	
	public void run(){
		while(rules.checkForWins() == null){
			System.out.println(redPlayer.getName() + " test");
			System.out.println(bluePlayer.getName());
			rules.nextTurn();
			setChanged();
			notifyObservers(rules.getNextPlayer()); //updates the observables
			System.out.print(CommandLineView.boardToString(board));
			ArrayList<Move> legalMoves = new ArrayList<Move>();
			legalMoves = rules.getLegalMoves(rules.getPlayers().peek());
			Move m = rules.getPlayers().peek().getMove(board, legalMoves);
			System.out.println("requested move of " + rules.getPlayers().peek().toString());
			if (rules.isLegalMove(m)){
				try {
					rules.makeMove(m);
				} catch (InvalidMoveException e){
					System.out.println("e");
				}
			}
		}
		System.out.println(rules.getNextPlayer().getColor() + " " + rules.getNextPlayer().getName() + " wins!");
	}
	
	public void stopGame(){
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Thread t = new Thread(GraphicalBoardView.setup());
		t.start();
	}
}
