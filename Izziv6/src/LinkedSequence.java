public class LinkedSequence<T extends Comparable> implements ComparableSequence<T> {

	class Node{
		T value;
		Node prev, next;
	}
	
	private Node first;
	private int size;
	
    private int swap = 0;
    
    public LinkedSequence() {
    	size = 0;
    	first = null;
    }
	
	@Override
	public T get(int i) throws CollectionException {
		if(i > size)
			throw new CollectionException(Sequence.ERR_MSG_INDEX);
		else {
			Node n = first;
			for(int z = 0; z < i; z++) {
				n = n.next;
			}
			return n.value;
		}
	}

	@Override
	public void set(int i, T x) throws CollectionException {
		if(i > size)
			throw new CollectionException(Sequence.ERR_MSG_INDEX);
		else {
			Node node = new Node();
			node.value = x;
		
			Node n = first;
			for(int z = 0; z < i; z++) {
				n = n.next;
			}
		
			breakNodes(n.prev, n.next);
			Node prev = n.prev;
			Node next = n.next;
			node.next = next;
			next.prev = node;
			node.prev = prev;
			prev.next = node;
		}
	}

	@Override
	public void insert(int i, T x) throws CollectionException {
		if(i > size)
			throw new CollectionException(Sequence.ERR_MSG_INDEX);
		else {
			Node node = new Node();
			node.value = x;
		
			if(i == 0)
				insertAtStart(node);
			else if(i == size)
				insertAtEnd(node);
			else {
				insertAt(i, node);
			}
		}
		size++;
	}
	
	private void insertAt(int i, Node node) {
		Node n = first;
		for(int z = 0; z < i-1; z++) {
			n = n.next;
		}
		node.next = n.next;
		n.next.prev = node;
		n.next = node;
		node.prev = n;
	}
	
	private void insertAtStart(Node node) {
		node.next = first;
		first = node;
		if(size > 0)
			node.next.prev = node;
	}
	
	private void insertAtEnd(Node node) {
		Node n = first;
		while(n.next != null) {
			n = n.next;
		}
		n.next = node;
		node.prev = n;
	}

	@Override
	public T delete(int i) throws CollectionException{
		if(i > size)
			throw new CollectionException(Sequence.ERR_MSG_INDEX);
		else{
			Node n = first;
			for(int z = 0; z < i; z++) {
				n = n.next;
			}
			Node prev = n.prev;
			Node del = n;
			Node next = n.next;
			prev.next = next;
			next.prev = prev;
			n = null;
			size--;
			return del.value;
		}
	}
	
	private void breakNodes(Node prev, Node next) {
		prev.next = null;
		next.prev = null;
	}

	@Override
	public boolean isEmpty() {
		if(first == null)
			return true;
		else
			return false;
	}

	@Override
	public int size() {
		return size;
	}

	public void quick(int left, int right, int v) throws CollectionException {
		if (left >= right) return;
        int r = partition(left, right, v); 
		quick(left, r-1, v); 
		quick(r+1, right, v);
	}
	
    	int partition(int left, int right, int v) throws CollectionException{ 
    		T p = this.get(left);  
    		int l = left;
    		int r = right + 1;
    		while(true) 
    		{ 
    			do {l++;} while(p.compareTo(this.get(l)) > 0 && this.get(right).compareTo(this.get(l)) > 0);
    			do {r--;} while(this.get(r).compareTo(p) > 0);
    			if(l >= r) break;
    			swap(r, l);
    		}
    		swap(r, left);
    		
    		return r; 
    	}
	
	private void swap(int r, int l) {
		Node nL = first;
		for(int z = 0; z < l; z++) {
			nL = nL.next;
		}
		Node nR = first;
		for(int z = 0; z < r; z++) {
			nR = nR.next;
		}
		
		if(nL.prev == null) {
			if(nR.next == null) {
				Node tmp = first;
				Node n = nR;
				first = nR;
				first.next = tmp.next; first.next.prev = first;
				tmp.prev = n.prev; n.prev.next = tmp;
			}
			else {
				Node tmp = first;
				Node n = nR;
				first = nR;
				first.next = tmp.next; first.next.prev = first;
				tmp.prev = n.prev; n.prev.next = tmp;
				tmp.next = n.next; n.next.prev = tmp;
			}
			
		
		}
			
		
		this.swap += 3;
		
	}

	@Override
	public String toString() {
		String rtn = "";
		Node n = first;
		while(n.next != null) {
			rtn += n.value.toString() + " ";
			n = n.next;
		}
		return rtn + n.value.toString() +"";
	}
	
}