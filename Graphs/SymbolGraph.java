package program7;

/*
 * Name:			Danielle Coulter
 * Class:       AD 325 WI 18
 * Assignment:  8
 * Title:       SymbolGraph.java 
 * Due Date:    March 10, 2018
 * Material:		Graphs: 4.1 Undirected & 4.2 Directed 
 * Reference:	https://algs4.cs.princeton.edu/41graph/SymbolGraph.java.html
 */
import java.util.*;
import java.io.*;

public class SymbolGraph { 
    
	public static void main(String[] args) throws FileNotFoundException {

		String choice = "y";
		SymbolGraph G = new SymbolGraph(new File("Routes.csv"));

		Scanner in = new Scanner(System.in);
		while(choice.equalsIgnoreCase("y")){
			System.out.println("Hi, my name is Danielle Coulter and I can help.");
			System.out.println("So you're planning a trip? Let's see your options!");
			System.out.print("\nI'm flying FROM: ");
			String start = in.next().toUpperCase();
			//Scanner input = new Scanner(in);
			System.out.print("I'm flying TO: ");
			String end = in.next().toUpperCase();
			
			int airport1 = G.indexOf(start);
			int airport2 = G.indexOf(end);
			BreadthFirstPaths dfs = new BreadthFirstPaths(G, airport1);
	
			System.out.println();
	
	        if(dfs.hasPathTo(airport2)) {
	        	System.out.println("Yay, that route IS possible! Call us now to reserve.");
	        }
	        else {
	        	System.out.println("We're sorry, this route is NOT possible.");
	        }
	        
	        System.out.println("\nPlanning another trip? (y/n): ");
	        choice = in.next();
		}//end while 
		        
        System.out.println("\tThanks for choosing us. Safe travels!");	
		System.exit(0);	
		in.close();
		 
	}//end main
	
	private HashMap<String, Integer> graphMap;  
    private String[] keys;           
    private Digraph G; 
 
    
    public SymbolGraph(File filename) throws FileNotFoundException { 
        
    	graphMap = new HashMap<String, Integer>(); 
 
        Scanner in1 = new Scanner(filename);
        
        // Build index
        while(in1.hasNextLine()) {
			String s = in1.nextLine();
			Scanner input = new Scanner(s).useDelimiter(",");
			String skip = input.next();
			while(input.hasNext()) {
				String key = input.next();
				if(!graphMap.containsKey(key)) {
					graphMap.put(key, graphMap.size());
				}
			}
		}
        
        System.out.println("Done reading " + filename); 
 
        // now index to string keys in [] 
        keys = new String[graphMap.size()]; 
        for (String name : graphMap.keySet()) { 
            keys[graphMap.get(name)] = name; 
        } 
 
        // Build graph        
        G = new Digraph(graphMap.size()); 
        
        Scanner in2 = new Scanner(filename); 
        
        while (in2.hasNextLine()) { 
        	String s2 = in2.nextLine();
			Scanner input2 = new Scanner(s2).useDelimiter(",");
			String skip2 = input2.next();
			if(input2.hasNext()) {
				int v = graphMap.get(input2.next());

				while(input2.hasNext()) {
					G.addEdge(v, graphMap.get(input2.next()));
				}//end inner while
			}//end if
		}//end outer while
    }//end constructor 
 
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

}//end class