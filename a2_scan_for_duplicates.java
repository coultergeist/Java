/*******************************
* Author: Danielle Coulter
* Title: a2_scan_for_duplicates.java
* Description: ArrayLists and duplicates
* Material: Chapter 10
* Date: 10/15/2017
*
*
* This program is designed to accept input from one .txt file,
* arrange the words into an array, and then scan for duplicates. 
*
* Duplicates will be removed and then displayed on the console.
* 
* @author Danielle Coulter
******************************
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class a2_scan_for_duplicates{

    public static void main(String []args) 
            throws FileNotFoundException {
      
      //hard-coded filename
		//Scanner in1 = new Scanner(new File("words.txt"));
		Scanner console = new Scanner(System.in);
      
      //Prompt user for file name
      System.out.println("Let's clean this up!");
      System.out.println("What's your file name? ");
      Scanner in1 = new Scanner(new File(console.nextLine()));
      System.out.println();
      
      //Scan words in file and store in a list
      ArrayList<String> list = getWords(in1);
      
      //Find overlap within list
      ArrayList<String> common = getOverlap(list);
      	
   // TODO Auto-generated method stub
	return;
   
   }//end main method


	/*
   * This method reads words from scanner, converts
   * them to lower case for sorting, and finds any
   * duplicates within the file.
   */
   public static ArrayList<String> getWords(Scanner input) {
         
      //Delimiter to ignore illegal characters 
      input.useDelimiter("[^a-zA-Z']+");
      
      //Read and sort words
      ArrayList<String> words = new ArrayList<String>();
      
      while (input.hasNext()){
         String next = input.next().toLowerCase();
         words.add(next);
      }//end while 
      
      Collections.sort(words);
   
      //Look for unique words and keep them in a list
      ArrayList<String> result = new ArrayList<String>();
      if (words.size() > 0) {
         result.add(words.get(0));
      
         for (int i = 1; i < words.size(); i++){
            if (!words.get(i).equals(words.get(i-1))) {
               result.add(words.get(i));
            }//end inner if
      
         }//end for loop
      
      }//end outter if

      return result;
      //System.out.println("All cleaned up! Here's your list with no duplicates: " + result);

      }//end getWords method
      
       /*
      * This method will compare words within the text file
      * and store any that are similar (or overlap)
      * 
      * Condition: only accept letters
      */
      public static ArrayList<String> getOverlap(
               ArrayList<String> list){
         
         //remove non-character items like white spaces
         //nStr = nStr.replace("_","");
         
         //Use a hashmap to track occurrences
         Map<String, Integer> occurrences = new HashMap<String, Integer>();
         
         //perform iteration
         for(String word: list){
            
            //check for existance in has. If null, reset count=0
            Integer oldCount = occurrences.get(word);
            
            if (oldCount == null){
               
               //if !null, count occurence
               occurrences.put(word, 1);
             
            }//end if 
            
            else{
               
               //if word is present then count
               occurrences.put(word, oldCount+1);
               
            }//end else   
         }//end for loop
         
         ArrayList<String> overlapped = new ArrayList<String>();
         
         for (String word : occurrences.keySet()){
            
            Integer count = occurrences.get(word);
            
            if(count > 1)
               overlapped.add(word);
            
            }//end if
            
            return overlapped;
            
          //end for  
      
      }//end getOverlap method
      
      
      /*
      * This method displays the ArrayList with all duplicate words 
      * that were removed.
      */
      
      public static void duplicatesRemoved(ArrayList<String> list, 
               ArrayList<String> common) {
      
         System.out.println("All cleaned up! Here's your list with no duplicates: " 
               + common);
   
      }//end duplicatesRemoved method  
      
}//end class
