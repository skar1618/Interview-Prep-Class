

public class LinkedLists {
	public class Result {
		public Node node;
		public boolean result;
	}
	
	public class PartialSum {
		public int carry;
		public Node digits;
	}
	
	
	/**
	 * Implement an algorithm to find the kth to last element of a singly linked list.
	 * You are not allowed to compute the size of the list.
	 * @param Node head: the head of the linked list to be scanned
	 * @param int k 
	 */
	public int kthToLast(Node head, int k) {
		Node itr1 = head;
		for(int i = 0; i < k - 1; i++) {
			itr1= itr1.next;
		}
		Node itr2 = head;
		while(itr1.next != null) {
			itr1 = itr1.next;
			itr2 = itr2.next;
		}
		
		return itr2.val;
	}
	
	/**
	 * Implement a function to check if a linked list is a palindrome
	 * @param Node head: the head of the linked list to be scanned
	 */
	public boolean isPalindrome(Node head) {
		Result res = isPalindrome(head, head.size());
		return res.result;
	}
	
	public Result isPalindrome(Node head, int length) {
		// TODO: Base case
		if(length == 1) {
			Result res = new Result();
			res.result = true;
			res.node = head.next;
			return res;
		}
		else if(length == 2){
			Result res = new Result();
			res.result = (head.val == head.next.val);
			res.node = head.next.next;
			return res;
		}
		
		Result res = isPalindrome(head.next, length - 2);
		if(res.result) {
			res.result = (head.val == res.node.val);
			res.node = res.node.next;
		}
		return res;
		
	}
	
	/**
	 * You have two numbers represented by a linked list, where each node contains a
	 * single digit. Write a function that adds the two numbers and returns 
	 * the sum as a linked list.
	 * @param Node head1
	 * @param Node head2 
	 */
	public Node sumLists(Node head1, Node head2) {
		int l1 = head1.size();
		int l2 = head2.size();
		
		if(l1 > l2) {
			head2 = addZerosToFront(head2, l1 - l2);
		}
		else if(l2 > l1){
			head1 = addZerosToFront(head1, l2 - l1);
		}
		
		PartialSum sum = sumEqualLists(head1, head2); 
		if(sum.carry == 1) {
			Node carryNode = new Node(1);
			carryNode.next = sum.digits;
			sum.digits = carryNode;
		}

		return sum.digits;
		
	}
	
	private PartialSum sumEqualLists(Node head1, Node head2) {
		// TODO: Base Case
		if(head1 == null) {
			PartialSum sum = new PartialSum();
			sum.carry = 0;
			sum.digits = null;
			return sum;
		}
		
		PartialSum oldSum = sumEqualLists(head1.next, head2.next);
		PartialSum sum = new PartialSum();
		int digitSum = oldSum.carry + head1.val + head2.val;
		
		Node first = new Node(digitSum % 10);
		first.next = oldSum.digits;
		sum.digits = first;
		
		if(digitSum >= 10) {
			sum.carry = 1;
		}
		else {
			sum.carry = 0;
			
		}
		return sum;
	}

	private Node addZerosToFront(Node head, int z) {
		Node itr = head;
		for(int i = 0; i < z ; i++) {
			Node zero = new Node(0);
			zero.next = itr;
			itr = zero;
		}
		return itr;
	}
	
	/**
	 * Given a circular linked list, implement an algorithm which returns the node at the
	 * beginning of the loop.
	 * @param Node head
	 */
	public Node findBeginning(Node head) {
		Node slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow.equals(fast)) {
				break;
			}
		}
		
		if(fast == null || fast.next == null) {
			return null;
		}
		
		Node itr = head;
		while(!slow.equals(itr)) {
			slow = slow.next;
			itr = itr.next;
		}
		
		return itr;
	}
	
	/**
	 * Merge two sorted linked lists
	 * @param Node head1
	 * @param Node head2
	 */
	public Node mergeTwoLists(Node head1, Node head2) {
		Node itr1 = head1;
		Node itr2 = head2;
		
		while(itr1 != null && itr2 != null) {
			if(itr1.val < itr2.val) {
				itr1 = linkNodes(itr1, itr2);
			}
			else {
				itr1 = linkNodes(itr2, itr1);
			}
		}
		
		return (head1.val < head2.val) ? head1:head2;
	}

	private Node linkNodes(Node itr1, Node itr2) {
		while(itr1.next != null && itr1.next.val < itr2.val) {
			itr1 = itr1.next;
		}
		
		Node temp = itr1.next;
		itr1.next = itr2;
		return temp;
	}
	
	/**
	 * A linked list is given such that each node contains an additional 
	 * random pointer which could point to any node in the list or null.
	 * Return a deep copy of the list.
	 * @param Node head
	 */
	public Node copyRandomList(Node head) {
		for(Node itr = head; itr != null; itr = itr.next.next) {
			Node copyNode = new Node(itr.val);
			copyNode.next = itr.next;
			copyNode.random = itr.random;
			itr.next = copyNode;
		}
		Node copyHead = head.next;
		for(Node itr = head.next; itr != null; itr = itr.next.next) {
			itr.random = itr.random.next;
			if(itr.next == null) {
				break;
			}
		}
		
		for(Node itr = head, itrCopy = head.next; itr != null; itr = itr.next, itrCopy = itrCopy.next) {
			itr.next = itr.next.next;
			
			if(itrCopy.next != null) {
				itrCopy.next = itrCopy.next.next;
			}
		}
		return copyHead;
	}
}
