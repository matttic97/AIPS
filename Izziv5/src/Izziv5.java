import java.util.Scanner;

public class Izziv5 {

	public static void main(String[] args) {
		
		String[] imena = {
				"Matic", "Andrej", "Bella", "Tine", "Teja", 
				"Amanda", "Peter", "Gregor", "Silvija", "Jože", 
				"Anèka", "Žan", "Sara", "Anže", "Diana",
				"Nina", "Nik", "Žiga", "Gaja", "Lojzek"				
				};
		String[] priimki = {
				"Isovski", "Klepaè", "Odnikar", "Plestenjak", "Murko", 
				"Sedmikar", "Kuzelj", "Radešiè", "Pogaèar", "Pleènikar", 
				"Cankar", "Finžgar", "Fetiš", "Pahor", "Bebler", 
				"Gabršek", "Faganel", "Oblak", "Pestner", "Tanc", 
				};
		int[] letnice = {
				1997, 1968, 2002, 1965, 2005, 
				1988, 1974, 2000, 1989, 1999, 
				2001, 1993, 1957, 2003, 1995,
				1966, 1955, 2010, 1980, 1972
				};
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Vpišite velikost tabele: ");
		int n = Integer.parseInt(sc.nextLine());
		
		Oseba[] tt = new Oseba[n];
		for(int i=0; i<n; i++) {
			tt[i] = new Oseba(imena[(int)(Math.random()*19) + 0], priimki[(int)(Math.random()*19) + 0], letnice[(int)(Math.random()*19) + 0]);
		}
		
		boolean close = false;
		while(!close) {
			Oseba[] t = new Oseba[n];
			t = tt;
			
			System.out.println("   -----   -----   ");
			for(int i=0; i<n; i++) {
				System.out.println(t[i].toString());
			}
			
			System.out.println("   -----   -----   ");
			System.out.print("Izberite atribut (ime: 0, priimek: 1, letnik: 2): ");
			int atr = Integer.parseInt(sc.nextLine());
			System.out.print("Izberite smer (navzgor: 1, navzdol: -1): ");
			int smer = Integer.parseInt(sc.nextLine());
			Oseba.setAtr(atr);
			Oseba.setSmer(smer);
			
			System.out.println("   -----   -----   ");
			t = Oseba.sort(t);
			
			System.out.println("   -----   -----   ");
			System.out.print("Bi radi ponovili? (da: 1, ne: 2): ");
			int exit = Integer.parseInt(sc.nextLine());
			close = (exit == 1) ? false : true;
			System.out.println("**********************************************");
			
		}
		
		sc.close();
		System.exit(0);

	}

}
