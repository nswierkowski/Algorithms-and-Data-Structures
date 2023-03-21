package lab4;

import java.util.ConcurrentModificationException;
import java.util.Iterator;


public class Main {

	public static void main(String[] args) {
		//testInteger();
		test();
	}

	static void display(IList<Integer> list) {
		for(Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println("\n");
	}
	
	static void testInteger() {
		TwoWayCycledListWithSentinel<Integer> l1 = new TwoWayCycledListWithSentinel<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		display(l1);
		Iterator<Integer> it1 = l1.revIterator();
		int i = 0;
		while(it1.hasNext()) {
			System.out.print(it1.next() + " ");
			if(i == 2) break;
			i++;
		}
		System.out.println("\n");
		System.out.println("Odwróć");
		l1.reverseInPlace();
		display(l1);
		TwoWayCycledListWithSentinel<Integer> l2 = (TwoWayCycledListWithSentinel<Integer>) l1.reverseCreate();
		display(l2);
		System.out.println("Usuń nieparzyste");
		l2.decimate(false);
		display(l2);
		System.out.println("Usuń parzyste");
		l1.decimate(true);
		display(l1);
		TwoWayCycledListWithSentinel<Integer> l3 = new TwoWayCycledListWithSentinel<Integer>();
		l3.add(4);
		l3.add(2);
		l3.add(4);
		l3.add(4);
		l3.add(5);
		display(l3);
		System.out.println("Przesuń 4 na początek");
		System.out.println(l3.moveToBegin(4));
		display(l3);
		System.out.print("l1 : ");
		display(l1);
		System.out.print("l2 : ");
		display(l2);
		System.out.println("Do l2 dołącz l1");
		TwoWayCycledListWithSentinel<Integer> l4 = (TwoWayCycledListWithSentinel<Integer>) l2.merge(l1, true);
		display(l4);
		System.out.println("Do l1 dołącz l2");
		TwoWayCycledListWithSentinel<Integer> l5 = (TwoWayCycledListWithSentinel<Integer>) l2.merge(l1, false);
		display(l5);
		System.out.println("Wyświetl elementy od 1 do 3");
		TwoWayCycledListWithSentinel<Integer> l6 = (TwoWayCycledListWithSentinel<Integer>) l5.sublist(1, 3);
		display(l6);
		
		try {
			while(it1.hasNext()) {
				System.out.print(it1.next() + " ");
			}
		}catch (ConcurrentModificationException e){
			System.out.print("ERROR");
		}
		System.out.println("\n");
		
		Iterator<Integer> it = l5.revIterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println("\n");
	}
	

	static void test() {
			TwoWayCycledListWithSentinel<Integer> o = new TwoWayCycledListWithSentinel<Integer>();
			o.add(1);
			o.add(3);
			o.add(2);
			o.add(10);
			o.add(11);
			display(o);
			
			System.out.println("Odwróc liste pierwszą");
			o.reverseInPlace();
			display(o);
			System.out.println("Stwórz nową liste ponownie odwracając l1");
			TwoWayCycledListWithSentinel<Integer> l2 = (TwoWayCycledListWithSentinel<Integer>) o.reverseCreate();
			display(l2);
			System.out.println("Usuń parzyste z l2");
			l2.decimate(true);
			display(l2);
			display(o);
			System.out.println("Usuń nieparzyste z l1");
			o.decimate(false);
			display(o);
			
			TwoWayCycledListWithSentinel<Integer> l3 = new TwoWayCycledListWithSentinel<Integer>();
			l3.add(1);
			l3.add(2);
			l3.add(4);
			l3.add(4);
			l3.add(4);
			l3.add(5);
			
			display(l3);
		//	Element c = new Element(4);
			System.out.println("Przesuń element 4 na przód");
			l3.moveToBegin(4);
			display(l3);
			display(l2);
			TwoWayCycledListWithSentinel<Integer> l4 = (TwoWayCycledListWithSentinel<Integer>) l3.merge(l2, true);
			System.out.println("Połącz 2 liste l3 i l2 (l2 na końcu) ");
			display(l4);
			System.out.println("Połącz 2 liste l3 i l2 (l2 na przodzie) ");
			TwoWayCycledListWithSentinel<Integer> l5 = (TwoWayCycledListWithSentinel<Integer>) l3.merge(l2, false);
			display(l5);
			
			l3.clear();
			l3 = new TwoWayCycledListWithSentinel<Integer>();
			l3.add(1);
			l3.add(2);
			l3.add(4);
			l3.add(4);
			l3.add(4);
			l3.add(5);
			display(l3);
			
			System.out.println("Elementy listy l3 od 1 do 3");
			TwoWayCycledListWithSentinel<Integer> l6 = (TwoWayCycledListWithSentinel<Integer>) l3.sublist(1,3);
			display(l6);
		}
	}

