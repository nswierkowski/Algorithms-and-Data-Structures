package Zadanie6;

public class Main {

	public static void main(String[] args) {
		CompareAlgorithms<Float> ca = new CompareAlgorithms<Float>(6000000);
		ca.generateFloat();
		ca.compare(20);
		System.out.println("\n");

		
	}

}
