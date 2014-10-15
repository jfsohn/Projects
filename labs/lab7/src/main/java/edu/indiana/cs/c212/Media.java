package edu.indiana.cs.c212;

public abstract class Media implements MediaItem{
	protected String title;
	protected int lengthInSeconds;
	protected int copyrightYear;
	
	public String getTitle() {
		return this.title;
	}

	public int getLengthInSeconds() {
		return this.lengthInSeconds;
	}
	
	public double getLengthInMinutes() {
		return this.getLengthInSeconds()/60.0;
	}
	
	public double getLengthInHours(){
		return this.getLengthInMinutes()/60;
	}

	public int getCopyrightYear() {
		return this.copyrightYear;
	}
}
