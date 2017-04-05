import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


//directed graph
public class GraphBFS {
	
	LinkedList<Integer>[] arr;
	int V;
	
	
	public GraphBFS(int v){
		V= v;
		arr = new LinkedList[V];
		for(int i=0;i<V;i++){
			arr[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v,int i){
		
		arr[v].add(i);
		
	}
	
	public  void BFS(int start){
		
		boolean[] visited = new boolean[V];
		
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		
		while(!q.isEmpty()){
			
			int node = q.poll();
			System.out.println(node);
			visited[node] = true;
			
			Iterator it = arr[node].listIterator();
			while(it.hasNext()){
				int adjNode = (int)it.next();
				
				if(!visited[adjNode]){
					q.add(adjNode);
				}
			}
			
			
		}
		
		
		
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr1 = new int[5];
		GraphBFS graph = new GraphBFS(10);
		
		
		graph.addEdge(1,6);
		graph.addEdge(2,7);
        graph.addEdge(3,8);
        graph.addEdge(4,9);
        graph.addEdge(2,6);
        graph.addEdge(3, 3);
        
        graph.BFS(1);
        
	}

}
