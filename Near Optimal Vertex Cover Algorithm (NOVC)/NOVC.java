// Java Program to print Vertex Cover of a given undirected graph 
import java.io.*; 
import java.util.*; 
import java.util.LinkedList;
  
// This class represents an undirected graph using adjacency list 
class NOVC 
{ 
    private int V;   // No. of vertices 
  
    // Array  of lists for Adjacency List Representation 
    private LinkedList<Integer> adj[]; 
  
    // Constructor 
    NOVC(int v) 
    { 
        V = v; 
        adj = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList<>(); 
    } 
  
    //Function to add an edge into the graph 
    void addEdge(int v, int w) 
    { 
        adj[v].add(w);  // Add w to v's list. 
        adj[w].add(v);  //Graph is undirected 
    }
	
	int degree(int v)
	{
		return adj[v].size();
	}
	
	int sum_of_adj(int v)
	{
		int sum=0;
		int degree = adj[v].size();
		for(int i=0;i<degree;i++)
			{
				sum += degree(adj[v].get(i));
			}
		return sum;
	}
    // The function to print vertex cover 
    void printVertexCover() 
    {
		LinkedList<Integer> vertexCover = new LinkedList<>();
		while(true){
		LinkedList<Integer> min_degree_vertices = new LinkedList<>();
		int min_degree = 10000;
		for(int i=0;i<V;i++){
			int degree = degree(i);
			if(degree == 0)
				continue;
			else if(degree<min_degree){
				min_degree = degree;
				min_degree_vertices.clear();
				min_degree_vertices.add(i);
			}
			else if(degree == min_degree){
				min_degree_vertices.add(i);
			}
		}
		if(min_degree_vertices.size() == 0){
			break;
		}
		if(min_degree_vertices.size() == 1){
			Integer add_vertex = adj[min_degree_vertices.get(0)].get(0);
			for(int a=0;a<adj[add_vertex].size();a++){
					int vertex_adj = adj[add_vertex].get(a);
					adj[vertex_adj].remove(add_vertex);
				}
				adj[add_vertex].clear();
			vertexCover.add(add_vertex);
		}
		else{
			LinkedList<Integer> max_adj_sum_vertices = new LinkedList<>();
			int min_degree_Vertex;
			int max = 0;
			for(int i=0;i<min_degree_vertices.size();i++){
				int adj_sum = sum_of_adj(min_degree_vertices.get(i));
				if(adj_sum > max){
					max = adj_sum;
					max_adj_sum_vertices.clear();
					max_adj_sum_vertices.add(min_degree_vertices.get(i));
				}
				else if(adj_sum == max){
					max_adj_sum_vertices.add(min_degree_vertices.get(i));
				}
			}
			if(max_adj_sum_vertices.size() == 1){
				min_degree_Vertex = max_adj_sum_vertices.get(0);
			}
			else {
				min_degree_Vertex = max_adj_sum_vertices.get(0);
			}
			for(int i=0;i<adj[min_degree_Vertex].size();i++){
				Integer vertex_To_Be_Added = adj[min_degree_Vertex].get(i);
				for(int a=0;a<adj[vertex_To_Be_Added].size();a++){
					int vertex_adj = adj[vertex_To_Be_Added].get(a);
					adj[vertex_adj].remove(vertex_To_Be_Added);
				}
				adj[vertex_To_Be_Added].clear();
				vertexCover.add(vertex_To_Be_Added);
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
            NOVC g = new NOVC(7);  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(3, 4); 
        g.addEdge(4, 5); 
        g.addEdge(5, 6);
        g.printVertexCover();
        break;}
        
        
        case 2: {
            NOVC g = new NOVC(7);
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
            NOVC g = new NOVC(9);
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
            NOVC g = new NOVC(17);
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
            NOVC g = new NOVC(25);
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
            NOVC g=new NOVC(25);
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
        System.out.println("Execution time in Nano-Seconds: "+timeElapsed);
        Runtime runtime=Runtime.getRuntime();
        runtime.gc();
        double memory = runtime.totalMemory()-runtime.freeMemory();
        System.out.println("Used memory in megabytes: "+ (memory/1000000)); 
    } 
    } 
