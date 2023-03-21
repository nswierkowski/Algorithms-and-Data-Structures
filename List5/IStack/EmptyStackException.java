package IStack;

public class EmptyStackException extends Exception{

	public EmptyStackException() {
		System.out.println("Stos jest pusty - nie można pobrać wartości");
	}
}
