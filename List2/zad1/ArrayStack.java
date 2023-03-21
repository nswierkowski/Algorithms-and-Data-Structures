package zad1;

public class ArrayStack<T> {

	private static final int DEFAULT_CAPACITY = 16;
	T array[];
	int topIndex;
	
	@SuppressWarnings("unchecked")
	public ArrayStack (int initialSize){
		array=(T[])(new Object[initialSize]);
		topIndex = 0;
	}
	
	public ArrayStack (){
		this(DEFAULT_CAPACITY);
	}
	
	public boolean isEmpty() {
		return topIndex == 0;
	}
	
	public boolean isFull() {
		return topIndex == array.length;
	}
	
	public T pop() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return array[--topIndex];
	}
	
	public void push(T elem) throws FullStackException {
		if(isFull()) throw new FullStackException();
		array[topIndex++]=elem;
	}
	

	public T top() throws EmptyStackException {
		if(isEmpty()) throw new EmptyStackException();
		return array[topIndex-1];
	}
}
