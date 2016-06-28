import java.util.ArrayList;

public class Queue<T> {
	private ArrayList<T> elems;
	
	public Queue() {
		elems = new ArrayList<T>();
	}
	
	public void push(T t) {
		this.elems.add(t);
	}
	
	public T pop() {
		T t = this.elems.get(0);
		this.elems.remove(0);
		return t;
	}
	
	public T peek() {
		T t = this.elems.get(0);
		return t;
	}
	
	public boolean isEmpty() {
		return this.elems.isEmpty();
	}
}
