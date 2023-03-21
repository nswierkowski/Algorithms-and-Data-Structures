package Zadanie5;

import java.util.Comparator;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		CompareAlgorithms ca = new CompareAlgorithms(30000);
		ca.compareChar(20);
		System.out.println("\n");

		System.out.println("40000");
		ca.setSize(40000);
		ca.compareChar(20);
		System.out.println("\n");
		
		System.out.println("50000");
		ca.setSize(50000);
		ca.compareChar(20);
		System.out.println("\n");
		
		System.out.println("60000");
		ca.setSize(60000);
		ca.compareChar(20);
		System.out.println("\n");
		
		System.out.println("70000");
		ca.setSize(70000);
		ca.compareChar(20);
		System.out.println("\n");
		
		System.out.println("80000");
		ca.setSize(80000);
		ca.compareChar(20);
		System.out.println("\n");
		
		System.out.println("90000");
		ca.setSize(90000);
		ca.compareChar(20);
		System.out.println("\n");
		
		System.out.println("100000");
		ca.setSize(100000);
		ca.compareChar(20);
		System.out.println("\n");
		
	}

}
