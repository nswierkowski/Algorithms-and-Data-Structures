package zad2;

import zad1.ArrayStack;
import zad1.EmptyStackException;
import zad1.FullStackException;

public class StackWithReverse<T> extends ArrayStack<T>{

	private static final int DEFAULT_CAPACITY = 16;
	T array[];
	int topIndex;
	
	@SuppressWarnings("unchecked")
	public StackWithReverse (int initialSize){
		array=(T[])(new Object[initialSize]);
		topIndex = 0;
	}
	
	public StackWithReverse (){
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
	
	public StackWithReverse<T> reverse() throws FullStackException, EmptyStackException {
		StackWithReverse<T> revList = new StackWithReverse();
		while(!isEmpty()) {
			revList.push(pop());
		}
		
		return revList;
	}
}
