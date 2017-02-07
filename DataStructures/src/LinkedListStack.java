import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LinkedListStack {
	
	ListElement headNode;
	
	public LinkedListStack(){
		this.headNode = new ListElement(null);
	}
	
	public boolean isEmpty(){
		return(headNode.data==null);
	}
	
	public int top(){
	
		int a = (int)headNode.data;
		return a;
	}
	
	public void push(int value){
		if(headNode == null) {
			headNode = new ListElement(value);
		}
		if(isEmpty()){
			headNode.data = value;
		}else {
		ListElement b = new ListElement(value);
		b.next = headNode;
		headNode = b;
		}
	}
	
	public int pop(){
		int c = (int)headNode.data;
		headNode = headNode.next;
		return c;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		

		LinkedListStack a = new LinkedListStack();
		a.push(2);
		a.push(4);
		a.push(7);
		
		
		
		int b = a.pop();
		System.out.println("Popped Element " + b);
		
		while(a.headNode!=null && a.headNode.data!=null){
			System.out.print( " "+  a.headNode.data);
			a.headNode = a.headNode.next;
		}
	
	}
	

}
