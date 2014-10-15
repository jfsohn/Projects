package edu.indiana.cs.c212;

public class DVD extends Media{
	private String title;
	private int copyrightYear;
	private int lengthInSeconds;
	private String studio;
	private String genre;
	private String director;
	
	public DVD(String title, int copyrightYear, int lengthInSeconds, String studio, String genre, String director){
		this.title = title;
		this.copyrightYear = copyrightYear;
		this.lengthInSeconds = lengthInSeconds;
		this.studio = studio;
		this.genre = genre;
		this.director = director;
	}
	
	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public int getLengthInSeconds() {
		return this.lengthInSeconds;
	}

	@Override
	public int getCopyrightYear() {
		return this.copyrightYear;
	}
	
	public String getStudio(){
		return this.studio;
	}
	
	public String getDirector(){
		return this.director;
	}

	@Override
	public DVD makeCopy() {
		return new DVD(this.title, this.copyrightYear, this.lengthInSeconds, this.studio, this.genre, this.director);
	}
	
	public boolean equals(DVD dvd){
		return(this.title.equals(dvd.title) &&
				this.copyrightYear == dvd.copyrightYear &&
				this.lengthInSeconds == dvd.lengthInSeconds &&
				this.studio.equals(dvd.studio) &&
				this.genre.equals(dvd.genre) &&
				this.director.equals(dvd.director));
	}
	
	@Override
	public String toString(){
		return (this.title + " (" + this.copyrightYear + ")");
	}

}
