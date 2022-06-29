public class ArrayHeapPQ<T extends Comparable<T>> implements AbstractArray<T>{
	
	private static int DEFAULT_CAPACITY = 64;
    private T[] tabela;
    private int front;
    private int size;
    
    private int stPrimerjav;
    private int stPrirejanj;
    
	@SuppressWarnings("unchecked")
	public ArrayHeapPQ(){
       	tabela = (T[])new Comparable[DEFAULT_CAPACITY];
       	size = 0; 
       	front = 0;
       	stPrimerjav = 0;
       }
    
	@Override
	public T front() throws CollectionException {
		if(!isEmpty())
			return tabela[front];
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
		if(size > 1) {
			siftUp();
		}
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
			if(size == DEFAULT_CAPACITY - 1) {
				resize(-1);
			}
			T max = front();
			stPrirejanj++;
			preuredi();
			return max;
		}
		else
			throw new CollectionException(ERR_MSG_EMPTY);
	}
	
	private void preuredi() {
		size--;
		tabela[front] = tabela[size];
		tabela[size] = null;
		stPrirejanj += 2;
		
		if(size > 3)
			siftDown();
		
		if(size == 2) {
			if(compareTo(tabela[0], tabela[1]) < 0) {
				T tmp = tabela[0];
				tabela[0] = tabela[1];
				tabela[1] = tmp;
				stPrirejanj += 3;
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
	
	@Override
	public int size() {
		return size;
	}
	
	public void siftDown(){
		int root = 0;
		int end = size-1;
	 
		while((root * 2 + 1) <= end){      
			int child = root * 2 + 1; 
			
			if(child + 1 <= end && compareTo(tabela[child], tabela[child + 1]) > 0)
				child = child + 1;     
			
			if(compareTo(tabela[root], tabela[child]) < 0){    
				T tmp = tabela[root];
				tabela[root] = tabela[child];
				tabela[child] = tmp;
				stPrirejanj += 3;
				root = child;                
			}
			
			else
				return;
		}
		
	}
	
	public void siftUp() {
		int i = size-1;
		while(i > 0) {
			int parent = (i-1)/2;
			T x = tabela[i];
			T p = tabela[parent];
			stPrirejanj += 2;
			
			if(compareTo(x, p) > 0) {
				T tmp = tabela[i];
				tabela[i] = tabela[parent];
				tabela[parent] = tmp;
				stPrirejanj += 3;
				
				i = parent;
			}
			else
				break;
		}
	}
	
	public String toString() {
		String str = "";
		for(int i=0; i<size; i++) {
			str += tabela[i] + " ";
		}
		return str;
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