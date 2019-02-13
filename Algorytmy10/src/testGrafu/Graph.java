package testGrafu;
import java.util.*;
import java.lang.*;
import java.io.*;
public class Graph {
	// A class to represent a graph edge
    class Edge implements Comparable<Edge>
    {
    	
        int src, dest, weight;
 
        // Comparator function used for sorting edges 
        // based on their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight-compareEdge.weight;
        }
    };
 
    // A class to represent a subset for union-find
    class subset
    {
        int parent, rank;
    };
 
    int V, E;    // V-> no. of vertices/wierzcho³kow & E->no.of edges/krawedzi
    Edge edge[]; // collection of all edges
 
    // Creates a graph with V vertices and E edges
    Graph(int v, int e)
    {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i=0; i<e; ++i)
            edge[i] = new Edge();
    }
 
    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as root and increment
        // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    void KruskalMST()
    {
        Edge result[] = new Edge[V];  // Tnis will store the resultant MST
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // An index variable, used for sorted edges
        for (i=0; i<V; ++i)
            result[i] = new Edge();
 
        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Arrays.sort(edge);
 
        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[V];
        for(i=0; i<V; ++i)
            subsets[i]=new subset();
 
        // Create V subsets with single elements
        for (int v = 0; v < V; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
 
        i = 0;  // Index used to pick next edge
 
        // Number of edges to be taken is equal to V-1
        while (e < V - 1)
        {
            // Step 2: Pick the smallest edge. And increment 
            // the index for next iteration
            Edge next_edge = new Edge();
            next_edge = edge[i++];
 
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
 
            // If including this edge does't cause cycle,
            // include it in result and increment the index 
            // of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge
        }
 
        // print the contents of result[] to display
        // the built MST
        System.out.println("Po³¹czenia w grafie ");
        int droga=0;
        for (i = 0; i < e; ++i)
        	
            System.out.println(result[i].src+"->" + 
                   result[i].dest+" = " + result[i].weight);
        for (i = 0; i < e; ++i)
            droga=droga+result[i].weight;
           			
        System.out.println("Ca³kowity koszt po³¹czenia to :"+droga);				
    }
    public void createGraph() {
    	Scanner sc=new Scanner(System.in);
    	String pom=sc.nextLine();
    	String []tab=pom.split(" ");
    	Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
    	int counter=0;
    	while(counter<Integer.parseInt(tab[1])) {
    		String pom2=sc.nextLine();
    		String tab2[]=pom2.split(" ");
    		graph.edge[counter].src =Integer.parseInt(tab[0]);
            graph.edge[counter].dest = Integer.parseInt(tab[1]);
            graph.edge[counter].weight = Integer.parseInt(tab[2]);
    	}
    	
    }
    
    
	public static void main(String[] args) {
		/*Graph graph = new Graph(5,8);
		
		graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 30;
        graph.edge[3].src = 0;
        graph.edge[3].dest = 4;
        graph.edge[3].weight = 100;
        graph.edge[4].src = 1;
        graph.edge[4].dest = 2;
        graph.edge[4].weight = 50;
        graph.edge[5].src = 2;
        graph.edge[5].dest = 4;
        graph.edge[5].weight = 10;
        graph.edge[6].src = 3;
        graph.edge[6].dest = 2;
        graph.edge[6].weight = 20;
        graph.edge[7].src = 3;
        graph.edge[7].dest = 4;
        graph.edge[7].weight = 60;
        
        graph.KruskalMST();*/
	/*	Scanner sc=new Scanner(System.in);
    	String pom=sc.nextLine();
    	String []tab=pom.split(" ");
    	
    	Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
    	int counter=0;
    	while(counter<Integer.parseInt(tab[1])) {
    		String pom2=sc.nextLine();
    		String tab2[]=pom2.split(" ");
    		//System.out.println(tab2[0]+" "+tab2[1]+ " "+tab2[2]);
    		graph.edge[counter].src =Integer.parseInt(tab2[0]);
            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
            
            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
            counter++;
    	}
    	graph.KruskalMST();   */
		
		try(BufferedReader reader=new BufferedReader(new FileReader("da1.txt"))){
			String pom=reader.readLine();
			String []tab=pom.split(" ");
			
			Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
			int counter=0;
			while(counter<Integer.parseInt(tab[1])) {
				String pom2=reader.readLine();
				String tab2[]=pom2.split(" ");
				
				graph.edge[counter].src =Integer.parseInt(tab2[0]);
	            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
	            
	            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
	            counter++;
			}
			graph.KruskalMST();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(BufferedReader reader1=new BufferedReader(new FileReader("da2.txt"))){
			String pom=reader1.readLine();
			String []tab=pom.split(" ");
			
			Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
			int counter=0;
			while(counter<Integer.parseInt(tab[1])) {
				String pom2=reader1.readLine();
				String tab2[]=pom2.split(" ");
				
				graph.edge[counter].src =Integer.parseInt(tab2[0]);
	            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
	            
	            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
	            counter++;
			}
			graph.KruskalMST();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(BufferedReader reader2=new BufferedReader(new FileReader("da3.txt"))){
			String pom=reader2.readLine();
			String []tab=pom.split(" ");
			
			Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
			int counter=0;
			while(counter<Integer.parseInt(tab[1])) {
				String pom2=reader2.readLine();
				String tab2[]=pom2.split(" ");
				
				graph.edge[counter].src =Integer.parseInt(tab2[0]);
	            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
	            
	            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
	            counter++;
			}
			graph.KruskalMST();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(BufferedReader reader4=new BufferedReader(new FileReader("da4.txt"))){
			String pom=reader4.readLine();
			String []tab=pom.split(" ");
			
			Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
			int counter=0;
			while(counter<Integer.parseInt(tab[1])) {
				String pom2=reader4.readLine();
				String tab2[]=pom2.split(" ");
				
				graph.edge[counter].src =Integer.parseInt(tab2[0]);
	            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
	            
	            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
	            counter++;
			}
			graph.KruskalMST();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(BufferedReader reader5=new BufferedReader(new FileReader("da5.txt"))){
			String pom=reader5.readLine();
			String []tab=pom.split(" ");
			
			Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
			int counter=0;
			while(counter<Integer.parseInt(tab[1])) {
				String pom2=reader5.readLine();
				String tab2[]=pom2.split(" ");
				
				graph.edge[counter].src =Integer.parseInt(tab2[0]);
	            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
	            
	            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
	            counter++;
			}
			graph.KruskalMST();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(BufferedReader reader6=new BufferedReader(new FileReader("da6.txt"))){
			String pom=reader6.readLine();
			String []tab=pom.split(" ");
			
			Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
			int counter=0;
			while(counter<Integer.parseInt(tab[1])) {
				String pom2=reader6.readLine();
				String tab2[]=pom2.split(" ");
				
				graph.edge[counter].src =Integer.parseInt(tab2[0]);
	            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
	            
	            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
	            counter++;
			}
			graph.KruskalMST();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(BufferedReader reader7=new BufferedReader(new FileReader("da7.txt"))){
			String pom=reader7.readLine();
			String []tab=pom.split(" ");
			
			Graph graph=new Graph(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
			int counter=0;
			while(counter<Integer.parseInt(tab[1])) {
				String pom2=reader7.readLine();
				String tab2[]=pom2.split(" ");
				
				graph.edge[counter].src =Integer.parseInt(tab2[0]);
	            graph.edge[counter].dest = Integer.parseInt(tab2[1]);
	            
	            graph.edge[counter].weight = Integer.parseInt(tab2[2]);
	            counter++;
			}
			graph.KruskalMST();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
