import java.util.Scanner;

public class InvertABinaryTree {
	
	public static Node root;
	
	public static Node insert(Node root,int val){
		
		if(root == null){
			Node newNode = new Node(val);
			return newNode;
		}
		
		int currVal = root.getValue();
		
		if(val>currVal){
			Node right = insert(root.getRight(), val);
			root.setRight(right);
		}
		if(val<currVal){
			Node left = insert(root.getLeft(), val);
			root.setLeft(left);
		}
		
		return root;
		
	}

	public static Node invertTree(Node root){
		
		if(root == null){
			return null;
		}
		
		Node left = root.getLeft();
		Node right = root.getRight();
		
		root.setLeft(invertTree(right));
		root.setRight(invertTree(left));
		
		return root;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner in = new Scanner(System.in);
		/*8
		4 2 7 1 3 6 8*/
		int size = in.nextInt();
		
		for(int i =0;i<size;i++){
			root = insert(root, in.nextInt());
		}
		
		invertTree(root);
		
		System.out.println("Tree inverted");
		
	}

}
