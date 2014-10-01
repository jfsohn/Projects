package src.test.java.edu.indiana.cs.c212;

import static org.junit.Assert.*;
import src.main.java.edu.indiana.cs.c212.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.*;

import org.junit.Test;

public class WordPlayTest {

	@Test
	public void testFetchWords() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class<?> c = Class.forName("src.main.java.edu.indiana.cs.c212.WordPlay");
	  Class<?>[] parameters = {Class.forName("java.lang.String")};	
		Method fetchWords = c.getDeclaredMethod("fetchWords", parameters);
		
		
		
		//Oh god so gross
		Field f = c.getDeclaredField("fridge");
		f.setAccessible(true);

    WordPlay w = new WordPlay();
		Fridge fridge = (Fridge) f.get(w);
		
		Field magnets = fridge.getClass().getDeclaredField("magnets");
		magnets.setAccessible(true);
    magnets.set(fridge, new ArrayList<Magnet>());
    ArrayList<Magnet> theirList = (ArrayList<Magnet>) magnets.get(f);
    for(Magnet magnet : theirList){
    	System.out.println(magnet.getWord());
    }
    fetchWords.setAccessible(true);
		try{
			fetchWords.invoke(w, "octocat, banana. !! 32 42 rawlins java coffee hadoop mpi reduce partition twittertweets!");
		}
		catch(InvocationTargetException e){
			System.out.println("error");
		}

    ArrayList<String> testStrings = new ArrayList<String>();
    testStrings.add("octocat");
    testStrings.add("banana");
    testStrings.add("rawlins");
    testStrings.add("java");
    testStrings.add("coffee");
    testStrings.add("hadoop");
    testStrings.add("mpi");
    testStrings.add("reduce");
    testStrings.add("partition");
    testStrings.add("twittertweets");

	}
}
