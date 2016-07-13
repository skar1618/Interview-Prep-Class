import java.util.ArrayList;


public abstract class Heap {
	private ArrayList<Integer> elems = new ArrayList<Integer>();
	
	private int parent(int i) {
		return i / 2;
	}
	
	private int left(int i) {
		return 2 * i + 1;
	}
	
	private int right(int i) {
		return left(i) + 1;
	}
	
	public boolean isEmpty() {
		return elems.isEmpty();
	}
	
	public void insert(int elem) {
		elems.add(elem);
		if(elems.size() > 1) {
			int index = elems.size() - 1;
			int parent = parent(index);
			while(!compare(elems.get(index),elems.get(parent)) && index != 0) {
				swapElems(index, parent);
				index = parent;
				parent = parent(index);
			}
		}
	}
	
	public int size() {
		return elems.size();
	}
	
	public int root() {
		return elems.get(0);
	}
	
	public int deleteRoot() {
		int root = elems.get(0);
		elems.set(0, elems.get(elems.size() - 1));
		elems.remove(elems.size() - 1);
		this.heapify(0);
		return root;
	}

	private void heapify(int i) {
		int size = elems.size(), big = 0;
		if(i >= size / 2) {
			return;
		}
		
		int left = left(i);
		int right = right(i);
		
		if(elems.get(left) > elems.get(i)) {
			big = left;
		}
		if(right < size && elems.get(right) > elems.get(big)) {
			big = right;
		}
		
		if(big != i) {
			swapElems(i, big);
			heapify(big);
		}
	}
	
	private void swapElems(int i, int j) {
		int temp = elems.get(i);
		elems.set(i, elems.get(j));
		elems.set(j, temp);
	}
	
	protected abstract boolean compare(Integer integer, Integer integer2);
	
}
