import java.util.*;
import java.io.*;

class DNAfile {

   public static void main(String[] args) {
   
      // hard code these for now, do something with user input later
      String inFileName = "testdata.txt";
      String outFileName = "analysis.txt";
      
      // do the thing
      processFiles(inFileName, outFileName);      
   }
   
   public static void processFiles(String inF, String outF) {
      File inputFile = new File(inF);
      File outputFile = new File(outF);
      
      // open the input file for reading
      try {
         // local variables
         String titleLine = "";
         String nucleotidesLine = "";

         // open the input file
         Scanner scIn = new Scanner(inputFile);
         
         // create the output file
         outputFile.createNewFile();
         Scanner scOut = new Scanner(outputFile);

         while (scIn.hasNext()) {
            // get lines in title, nucleotide pairs
            titleLine = scIn.nextLine();
            nucleotidesLine = scIn.nextLine();
            nucleotidesLine = nucleotidesLine.toUpperCase();
            
            // start processing the file
            System.out.println(titleLine);
            boolean massTest = getMassInfo(nucleotidesLine);
            boolean b = isProtein(nucleotidesLine, massTest);
            breakIntoCodons(nucleotidesLine);
            if (!b)
               System.out.println("NO");
            else
               System.out.println("YES");
            System.out.println();
         }
      }
      catch (IOException e) {
         System.out.print("Something went wrong:\n\t" + e.getMessage() + "\n");
      }            
}
   
   // can't I pass in the outfile scanner obj here for writing to the file?
   // anything we can do with println, we can do with a Scanner obj that points to the output file....
   // return a boolean because there is a mass-based calc that determines protein or not
   public static boolean getMassInfo(String nStr) {
      // constants
      double proteinMasses[] = {135.128, 111.103, 151.128, 125.107, 100.0};
      
      // arrays for calculations
      double totalMass = 0.0;
      int ACGTJ[] = {0, 0, 0, 0, 0};
      double percentsACGTJ[] = {0.0, 0.0, 0.0, 0.0, 0.0};

      // walk through nStr char by char and collect data
      for (int i=0; i<nStr.length(); i++)
      switch (nStr.charAt(i)) {
         case 'A': {
            ACGTJ[0]++;
            break;
         }
         case 'C': {
            ACGTJ[1]++;
            break;
         }
         case 'G': {
            ACGTJ[2]++;
            break;
         }
         case 'T': {
            ACGTJ[3]++;
            break;
         }
         case '-': {
            ACGTJ[4]++;
            break;
         }
      };
      
      // calculate total mass
      for (int i=0; i<5; i++)
         totalMass += ACGTJ[i] * proteinMasses[i];

      // calculate the percentages - 1-digit precision
      double currPercentage = 0.0;
      for (int i=0; i<5; i++) {
         currPercentage = ACGTJ[i] * proteinMasses[i] / totalMass * 100.0;
         percentsACGTJ[i] = Math.floor(currPercentage*10) / 10.0;
      }   

      // replace these printlns with writing to the output file via the Scanner obj for output file
      System.out.println(nStr);
      System.out.println(Arrays.toString(ACGTJ));
      System.out.println(Arrays.toString(percentsACGTJ));

      // get this test into the isProtein() function, since there is a mass-based requirement to protein or not
      if ((percentsACGTJ[1] + percentsACGTJ[2]) < 30.0)
         return false;      
      else
         return true;
   }
   
   public static void breakIntoCodons(String nStr) {
      
      // delete junk proteins
      nStr = nStr.replace("-","");
      System.out.print("[ ");
      for (int i=0; i<nStr.length()/3; i++) {
         for (int j=0; j<3; j++) {
            //print next char and advance
            System.out.print(nStr.charAt(i*3+j));
         }
         System.out.print(", ");
      }
      System.out.println("]");
   }
   
   public static boolean isProtein(String nStr, boolean rightMass) {
      // delete junk proteins
      nStr = nStr.replace("-","");

      // all the constraints
      if (!rightMass)
         return false;
      if (!nStr.startsWith("ATG"))
         return false;
      if (!(nStr.endsWith("TAA") || nStr.endsWith("TAG") || nStr.endsWith("TGA")))
         return false;
      if (nStr.length() < 15)
         return false;
      else 
         return true;
   }   
}
