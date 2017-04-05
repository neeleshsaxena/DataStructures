import java.util.Iterator;
import java.util.LinkedList;

public class GraphDFS {
	
	private int V;
	
	private LinkedList<Integer> arr[];    //another way of declaring an array of linkedLists
											// other one - LinkedList[] arr;| or - LinkedList<Integer>[] arr
	
	
	public GraphDFS(int v){
		V = v;
		
		arr = new LinkedList[v];      //array of linkedLists
		for(int i =0;i<v;i++){
			arr[i] = new LinkedList<>();    //initialize the array with linkedLists
		}
		
		
	}
	
	
	//adding an edge of the graph
	private void addEdge(int v, int i){
		arr[v].add(i);   //adding the adjacent nodes that can be traversed(have a direct path)
	}
	
	void UtilDFS(int v , boolean[] visited){
		
		visited[v] = true;
		System.out.print(v+ " ");
		
		
		Iterator<Integer> it = arr[v].listIterator();
		
		while(it.hasNext()){
			int node = it.next();
			
			if(!visited[node] ){
				UtilDFS(node, visited);
			}
			
			
		}
		
		
	}
	
	void DFS(){
		
		boolean[] visited = new boolean[V];    //hashing -- creating an array of bool to keep a check on already visited nodes
		
		
		for(int i=0;i<V;i++){       //because of the for loop, unvistied nodes or independent nodes will also be displayed | this loop 
									//makes sure to start from the next node once all adjacent nodes of this node are traversed
			if(!visited[i]){
				UtilDFS(i, visited);
			}
		}
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = new int[5];
		GraphDFS graph = new GraphDFS(10);
		
		
		graph.addEdge(1,6);
		graph.addEdge(2,7);
        graph.addEdge(3,8);
        graph.addEdge(4,9);
        graph.addEdge(2,6);
        graph.addEdge(3, 3);
        
        
        
        graph.DFS();
		
		
	}

}
