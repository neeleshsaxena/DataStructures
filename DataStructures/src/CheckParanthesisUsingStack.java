import java.util.Scanner;
import java.util.Stack;

public class CheckParanthesisUsingStack {

	public static boolean check(String value){
		Stack st = new Stack();
		int lenght = value.length();
		for(int i=0;i<lenght;i++){
			
			if(value.charAt(i)=='(' || value.charAt(i)=='{' || value.charAt(i)=='['){
				st.push(value.charAt(i));
			}
			else if(value.charAt(i)==')' && !st.isEmpty() && st.peek().equals('(') ){
				st.pop();
			}
			else if(value.charAt(i)=='}' && !st.isEmpty() && st.peek().equals('{') ){
				st.pop();
			}
			else if(value.charAt(i)==']' && !st.isEmpty() && st.peek().equals('[') ){
				st.pop();
			}
			
			else return false;
			
		}
		return st.empty();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            String s = in.next();
	            
	            if(check(s)){
	            	System.out.println("YES");
	            }else System.out.println("NO");
	        }
	        
	        
	        
		
	}

}
