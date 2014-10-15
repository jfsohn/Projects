package edu.indiana.cs.c212;

import java.util.ArrayList;

public class CD extends Media{

	private ArrayList<MP3> trackList;
	private String artist;
	private String publisher;
	private int numberOfTracks;
	private String genre;
	
	public CD(String title, String artist, int copyrightYear, ArrayList<MP3> songs, String publisher, String genre){
		this.title = title;
		this.artist = artist;
		this.copyrightYear = copyrightYear;
		this.trackList = songs;
		this.publisher = publisher;
		this.numberOfTracks = songs.size();
		this.genre = genre;
		for(MP3 song : songs){
			this.lengthInSeconds += song.lengthInSeconds;
		}
	}

	@Override
	public CD makeCopy() {
		ArrayList<MP3> songsCopy = new ArrayList<MP3>();
		for(MP3 track : trackList){
			songsCopy.add(track.makeCopy());
		}
		return new CD(this.title, this.artist, this.copyrightYear, songsCopy, this.publisher, this.genre);
	}
	
	public String getPublisher(){
		return this.publisher;
	}
	
	public String getGenre(){
		return this.genre;
	}
	
	public int getNumberOfTracks(){
		return this.numberOfTracks;
	}
	
	public boolean equals(Object objcd){
		if(objcd instanceof CD){
			CD cd = (CD) objcd;
			return (this.title.equals(cd.title) &&
					this.artist.equals(cd.artist) &&
					this.copyrightYear == cd.copyrightYear &&
					this.numberOfTracks == cd.numberOfTracks &&
					this.publisher.equals(cd.publisher) &&
					this.trackList.equals(cd.trackList));
		}	
		return false;
	}
	
	@Override
	public String toString(){
		return (this.title + " - " + this.artist + " (" + this.copyrightYear +")");
	}
}
