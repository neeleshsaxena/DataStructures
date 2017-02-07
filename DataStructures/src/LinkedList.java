import java.awt.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LinkedList {
	
	public static ListElement insertToHead(ListElement list, Object data){
		
		ListElement l = new ListElement(data);
		
		l.next = list;
		
		return l;
		
		
	}
	
	public static ListElement reverseLinkedList(ListElement head){
		ListElement currNode = head;
		ListElement prevNode = null;
		ListElement nextNode = null;
		
		while(currNode!=null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		
		
		head = prevNode;
		
		return head;
		
		/*ArrayList arr = new ArrayList<>();
		ArrayList arr1 = new ArrayList<>();
		//Map na = new HashMap<>();
		//Collection as = na.values();
		
		
		
		//recursion
		if (head == null || head.next == null) {
			return head;
		}

		ListElement remaining = reverseLinkedList(head.next);

		head.next.next = head;

		head.next = null;

		return remaining;*/ 
		
		
	}
	
	public static void reversePrint(ListElement head){
	/*	ArrayList arr = new ArrayList<>();
		
		while(head!=null){
			arr.add(head.data);
			head = head.next;
		}
		
		for(int i=arr.size()-1;i>=0;i--){
			System.out.print(arr.get(i) + " ");
		}*/
		
		
		//recursion
		if(head!=null){
			
			reversePrint(head.next);
			System.out.print(head.data + " ");
			
		}
		
		
	}
	
	
	public static ListElement insertToTail(ListElement list, Object data){
		ListElement l  = new ListElement(data);
		l.next = null;
		
		ListElement current = list;
		while(current.next!=null){
			current = current.next;
		}
		current.next = l;
		
		return list;
	}
	
	public static ListElement deleteAtPos(ListElement list, int position){
		
		if(list!=null){
			
			if(position ==0){
				ListElement temp = list;
				list = list.next;
				temp.next = null;
				return list;
			}
			
			ListElement trackedNode = list;
			int currPos = 0;
			
			while(currPos<position-1){
				list = list.next;
				currPos++;
			}
			
			ListElement nodeToDelete = list.next;
			list.next = nodeToDelete.next;
			nodeToDelete.next = null;
			
			return trackedNode;
			
			
		}
		return null;
		
	}
	
	public static int length(ListElement head){
		
		int count=0;
		
		while(head!=null){
			count++;
			head= head.next;
		}
		return count;
	}
	
	
	public static ListElement insertAtPosition(ListElement head, Object data, int position){
		
		/*//should return the head
		ListElement trackedNode = list;
		
		//new node
		ListElement nodeToInsert = new ListElement(data);
		
		//if the list is empty
		if(list==null){
			return nodeToInsert;
		}
		
		//at starting position
		if(position ==0){
			ListElement l = new ListElement(data);
			l.next = list;
			return l;
		}
		
		
		
		int currentPosition = 0;
		
		if(currentPosition<position-1 && list.next!=null){
			list = list.next;
			currentPosition++;
			
		}
		
		//use it later
		ListElement previousNode = list.next;
		
		list.next = nodeToInsert;
		list = list.next;
		list.next = previousNode;
		
		return trackedNode;
		*/
		
		ListElement trackedNode = head;
		
		ListElement newNode = new ListElement(data);
		
		//if list is null
		if(head==null){
			return newNode;
		}
		
		//get size
		int size = length(head);
		if(position>size+1 || position<1){
			System.out.println("Cant do it");
			return head;
		}
		
		//if at 0 position
		if(position==0){
			newNode.next= head;
			return newNode;
			
		}
		
		//in the middle
		ListElement prevNode = head;
		int pos =1;
		while(pos<position-1){
			prevNode = prevNode.next;
			pos++;
		}
		
		ListElement currentNode = prevNode.next;
		newNode.next = currentNode;
		prevNode.next = newNode;
		
		
		return trackedNode;
		
		
	}
	
	public static ListElement find(ListElement head, Object data){
		
		if(head!= null && head.data!= data){
			head = head.next;
		}
		
		return head;
	}
	
	
	public static int compareList(ListElement nodeA, ListElement nodeB){
		if(nodeA==null || nodeB==null){
			return 0;
		}
		
		while(nodeA!=null && nodeB!=null){
			
			if(nodeA.data!=nodeB.data){
				return 0;
			}
			
			nodeA = nodeA.next;
			nodeB = nodeB.next;
				
		}
		
		
		if(nodeA == null && nodeB== null){return 1;} else return 0;
		
		
	}
	
	public static ListElement mergeSort(ListElement headA){
		
		if(headA==null || headA.next==null){
			return headA;
		}
		
		
		//break off
		ListElement middle = findMiddle(headA);
		ListElement nextOfMiddle = middle.next;
		middle.next = null;
		
		
		ListElement left = mergeSort(headA);
		ListElement right = mergeSort(nextOfMiddle);
		
		
		ListElement sorted = mergeList(left, right);
		
		return sorted;
		
	}
	
	public static ListElement findMiddle(ListElement head){
		
		ListElement p1 = head;
		ListElement p2 = head;
		
		int i=0;
		while(p1.next!=null){
			if(i==0){
				p1 = p1.next;
				i=1;
			}
			else if(i==1){
				p1 = p1.next;
				p2 = p2.next;
				i=0;
			}
			
			
		}
		
		return p2;
		
	}
	
	public static ListElement mergeList(ListElement headA , ListElement headB){
		/* if( headA == null && headB!=null){
		        return headB;
		    }
		    if(headB == null && headB !=null){
		        return headB;
		    }
		    
		    if(headA ==null && headB == null){
		        return null;
		    }
		    
		    int a = (int)headA.data;
		    int b = (int)headB.data;
		    if(a<b){
		        while(headA.next!=null){
		            headA = headA.next;
		        }
		        headA.next = headB;
		        return headA;
		        
		    }
		    if(b<a){
		        while(headB.next!=null){
		            headB = headB.next;
		        }
		        headB.next = headA;
		        return headB;
		        
		    }
		    else return null;*/
		
		
		//recursion
		if(headA==null){
			return headB;
		}
		if(headB==null){
			return headA;
		}
		
		int a = (int)headA.data;
		int b = (int)headB.data;
		if(a<b){
			headA.next = mergeList(headA.next, headB);
			return headA;
		}
		
		if(b<a){
			headB.next = mergeList(headA, headB.next);
			return headB;
		}
		
		
		else return null;
		
	}
	
	public static int nodeFromTail(ListElement head, int n){
		ListElement trackedNode = head;
		int len =0;
		while(head.next!=null){
			head = head.next;
			len++;
		}
		
		int pos = len-n;
		
		int curPos= 0;
		while(curPos<pos){
			trackedNode= trackedNode.next;
			curPos++;
		}
		
		int a = (int)trackedNode.data;
		return a;
		
	}
	
	public static ListElement removeDuplicates(ListElement head){
		if(head ==null){
			return null;
		}
		
		ListElement nextNode = head.next;
		
		while(nextNode!= null && head.data == nextNode.data){
			nextNode = nextNode.next;
		}
		
		head.next = removeDuplicates(nextNode);
		return head;
		
		
	}
	
	public static int findMergePointOfTwoLists(ListElement headA, ListElement headB){
		
		ListElement currA = headA;
		ListElement currB = headB;
		
		//checks the address, not the value of the node
		while(currA!=currB){
			
			//If you reached the end of one list start at the beginning of the other one
			//currA
			if(currA.next == null){
				currA = headB;
			}
			else{
				currA = currA.next;
			}
			
			
			//currB
			if(currB.next==null){
				currB = headA;
			}
			else{
				currB = currB.next;
			}
			
			
			
		}
		
		int value = (int)currB.data;
		return value;
		
		
	}
	
	public static int mergePoint(ListElement A, ListElement B){
		
		
		ListElement currA = A;
		ListElement currB = B;
		
		
		while(currA!=null){
			currB = B;
			
			while(currB!=null){
				
				if(currA==currB){
					return (int)currB.data;
				}
				else{
					currB = currB.next;
				}
				
			}
			currA = currA.next;
			
		}
		
		
		return 0;
	}
	
	public static void reverse(ListElement head){
		
		ListElement a = head;
		ListElement b = head.next;
		
		while(b.next.next!=null){
			
			ListElement temp = b.next;
			ListElement temp2 = b.next.next;
			
			b.next = a;
			
			
			
			
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a = 5/2;
		System.out.println(a);
		Object data = 1;
		Object data3 = 3;
		Object data4 = 4;
		Object data5 = 5;
		
		ListElement head = new ListElement (2);
		
		
		head = insertToHead(head, data);
		head = insertToHead(head, data3);
		head = insertToHead(head, data4);
		head = insertToHead(head, data5);
		
		ListElement ahead = new ListElement(5);
		//ahead.next = head.next.next.next;
		
		ListElement middle = findMiddle(head);
		
		ListElement sorted = mergeSort(head);
		/*int a = mergePoint(head, ahead);
		
		head = reverseLinkedList(head);*/
		
		
		//System.out.println(head.data);
		
		while(sorted!=null && sorted.data!=null){
			System.out.println(sorted.data);
			sorted = sorted.next;
		}
		
		
		//head = find(head,2);
		
		//System.out.println(head.data);
		
		/*while(head!=null && head.data!=null){
		System.out.println(head.data);
		head = head.next;
	}*/
		
		//head = deleteAtPos(head, 2);
		
		//reversePrint(head);
		
		//ListElement trackedElement = head;
		
		/*ArrayList arr = new ArrayList<>();
		
		while(head!=null && head.data!=null){
		System.out.println(head.data);
		arr.add(head.data);
		head = head.next;
		
		}

		
		for(int i = arr.size()-1;i>=0;i--){
			System.out.print(arr.get(i) + " ");
		}*/
		
		
	/*	Object data1 = 1;
		Object data2 = 2;
		Object data3 = 3;
		
		ListElement head = new ListElement (12);
		
		
		head = insertToHead(head, data3);
		head = insertToHead(head, data2);
		head = insertToHead(head, data1);*/
		
		/*Object data5 = 5;
		Object data6 = 6;*/

		
		//ListElement head2 = new ListElement (15);
		
		
	/*	head2 = insertToHead(head2, data6);
		head2= insertToHead(head2, data5);*/

		//ListElement a = mergeList(head2, head);
		
		//int a = nodeFromTail(head, 2);
		
		//System.out.println(a);
		
		/*while(head!=null && head.data!=null){
			System.out.println(head.data);
		
			head = head.next;
			
			}*/
		
	}

}
