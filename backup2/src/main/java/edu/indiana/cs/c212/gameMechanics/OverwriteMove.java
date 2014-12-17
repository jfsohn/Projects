package edu.indiana.cs.c212.gameMechanics;

public class OverwriteMove extends Move{
	private int x;
	private int y;
	private boolean isOverwrite = true;
	
	public OverwriteMove(int x, int y){
		super(x, y);
	}
	
	public boolean isOverwriteMove(){
		return isOverwrite;
	}
	
	@Override
	public String toString(){
		return "OVERWRITE " + super.toString();
	}
}
