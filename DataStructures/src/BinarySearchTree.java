import java.util.Stack;

public class BinarySearchTree {

	//assuming this is a balanced tree
	public static Node findNode(Node root, int value){
		
		/*while(root!=null){
			
			int currVal = root.getValue();
			
			if(currVal == value){
				break;
			}
			
			if(currVal<value){
				root = root.getRight();
			}
			if(currVal>value){
				root = root.getLeft();
			}
			
		}
		return root;*/
		
		//recursion
		if(root == null){
			return null;
		}
		
		int currVal = root.getValue();
		
		if(currVal<value){
			root = findNode(root.getRight(), value);
		}
		if(currVal>value){
			root = findNode(root.getLeft(), value);
		}
		
		return root;
	}
	
	//insert data into a binary search tree
	public static Node insert(Node root, int val){
		
		
		if(root==null){
			Node newNode = new Node(val);
			return newNode;
		}
		
		int currVal = root.getValue();
		
		if(currVal<val){
			Node right = insert(root.getRight(), val);
			root.setRight(right);
		}
		
		if(currVal>val){
			Node left = insert(root.getLeft(), val);
			root.setLeft(left);
		}
		
		return root;
		
	}
	
	
	//traversals
	public static void preOrder(Node root){
		if(root ==null){
			return;
		}
		
		System.out.print(root.getValue() + " ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
		
		
		
	}
	
	public static void inOrder(Node root){
		if(root ==null){
			return;
		}
		
		inOrder(root.getLeft());
		System.out.print(root.getValue() + " ");
		inOrder(root.getRight());
	}
	
	public static void postOrder(Node root){
		if(root==null){
			return;
		}
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getValue() + " ");
		
	}
	
	//find min and max value
	public static Node findMin(Node root){
	/*	if(root==null){
		return null;
		}
		
		while(root.getLeft()!=null){
			root = root.getLeft();
		}
		
		return root;*/
		
		
		if(root==null || root.getLeft()==null){
			return root;
		}
		
		root = findMin(root.getLeft());
		
		return root;
		
		
	}
	public static Node findMax(Node root){
		
	/*	if(root ==null){
			return null;
		}
		while(root.getRight()!=null){
			root = root.getRight();
		}
		
		return root;*/
		
		if(root==null || root.getRight()==null){
			return root;
		}
		
	return 	root = findMax(root.getRight());
		
		
		
	}
	
	
	//find the height of a tree(any)
	public static int findHeight(Node root){
		if(root==null){
			return -1;
		}
		
		int height = 1 + Math.max(findHeight(root.getLeft()),findHeight(root.getRight()));
		
		return height;
	}
	
	
	public static boolean checkBST(Node root, int min, int max){
		

		if(root==null){
			return true;
		}
		
		if(root.getValue()<=min || root.getValue()>=max){
			return false;
		}
		
		if(!checkBST(root.getLeft(), min, root.getValue()) || !checkBST(root.getRight(), root.getValue(), max)){
			return false;
		}
		
		return true;
		
	}
	

	public static boolean isBinarySearchTree(Node root){
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		return checkBST(root, min, max);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n2 = new Node(2);
		Node n4 = new Node (4);
		Node n3 = new Node (n2,n4,3);
		Stack st = new Stack();
		
		
		Node n7 = new Node(7);
		Node n12 = new Node(12);
		Node n10 = new Node(n7,n12,10);
		
		Node root = new Node(n3,n10,5);
	
		//Node resultNode = findNode(root, 10);
		
		//System.out.println(resultNode.getValue());
		
		
		
		
		//insert a new node
		root = insert(root, 6);   //should be inserted on the left of 7, in preorder it should come after 7
		
		
		/*preOrder(root);
		System.out.println( " ");
		inOrder(root);
		System.out.println(" ");
		postOrder(root);*/
		
		/*findMin(root);
		findMax(root);*/
		Node min = findMin(root);
		Node max = findMax(root);
		System.out.println(min.getValue());
		System.out.println(max.getValue());
		
		boolean bst = isBinarySearchTree(root);
		System.out.println(bst);
	  /*int height = findHeight(root);
	  System.out.println(height);*/
		

		
		
	}

}
