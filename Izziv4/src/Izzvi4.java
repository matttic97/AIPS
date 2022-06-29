public class Izzvi4 {

	public static void main(String[] args) throws CollectionException {
		
		long zacCas, konCas;
		
		zacCas = System.nanoTime();
		Queue<Integer> vrsta = new ArrayPQ<Integer>();
		
		for(int i=0; i<1000; i++)
			vrsta.enqueue((int)Math.random()*1000+1);
		for(int i=0; i<500; i++) {
			vrsta.dequeue();
			vrsta.enqueue((int)Math.random()*1000+1);
			vrsta.front();
		}
			
		konCas = System.nanoTime() - zacCas;
		
		System.out.println("\t----- Neurejeno polje -----");
		System.out.print("Št primerjav: " + vrsta.getPrimerjave());
		System.out.print("\tŠt prirejanj: " + vrsta.getPrirejanje());
		System.out.println("\tÈas(ms): " + konCas + "\n");
		
		
		zacCas = System.nanoTime();
		Queue<Integer> vrsta2 = new ArrayHeapPQ<Integer>();
		
		for(int i=0; i<1000; i++)
			vrsta2.enqueue((int)Math.random()*1000+1);
		for(int i=0; i<500; i++) {
			vrsta2.dequeue();
			vrsta2.enqueue((int)Math.random()*1000+1);
			vrsta2.front();
		}
		
		konCas = System.nanoTime() - zacCas;

		System.out.println("\t----- Implicitna kopica -----");
		System.out.print("Št primerjav: " + vrsta2.getPrimerjave());
		System.out.print("\tŠt prirejanj: " + vrsta2.getPrirejanje());
		System.out.println("\tÈas(ms): " + konCas + "\n");
		
		zacCas = System.nanoTime();
		Queue<Integer> vrsta3 = new LinkedHeapPQ<Integer>();
		
		for(int i=0; i<1000; i++)
			vrsta3.enqueue((int)Math.random()*1000+1);
		for(int i=0; i<500; i++) {
			vrsta3.dequeue();
			vrsta3.enqueue((int)Math.random()*1000+1);
			vrsta3.front();
		}
		
		konCas = System.nanoTime() - zacCas;

		System.out.println("\t----- Eksplicitna kopica (test)-----");
		System.out.print("Št primerjav: " + vrsta3.getPrimerjave());
		System.out.print("\tŠt prirejanj: " + vrsta3.getPrirejanje());
		System.out.println("\tÈas(ms): " + konCas + "\n");
		
	}

}
