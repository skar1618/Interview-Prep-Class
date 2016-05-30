
public class Node {
	public int val;
	public Node next;
	public Node random;
	
	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
	
	public Node() {
		
	}
	
	public int size() {
		int size = 0;
		for(Node itr = this; itr != null; itr = itr.next) {
			size++;
		}
		
		return size;
	}
	
	void appendToTail(int d) {
		Node itr = this;
		while(itr.next != null) {
			itr = itr.next;
		}
		
		Node newNode = new Node(d);
		itr.next = newNode;
	}
	
	// Pretty Prints the linked list
	public void prettyPrintLinkedList() {
		StringBuffer sb = new StringBuffer();
		for(Node itr = this; itr != null; itr = itr.next){
			sb.append(itr.val);
			sb.append(" ");
		}
		System.out.println(sb.toString());
		System.out.println("----------------");
	}
	
	// prints the random node for each node
	public void printRandomNodes() {
		for(Node itr = this; itr != null; itr = itr.next) {
			System.out.println(itr.val + " -> " + itr.random.val);
		}
		System.out.println("----------------");
	}
}
