public class Sort {
	
	private static int[] tabela;
	private static int size;
	
	private int smer;
	private int swap;
	private int compare;
	private int count;
	private int countQ;
	
	public Sort(int[] t) {
		tabela = t;
		size = t.length;
		this.swap = 0;
		this.compare = 0;
		this.count = 1;
		this.countQ = 0;
	}	
	
	public void count(String mth) {
		switch(mth) {
		case "insert" : insert(true); insert(true); zamenjajSmer(); insert(true);
			break;
		case "select" : select(true); select(true); zamenjajSmer(); select(true);
			break;
		case "bubble" : bubble(true); bubble(true); zamenjajSmer(); bubble(true);
			break;
		case "heap" : heap(true); heap(true); zamenjajSmer(); heap(true);
			break;
		case "merge" : merge(true, 0, size-1); printCount(); reset(); merge(true, 0, size-1);  printCount(); reset(); zamenjajSmer(); merge(true, 0, size-1); printCount(); reset();
			break;
		case "quick" : quick(true, 0, size-1); printCount(); reset(); quick(true, 0, size-1); printCount(); reset(); zamenjajSmer(); quick(true, 0, size-1);printCount(); reset();
			break;
		case "radix" : radix(true); radix(true); zamenjajSmer(); radix(true);
			break;
		case "bucket" : //bucket(true); printCount(); reset(); bucket(true); printCount(); reset(); zamenjajSmer(); bucket(true);printCount(); reset();
			break;
		default :
			break;
		}
	}
	
	public void trace(String mth){
		switch(mth) {
		case "insert" : ToString(); insert(false);
			break;
		case "select" : select(false);
			break;
		case "bubble" : bubble(false);
			break;
		case "heap" : heap(false);
			break;
		case "merge" : ToString();// merge(false, 0, size-1);
			break;
		case "quick" : ToString(); quick(false, 0, size-1); ToString();
			break;
		case "radix" : radix(false);
			break;
		case "bucket" : ToString(); bucket(false);
			break;
		default :
			break;
		}
	}
	
 	private void bucket(boolean c) {
		
		int MIN = tabela[0];
		int MAX = MIN;
		for(int i=1; i<size; i++) {
			if(tabela[i] > MAX) MAX = tabela[i];
			else if(tabela[i] < MIN) MIN = tabela[i];
		}
		int k = size/2;
		int v = (int)Math.ceil((MAX-MIN)/k)+1;
		
	    // Sort buckets and stitch together answer
		int[][] buckets = new int[k][v];
		
		List<Bucket> bucketss = new List<Bucket>();
		for(int i=0; i<k; i++) {
			bucketss.add(new Bucket());
		}
		
	    for(int i=0; i<size; i++) {
	    	bucketss.get((tabela[i] - MIN) / v).add(tabela[i]);
	    	this.swap++;
	     }
	    
	    int j = 0;
	    if(smer==1) {
	    	for(int i=0; i<bucketss.len(); i++) {
	    	for(int z=0; z<bucketss.get(i).len();  z++ ) {
	    		tabela[j] = bucketss.get(i).get(z);
	    		j++; this.swap++;
	    	}
	    	}
	    }
	    else {
	    	k++;
	    	for(int i=bucketss.len()-1; i>=0; i--) {
		    	for(int z=0; z<bucketss.get(i).len();  z++ ) {
		    		tabela[j] = bucketss.get(i).get(z);
		    		j++; this.swap++;
		    	}
		    	}
	    }
	    
	    if(!c)
			printTrace(k-1);
	    insert(c);
	}

	private void radix(boolean c) {
		int MAX = tabela[0];
		for(int i=1; i<size; i++) {
			if(tabela[i] > MAX) MAX = tabela[i];
		}
		
		if(!c)ToString();
		for (int exp = 1; MAX/exp > 0; exp *= 10) {
			countSort(exp);
			if(!c)ToString();
		}
        if(c)
        	printCount();
        reset();
	}
	
