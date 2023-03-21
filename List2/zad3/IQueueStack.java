package zad3;

import zad1.ArrayStack;
import zad1.EmptyStackException;

public class IQueueStack<T> implements IQueue{

	ArrayStack<T> firstArray;
	ArrayStack<T> secondArray;
	
	@Override
	public boolean isEmpty() {
		if(firstArray.isEmpty() || secondArray.isEmpty()) return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(firstArray.isFull() || secondArray.isFull()) return true;
		return false;
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		return null;
	}

	@Override
	public void enqueue(Object elem) throws FullQueueException {
		
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public T first() throws EmptyQueueException {
		return null;
	}

}
