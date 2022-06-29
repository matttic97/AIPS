interface Comparable {
	  public int compareTo(Object o);
}

public class Oseba implements Comparable {
	
	private String ime, priimek;
	private int letoR;
	private static int atr;
	private static int smer;
	
	private static int compare = 0;
	
	public Oseba(String i, String p, int l) {
		this.ime = i;
		this.priimek = p;
		this.letoR = l;
	}
	
	private static void print(Oseba[]o, int l) {
		for(int i=0; i<o.length; i++) {
			if(i == l && l != -1)
				System.out.print("| " + o[i] + " ");
			else
				System.out.print(o[i] + " ");
		}
		System.out.println();
	}
	
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Oseba))
			return 0;
		
		compare++;
		
		Oseba os = (Oseba)o;
		switch(atr) {
			case 0: return (this.ime.compareTo(os.ime))*smer;
			case 1: return (this.priimek.compareTo(os.priimek))*smer;
			case 2: return (this.letoR - os.letoR)*smer;
			default: return 0;
		}
	}
	
	@Override
	public String toString() {
		switch(atr) {
			case 0: return this.ime;
			case 1: return this.priimek;
			case 2: return String.valueOf(this.letoR);
			default: return null;
		}
	}
	
	public static int getCompare() {
		return compare;
	}

	public static void setAtr(int atr) {
		Oseba.atr = atr;
	}

	public static void setSmer(int smer) {
		Oseba.smer = smer;
	}
	
	public String getIme() {
		return ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public int getLetoR() {
		return letoR;
	}

}