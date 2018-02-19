/*
	Assignment: Homework 5
	Date: Jan 23, 2017

	This program is an exercise in modular design with static methods.
	This program calculates the distance between two points; longitude and latitude.
	Functions will aggregate decomposed subtasks while utilizing Javadoc's documentation for program and public methods.
	
	@author Danielle Coulter
*/


//import java libraries
import java.math.BigDecimal;
import java.util.Scanner;

//begin class
 class Distance {
	
	//begin main method
	public static double round(double unrounded, int precision, int roundingMode)
	{
	    BigDecimal bd = new BigDecimal(unrounded);
	    BigDecimal rounded = bd.setScale(precision, roundingMode);
	    return rounded.doubleValue();
	}

	public static double distFrom(double lat1, double lng1, double lat2, double lng2, String unit)
	{
	    double theta = lng1 - lng2;

	    double distance = (
	        Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
	     )+(
	        Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta))
	     );
	    distance = Math.acos(distance);
	    distance = Math.toDegrees(distance);
	    distance = distance * 60 * 1.1515;

	    switch(unit)
	    {
	        /* Mi = miles, Km = Kilometers */
	        case "Mi"   : 
	            break;
	        case "Km"   : 
	            distance = distance *1.609344;
	            break;
	    }
	    distance = round(distance, 2, BigDecimal.ROUND_HALF_UP);
	    return distance;
	
		
		
		
		
		
	}//end main method
}//end class 