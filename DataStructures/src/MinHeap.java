import java.util.Scanner;

public class MinHeap {
	
	private static Object[] array;
	private static int lastIndex;
	
	static class Object{
		int val;
		
		public Object(int val){
			this.val = val;
		}
	}
	
	public MinHeap(int n){
		
		array = new Object[n+1];
		lastIndex = 0;
	}
	
	/*
	public static int getLastIndex(){
		for(int i=array.length-1;i>0;i--){
			if(array[i]!=null){
				return i;
			}
		}
		return -1;
		
	}*/
	
	public static void siftUp(){
		
		int k = lastIndex;
		
		
		
		while(k>1){
			
			int p = k/2;
			Object parent = array[p];
			Object current = array[k];
			
			if(current.val<parent.val){
				array[p] = current;
				array[k] = parent;
				k = p;
			}else {
				break;
			}
			
			
		}
	}
	
	public static void delete(int val){
		
		//if there is just one object
		if(lastIndex == 1 && array[1].val == val){
			array[1] = null;
			lastIndex--;
		}
		
		else{
			
			int indexToDelete = recurDelete(val, lastIndex, 1);
			array[indexToDelete] = array[lastIndex];
			array[lastIndex] = null;
			lastIndex--;
			siftDown();
			
			/*int index = 0;
			for(int i=1;i<=lastIndex;i++){
				if(array[i].val == val){
					index = i;
				}
			}
			
			
			array[index] = array[lastIndex];
			array[lastIndex] = null;
			
			lastIndex--;
			siftDown();*/
		}
		
		
	}
	
	public static int recurDelete(int val,int last,int pos){
		
		if(last<pos){
			return -1;
		}
		
		if(array[pos].val == val){
			return pos;
		}
		
		int left = recurDelete(val, last, pos*2);
		if(left>-1){
			return left;
		}
		
		return recurDelete(val, last, pos*2+1);
		
		
	}
	
	public static int delete(){
		
		
		
		Object b = array[1];
		
		Object last = array[lastIndex];
		
		array[1] = last;
		
		array[lastIndex] = null;
		lastIndex--;
		siftDown();
		
		return b.val;
	}
	
	public static void siftDown(){
		
		int k = 1;
		int l = 2*k;
		
		while(l<=lastIndex){
			int min = 2*k;
			int r = 2*k+1;
			
			if(r<=lastIndex){
				//right < left
				if(array[r].val<array[l].val){
					min++; //change min to right node
				}
			}
			
			if(array[min].val<array[k].val){
				Object t = array[k];
				array[k] = array[min];
				array[min] = t;
				k = min;
				l = 2*k;
			}else {
				break;
			}
			
		}
		
		
	}
	
	
	public static void insert(int val){
		
		
		for(int i =1;i<array.length;i++){
			if(array[i]==null){
				array[i] = new Object(val);
				lastIndex++;
				break;
			}
		}
	
		siftUp();
	}
	
	public static void print(){
		
		Object b = array[1];
		System.out.println(b.val);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int n = in.nextInt();
		MinHeap heap = new MinHeap(size);
	
		for(int i =0;i<n;i++){
			 
			insert(in.nextInt());
			
		}
		
		//insert
		insert(6);
		
		
		
		//delete particular value
		delete(5);
		
		
		
		//delete
		int minVal = delete();
		
		
	}

}
