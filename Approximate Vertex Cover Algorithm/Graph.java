// Java Program to print Vertex Cover of a given undirected graph 
import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 
  
// This class represents an undirected graph using adjacency list 
class Graph 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    Graph(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
        adj[w].add(v);  //Graph is undirected 
    } 
  
    // The function to print vertex cover 
    void printVertexCover() 
    { 
        // Initialize all vertices as not visited. 
        boolean visited[] = new boolean[V]; 
        for (int i=0; i<V; i++) 
            visited[i] = false; 
  
        Iterator<Integer> i; 
  
        // Consider all edges one by one 
        for (int u=0; u<V; u++) 
        { 
            // An edge is only picked when both visited[u] 
            // and visited[v] are false 
            if (visited[u] == false) 
            { 
                // Go through all adjacents of u and pick the 
                // first not yet visited vertex (We are basically 
                //  picking an edge (u, v) from remaining edges. 
                i = adj[u].iterator(); 
                while (i.hasNext()) 
                { 
                    int v = i.next(); 
                    if (visited[v] == false) 
                    { 
                         // Add the vertices (u, v) to the result 
                         // set. We make the vertex u and v visited 
                         // so that all edges from/to them would 
                         // be ignored 
                         visited[v] = true; 
                         visited[u]  = true; 
                         break; 
                    } 
                } 
            } 
        } 
  
        // Print the vertex cover 
        for (int j=0; j<V; j++) 
            if (visited[j]) 
              System.out.print(j+" "); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        Graph g = new Graph(25); 
        /*g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(3, 4); 
        g.addEdge(4, 5); 
        g.addEdge(5, 6);*/
		
		
		/*g.addEdge(0,5);
		g.addEdge(2,5);
		g.addEdge(3,5);
		g.addEdge(4,5);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(1,4);
		g.addEdge(1,6);*/
		
		/*g.addEdge(0,1);
		g.addEdge(1,4);
		g.addEdge(2,3);
		g.addEdge(3,4);
		g.addEdge(4,5);
		g.addEdge(5,6);
		g.addEdge(4,7);
		g.addEdge(7,8);*/
		
		/*g.addEdge(0,1);
		g.addEdge(0,2);
		g.addEdge(1,3);
		g.addEdge(1,4);
		g.addEdge(1,5);
		g.addEdge(1,6);
		g.addEdge(2,7);
		g.addEdge(2,8);
		g.addEdge(3,9);
		g.addEdge(4,10);
		g.addEdge(5,11);
		g.addEdge(5,12);
		g.addEdge(5,13);
		g.addEdge(6,14);
		g.addEdge(7,15);
		g.addEdge(8,16);*/
		
		g.addEdge(0,1);
		g.addEdge(0,4);
		g.addEdge(0,5);
		g.addEdge(1,2);
		g.addEdge(1,5);
		g.addEdge(1,6);
		g.addEdge(2,3);
		g.addEdge(2,6);
		g.addEdge(3,7);
		g.addEdge(4,5);
		g.addEdge(4,8);
		g.addEdge(5,6);
		g.addEdge(5,8);
		g.addEdge(5,9);
		g.addEdge(6,7);
		g.addEdge(6,10);
		g.addEdge(6,11);
		g.addEdge(8,9);
		g.addEdge(8,12);
		g.addEdge(9,10);
		g.addEdge(9,12);
		g.addEdge(9,13);
		g.addEdge(10,11);
		g.addEdge(10,13);
		g.addEdge(10,14);
		g.addEdge(11,15);
		g.addEdge(12,13);
		g.addEdge(12,16);
		g.addEdge(13,14);
		g.addEdge(13,17);
		g.addEdge(13,18);
		g.addEdge(14,15);
		g.addEdge(14,18);
		g.addEdge(15,19);
		g.addEdge(16,17);
		g.addEdge(16,20);
		g.addEdge(16,21);
		g.addEdge(17,18);
		g.addEdge(18,19);
		g.addEdge(18,22);
		g.addEdge(18,23);
		g.addEdge(18,24);
		g.addEdge(19,24);
  
        g.printVertexCover(); 
    } 
} 
// This code is contributed by Aakash Hasija 