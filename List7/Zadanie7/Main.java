package Zadanie7;

public class Main {

	public static void main(String[] args) {
		CompareAlgorithms<Integer> ca = new CompareAlgorithms<Integer>(12000000);
		ca.generateInt();
		ca.compare(20);
		System.out.println("\n");
	}

}
