
public class Algorithm {
	
	private static int[][] matrix;
	private static boolean[] visited;
	private static String output;
	
	public static String bfs(int[][] m) throws CollectionException {
		matrix = m;
		Deque<Integer> queue = new ArrayDeque<Integer>();
		visited = new boolean[matrix.length];
		output = new String();
		
		queue.enqueue(0);
		for(int y=0; y<matrix.length; y++) {
			int i = queue.dequeue(); // vzamemo vn in izbrišemo
			visited[i] = true;
			add(i);
			Deque<Integer> list = getNeigbours(i);
			for(int z=0; z<list.count();) {
				queue.enqueue(list.dequeue());
			}
			if(queue.isEmpty())
				queue.enqueue(next());
		}
		
		return output;
	}
	
	public static String dfs(int[][] m) throws CollectionException {
		matrix = m;
		Stack<Integer> queue = new ArrayDeque<Integer>();
		visited = new boolean[matrix.length];
		output = new String();
		
		queue.push(0);
		for(int y=0; y<matrix.length; y++) {
			int i = queue.pop(); // vzamemo vn in izbrišemo
			visited[i] = true;
			add(i);
			Deque<Integer> list = getNeigbours(i);
			for(int z=0; z<list.count();) {
				queue.push(list.dequeue());
			}
			if(queue.isEmpty())
				queue.push(next());
		}
		
		return output;
	}
	
	private static void add(int i) {
		output += i + " ";
	}
	
	private static int next() {
		int l = 0;
		for(int i=1; i<visited.length; i++) {
			if(!visited[i]) {
				l = i;
				break;
			}	
		}
		return l;
	}
	
	private static Deque<Integer> getNeigbours(int i) throws CollectionException {
		Deque<Integer> list = new ArrayDeque<Integer>();
		for(int z=0; z<matrix.length; z++) {
			if(matrix[i][z] > 0 && !visited[z]) {
				visited[z] = true;
				list.enqueue(z);
			}
				
		}
		return list;
	}

}
