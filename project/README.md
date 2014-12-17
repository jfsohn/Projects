#C212 Final Project - Trails
##What is Trails?
Trails is a 2 player game played on a board of hexagonal tiles. It can be seen as having a similar complexity as chess or go, but with simple rules and a clear winning state that allows new players to quickly pick up and play with ease. The game offers intricacies that make the game rewarding to master and, combined with the impossibility of a draw-game, gives a satisfying game.

##What is the Project?
You will be given a files that contain only the public methods annotated by javadocs. Do not alter any of the method signatures of private methods, but feel free to add your own private helpers.


##Description(s) of the improvement(s) attempted.
The improvement attempted in milestone five, was the random player move extension. To make this possible, I created a class named RandomPlayerMove.
In RandomPlayerMove I simply used random integer to take a random integer. I then checked to see if the random integer, 'randInt', was less than 5. If so, then it would add the blue move to the queue, otherwise it return red in the queue. Therefore, it would return red for the numbers 6-9 and thus return red 50% of the time as well.

##Any way in which you worked with your partner on this assignment.
I've worked with my partner by coding several classes and methods in order to create the hex game. Both of us have also made sure not only that the graphical board view functioned correctly (as well as the rest of the classes), but also that the graphical board view had a nice ui.
