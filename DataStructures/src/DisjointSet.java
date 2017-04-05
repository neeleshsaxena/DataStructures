import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DisjointSet {

	private int rank[];
	private int parent[];
	private int n;
	private Map<Integer,Integer> map;
	private static int count;
	
	public DisjointSet(int n){
		parent = new int[n+1];
		rank = new int[n+1];
		map = new HashMap<>();
		this.n = n;
		//makeSet();
		
	}
	
	private void makeSet(){
		for(int i=0;i<=n;i++){
			parent[i] = i;
		
		}
	}
	
	
	//will always return the parent of the node
	private int find(int i){
		
		if(parent[i]!=i){
			
			parent[i] = find(parent[i]);
		}
		
		return parent[i];
		
	}
	
	/*private int count(int i){
		if(parent[i]!=i){
			count++;
			parent[i] = find(parent[i]);
		}
		
		return parent[i];
		
	}*/
	
	private void union(int i,int v){
		
		if(parent[i] == 0){
			parent[i] = i;
		}
		if(parent[v]== 0){
			parent[v] = v;
		}
		
		int xRoot = find(i);
		int yRoot = find(v);
		
		if(rank[xRoot]<rank[yRoot]){
			parent[xRoot] = yRoot;
			
		}
		else if(rank[xRoot]>rank[yRoot]){
			parent[yRoot] = xRoot;
			
			
		}
		else{//if ranks are same
			
			//assign any to any
			parent[yRoot] = xRoot;
			
			
			rank[xRoot] = rank[xRoot] + 1;
		}
		
		
	}
	
	private int[] findMax(){
		
		int[] arr = new int[2];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()){
			int node = (int)it.next();
			int val = map.get(node);
			
			if(val>max){
				max = val;
			}
			
			if(val<min){
				min = val;
			}
			
		}
		
		arr[0] = min;
		arr[1] = max;
		
		return arr;
		
	}
	
	private void updateMap(){
		 for(int i=1;i<=n;i++){
	        	
	        	int par = find(parent[i]);
	        	
	        	if(map.containsKey(par)){
	        		map.replace(par, map.get(par) + 1);
	        	}
	        	else{
	        		map.put(par, 1);
	        	}
	        	
	        }
	        
	}
	
	private int[] minMax(){
		
		int[] result = new int[2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Iterator<Integer> it = map.keySet().iterator();
		
		while(it.hasNext()){
			int key = it.next();
			
			if(key!=0){
				int val = map.get(key);
				
				if(val>max){
					max = val;
				}
				if(val<min){
					min = val;
				}
			}
			
			
		}
		
		
		
		result[0] = min;
		result[1] = max;
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in = new Scanner(System.in);
        
        int n = 2*in.nextInt();
        
        DisjointSet sol = new DisjointSet(n);
        
        for(int i =0;i<n/2;i++){
            
            sol.union(in.nextInt(),in.nextInt());
        }
        
        sol.updateMap();
		int[] arr = sol.minMax();
		
		
		System.out.println("min " + arr[0]);
		System.out.println("max " + arr[1]);
		
	}

}
