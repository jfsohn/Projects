
Homework:
## Part 1

Create an empty area of size 300 * 300 and display a grid of randomly colored squares on it.
Each colored square fits into a square block of pixels such that: 
 - Each colored square is 25x25 pixels, 
 - Each side of each colored square is outlined by a 1-pixel thick black line
 - Each side of each outlined colored square is surrounded by a 3-pixel thick cyan background.

We have provided ColoredSquares.Java file with definition and code for few methods.
----------------------------------------------------------------------------------
Sequence of steps:

1. Create Jframe for this application.
JFrame class in Java:ƒ
It will be used to create a simple top-level window(container) for a Java application.
It is used to represent the stuff a window should have. This includes borders (resizeable y/n?), titlebar (App name or other message), controls (minimize/maximize allowed?), and event handlers for various system events like 'window close' (permit app to exit yet?).

2. Create JPanel and draw colored blocks on it.
Jpanel class in Java: 
A JPanel class is used to crate an empty area that can be used to draw graphics on it.
---------------------------------------------------------------------------------

Code Walk-through:

1. Create JFrame
  - Done in the main method of the class as JFrame frame = new JFrame("Colored Squares");

2. Create JPanel. In the provide code ColoredSquares class extends JPanel class.
   We create JPanel using ColoredSquares colorsquares = new ColoredSquares();
   The base class constructor get called from the subclass constructor automatically.
   Example:
   ColoredSquare()
   {
		JPanel(); // This statement is automatically added by compiler.
		....
   }
   
   JPanel constructor internally calls paintComponent(Graphics g) method.
   Sequence of calls:
   ColoredSquares() -> JPanel() -> paintComponent(Graphics g)
   
3. The drawBlock() method is called from paintComponent() method to draw block
4. Thhe randomColor() method is called from drawBlock() method to generate random color to block
5. The randomColorValue() returns random integers in range of 256. Using this random integer random color is generated by randomColor() method.

===========================================================================================

Part - 3
 
Complete the methods in NumberProcesssor.java file