		void countSort(int exp) {
			int n = size;
			int output[] = new int[n];
			int i; 
			int count[] = new int[10]; 
  
			for (i = 0; i < n; i++) {
				count[ (tabela[i]/exp)%10 ]++;
				this.compare++;this.swap++;
			}
            
			if(smer ==1)
				for (i = 1; i < 10; i++) 
					count[i] += count[i - 1];
			else
				for (i = 8; i >= 0; i--)
					count[i] += count[i + 1];
			
			for (i = n - 1; i >= 0; i--) 
			{ 
				output[count[ (tabela[i]/exp)%10 ] - 1] = tabela[i]; 
				count[ (tabela[i]/exp)%10 ]--;
				this.compare++;this.swap++;
			} 

			tabela = output;
		} 

	private void quick(boolean c, int left, int right) {
		if (left >= right) return;
        int r = partition(c, left, right); 
		quick(c, left, r-1); 
		quick(c, r+1, right);
	}
	
    	int partition(boolean c, int left, int right){ 
    		int p = tabela[left];  
    		int l = left;
    		int r = right + 1;
    		while(true) 
    		{ 
    			do {l++;} while(compare(p, tabela[l]) && compare(right, l));
    			do {r--;} while(compare(tabela[r], p));
    			if(l >= r) break;
    			swap(r, l);
    		}
    		swap(r, left);
    		int last = left;
    		if(!c)printQuick(last, right, r);
    		
    		return r; 
    	}

    private void merge(boolean c, int l, int r) {
		
		if (l < r) 
        { 
            int m = (l+r)/2; 
 
            merge(c, l, m); 
            merge(c, m+1, r); 
  
            mergeUp(c, l, m, r); 
        } 
		
	}
	
		void mergeUp(boolean c, int l, int m, int r){ 
	        int n1 = m - l + 1; 
	        int n2 = r - m; 
	  
	        int L[] = new int [n1]; 
	        int R[] = new int [n2]; 
	  
	        if(!c)printTrace(n2+1);
	        for (int i=0; i<n1; ++i) {
	        	L[i] = tabela[l + i];
	        }
	            
	        if(!c)printTrace(n2+1);
	        for (int j=0; j<n2; ++j) 
	            R[j] = tabela[m + 1+ j]; 

	        int i = 0, j = 0; 
	  if(!c)printTrace(r);
	        int k = l; 
	        while (i < n1 && j < n2) 
	        { 
	        	this.compare++;
	            if (smer==1 ? L[i] <= R[j] : L[i] >= R[j]) 
	            { 
	            	tabela[k] = L[i]; 
	                i++;
	                this.swap+=2;
	            } 
	            else
	            { 
	            	tabela[k] = R[j]; 
	                j++; 
	                this.swap+=2;
	            } 
	            k++; 
	        } 
	  
	        while (i < n1) 
	        { 
	        	tabela[k] = L[i]; 
	            i++; 
	            k++;
	            this.swap+=2;
	        } 
	  
	        while (j < n2) 
	        { 
	        	tabela[k] = R[j]; 
	            j++; 
	            k++; 
	            this.swap+=2;
	        } 
	} 

	private void heap(boolean c) {
		int n = size; 
		
		if(!c)
			ToString();

		for (int i = n / 2 - 1; i >= 0; i--) {
        	  siftDown(n, i); 
        }
        
		int end = n-1;
        while (end>=0){ 
            if(!c)
            	printTrace(end);
            
            if(end != 0)
            	swap(end, 0);
            siftDown(end, 0);
            end--;
        }
        
        if(c)
        	printCount();
        reset();
        
	}
	
		private void siftDown(int n, int i) { 
			int largest = i;
			int l = 2*i + 1;
			int r = 2*i + 2;
	  
			if (l < n && compare(tabela[l], tabela[largest])) 
				largest = l; 
	  
			if (r < n && compare(tabela[r], tabela[largest])) 
				largest = r; 
	  
			if (largest != i){ 
				swap(largest, i); 
				siftDown(n, largest); 
			} 
		} 

	private void bubble(boolean c) {
		int lastC = -1;
		
		if(!c)
			printTrace(lastC);
		for (int i = 0;  i < tabela.length - 1;  i = lastC) {
            lastC = tabela.length - 1;
            for (int j = tabela.length - 2;  j >= i; --j) {
                if (compare(tabela[j], tabela[j+1])) {
                	swap(j, j+1);
                    lastC = j+1;
                }
            }
            if(!c)
	    		printTrace(lastC-1);
        }
		if(c)
			printCount();
		reset();
	}

