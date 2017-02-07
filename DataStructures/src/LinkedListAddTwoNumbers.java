import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class LinkedListAddTwoNumbers {
	
	
	 public static ListNode insert(ListNode head, int data){
		 
		 ListNode l = new ListNode(data);
		 l.next = head;
		 
		 return l;
		 
	 }
	 
	 
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode c1 = l1;
	        ListNode c2 = l2;
	        ListNode sentinel = new ListNode(0);
	        ListNode d = sentinel;
	        int sum = 0;
	        while (c1 != null || c2 != null) {
	            sum /= 10;
	            if (c1 != null) {
	                sum += c1.val;
	                c1 = c1.next;
	            }
	            if (c2 != null) {
	                sum += c2.val;
	                c2 = c2.next;
	            }
	            d.next = new ListNode(sum % 10);
	            d = d.next;
	        }
	        if (sum / 10 == 1)
	            d.next = new ListNode(1);
	        return sentinel.next;
	    }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListAddTwoNumbers list = new LinkedListAddTwoNumbers();
		
		ListNode l = new ListNode(3);
		l = insert(l, 4);
		l = insert(l, 2);
		
		ListNode l1 = new ListNode(4);
		
		l1 = insert(l1,6);
		l1 = insert(l1, 5);
		
		ListNode result = list.addTwoNumbers(l, l1);
		
	}

}
