package program8;

/*
 * Name:			Danielle Coulter
 * Class:       AD 325 WI 18
 * Assignment:  8 (enhanced from program 7)
 * Title:       SymbolGraph.java 
 * Due Date:    March 13, 2018
 * Material:		Graphs: 4.1 Undirected & 4.2 Directed 
 * Reference:	https://algs4.cs.princeton.edu/13stacks/Bag.java.html
 */

import java.util.*;
import java.io.*;

// "**" denotes altered portions from Program 7 for Program 8 
public class SymbolGraph { 
    
	public static void main(String[] args) throws FileNotFoundException {

		String choice = "y";
		SymbolGraph G = new SymbolGraph(new File("Routes.csv"));
		
		//**
		int s = 1; 
		
		//create scanner
		Scanner in = new Scanner(System.in);
		
		while(choice.equalsIgnoreCase("y")){
			
			//make it pretty
			System.out.println("Hi, my name is Danielle Coulter and I can help.");
			System.out.println("So you're planning a trip? Let's see your options!");
			
			//start index
			//test: LAX to LAZ for a pretty result
			System.out.print("\nI'm flying FROM: ");
			//make it smart
			String start = in.next().toUpperCase();
			
			//end index
			System.out.print("I'm flying TO: ");
			//make it smart
			String end = in.next().toUpperCase();
			
			int airport1 = G.indexOf(start);
			int airport2 = G.indexOf(end);
			BreadthFirstPaths dfs = new BreadthFirstPaths(G, airport2);//** airport 2 here
		
	        if(dfs.hasPathTo(airport1)) {//**airport 1 here
	        		System.out.println("Yay, that route IS possible!");
	        		System.out.println("\nWe'll get you there faster with fewest transfers through:");
	        		
	        		//** insert for loop to calculate shortest distance
	        		for(int x : dfs.pathTo(airport1)){
	        			
	        			if(x ==s) {System.out.print(G.nameOf(x));}
	        			else {System.out.print("\t" + G.nameOf(x) + ",");}
	        		}//end inner for
	        	//** end changes
	        }else{
	        	System.out.printf("We're sorry! %d to %d: is not possible.\n", start, end);
	        }//end if
	        
	        System.out.println("\n\nCall us now to reserve.");
	        System.out.println("\nPlanning another trip? (y/n): ");
	        choice = in.next();
		}//end while 
		        
        System.out.println("\tThanks for choosing us. Safe travels!");	
		System.exit(0);	
		in.close();
		
	}//end of main
	
	
	private HashMap<String, Integer> graphMap;  
    private String[] keys;           
    private Digraph G; 
 
    
    public SymbolGraph(File filename) throws FileNotFoundException { 
        
    	graphMap = new HashMap<String, Integer>(); 
 
        Scanner in1 = new Scanner(filename);
        
        //build index
        while(in1.hasNextLine()) {
			String s = in1.nextLine();
			Scanner input = new Scanner(s).useDelimiter(",");
			String skip = input.next();
			while(input.hasNext()) {
				String key = input.next();
				if(!graphMap.containsKey(key)) {
					graphMap.put(key, graphMap.size());
				}//end if
			}//end inner while
		}//end outer while
        
        System.out.println("Done reading " + filename); 
 
        // now index to string keys in [] 
        keys = new String[graphMap.size()]; 
        for (String name : graphMap.keySet()) { 
            keys[graphMap.get(name)] = name; 
        } 
 
        //build graph
        G = new Digraph(graphMap.size()); 
        
        Scanner sc2 = new Scanner(filename); 
        
        while (sc2.hasNextLine()) { 
        	String s2 = sc2.nextLine();
			Scanner input2 = new Scanner(s2).useDelimiter(",");
			String skip2 = input2.next();
			if(input2.hasNext()) {
				int v = graphMap.get(input2.next());

				while(input2.hasNext()) {
					G.addEdge(v, graphMap.get(input2.next()));
				}//end of while
			}//end of if
		}//end of while
    }//end of constructor 
 
    public int V() {
		return G.V();
	}

	public Iterable<Integer> adjacent(int v) {
		return G.adj(v);
	}

	public Digraph G() {
		return G;
	}

	public int E() {
		return G.E();
	}

	public int indexOf(String s) {
		return graphMap.get(s);
	}

	public String nameOf(int v) {
		return keys[v];
	}

}
