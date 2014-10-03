package edu.indiana.c212.labs.two;

public class Lab2 {
	public static int recursiveAdd(int x, int y){
		if (y == 0) {
			return x;
		} else if (x == 0) {
			return y;
		} else {
			return recursiveAdd( x + 1 , y - 1);
		}
}

	public static int iterativeAdd(int x, int y){
		int i = 0;
		while (i < y) {  
			x = x + 1; 
			i = i + 1; 
		}
		return x;
	}
	public static int iterativeMult(int x, int y){
	    if (y == 0) {
	    	return 0;
	    }   else {
	    	  int i = x;     //i = 3    x=6,12  y=3
	    	  while (y > 1) {
	    		  x = iterativeAdd(x , i);
	    	      y = y -1;
	    	  }
	    	  return x;
	    }	
	}
	
	public static int iterativeExp(int x, int exp){	
		int n = x;
		if(exp == 0){
			return 1;
		}
		else for(int i = 1; i < exp; i++) {
			x = iterativeMult(x,n);
		}
		return x;
	}
		
		

    public  static void printExpected(Object expected, Object actual){
        System.out.printf("Expected value is : %s, received value was: %s. \n", expected, actual);
    }

	public static void main(String[] args){
		printExpected(4, recursiveAdd(0, 4));//Expected result 4
		printExpected(7, recursiveAdd(3, 4));//Expected result 7
		printExpected(7, iterativeAdd(3, 4));//Expected result 7
		printExpected(12, iterativeMult(3, 4));//Expected result 12
		printExpected(81, iterativeExp(3, 4));//Expected result 81

	}
}