package edu.indiana.cs.c212;
import java.util.ArrayList;

public class MediaCollection {
	
	private ArrayList<Media> collection;
	private String name;
	private int size;
	
	MediaCollection(String name){
		this.name = name;
		this.size = 0;
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
		this.size = 0;
		this.collection = new ArrayList<Media>();
	}
	
	//adds the given media to the collection
	public void add(Media m){
		this.collection.add(m);
		this.size++;
	}
	
	public String getName(){
		return this.name;
	}
	
	//removes all copies of the given media from the collection
	public void remove(Media m){
		ArrayList<Media> toBeRemoved = new ArrayList<Media>();
		for(Media current : this.collection){
			if(m.getClass().equals(current.getClass())){
				if(m instanceof DVD && ((DVD)m).equals((DVD) current)){
					toBeRemoved.add(current);
				}
				else if(m instanceof CD && ((CD)m).equals((CD) current)){
					toBeRemoved.add(current);
				}
				else if(m instanceof MP3 && ((MP3)m).equals((MP3) current)){
					toBeRemoved.add(current);
				}
			}
		}
		for(Media removed : toBeRemoved){
			if(collection.remove(removed)){
				size--;
			}
		}
	}
	
	//returns the number of items in the collection
	public int getSize(){
		return this.size;
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
		String output = "";
		int count = 1;
		for(Media media : this.collection){
			output += count + ": ";
			if(media instanceof DVD){
				output += ((DVD) media).toString() + "\n";
			}
			else if(media instanceof CD){
				output += ((CD)media).toString() + "\n";
			}
			else if(media instanceof MP3){
				output += ((MP3)media).toString() + "\n";
			}
			count++;
		}
		return output;
	}
}
