package graph;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLatice wl1 = new WordLatice();
		wl1.loadLattice("test1.txt");
		System.out.println("TEST1");
		System.out.println("Zawiera cykle: " + wl1.containsCycles());
		String [] strings = wl1.successors("<s>");
		System.out.println("Następca <s>: ");
		for(int i = 0; i < strings.length; i++) {
			System.out.print(strings[i] + " ");
		}
		System.out.print("\n");	
		System.out.print("\n");		
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		System.out.println(wl1.getNextPath());
		
		WordLatice wl2 = new WordLatice();
		wl2.loadLattice("test2.txt");
		System.out.println("\nTEST2");
		System.out.println("Zawiera cykle: " + wl2.containsCycles());
		
		if(!wl2.containsCycles()){
			System.out.println("Następca <s>: ");
			String [] strings2 = wl2.successors("<s>");
			for(int i = 0; i < strings2.length; i++) {
				System.out.print(strings2[i] + " ");
			}
			System.out.print("\n");	
			System.out.print("\n");		
			System.out.println(wl2.getNextPath());
			System.out.println(wl2.getNextPath());
			System.out.println(wl2.getNextPath());
			System.out.println(wl2.getNextPath());
		}
	}

}
