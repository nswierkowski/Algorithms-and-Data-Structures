package zad1;

public class VelosoStack<T> extends ArrayStack<T>{

	private static final int DEFAULT_CAPACITY = 16;
	T array[];
	int topIndex;
	int pointer;
	
	@SuppressWarnings("unchecked")
	public VelosoStack (int initialSize){
		array=(T[])(new Object[initialSize]);
		topIndex = 0;
	}
	
	public VelosoStack (){
		this(DEFAULT_CAPACITY);
	}
	
	public boolean isEmpty() {
		return topIndex == 0;
	}
	
	public boolean isFull() {
		return topIndex == array.length;
	}
	
	public T pop() throws EmptyStackException {
		pointer = 0;
		if(isEmpty()) throw new EmptyStackException();
		return array[--topIndex];
	}
	
	public void push(T elem) throws FullStackException {
		pointer = 0;
		if(isFull()) throw new FullStackException();
		array[topIndex++]=elem;
	}
	
	public int size() {
		return topIndex;
	}
	
	public T top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return array[topIndex-1];
	}
	
	public void down() {
		if(pointer < array.length) {
			if(pointer == array.length - 1) System.out.println("Wskaźnik jest na dole stosu");
			pointer++;
		}
		else {
			System.out.println("Wskaźnik jest już na dole stosu");
		}
	}
	
	public void top1() {
		pointer = array.length - 1;
	}
	
	public T peek() {
		if(pointer >= array.length) new ArrayIndexOutOfBoundsException();
		return array[pointer];
	}
}
