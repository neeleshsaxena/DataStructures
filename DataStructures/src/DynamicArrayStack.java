
public class DynamicArrayStack {
	
	private int top;
	private int capacity;
	private int[] array;
	
	
	public DynamicArrayStack(){
		capacity = 1;
		top = -1;
		array = new int[capacity];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	public int top(){
		int topElement = array[top];
		return topElement;
	}
	
	public boolean isStackFull(){
		 return (top == array.length -1);
		
	}
	
	public void doubleStack(){
		int[] newArr = new int[capacity*2];
		System.arraycopy(array, 0, newArr, 0, capacity);
		capacity = capacity*2;
		array = newArr;
		
	}
	
	public void push(int data){
		if(isStackFull()){
			doubleStack();
		}
		
		top = top +1;
		array[top] = data;
	}
	
	public int pop(){
		if(isEmpty()){System.out.println("Stack already empty");}
		int data = top();
		top = top -1;
		return data;
		
	}

	public void deleteStack(){
		top = -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DynamicArrayStack stack = new DynamicArrayStack();
		stack.push(2);
		stack.push(4);
		stack.push(6);
		stack.push(7);
		
		for(int arr:stack.array){
			System.out.print(arr + " ");
		}
	int a = stack.pop();
	
	System.out.println(a);
	
	stack.push(8);
	
	for(int arr:stack.array){
		System.out.println(arr + " ");
	}
	
	}

}
