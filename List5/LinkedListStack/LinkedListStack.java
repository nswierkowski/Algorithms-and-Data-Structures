package LinkedListStack;

import java.util.Iterator;

import IStack.*;

public class LinkedListStack<Integer> implements IStack<Integer>{
	
	Element<Integer> head = null;
	int size = 0;
	
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
	}
	
	public boolean isEmpty() {
		// TODO: Sprawdza czy stos jest pusty
		return head == null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(isEmpty()) new EmptyStackException();
		size--;
		Element elementWhichWillBeTaken = head;
		head = head.getNext();
		return (Integer) elementWhichWillBeTaken.getValue();
	}

	@Override
	public void push(Integer elem) throws FullStackException {
		// TODO Auto-generated method stub
		size++;
		if(head == null) head = new Element(elem);
		else {
			Element next = head;
			head = new Element(elem);
			head.setNext(next);
		}
	}

	@Override
	public Integer top() throws EmptyStackException {
		// TODO Auto-generated method stub
		if(isEmpty()) new EmptyStackException();
		size--;
		return (Integer) head.getValue();
	}
}
