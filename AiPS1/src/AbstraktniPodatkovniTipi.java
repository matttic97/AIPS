import java.util.*;

public class AbstraktniPodatkovniTipi {
	
	public static void main (String[] args) 
    { 
        Stack<String> s = new Stack<String>();
        Stack<Object> s2 = new Stack<Object>();
        
        //2.
        napolni(s);
        Stack<String> t = obrni(s);
        izpis(t);
        
        //3.
        napolni(s);
        t = obrni(s, 2, 3);
        izpis(t);
        
        //4.
        napolni(s);
        t = pogrezni(s, 2, 3);
        izpis(t);
        
        //5.
        napolni(s);
        int z = izloci(s, "A");
        System.out.println(z);
        
        //6. - SE SPLOH DA NAREDITI TABELO, KI IMA RAZLIÈNO ŠTEVILO STOLPCEV V VRSTICAH IN SE DA DODAJATI VRSTICE NAKNADNO?
        Object crke [] = {"A", "B", 1, 2, true, false, false};
        for(int i=0; i<crke.length; i++){
        	s2.push(crke[i]);
        }

        Object[][] tab = pogrezni(s2, null);
        
        for(int i=0; i<tab.length; i++) {
        	System.out.print("{");
			for(int z2=0; z2<tab[i].length; z2++) {
				if(z2 != tab[i].length-1 && tab[i][z2] != null)
					System.out.print(tab[i][z2] + ", ");
				else if(z2 == tab[i].length-1 && tab[i][z2] != null) {
					System.out.print(tab[i][z2]);
				}
			}
			System.out.println("}");
		}
        
    }
	
	static void napolni(Stack<String> s) {
        String crke [] = {"A", "B", "C", "D", "E", "F", "G"};
        for(int i=0; i<crke.length; i++){
        	s.push(crke[i]);
        }
	}
	
	static void izpis(Stack<String> s){
		Stack<String> t = obrni(s);
		System.out.print("[");
		for(int i=0; i<t.size(); i=0) {
			if(i == t.size()-1) {
				System.out.print(t.pop());
				}
			else {
				System.out.print(t.pop() + ",");
				}
			}
		System.out.println("]");
	}
    
	
	//2.
	static Stack<String> obrni(Stack<String> s){
		Stack<String> t = new Stack<String>();
		for(int i=0; i<s.size(); i=0) {
			t.push(s.pop());
		}
		return t;
	}
	
	static Stack<String> obrni(Stack<String> s, Stack<String> t){
		for(int i=0; i<s.size(); i=0) {
			t.push(s.pop());
		}
		return t;
	}
	
	static Stack<String> obrni(Stack<String> s, int n){
		Stack<String> t = new Stack<String>();
		while(n>0){
			t.push(s.pop());
			n--;
		}
		return t;
	}
	
	//3.
	static Stack<String> obrni(Stack<String> s, int n, int m){
		Stack<String> t1 = obrni(s);
		Stack<String> t = obrni(t1, n);
		Stack<String> t2 = obrni(t1, m);
		t = obrni(t2, t);
		t = obrni(t1, t);
		return t;
	}
	
	//4.
	static Stack<String> pogrezni(Stack<String> s, int n, int m){
		Stack<String> t1, t2, t3, t4, t5 , t;
		t1 = obrni(s);
		t2 = obrni(t1, n);
		t3 = obrni(t1, m);
		t4 = obrni(t3);
		t5 = obrni(t2);
		t = obrni(t4);
		t = obrni(t5, t);
		t = obrni(t1, t);
		return t;
	}
	
	//5.
	static int izloci(Stack<String> s, Object o){
		int st = 0;
		for(int i=0; i<s.size(); i=0) {
			if(s.peek().equals(o)) {
				s.pop();
				st++;
			}
			else {
				s.pop();
			}
		}
		return st;
	}
	
	//6.
	static Object[][] pogrezni(Stack<Object> s, Object[][] t){
		Object fO = s.pop();
		Stack<Object> sT = new Stack<Object>();
		Stack<Object> r = new Stack<Object>();
		Object[][] tabela;
		
		sT.push(fO);
		for(int i=0; i<s.size(); i=0) {
			if(s.peek().getClass() == fO.getClass()) {
				sT.push(s.pop());
			}
			else {
				r.push(s.pop());
			}
		}
		
		Object[] type = new Object[sT.size()];
		for(int i=0; i<type.length; i++) {
			type[i] = sT.pop();
			
		}
		Stack<Object> m = new Stack<Object>();
		for(int i=0; i<r.size(); i=0) {
			m.push(r.pop());
		}
		
		if(t == null) {
			tabela = new Object[1][type.length];
			for(int i=0; i<type.length; i++) {
				tabela[0][i] = type[i];
			}
			
			if(!m.isEmpty()) {
				return pogrezni(m, tabela);
			}
			else {
				return tabela;
			}
		}
		
		else {
			tabela = new Object[t.length+1][t[0].length];
			for(int i=0; i<t.length; i++) {
				for(int z=0; z<t[i].length; z++) {
					tabela[i][z] = t[i][z];
				}
			}
			for(int z=0; z<type.length; z++) {
				tabela[t.length][z] = type[z];
			}
			
			if(!m.isEmpty()) {
				return pogrezni(m, tabela);
			}
			else {
				return tabela;
			}
		}
		
	}
		
}
