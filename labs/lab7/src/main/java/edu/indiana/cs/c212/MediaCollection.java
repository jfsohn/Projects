package edu.indiana.cs.c212;
import java.util.ArrayList;

public class MediaCollection {
	
	private ArrayList<Media> collection;
	private String name;
	
	MediaCollection(String name){
		this.name = name;
		this.collection = new ArrayList<Media>();
	}
	
	//return a copy of the media collection (including copies of all media) not the collection itself.
	public ArrayList<Media> copyMediaCollection(){
		ArrayList<Media> mediaCollectionCopy = new ArrayList<Media>();
		for(Media media : collection){
			mediaCollectionCopy.add(media.makeCopy());
		}
		return mediaCollectionCopy;
	}
	
	//returns the media collection
	public ArrayList<Media> getCollection(){
		return this.collection;
	}
	
	//removes all media from the collection
	public void removeAllMedia(){
		collection.clear();
	}
	
	//adds the given media to the collection
	public void add(Media m){
		this.collection.add(m);
	}
	
	public String getName(){
		return this.name;
	}
	
	//removes all copies of the given media from the collection
	public void remove(Media m){
		for(int i = 0; i < collection.size(); i++){
			if(m.getClass().equals(collection.get(i).getClass()) && m.equals(collection.get(i))){
				collection.remove(i);
				i--;
			}
		}
	}
	
	//returns the number of items in the collection
	public int getSize(){
		return collection.size();
	}
	
	//returns the total play time of all media in the collection in hours
	public double getTotalPlaytimeInHours(){
		double playtime = 0;
		for(Media m : collection){
			playtime += m.getLengthInSeconds();
		}
		return playtime/3600;
	}
	
	/*toString method, allows us to nicely display the whole collection.
	Note: any time you call System.out.println on an Object, the println
	method will use that Object's toString method to get the string it prints */
	@Override
	public String toString(){
		String output = this.name + "\n";
		int count = 1;
		for(Media media : this.collection){
			output += count + ": " + media.toString() + "\n";
			count++;
		}
		return output;
	}
}
