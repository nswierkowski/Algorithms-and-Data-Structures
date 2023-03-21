package lab3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		test1();
		test();
	}

	static void test1() {
		OneWayLinkedListWithHead<Integer> o = new OneWayLinkedListWithHead<Integer>();
		o.add(0);
		o.add(1);
		o.add(2);
		o.add(3);
		o.add(4);
		o.add(5);
		o.add(6);
		o.add(7);
		o.add(8);
		o.add(9);
		o.add(10);
		o.add(11);
		o.add(12);
		o.add(13);
		o.add(14);
		
		System.out.println("Wyświetlam zawartość: ");
		for(Integer s : o) {
			System.out.print(s);
		}
		System.out.println(o.size());
		System.out.println("\n" + o.head.getValue());
		System.out.println("\n");

		o.reverseInPlace();
		
		System.out.println("Odwrócona kolejność:");
		System.out.println(o.size());
		for(Integer s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Nowa odwrócona lista:");
		IList<Integer> newList = o.reverseCreate();
		for(Integer s : newList) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Usuń elementy parzyste:");
		o.decimate(true);
		for(Integer s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Przesuń wszystkie elementy e na przód: ");
		Element<Integer> newElem = new Element<Integer>(9);
		o.moveToBegin(newElem);
		for(Integer s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Połączene listy: ");
		IList<Integer> list = o.merge(newList, true);
		for(Integer s : list) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		int start_ind = 3;
		int end_ind = 5;
		System.out.println("Lista od " + start_ind + " do " + end_ind + ": ");
		IList<Integer> sublist = o.sublist(start_ind, end_ind);
		for(Integer s : sublist) {
			System.out.print(s);
		}
		System.out.println("\n");
	}
	
	static void test2() {
		OneWayLinkedListWithHead<String> o = new OneWayLinkedListWithHead<String>();
		o.add("algorytmy ");
		o.add("i ");
		o.add("struktury ");
		o.add("danych ");
		o.add("Architektura ");
		o.add("komputerów ");
		o.add("Analiza ");
		o.add("danych ");
		
		System.out.println("Wyświetlam zawartość: ");
		for(String s : o) {
			System.out.print(s);
		}
		System.out.println("\n");

		o.reverseInPlace();
		
		System.out.println("Odwrócona kolejność:");
		for(String s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Nowa odwrócona lista:");
		IList<String> newList = o.reverseCreate();
		for(String s : newList) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Usuń elementy nieparzyste:");
		o.decimate(false);
		for(String s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Przesuń wszystkie elementy e na przód: ");
		String s = "i ";
		Element<String> newElem = new Element<String>(s);
		o.moveToBegin(newElem);
		for(String s1 : o) {
			System.out.print(s1);
		}
		System.out.println("\n");
		
		System.out.println("Połączene listy: ");
		IList<String> list = o.merge(newList, true);
		for(String s2 : list) {
			System.out.print(s2);
		}
		System.out.println("\n");
		
		int start_ind = 3;
		int end_ind = 5;
		System.out.println("Lista od " + start_ind + " do " + end_ind + ": ");
		IList<String> sublist = o.sublist(start_ind, end_ind);
		for(String s3 : sublist) {
			System.out.print(s3);
		}
		System.out.println("\n");
	}
	
	static void test3() {
		OneWayLinkedListWithHead<String> o = new OneWayLinkedListWithHead<String>();
		o.add("algorytmy ");
		o.add("i ");
		o.add("struktury ");
		o.add("danych ");
		o.add("architektura ");
		o.add("komputerów ");
		o.add("analiza ");
		o.add("danych ");
		o.add("matematyka ");
		o.add("danych ");
		o.add("danych ");
		o.add("danych ");
		
		o.reverseInPlace();
		
		System.out.println("Odwrócona kolejność:");
		for(String s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		o.reverseInPlace();
		
		System.out.println("Nowa odwrócona lista:");
		IList<String> newList = o.reverseCreate();
		for(String s : newList) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		o.decimate(true);
		System.out.println("Usuń parzyste:");
		for(String s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Przesuń słowo danych na przód:");
		Element e = new Element("danych ");
		o.moveToBegin(e);
		for(String s : o) {
			System.out.print(s);
		}
		System.out.println("\n");

		System.out.println("Zrób to ponownie i się nie wywal na łeb:");
		o.moveToBegin(e);
		for(String s : o) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Połączona lista z odwróconą listą(lista odwrócona dodana na końcu):");
		IList<String> BothList = o.merge(newList, true);
		for(String s : BothList) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Zrób to ponownie ale lista dodana na początku:");
		BothList = o.merge(newList, false);
		for(String s : BothList) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Lista z elementami od 0 do 0:");
		IList<String> temp2 = o.sublist(0, 0);
		for(String s : temp2) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Lista z elementami od 15 do 19:");
		IList<String> temp3 = o.sublist(15, 19);
		if(temp3.isEmpty()) System.out.println("Lista jest pusta");
		for(String s : temp3) {
			System.out.print(s);
		}
		System.out.println("\n");
		
		System.out.println("Lista z elementami od 1 do 3:");
		IList<String> temp4 = o.sublist(1, 3);
		for(String s : temp4) {
			System.out.print(s);
		}
		System.out.println("\n");
	}
	
	static void display(OneWayLinkedListWithHead<Integer> o) {
		for(Integer s : o) {
			System.out.print(s + " ");
		}
		System.out.println("\n");
	}
	
	static void test() {
		OneWayLinkedListWithHead<Integer> o = new OneWayLinkedListWithHead<Integer>();
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
		OneWayLinkedListWithHead<Integer> l2 = (OneWayLinkedListWithHead<Integer>) o.reverseCreate();
		display(l2);
		System.out.println("Usuń parzyste z l2");
		l2.decimate(true);
		display(l2);
		display(o);
		System.out.println("Usuń nieparzyste z l1");
		o.decimate(false);
		display(o);
		
		OneWayLinkedListWithHead<Integer> l3 = new OneWayLinkedListWithHead<Integer>();
		l3.add(1);
		l3.add(2);
		l3.add(4);
		l3.add(4);
		l3.add(4);
		l3.add(5);
		
		display(l3);
		Element c = new Element(4);
		System.out.println("Przesuń element 4 na przód");
		l3.moveToBegin(c);
		display(l3);
		display(l2);
		OneWayLinkedListWithHead<Integer> l4 = (OneWayLinkedListWithHead<Integer>) l3.merge(l2, true);
		System.out.println("Połącz 2 liste l3 i l2 (l2 na końcu) ");
		display(l4);
		System.out.println("Połącz 2 liste l3 i l2 (l2 na przodzie) ");
		OneWayLinkedListWithHead<Integer> l5 = (OneWayLinkedListWithHead<Integer>) l3.merge(l2, false);
		display(l5);
		
		l3.clear();
		l3 = new OneWayLinkedListWithHead<Integer>();
		l3.add(1);
		l3.add(2);
		l3.add(4);
		l3.add(4);
		l3.add(4);
		l3.add(5);
		display(l3);
		
		System.out.println("Elementy listy l3 od 1 do 3");
		OneWayLinkedListWithHead<Integer> l6 = (OneWayLinkedListWithHead<Integer>) l3.sublist(1,3);
		display(l6);
	}
}
