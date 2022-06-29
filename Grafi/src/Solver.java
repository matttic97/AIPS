
public class Solver {
	
	private int[][] matrixN;
	private int[][] matrixI;
	
	public Solver(int size) {
		this.matrixN = new int[size][size];
	}
	
	public void Solve(Sequence<int[]> graf, String[] cmds) throws CollectionException {
		switch(cmds[0]) {
			case "directed" : Matrix.toNeighbourMatrix(graf, this.matrixN, true); directed(cmds);
				break;
			case "undirected" : Matrix.toNeighbourMatrix(graf, this.matrixN, false); undirected(cmds);
				break;
		}
	}
	
	private void izpis(int[][] m) {
		for(int z=0; z<m.length; z++) {
			for(int i=0; i<m.length; i++) {
				System.out.print(m[z][i] + " ");
			}
			System.out.println();
		}
	}
	
	private void undirected(String[] cmds) throws CollectionException {
		switch(cmds[1]) {
			case "info" : infoU();
				break;
			case "walks" : walks(Integer.parseInt(cmds[2]));
				break;
			case "dfs" : System.out.println(Algorithm.dfs(this.matrixN));
				break;
			case "bfs" : System.out.println(Algorithm.bfs(this.matrixN));
				break;
			case "sp" : sp(cmds[2]);
				break;
			case "comp" : comp();
				break;
		}
	}
	
	private void directed(String[] cmds) throws CollectionException {
		switch(cmds[1]) {
		case "info" : infoD();
			break;
		case "walks" : walks(Integer.parseInt(cmds[2]));
			break;
		case "dfs" : dfs();
			break;
		case "bfs" : System.out.println(Algorithm.bfs(this.matrixN));
			break;
		case "sp" : sp(cmds[2]);
			break;
		case "comp" : comp();
			break;
		}
	}

	private void comp() {
		// TODO Auto-generated method stub
		
	}

	private void sp(String string) {
		// TODO Auto-generated method stub
		
	}

	private void bfs() {
		
	}

	private void dfs() {
		// TODO Auto-generated method stub
		
	}

	private void walks(int n) {
		izpis(Matrix.power(this.matrixN, n));
	}

	private void infoD() {
		int v = this.matrixN.length;
		int[] in = new int[v];
		int[] out = new int[v];
		int e = 0;
		
		for(int i=0; i<v; i++) {
				int countIn = 0;
				int countOut = 0;
				for(int z=0; z<v; z++) {
					if(this.matrixN[i][z] > 0) {
						countIn++;
						e++;
					}
					if(this.matrixN[z][i] > 0) {
						countOut++;
						e++;
					}
				}
				in[i] = countIn;
				out[i] = countOut;
			}
		
		e /= 2;
		System.out.println(v + " " + e);
		for(int i=0; i<v; i++) {
			System.out.println(i + " " + in[i] + " " + out[i]);
		}
	}

	private void infoU() {
		int v = this.matrixN.length;
		int[] in = new int[v];
		int e = 0;
		
		for(int i=0; i<v; i++) {
				int count = 0;
				for(int z=0; z<v; z++) {
					if(this.matrixN[i][z] > 0) {
						count++;
						e++;
					}	
				}
				in[i] = count;
			}
		
		e /= 2;
		System.out.println(v + " " + e);
		for(int i=0; i<v; i++) {
			System.out.println(i + " " + in[i]);
		}
	}

}
