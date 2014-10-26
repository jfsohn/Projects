###Tile.java

Each Tile is a spot on the board. It knows about the player color that populates that spot, as well as which hexagon on the board it occupies. It should be able to tell if it is equal to another given Object, as well as have a nice way to print.

Tiles are used to control the spots that each player chooses each turn. These are the back-end to the graphical and textual output that will let you play the game.

Remember PlayerColor allows for three options, RED, BLUE, and BLANK. In StandardRules all tiles should be BLANK at the beginning of the game and will stay that way until a player makes a legal move on them.

###SimpleGameBoard.java

The SimpleGameBoard is the class that ties together all of the other pieces of our project. It keeps track of the current Player, it tracks when changes occur, and it knows the size of the board. This class acts as a controller for the model and the view (which we will get to next week). The constructor also specifies the end zones of the board, which will be very useful in determining whether any given move connects two sides of the board by a path of one color of tiles.

In SimpleGameBoard, you will need to create the board (for example, as a Tile[ ][ ] with some goal nodes) initialize it with the appropriate starting state and then update the board as moves or other events happen to keep it current with the state of the game.  Remember that the color (PlayerColor) of the Tile being constructed matters.

Think about the goal zones as nodes (Tiles), one on each edge of the board, that connnect to every Tile on that edge of the board.  Using an implementation like this you can think about checking whether someone has won as checking whether this is a path connecting to goal nodes where all the Tiles on that path (including the nodes) are of the same PlayerColor.  In such an implementation you might want to give the goal zones coordinates using x and y values of -1 or size (where size is the size of any side of the board).  Choosing an implementation like this might simplify the writing of your conditional checks when trying to determine whether a player has won or what the neighbors of a Tile are.  Board.jpg in this folder shows an ASCII art example of this sort of board representation.

The SimpleGameBoard class specifies the way that the Rules are able to access the Tiles at a specified coordinate. It also returns a Set of Tiles that represent the neighbors of a given Tile. Another method that is inherited from the Board interface is the makeMove method. This method sets the color of the Tile represented by the given Move to the color of the given player. It then marks that changes have been made via the Observable pattern, and notifies all observers that changes have been made.

A Set in java is a collection that contains no duplicate elements.  
For more information on the Set interface see: http://docs.oracle.com/javase/7/docs/api/java/util/Set.html

And for a class that implements Set see HashSet: http://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html 

Link to the Observable Interface: http://docs.oracle.com/javase/7/docs/api/java/util/Observable.html

Keep in mind that an Observer work similarly to a button that gets pressed. When an action happens, an Observable notifies all of its observers that an action happened.

Here are the rules surrounding Observers and Observables:

1.) Observable is a Class and Observer is an Interface.

2.) Observable class maintain a list of observers.

3.) When an Observable object is updated it invokes the update() method of each of its observers to notify the observers that it has changed state.

Here is an example of Observable and Observer Classes that illustrates how they can be used:

```java
import java.util.Observable; 
import java.util.Observer;

class MessageBoard extends Observable { private String message;

	public String getMessage() { 
		return message; 
	}
	
	public void changeMessage(String message) { 
		this.message = message; 
		//Here An action took place, and we notify the Observers 
		setChanged();
		notifyObservers(message); 
	}

	public static void main(String[] args) { 
		MessageBoard board = new MessageBoard(); 
		Student bob = new Student(); 
		Student joe = new Student(); 
		board.addObserver(bob); 
		board.addObserver(joe); 
		board.changeMessage("More Homework!"); 
	}
}

class Student implements Observer { 
	public void update(Observable o, Object arg) { 
		System.out.println("Message board changed: " + arg); 
	}
}
```
