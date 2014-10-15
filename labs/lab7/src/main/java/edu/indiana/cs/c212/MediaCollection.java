package edu.indiana.cs.c212;
import java.util.ArrayList;

public class MediaCollection {
	
	private ArrayList<Media> collection;
	private String name;
	
	MediaCollection(String name){
		this.name = name;
		this.collection = new ArrayList<Media>();
	}

	/**
	 * copyCollection returns a copy of the media collection. It is
	 * important to remember that this should involve a copy of every form
	 * of Media in the collection.
	 * 
	 * @return a copy of the media collection
	 */
	public MediaCollection copyCollection(){
		//FIXME
		return null;
	}
	
	/**
	 * @return the collection
	 */
	public ArrayList<Media> getCollection(){
		return this.collection;
	}
	
	/**
	 * removes all media from the collection
	 */
	public void removeAllMedia(){
		collection.clear();
	}
	
	/**
	 * @param m, adds m to the collection
	 */
	public void add(Media m){
		this.collection.add(m);
	}
	
	/**
	 * @return the name of the collection
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * setName sets the collection's name to the given name
	 * 
	 * @param name, the new name for the collection
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * @param m, remove all copies of m from the collection
	 */
	public void remove(Media m){
		for(int i = 0; i < collection.size(); i++){
			if(m.getClass().equals(collection.get(i).getClass()) && m.equals(collection.get(i))){
				collection.remove(i);
				i--;
			}
		}
	}
	
	/**
	 * @return the number of items in the collection
	 */
	public int getSize(){
		return collection.size();
	}
	
	/**
	 * @return the total playtime of all media in the collection in hours
	 */
	public double getTotalPlaytimeInHours(){
		double playtime = 0;
		for(Media m : collection){
			playtime += m.getLengthInHours();
		}
		return playtime;
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
