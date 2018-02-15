// Class Assignment: Fibonacci Numbers
// Name: Danielle Coulter
// Date: Jan 19, 2017
//This program calculates the Fibonacci numbers, up to 5.

import java.util.Scanner;

//begin class
public class Fib {
	
	//begin main method
	public static void main(String[] args){
		int N = 5;
		int first = 0;
		int second = 1;
		int fib_i = 0;
      
		//Print the first Fib number
		System.out.println("fib_1=" + first);
		System.out.println("fib_1=" + second);
		
		//begin test
		for (int i = 3; i<= N; i++){
			
			//Perform calculation
			fib_i = first + second; 
			System.out.println("fib_" + i + "=" +fib_i); //display calculation
			//advance to the next increment
			first = second;
			second = fib_i;
			
		}//end for loop
	
	}//end main method
}//end class 