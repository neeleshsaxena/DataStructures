
public class Factorial {

	public static int factorial(int n){
		
		//recursive
	/*	if(n<=1){
			return 1;
		}
		else
		return	n * factorial(n-1);*/
		
		//iterative
		int fact =1;
		for(int i=n;i>=1;i--){
			fact *= i;
		}
		return fact;
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int fact = factorial(7);
		System.out.println(fact);
		int a = 7/2;
		System.out.println(a);
		
	}

}
