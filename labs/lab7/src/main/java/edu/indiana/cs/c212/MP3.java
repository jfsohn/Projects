package edu.indiana.cs.c212;

public class MP3 extends Media{
	private String artist;
	private String genre;
	
	public MP3(String artist, String title, int lengthInSeconds, String genre, int copyrightYear){
		this.artist = artist;
		this.title = title;
		this.lengthInSeconds = lengthInSeconds;
		this.genre = genre;
		this.copyrightYear = copyrightYear;
	}

	public String getGenre(){
		return this.genre;
	}
	
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	@Override
	public MP3 makeCopy() {
		return new MP3(this.artist, this.title, this.lengthInSeconds, this.genre, this.copyrightYear);
	}
	
	public String getArtist(){
		return this.artist;
	}
	
	public boolean equals(Object objmp3){
		if(objmp3 instanceof MP3){
			MP3 mp3 = (MP3) objmp3;
			return (this.artist.equals(mp3.artist) &&
					this.copyrightYear == mp3.copyrightYear &&
					this.genre.equals(mp3.genre) &&
					this.title.equals(mp3.title) &&
					this.lengthInSeconds == mp3.lengthInSeconds);
		}
		return false;
	}
	
	@Override
	public String toString(){
		return (this.title + " - " + this.artist + " (" + this.copyrightYear +")");
	}
}
