package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class WordLatice {

	Graph g;
	
	public WordLatice() {
		g = new Graph();
	}
	
	void loadLattice( String fname ) {
	// Tworzy graf z pliku i normalizuje prawdopodobieństwa
		try {
			Scanner sc = new Scanner(new FileReader(new File(fname)));
			while(sc.hasNext()) {
				String parent = sc.next();
				String child = sc.next();
				String f1 = sc.next();
				float f2 = Float.parseFloat(f1);
				g.addEdge(parent, child, f2);
			//	g.repair();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	void show() {
		g.show();
	}
	
	boolean containsCycles() {
		// Sprawdza czy w grafie są cykle
		return g.lookForCycle();
	}
	
	void pathFinderReset() {
		// Rozpoczyna wyszukiwanie wszystkich ścieżek w grafir
		g.newPath();
	}
	
	String getNextPath() {
		// zwraca następną ścieżkę od <s> do </s> w postaci napisu
		// o nastęującej postaci:
		// "prawdopodobieństwo <s> slowo1 slowo2 . . . slowoN </s>"
		// Jeśli wszystkie ścieżki zostały już wygenerowanie - zwraca
		// napis pusty
		return g.path();
	}
	
	String [] successors( String word ) {
		// zwraca tablicę wszystkich słów które mogą wystąpić po
		// słowie "word"
		TreeSet<String> next = g.getNext(word);
		String [] array = new String [next.size()];
		int i = 0;
		for(String s : next) {
			array[i] = s;
			i++;
		}
		return array;
	}
}
