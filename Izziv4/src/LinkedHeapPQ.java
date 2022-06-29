public class LinkedHeapPQ<T extends Comparable<T>> implements PriorityQueue<T>{
	
	private class Node<T>{
		private T item;
		private Node<T> left, right, parent;
    }

	private int stPrimerjav;
	private int stPrirejanj;
	
	public LinkedHeapPQ() {
		stPrimerjav = 0;
		stPrirejanj = 0;
	}
	
	@Override
	public T front() throws CollectionException {
		return null;
	}

	@Override
	public void enqueue(T x) throws CollectionException {
		Node<T> node = new Node<T>();
		node.item = x;
		stPrirejanj++;
	}

	@Override
	public T dequeue() throws CollectionException {
		return front();
	}

	@Override
	public boolean isEmpty() {
		return false;
	} 

	@Override
	public int size() {
		return 0;
	}

	@Override
	public int compareTo(T x, T y) {
		stPrimerjav++;
		Integer temp1 = (Integer) x;
        Integer temp2 = (Integer) y;
        return temp1.compareTo(temp2);
	}

	@Override
	public int getPrimerjave() {
		return this.stPrimerjav;
	}

	@Override
	public int getPrirejanje() {
		return this.stPrirejanj;
	}
	
}
