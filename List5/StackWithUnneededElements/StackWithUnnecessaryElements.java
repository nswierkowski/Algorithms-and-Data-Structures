package StackWithUnneededElements;

import IStack.Element;
import IStack.EmptyStackException;
import IStack.FullStackException;
import IStack.IStack;

public class StackWithUnnecessaryElements<Integer> implements IStack<Integer>{

	Element<Integer> head = null;
	Element<Integer> headUnnecessary = null;
	int size = 0;
	int sizeUnnecessary = 0;
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
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
		if(headUnnecessary == null) {
			headUnnecessary = head;
			head = head.getNext();
			headUnnecessary.setNext(null);
		}
		else {
			Element elementWhichWillBeTaken = head;
			head = head.getNext();
			elementWhichWillBeTaken.setNext(headUnnecessary);
			headUnnecessary = elementWhichWillBeTaken;
		}
		return (Integer) headUnnecessary.getValue();
	}

	@Override
	public void push(Integer elem) throws FullStackException {
		// TODO Auto-generated method stub
		size++;
		if(headUnnecessary == null) {
			Element newElement = new Element(elem);
			newElement.setNext(head);
			head = newElement;
		}
		else {
			Element newElement = headUnnecessary;
			sizeUnnecessary--;
			if(sizeUnnecessary > 0) {
				headUnnecessary = headUnnecessary.getNext();
				newElement.setNext(head);
				head = newElement;
			}
			else {
				headUnnecessary = null;
				newElement.setNext(head);
				head = newElement;
			}
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public int sizeUnnecessary() {
		// TODO Auto-generated method stub
		return sizeUnnecessary;
	}
	
	@Override
	public Integer top() throws EmptyStackException {
		// TODO Zwraca bez utraty element stosu
		if(isEmpty()) new EmptyStackException();
		return (Integer) head.getValue();
	}

}
