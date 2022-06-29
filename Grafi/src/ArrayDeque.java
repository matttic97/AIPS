
public class ArrayDeque<T> implements Sequence<T>, Deque<T>, Stack<T> {
    private static int DEFAULT_CAPACITY = 64;
    private T[] tabela;
    private int front, back, size;

	@SuppressWarnings("unchecked")
	public ArrayDeque() {
    	tabela = (T[])new Object[DEFAULT_CAPACITY];
    	front = 0; back = 0; size = 0;
    }
    
    private int next(int i) {
    	return (i+1)%DEFAULT_CAPACITY;
    }
    
    private int prev(int i) {
    	return (i>0 ? i-1 : DEFAULT_CAPACITY-1);
    }
    
    @SuppressWarnings("unused")
	private int index(int i) throws CollectionException {
    	if(i<0 || i>=size) {
    		throw new CollectionException("ERR_MSG_INDEX");
    	}
    	return (front+i)%DEFAULT_CAPACITY;
    }

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean isFull() {
		return (size == DEFAULT_CAPACITY);
	}

	@Override
	public int count() {
		return size;
	}

	@Override
	public T get(int i) throws CollectionException {
		if(!this.isEmpty()) {
			return tabela[i];
		}
		else 
			throw new CollectionException("ERR_MSG_INDEX");
	}

	@Override
	public void add(T x) throws CollectionException {
		push(x);
	}

	@Override
	public T top() throws CollectionException {
		if(isEmpty())
			throw new CollectionException("ERR_MSG_EMPTY");
		return tabela[prev(back)]; 
	}

	@Override
	public void push(T x) throws CollectionException {
		if(isFull())
			resize();
		tabela[back] = x;
		back = next(back);
		size++;
	}

	@SuppressWarnings("unchecked")
	private void resize() {
		T[] tmp = tabela;
		tabela = (T[])new Comparable[DEFAULT_CAPACITY *= 2];
		for(int z=0; z<tmp.length; z++) {
			tabela[z] = tmp[z];
		}
	}

	@Override
	public T pop() throws CollectionException {
		if(isEmpty())
			throw new CollectionException("ERR_MSG_EMPTY");
		back = prev(back);
		T x = tabela[back];
		tabela[back] = null;
		size--;
		return x;
	}

	@Override
	public T front() throws CollectionException {
		if(tabela[front] == null) {
			throw new CollectionException("ERR_MSG_EMPTY");
		}
		T x = tabela[front];
		tabela[front] = null;
		front = next(front);
		size--;
		return x;
	}

	@Override
	public T back() throws CollectionException {
		return top();
	}

	@Override
	public void enqueue(T x) throws CollectionException {
		push(x);
	}

	@Override
	public void enqueueFront(T x) throws CollectionException {
		if(tabela[front] == tabela[back]) {
			throw new CollectionException("ERR_MSG_FULL");
		}
		front = prev(front);
		tabela[front] = x;
		size++;
	}

	@Override
	public T dequeue() throws CollectionException {
		if(tabela[front] == null) {
			throw new CollectionException("ERR_MSG_EMPTY");
		}
		T x = tabela[front];
		tabela[front]  = null;
		front = next(front);
		size--;
		return x;
	}

	@Override
	public T dequeueBack() throws CollectionException {
		return pop();
	}


}