import java.util.LinkedList;

public class Solution1 {

	static Node head;

	static class Node {

		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	// "slow" and "fast" iterate will cause a collide if we have a cycle
	boolean hasCycle(Node head) {
		if (head == null) {
			return false;
		}

		Node slow = head; // moves 1 Node at a time
		Node fast = head; // moves 2 Nodes at a time

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true; // since "slow" and "fast" collided
			}
		}
		return false;
	}
	
	// Function to print the linked list 
    static void printList(Node node) { 
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
    } 
    // Driver program to test above functions 
    public static void main(String[] args) { 
        
        Solution1.head = new Node(50); 
        head.next = new Node(20); 
        head.next.next = new Node(15); 
        head.next.next.next = new Node(4); 
        head.next.next.next.next = new Node(10); 
  
        // Creating a loop for testing  
        head.next.next.next.next.next = head.next.next; 

        printList(head); 
    } 
}
