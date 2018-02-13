//*******************************
//Name: Danielle Coulter
//Title: Geek.java (with Assignment5.java)
//Author: Assignment from Professor Oskooyee
//Description: Implementing classes & testing
//Time spent: 3 hours
//Date: 11/14/2016
//*******************************

// Geek class implementation
public class Geek
{
   // Define Instance Variables
   private String nameOfGeek;
   private int numOfQuestions;
  
   // Create Constructors
   public Geek(String name, int numQuestions)
   {
       nameOfGeek = name;
       numOfQuestions = numQuestions;
   }
  
   //Method A: getName
   public String getName()
   {
       return nameOfGeek;
   }
  
   //Method B: Number of questions
   public int getNumOfQuestions()
   {
       return numOfQuestions;
   }
  
   //Method C: if sum is even
   public boolean isEven(int num1, int num2)
   {
       numOfQuestions++;
      
       if((num1 + num2) % 2 == 0)
           return true;
       else
           return false;
   }
  
   //Method D: Returns sum of all numbers between two entries
   public int sum(int num1, int num2)
   {
       numOfQuestions++;
      
       int total = 0;
      
       if(num1 > num2)
       {
           int temp = num1;
           num1 = num2;
           num2 = temp;
       }
      
       for(int n = num1; n <= num2; n++)
       {
           total = total + n;
       }
      
       return total;
   }
  
   //Method E: Is year entered a leap year
   public boolean leapYear(int year)
   {
       numOfQuestions++;
      
       if((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))
           return true;
       else
           return false;
   }
} // end of Geek class