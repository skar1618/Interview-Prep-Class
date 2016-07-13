
public class MaxHeap extends Heap {

	@Override
	protected boolean compare(Integer integer1, Integer integer2) {
		return integer1 < integer2;
	}

}
