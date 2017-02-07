import java.util.Scanner;

public class LeftRotation {
	/* provide input as 3 1
						1 2 3*/ 
	
	
	//for right rotation - changePosition = size-number of rotations
	public static void main(String[] args) {  //value[(i+size - positionchange)%size)]
		// TODO Auto-generated method stub
	
		Scanner in = new Scanner(System.in);
	
		int size = in.nextInt();
		
		int changePostion = in.nextInt();
		
		int[] values = new int[size];
		
		for(int i =0;i<size;i++){
			values[(i+size-changePostion)%size] = in.nextInt();
		}
		

		for(int value:values){
			System.out.print(value + " ");
		}
		

		
		
	}

}
