
public class Drevo {
	
	private static double dX=1;
	private static double dY=1;
	private static int[] x = {6,3,8,1,5,7,9,0,2,4};
	private static int[] y = {0,1,1,2,2,2,2,3,3,3};
	private static char[] elementi = {'A','B','C','D','E','F','G','H','I','J'};
	String niz;
	
	public Drevo(double X, double Y, int n) {
		//x = new int[n];
		//y = new int[n];
		//elementi = new char[n];
		//napolni(elementi);
		dX = X;
		dY = Y;
		//traverse(elementi);
	}
	

	private void napolni(char[] elementi2) {
		String niz = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for(int i=0; i<elementi.length; i++) {
			elementi[i] = niz.charAt(i);
		}
	}

	private void traverse(char[] e) {
		for(int i=0; i<e.length; i++) {
			//x[i] = niz.indexOf(e[i]);
			y[i] = (int)(Math.log(i+1));
		}
	}
	
	public static void sortAscending(int[] Y, int[]x){
	    int[] sortedArray = new int[x.length];
	    int tempx, tempy;
	    for (int i = 0; i <= x.length; i++) 
	    {
	        for (int j = i+1; j < x.length; j++)
	        {
	            if (x[i] > x[j]) 
	            {
	                tempx = x[i];
	                tempy= y[i];
	                x[i] = x[j];
	                y[i] = y[j];
	                x[j] = tempx;
	                y[j] = tempy;
	            }
	        }
	    }
	}

	void drawLevelorder() {
//		sortAscending(y, x);
		for(int i=0; i<x.length; i++) {
			System.out.println(y[i]);
			dX = x[i];
			dY = y[i]+2;
			for(int z=0; z<x.length; z++) {
				if(y[z] == (i+1)) {
					StdDraw.line(x[z], y[z]+2, dX, dY+2);
				}
			}
			StdDraw.circle(dX, dY, 0.2);
			StdDraw.text(dX, dY, String.valueOf(elementi[i]));
		}
	}
	
	void drawPreorder(int i) {
		
	}
	
	void drawInorder(int i) {
		
	}
	
	void drawPostorder(int i) {
		
	}
	
}
