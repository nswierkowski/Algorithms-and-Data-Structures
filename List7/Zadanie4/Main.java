package Zadanie4;

import java.util.Comparator;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		CompareAlgorithms<Float> ca = new CompareAlgorithms<Float>(80000);
		ca.generateInteger();
		NewComparator<Float> comparator = new NewComparator<Float>();
		ca.compare(comparator, 20);
		System.out.println("\n");
		
		CompareAlgorithms<Float> ca2 = new CompareAlgorithms<Float>(90000);
		ca2.generateInteger();
		ca2.compare(comparator, 20);
		System.out.println("\n");
		
		CompareAlgorithms<Float> ca21 = new CompareAlgorithms<Float>(100000);
		ca21.generateInteger();
		ca21.compare(comparator, 20);
		System.out.println("\n");

	}

}
