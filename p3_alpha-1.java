package p3_alpha;
/*******************************
* Author: Danielle Coulter
* Title: p3_alpha.java
* Description: Counting and alphabetizing 
* Material: Chapter 11
* Date: 11/08/2017
******************************
*/

import java.util.*;
import java.io.FileNotFoundException;
import java.io.*;

public class p3_alpha{
   /*
   * This program is designed to accept input from one .txt file,
   * sort and count words, organize them alphabetically and print 
   * to console the occurrences of each word. 
   * 
   * @author Danielle Coulter
   */
   
     
   //define constant
   //outside of main method
   
   /*
   * This method uses a map to count the occurrences 
   * of words in the file
   * 
   * @param count counts words in file
   * @value OCCUR stores and keeps count of words
   * @throws FileNotFoundException of file presence or restrictions
   */   
   public static void main(String []args) 
            throws FileNotFoundException {
      
      //Prompt user for file name
      System.out.println("Let's get started!");
      System.out.println("First we see the words in alphabetical order");
      System.out.println("and then we'll count the occurances of each word.");
      System.out.println();

      //Create scanner for file input
      Scanner in = new Scanner(new File("agile_manifesto.txt"));

      //pg742
      Map<String, Integer> wordCountMap = new TreeMap<String, Integer>();
      ValueComparator vc = new ValueComparator(wordCountMap);
   
      Map<String, Integer> sortedWord = new TreeMap<String, Integer>(vc);

      while(in.hasNext()) {
    	  
    	  String word = in.next();
    	  if (wordCountMap.containsKey(word)) {
    		  
    		  Integer count = wordCountMap.get(word);
    	      //remove non-character items like white spaces
    		  wordCountMap.put(word.trim().toLowerCase().replaceAll("\\p{Punct}+", ""), count +1);
    	  }else {
    		  
    		  //find new words
    		  wordCountMap.put(word.trim().toLowerCase().replaceAll("\\p{Punct}+", ""), 1);
    		  
    	  }//end if/else
    	  
      }//end while
      
      System.out.println("Here are the words, in alphabetical order: ");
      
      Set set = wordCountMap.entrySet();
      Iterator iter = set.iterator();
      //print words Alphabetically
      while(iter.hasNext()){
    	  
    	  Map.Entry me = (Map.Entry)iter.next();
    	  System.out.println(me.getKey() + ": " + me.getValue());
    	  
      }//end while
      
      sortedWord.putAll(wordCountMap);
      
      System.out.println();
      System.out.println("And here's how many times each word appears : ");
      
      Set set2 = sortedWord.entrySet();
      Iterator j = set2.iterator();
      
      //loop and print highest count of occurrences
      while (j.hasNext()) {
    	  
    	  Map.Entry me2 = (Map.Entry)j.next();
    	  System.out.println(me2.getKey() + ": " + me2.getValue());
    	  
      }//end while
      
      in.close();
      
      
   }//end main method
   
   /*
   * This method reads the file and returns a map from words to count
   * 
   * @return returns the count of words 
   */

   
   
}//end class

class ValueComparator implements Comparator<String>{
	
	Map <String, Integer> base;
		
	public ValueComparator(Map<String, Integer> base) {
		
		this.base=base;

	}//end Valuecomp method
	
	public int compare (String a, String b) {
		
		if(base.get(a) >= base.get(b)) {
			
			return -1;

		}else {
			return 1;
			
		}//end else
	}//end compare
}//end of ValueComp class

/*
 * I tried this method but I was stuck in an infinite loop
 * 
 * public static Map<String, Integer> getCountMap(Scanner in){

   Map<String, Integer> wordCountMap = 
      new TreeMap<String, Integer>();
      
      while (in.hasNext()) {
         String word = in.next().toLowerCase();
         System.out.println(word);
         
         if (wordCountMap.containsKey(word)) {
            //if word is repeated, increment
            int count = wordCountMap.get(word);
            wordCountMap.put(word, count + 1);
            
         } else {
            //new word discovered
            wordCountMap.put(word, 1);
            
         }//else
         
      }//end while

      return wordCountMap;
      
}//end getCountMap ()
*/

/*
possible report:
Set was described in Chapter 11.2 (pg 730) as efficient and has good performance.

HashSet is great ofr add, removing and searching for duplicates but will not alphabetize.

TreeSet will sort the order and all things Hash can do but is slower.

TreeMap will store keys in sorted order, which means we can alphabetize them.

An Union se  operation can split the text file into two sets of words. Then
   it can compare overlapping instances that are contained in both sets. Since the original 
   sets' contents are not important we can easily use this method.
   
Requirements:
   store
   count
   organize (alphabetically)
   print (all)
   
   
   
   
   
*/
