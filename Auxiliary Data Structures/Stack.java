import java.util.ArrayList;


public class Stack {
	private ArrayList<Integer> elems;
	private ArrayList<Integer> mins;
	
	public Stack() {
		elems = new ArrayList<Integer>();
		mins = new ArrayList<Integer>();
	}
	
	public boolean isEmpty() {
		return elems.isEmpty();
	}
	
	public void push(Integer t) {
		elems.add(t);
		if(mins.isEmpty()) {
			mins.add(t);
		}
		
		if(t <= mins.get(mins.size() - 1)) {
			mins.add(t);
		}
	}
	
	public Integer pop() {
		int lastIndex = elems.size() - 1;
		Integer t = elems.get(lastIndex);
		elems.remove(lastIndex);
		if(t == mins.get(mins.size() - 1)) {
			mins.remove(mins.size() - 1);
		}
		
		return t;
	}
	
	public Integer peek() {
		Integer t = elems.get(elems.size() - 1);
		return t;
	}
	
	public Integer min() {
		return mins.get(mins.size() - 1);
	}
}
