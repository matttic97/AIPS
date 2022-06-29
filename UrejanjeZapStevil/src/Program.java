import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = "";
		
		if(sc.hasNextLine())
			str = sc.nextLine();
		String[] cmds = str.split(" ");
		
		if(sc.hasNextLine())
			str = sc.nextLine();
		sc.close();
		
		String[] sequence = str.split(" ");
		int[] tabela = new int[sequence.length];
		for(int i=0; i<tabela.length; i++) {
			tabela[i] = Integer.parseInt(sequence[i]);
		}
		Sort zaporedje = new Sort(tabela);
		
		if(cmds[2].equals("up"))
			zaporedje.setSmer(1);
		else if(cmds[2].equals("down"))
			zaporedje.setSmer(-1);
		if(cmds[0].equals("trace"))
			zaporedje.trace(cmds[1]);
		else if(cmds[0].equals("count"))
			zaporedje.count(cmds[1]);

	}

}
