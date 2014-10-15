package edu.indiana.cs.c212;

public interface MediaItem {
	String getTitle();
	int getLengthInSeconds();
	int getCopyrightYear();
	Media makeCopy();
}
