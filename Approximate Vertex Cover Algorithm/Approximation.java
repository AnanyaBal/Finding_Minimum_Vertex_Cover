// Java Program to print Vertex Cover of a given undirected graph 
import java.io.*; 
import java.util.*; 
import java.util.LinkedList; 
  
// This class represents an undirected graph using adjacency list 
class Approximation 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    Approximation(int v) 
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
		ArrayList<Integer> vertexCover = new ArrayList<>();
		boolean added = true;
		while(added == true){
			for(int u=0;u<V;u++){
				if(adj[u].size()>0){
					Integer vertex = u;
					Integer adjVertex = adj[u].get(0);
					vertexCover.add(vertex);
					vertexCover.add(adjVertex);
					for(int i=0;i<adj[vertex].size();i++){
						int nextVertex = adj[vertex].get(i);
						adj[nextVertex].remove(vertex);
					}
					adj[vertex].clear();
					for(int i=0;i<adj[adjVertex].size();i++){
						int nextVertex = adj[adjVertex].get(i);
						adj[nextVertex].remove(adjVertex);
					}
					adj[adjVertex].clear();
					break;
				}
				else if(u == (V-1)){
					added = false;
				}
			}
		}
		System.out.println(vertexCover);
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        // Create a graph given in the above diagram 
        System.out.println("/tMenu: ");
        System.out  .println("1. Graph 1(7 vertices)");
        System.out.println("2. Graph 2(7 vertices)");
        System.out.println("3. Graph 3(9 vertices)");
        System.out.println("4. Graph 4(17 vertices)");
        System.out.println("5. Graph 5(25 vertices)");
		System.out.println("6. Graph 6(25 vertices)");
        System.out.println("Enter your Choice: ");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
		long start=System.nanoTime();
        switch(n)
        {
        case 1: { 
            Approximation g=new Approximation(7);  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(3, 4); 
        g.addEdge(4, 5); 
        g.addEdge(5, 6);
        g.printVertexCover();
        break;}
        
        
        case 2: {
            Approximation g=new Approximation(7);
            g.addEdge(0,5);
        g.addEdge(2,5);
        g.addEdge(3,5);
        g.addEdge(4,5);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        g.addEdge(1,6);
        g.printVertexCover();
        break;
    }
        
        case 3: {
            Approximation g=new Approximation(9);
            g.addEdge(0,1);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(5,6);
        g.addEdge(4,7);
        g.addEdge(7,8);
        g.printVertexCover();
        break;
    }
        
        case 4: 
        {
            Approximation g=new Approximation(17);
            g.addEdge(0,1);
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
        g.addEdge(8,16);
        g.printVertexCover();
        break;}
        
        case 5:
        {
            Approximation g=new Approximation(25);
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
        break;}
		
		case 6:
        {
            Approximation g=new Approximation(25);
		g.addEdge(0,6);
		g.addEdge(1,7);
		g.addEdge(2,8);
		g.addEdge(3,9);
		g.addEdge(4,10);
		g.addEdge(5,11);
		g.addEdge(6,7);
		g.addEdge(7,8);
		g.addEdge(8,9);
		g.addEdge(9,10);
		g.addEdge(10,11);
		g.addEdge(11,6);
		g.addEdge(6,13);
		g.addEdge(7,14);
		g.addEdge(8,15);
		g.addEdge(9,16);
		g.addEdge(10,17);
		g.addEdge(11,12);
		g.addEdge(13,19);
		g.addEdge(14,20);
		g.addEdge(15,21);
		g.addEdge(16,22);
		g.addEdge(17,23);
		g.addEdge(12,18);
		g.addEdge(19,20);
		g.addEdge(20,21);
		g.addEdge(21,22);
		g.addEdge(22,23);
		g.addEdge(23,18);
		g.addEdge(18,19);
		g.addEdge(18,24);
		g.addEdge(19,24);
		g.addEdge(20,24);
		g.addEdge(21,24);
		g.addEdge(22,24);
		g.addEdge(23,24);
        g.printVertexCover();
        break;}
        
        default : {System.out.println("Enter a valid choice." );
        }
    }
        long end=System.nanoTime();
        long timeElapsed= end - start;
        System.out.println("Execution time in milliseconds: "+timeElapsed);
        Runtime runtime=Runtime.getRuntime();
        runtime.gc();
        double memory = runtime.totalMemory()-runtime.freeMemory();
        System.out.println("Used memory in megabytes: "+ (memory/1000000)); 
    } 
} 
