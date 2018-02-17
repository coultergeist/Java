//This is a simple program to compute tax (sales & county) of a purchase and provide a total.
//Sales tax = 8.5% and County tax = 2.5%

//importing java scanners
import java.util.Scanner;
import java.text.NumberFormat; 

public class Tax {
	public static void main(String[] args){
			
		//Declaring Variables
		int bill;
		double state = 8.50;
		double county = 2.50;
		double taxTotal, total;
		
		//java scanner
		Scanner scan = new Scanner(System.in);
		
		//Instance 1: purchase amount
		System.out.println("Let's view a breakdown of your bill today!\n" );
		System.out.println("What was the amount of your purchase? ");
		bill = (int) scan.nextDouble();
		
		//Perform Calculations
		state = bill * (state/100.00);
		county = county * (county/100.00);
		taxTotal = state + county;
		total = bill + taxTotal ;
		
		//Display results to user
		//Instance 2: state sales tax
		System.out.println("\nThe amount of State sales tax came to: $" + state);
				
		//Instance 3: county sales tax
		System.out.println("The amount of County sales tax came to: $" + county);
				
		//Instance 4: tax total
		System.out.println("In total, the sales tax were: $" + taxTotal);
			
		//Instance 5: purchase total
		System.out.println("\nYour grand total today was: $" + total);
				
	}//end of method
}//end of class