import Izziv2.ArrayDeque;
import Izziv2.CollectionException;
import Izziv2.Deque;
import Izziv2.Sequence;
import Izziv2.Stack;

public class Izziv2 {

	public static void main(String[] args) {
		
		Stack<String> s = new ArrayDeque<String>();
		Deque<String> d = new ArrayDeque<String>();
		Sequence<String> z = new ArrayDeque<String>();
		
		//Stack
		try {
			s.push("M");
			s.push("A");
			s.push("T");
			s.push("I");
			s.push("C");

		} catch (CollectionException e) {
			e.printStackTrace();
		}
		
		//Sequence
		try {
			z.add("I");
			z.add("S");
			z.add("O");
			z.add("V");
			z.add("S");
			z.add("K");
			z.add("I");

		} catch (CollectionException e) {
			e.printStackTrace();
		}
		
		//Deque
		try {
			d.enqueue("ena");
			d.enqueue("dva");
			d.enqueue("tri");
			d.enqueue("stiri");
			d.enqueue("pet");
			d.enqueueFront("deset");
			d.enqueueFront("devet");
			d.enqueueFront("osem");
			d.enqueueFront("sedem");
			d.enqueueFront("sest");
			

		} catch (CollectionException e) {
			e.printStackTrace();
		}
		
		while(!s.isEmpty()){
			try {
				System.out.print(s.top() + " ");
				d.enqueueFront(s.pop());
			} catch (CollectionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.print("\n Deque: ");
		while(!d.isEmpty()) {
			try {
				System.out.print(d.back() + " ");
				z.add(d.dequeueBack());
			} catch (CollectionException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n Sequence: ");
		for(int i=0; i< z.count(); i++) {
			try {
				System.out.print((i+1) + "." + z.get(i) + " ");
			} catch (CollectionException e) {
				e.printStackTrace();
			}
		}
			

	}

}
