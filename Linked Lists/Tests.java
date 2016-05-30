import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {
	LinkedLists list = new LinkedLists();
	
	public Node createList(int[] vals) {
		Node head = new Node(vals[0]);
		int size = vals.length;
		for(int i = 1; i < size; i++)
			head.appendToTail(vals[i]);
	
		return head;
	}
	
	@Test
	public void kthToLastTests() {
		int[] vals = {5, 10, 15, 20, 25};
		Node head = createList(vals);
		int k1 = list.kthToLast(head, 1);
		int k2 = list.kthToLast(head, 3);
		assertEquals(k1, 25);
		assertEquals(k2, 15);
	}
	
	@Test
	public void isPalindromeTests() {
		int[] vals1 = {0,1,2,1,0};
		Node head1 = createList(vals1);
		int[] vals2 = {0,1,2,3,3,2,1,0};
		Node head2 = createList(vals2);
		int[] vals3 = {0,1,2,1,5};
		Node head3 = createList(vals3);
		
		boolean b1 = list.isPalindrome(head1);
		boolean b2 = list.isPalindrome(head2);
		boolean b3 = list.isPalindrome(head3);
		
		assertEquals(b1, true);
		assertEquals(b2, true);
		assertEquals(b3, false);
	}
	
	@Test
	public void sumListsTests() {
		System.out.println("sumListsTests output");
		int[] vals1 = {8,7,5,2,7,0,3};
		Node head1 = createList(vals1);
		int[] vals2 = {9,7,3,0,6};
		Node head2 = createList(vals2);
		Node sum = list.sumLists(head1, head2);
		sum.prettyPrintLinkedList();
		
	}
	
	
	@Test
	public void findBeginningTests() {
		int[] vals = {0,1,2,3,4,5,6,7,8};
		Node head = createList(vals);
		
		Node begin = head.next.next.next;
		Node itr = head;
		while(itr.next != null) {
			itr = itr.next;
		}
		itr.next = begin;
		
		Node begin1 = list.findBeginning(head);
		assertEquals(begin1, begin);
		
		int[] vals1 = {0,1,2,3,4,5,6,7,8};
		Node head1 = createList(vals1);
		Node begin2 = list.findBeginning(head1);
		assertEquals(begin2, null);
	}
	
	@Test
	public void mergeTwoListsTests() {
		System.out.println("mergeTwoListsTests output");
		int[] vals1 = {1,3,5,7,9,11,15,20};
		int[] vals2 = {6,8,10,12,13};
		Node head1 = createList(vals1);
		Node head2 = createList(vals2);
		
		Node merged = list.mergeTwoLists(head1, head2);
		merged.prettyPrintLinkedList();
	}
	
	
	@Test
	public void copyRandomTests() {
		System.out.println("copyRandomTests output");
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		node1.random = node3;
		node2.random = node1;
		node3.random = node4;
		node4.random = node2;
		
		Node copy = list.copyRandomList(node1);
		node1.prettyPrintLinkedList();
		copy.prettyPrintLinkedList();
		node1.printRandomNodes();
		copy.printRandomNodes();
	}
	
}
