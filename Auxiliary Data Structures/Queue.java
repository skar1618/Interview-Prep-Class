
public class Queue {
	private Stack stack1;
	private Stack stack2;
	
	public Queue() {
		stack1 = new Stack();
		stack2 = new Stack();
	}
	
	public void push(Integer n) {
		stack1.push(n);
	}
	
	public Integer pop() {
		while(!stack1.isEmpty()) {
			Integer elem = stack1.pop();
			stack2.push(elem);
		}
		
		Integer elem1 = stack2.pop();
		while(!stack2.isEmpty()) {
			Integer elem = stack2.pop();
			stack2.push(elem);
		}
		
		return elem1;
	}
	
	public Integer peek() {
		while(!stack1.isEmpty()) {
			Integer elem = stack1.pop();
			stack2.push(elem);
		}
		
		Integer elem1 = stack2.peek();
		while(!stack2.isEmpty()) {
			Integer elem = stack2.pop();
			stack2.push(elem);
		}
		return elem1;
	}
}
