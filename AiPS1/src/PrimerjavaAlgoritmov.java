import java.util.*;

public class PrimerjavaAlgoritmov {
	
	public static void main(String [] args){
			Izpis();
	  }
	  
	  static int[] generirajTabelo(int n)
	  {
	    int tabela[] = new int[n];
	    for(int i=0; i<n; i++)
	    {
	      tabela[i] = i+1;
	    }
	    
	    return tabela;
	  }
	  
	  static int zaporednoIskanje(int[] t, int v)
	  {
	    int r = 0;
	    for(int i=0; i<t.length; i++)
	    {
	      if(t[i] == v)
	        r = i+1;
	    }
	    return r;
	  }
	  
	  static int dvojiskoIskanje(int[] t, int v, int l, int d)
	  {    
	    if (l < d)
	    {
	      return -1;
	    }
	    else
	    {
	      int s = (l + d) / 2;
	     
	      if (v < t[s])
	      {
	        return dvojiskoIskanje(t, v, l, s - 1);
	      }
	      else if (v > t[s])
	      {
	        return dvojiskoIskanje(t, v, s + 1, d);
	      }
	      else
	      {
	        return s;
	      }
	    }
	  }
	 
	  static long casZaporednegaIskanja(int n)
	  {
	    int[] tabela = generirajTabelo(n);
	    
	    long zacCas = System.nanoTime();
	    
	    for(int i=0; i<1000; i++)
	    {
	      Random rnd = new Random();
	      int r = rnd.nextInt(n) + 1;
	      zaporednoIskanje(tabela, r);
	    }
	    long konCas = System.nanoTime() - zacCas;
	    return konCas;
	  }
	  
	  static long casDvojiskegaIskanja(int n)
	  {
	    int[] tabela = generirajTabelo(n);
	    
	    long zacCas = System.nanoTime();
	    
	    for(int i=0; i<1000; i++)
	    {
	      Random rnd = new Random();
	      int r = rnd.nextInt(n) + 1;
	      dvojiskoIskanje(tabela, r, 1, 1000);
	    }
	    long konCas = System.nanoTime() - zacCas;
	    return konCas;
	  }
	  
	  static void Izpis()
	  {
	    //glava
		  System.out.println(Sestavi("n", ' ') + Sestavi("zaporedno", ' ') + Sestavi("dvojisko", ' '));
		  
		//locilna crta
		  System.out.println(Sestavi("", '-') + Sestavi("", '-') + Sestavi("", '-'));
		  
		//vsebina
		for(int i=100000; i<=1000000; i+= 10000) {
		  System.out.println(Sestavi(String.valueOf(i), ' ') + Sestavi(String.valueOf(casZaporednegaIskanja(i)/1000) , ' ') + 
				  Sestavi(String.valueOf(casDvojiskegaIskanja(i)/1000), ' '));
		}
	    
	  }
	  
	  static String Sestavi(String besedilo, char znak)
	  {
		  int p = 12 - besedilo.length();
		  int z = p / 2;
		  
		  String a = new String();
		  for(int i=0; i<12; i++)
		  {
		    	if(i < z)
		    		a += znak;
		    	else if(i < besedilo.length() + z)
		    		a += besedilo.charAt(i-z);
		    	else if(i < 12)
		    		a += znak;
		  }
		  
		  return a += "|";
	  }

}