import java.util.Scanner;

public class ReverseArray {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
	     int size = in.nextInt();
	     int[] values = new int[size];
	     
	     for(int i =0;i<size;i++){
	         values[i] = in.nextInt();
	         
	     }
	     
	     for(int j=size-1;j>=0;j--){
	         System.out.print(values[j] + " ");
	     }

	}

}
