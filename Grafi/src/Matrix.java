
public class Matrix {
	
	public static int[][] toNeighbourMatrix(Sequence<int[]> graf,int[][] matrix, boolean t) throws CollectionException {
		for(int z=0; z<graf.count(); z++) {
			int f = graf.get(z)[0];
			for(int i=1; i<graf.get(z).length; i++) {
				int s = graf.get(z)[i];
				if(graf.get(z)[0] != graf.get(z)[i])
					matrix[f][s]++;
				if(!t)
					if(graf.get(z)[0] != graf.get(z)[i])
					matrix[s][f]++;
			}
		}
		
		return matrix;
	}
	
	
	public static int[][] power(int[][] m, int level) {
		int l = m.length;
		int[][] matrix = null;
		int[][] m1 = m;
		while(level > 1) {
			matrix = new int[l][l];
			for(int i=0; i<l; i++) {
				for(int z=0; z<l; z++) {
					for(int k=0; k<l; k++) {
						matrix[i][z] += m1[i][k] * m[k][z];
					}
				}
			}
			level--;
			m1 = matrix;
		}
		return matrix;
	}
}
