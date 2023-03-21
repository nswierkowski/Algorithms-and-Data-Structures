package ArraysLinkedListStack;

import IStack.Element;
import IStack.EmptyStackException;
import IStack.FullStackException;
import IStack.IStack;

public class ArraysLinkedLinkStack implements IStack<Integer>{

	Element<int []> head = null;
	int size = 0;
	int pointer = 0;
	
	@Override
	public boolean isEmpty() {
		// TODO Sprawdza czy lista jest pusta
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
		pointer--;
		if(pointer != -1) {
			return head.getValue()[pointer + 1];
		}
		else {
			head = head.getNext();
			pointer = 1023;
			return head.getValue()[pointer];
		}
		
	}

	@Override
	public void push(Integer elem) throws FullStackException {
		// TODO Auto-generated method stub
		size++;
		pointer++;
		if(head == null) {
			int [] array = new int [1024];
			array[0] = elem;
			head = new Element(array);
		}
		else {
			if(pointer != 1024) {
				head.getValue()[pointer - 1] = elem;
			}
			else {
				pointer = 0;
				int [] array = new int [1024];
				array[pointer] = elem;
				Element newElement = new Element(array);
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

	@Override
	public Integer top() throws EmptyStackException {
		// TODO Auto-generated method stub
		return head.getValue()[pointer];
	}
	
}
