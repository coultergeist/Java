//*******************************
//Name: Danielle Coulter
//Title: SuperHero.java (with Lab6.java) 
//Author: Assignment from Professor Oskooyee
//Description: Chapter 7 & 8: Writing classes, instance variables, methods & constructors
//Time spent: 4 hours
//Date: 11/15/2016
//*******************************

//This class is tested by the Lab6.java driver

// SuperHero class implementation
public class SuperHero {
	
	// instance variables go below here
	private static int numberOfHeroes;
	private String heroName;
	private String secretIdentity;
	private int numberOfPeopleSaved;
	private int numberOfLifeChances;
	
	// the two constructors go below here
	public SuperHero(String initHeroName, String initSecretIdentity, int initPeopleSaved) {
		numberOfHeroes++; // one more hero created
		numberOfLifeChances = 2; // start the hero with two lives
		heroName = initHeroName;
		secretIdentity = initSecretIdentity;
		numberOfPeopleSaved = initPeopleSaved;
		}//end Constructor #1
	
	 public SuperHero(String initHeroName) {
	       numberOfHeroes++; // one more hero created
	       numberOfLifeChances = 2; // start the hero with two lives
	       heroName = initHeroName;
	       secretIdentity = "unknown";
	       numberOfPeopleSaved = 0;
	   }//end constructor #2 
	
	
	// Method: getNumberOfHeroes() goes below here
	public static int getNumberofHeroes(){
		return numberOfHeroes;
	}
	
	// Method: recordSave() goes below here
	public void recordSave(){
		numberOfPeopleSaved++;
	}
	
	// Method: the second recordSave method goes here
	public void recordSave(int num){
		numberOfPeopleSaved += num;
	}
	
	// Method: killHero() goes below here
	public void killHero(){
		if (numberOfLifeChances == 0){
			System.out.println("The Hero is Dead!");
		} else {
			numberOfLifeChances --;
		}//end if statement
	}//end killHero method
	
	// printSuperHeroRecord() goes below here
	public void printSuperHeroRecord(){
		System.out.println("Name: " + heroName + "\nSecret Indentity: "
				+ secretIdentity + "\nStatus: "
				+((numberOfLifeChances == 0) ? "Dead" : "Alive")
				+ "\nPeople Saved: " + numberOfPeopleSaved + "\n");
	}
	
}//End of SuperHero Class
