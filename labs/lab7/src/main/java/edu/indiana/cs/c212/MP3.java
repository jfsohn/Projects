package edu.indiana.cs.c212;

public class MP3 extends Media{
	private String artist;
	private String title;
	private int lengthInSeconds;
	private String genre;
	private int copyrightYear;
	
	public MP3(String artist, String title, int lengthInSeconds, String genre, int copyrightYear){
		this.artist = artist;
		this.title = title;
		this.lengthInSeconds = lengthInSeconds;
		this.genre = genre;
		this.copyrightYear = copyrightYear;
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

	public String getGenre(){
		return this.genre;
	}
	
	@Override
	public MP3 makeCopy() {
		return new MP3(this.artist, this.title, this.lengthInSeconds, this.genre, this.copyrightYear);
	}
	
	public boolean equals(MP3 mp3){
		return (this.artist.equals(mp3.artist) &&
				this.copyrightYear == mp3.copyrightYear &&
				this.genre.equals(mp3.genre) &&
				this.title.equals(mp3.title) &&
				this.lengthInSeconds == mp3.lengthInSeconds);
	}
	
	@Override
	public String toString(){
		return (this.title + " - " + this.artist + " (" + this.copyrightYear +")");
	}
}
