import java.util.Scanner;

public class Main {
	
	static Sequence<int[]>  graf = new ArrayDeque<int[]>();

	public static void main(String[] args) throws CollectionException {


		Scanner sc = new Scanner(System.in);
		String cmds[] = sc.nextLine().split(" ");
		
	    String readString = sc.nextLine();
	    int size = Integer.parseInt(readString);
	    while(readString!=null) {

	        if (readString.isEmpty()) {
	            break;
	        }

	        if (sc.hasNextLine()) {
	            readString = sc.nextLine();
	            String[] a = readString.split(" ");
				if(a.length > 0)
					graf.add(toArray(a));
	            
	        } else {
	            readString = null;
	        }
	    }
	    
		sc.close();
		Solver solve = new Solver(size);
		solve.Solve(graf, cmds);
		
		
	}

	public static int[] toArray(String[] s) {
		int[] tmp = new int[s.length];
		for(int i=0; i<s.length; i++) {
			if(!s[i].equals(" ") && !s[i].equals(""))
				tmp[i] = Integer.parseInt(s[i]);
		}
		return tmp;
	}

}
