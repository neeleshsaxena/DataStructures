import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MaxElementUsingStack {

	static class StackNode{
		int val;
		int max;
		
		public StackNode(int val,int max){
			this.val = val;
			this.max = max;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Scanner in = new Scanner(System.in);
		int max = Integer.MIN_VALUE;
		int sizeOfQueries = in.nextInt();
		Stack<StackNode> stack = new Stack<>();
	
		while(sizeOfQueries>0){
			int query = in.nextInt();
			
			//push
			if(query ==1){
				int val = in.nextInt();
				max = Math.max(max, val);
				stack.add(new StackNode(val,max));
			}
			else if(query ==2){
				if(!stack.isEmpty()){
					stack.pop();
					//reset the max
				if(stack.isEmpty()){
					max = Integer.MIN_VALUE;
				}else{
					max = stack.peek().max;
				}
			
				}
			}else if(query ==3){
				System.out.println(max);
			}
			
			
			sizeOfQueries--;
		}
		
	
		
		
	}

}
