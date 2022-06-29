public class ArrayPQ<T extends Comparable<T>> implements AbstractArray<T>{
	
	private static int DEFAULT_CAPACITY = 64;
    private T[] tabela;
    private int front, size;
    
    private int stPrimerjav;
    private int stPrirejanj;
    
	@SuppressWarnings("unchecked")
	public ArrayPQ(){
       	tabela = (T[])new Comparable[DEFAULT_CAPACITY];
       	size = 0; 
       	front = 0;
       }
    
	@Override
	public T front() throws CollectionException {
		if(!isEmpty()) {
			compare();
			return tabela[front];
		}
		else
			throw new CollectionException(ERR_MSG_EMPTY);
	}
	
	@Override
	public void enqueue(T x) throws CollectionException {
		if(size == DEFAULT_CAPACITY-1) {
			resize(1);
		}
		tabela[size] = x;
		size++;
		stPrirejanj++;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int i) {
		if(i == 1) {
			T[] tmp = tabela;
			tabela = (T[])new Comparable[DEFAULT_CAPACITY *= 2];
			for(int z=0; z<tmp.length; z++) {
				tabela[z] = tmp[z];
				stPrirejanj++;
			}
		}
		else if(i == -1){
			T[] tmp = tabela;
			tabela = (T[])new Comparable[DEFAULT_CAPACITY /= 2];
			for(int z=0; z<tmp.length; z++) {
				tabela[z] = tmp[z];
				stPrirejanj++;
			}
		}
	}
	
	@Override
	public T dequeue() throws CollectionException {
		if(!isEmpty()) {
			if(size == DEFAULT_CAPACITY-1) {
				resize(-1);
			}
			
			T max = front();
			stPrirejanj++;
			size--;
			preuredi();
			return max;
		}
		else
			throw new CollectionException(ERR_MSG_EMPTY);
	}
	
	private void preuredi() {
		tabela[front] = tabela[size];
		tabela[size] = null;
		stPrirejanj += 2;
	}
	
	private void compare(){
		T x;
		front = 0; //?
		if(!isEmpty()) {
			for(int i=0; i<size; i++) {
				x = tabela[front];
				stPrirejanj++;
				if(compareTo(x, tabela[i]) < 0) {
					front = i;
				}
			}
		}
	}
	
	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		else
			return false;
	}
	
	public String toString() {
		String str = "";
		for(int i=0; i<size; i++) {
			str += tabela[i] + " ";
		}
		return str;
	}
	
	@Override
	public int size() {
		return size;
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