	private void select(boolean c) {
		if(!c)
			printTrace(-1);
		for(int i=0; i<tabela.length-1; i++) {
			int t = i;
			for(int j=i+1; j<tabela.length; j++) {
				if(compare(tabela[t], tabela[j]))
					t = j;
			}
			swap(i, t);
			if(!c)
				printTrace(i);
		}
		if(c)
			printCount();
		reset();
	}
	
	private void insert(boolean c) {
		int n = tabela.length;
		
        for (int i=1; i<n; i++) 
        { 
            int tmp = tabela[i]; 
            int j = i-1;
            
            while (j>=0 && compare(tabela[j], tmp))
            {
            	tabela[j+1] = tabela[j]; 
            	j = j-1;
            	this.swap++;
            }
            
            tabela[j+1] = tmp; 
            this.swap +=2;
            if(!c)
            	printTrace(i);
        }
        if(c)
        	printCount();
        reset();
	}
	
	private void reset() {
		this.swap = 0;
		this.compare = 0;
		this.countQ = 0;
	}

	private void swap(int f, int s) {
		int temp = tabela[s];
		tabela[s] = tabela[f]; 
		tabela[f] = temp;
		this.swap += 3;
			
	}
	
	private boolean compare(int a, int b) {
		this.compare++;
		boolean pogoj = smer==1 ? a>b : a<b;
		if(pogoj)
			return true;
		else
			return false;
	}
	
	private void printCount() {
		if(count == 2)
			System.out.print("| " + this.swap + " " + this.compare + " | ");
		else
			System.out.print(this.swap + " " + this.compare + " ");
		count++;
	}

	private  void printTrace(int l) {
		for(int i=0; i<tabela.length; i++) {
			if(i == l && l != -1)
				System.out.print("" + tabela[i] + " | ");
			else
				System.out.print(tabela[i] + " ");
		}
		System.out.println();
	}
	
	private void printQuick(int l, int r, int p) {
		for(int i=l; i<r+1; i++) {
			if(i == p && p != -1)
				System.out.print("| " + tabela[i] + " | ");
			else
				System.out.print(tabela[i] + " ");
		}
		System.out.println();
	}
	
	private void ToString() {
		String str = "";
		for(int i=0; i<tabela.length; i++) {
			str += tabela[i] + " ";
		}
		System.out.println(str);
	}

	public void setSmer(int s) {
		this.smer = s; 
	}

	private void zamenjajSmer() {
		if(this.smer == 1)
			this.smer = -1;
		else
			this.smer = 1;
	}
	
}

class List<T> {
    private int size = 0;
    private static int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public List() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(Bucket b) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = b;
    }

    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i >= size || i < 0) {
            try {
                throw new CollectionException("Index: " + i + ", Size " + i);
            } catch (CollectionException e) {
                e.printStackTrace();
            }
        }
        return (T) elements[i];
    }

    @SuppressWarnings("unchecked")
	public void resize() {
        DEFAULT_CAPACITY *= 2;
		T[] resized = (T[]) new Object[DEFAULT_CAPACITY];
        for (int i = 0; i < size; i++) {
            resized[i] = (T) elements[i];
        }
        elements = resized;
    }

    public int len() {
        return size;
    }

    public void reverseBuckets() {
        Object[] reversed = new Object[DEFAULT_CAPACITY];
        int cnt = 0;
        for (int i = size - 1; i >= 0; i--) {
            reversed[cnt++] = elements[i];
        }

        elements = reversed;
    }
}

class Bucket {
    private int [] bucket;
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;

    Bucket() {
        bucket = new int[DEFAULT_CAPACITY];
    }

    public void add(int number) {
        if (size == bucket.length) {
            resize();
        }
        bucket[size++] = number;
    }

    public int [] getBucket() {
        return bucket;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            try {
                throw new CollectionException("Index" + index + "does not exists");
            } catch (CollectionException e) {
                e.printStackTrace();
            }
        }
        return bucket[index];
    }

    public void resize() {
        DEFAULT_CAPACITY *= 2;
        int [] resized    = new int[DEFAULT_CAPACITY];
        for (int i = 0; i < size; i++) {
            resized[i] = bucket[i];
        }
        bucket = resized;
    }

    public int len() {
        return size;
    }
}

class CollectionException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public CollectionException(String msg) {
		super(msg);
	}

}
