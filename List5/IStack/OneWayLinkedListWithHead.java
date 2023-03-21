package IStack;

import java.util.Iterator;

public class OneWayLinkedListWithHead<E> extends AbstractList<E>{
	 
		Element<E> head = null;
		
		public OneWayLinkedListWithHead(){}
		
		public boolean isEmpty(){
			return head == null;
		}
		
		@Override
		public void clear() {
			head = null;
		}
		
		 Element getElement(int index) {
			
			if(index < 0) throw new IndexOutOfBoundsException();
			
			Element<E> actElem = head;
			
			while(index > 0 && actElem != null){
				index--;
				actElem = actElem.getNext();
			}
			
			if (actElem == null) throw new IndexOutOfBoundsException();
				return actElem;
			}
		
			@Override
			public boolean add(E e) {
				Element<E> newElem = new Element<E>(e);
				if(head == null){
					head = newElem;
					return true;
				}
			
				Element<E> tail = head;
				while(tail.getNext() != null) tail = tail.getNext();
				tail.setNext(newElem);
				return true;
			}
			
			public boolean add(Element e) {
				if(head == null){
					head = e;
					return true;
				}
			
				Element<E> tail = head;
				while(tail.getNext() != null) tail = tail.getNext();
				tail.setNext(e);
				return true;
			}
			
			@Override
			public void add(int index, E data) {
				if(index < 0) throw new IndexOutOfBoundsException();
				Element newElem = new Element(data);
				if(index == 0)
				{
					newElem.setNext(head);
					head = newElem;
					return;
				}
					Element actElem = getElement(index-1);
					newElem.setNext(actElem.getNext());
					actElem.setNext(newElem);
			}
			
			public void add(int index, Element e) {
				if(index < 0) throw new IndexOutOfBoundsException();
				if(index == 0)
				{
					e.setNext(head);
					head = e;
					return;
				}
					Element actElem = getElement(index-1);
					e.setNext(actElem.getNext());
					actElem.setNext(e);
			}
			
			@Override
			public int indexOf(E data) {
				int pos = 0;
				Element actElem = head;
				
				while(actElem != null)
				{
					if(actElem.getValue().equals(data)) return pos;
					pos++;
					actElem = actElem.getNext();
				}
				return -1;
			}
			
			@Override
			public boolean contains(E data) {
				return indexOf(data) >= 0;
			}
			
			@Override
			public E get(int index) {
				Element actElem = getElement(index);
				return (E) actElem.getValue();
			}
			
			@Override
			public E set(int index, E data) {
				Element actElem = getElement(index);
				E elemData = (E) actElem.getValue();
				actElem.setValue(data);
				return elemData;
			}
			
			@Override
			public E remove(int index) {
				if(index < 0 || head == null) throw new IndexOutOfBoundsException();
				if(index == 0){
					E retValue = head.getValue();
					head = head.getNext();
					return retValue;
				}
				Element actElem = getElement(index - 1);
				if(actElem.getNext() == null) throw new IndexOutOfBoundsException();
				E retValue = (E) actElem.getNext().getValue();
				actElem.setNext(actElem.getNext().getNext());
				return retValue;
			}
			
			@Override
			public boolean remove(E e) {
				E value = e;
				if(head==null) return false;
				if(head.getValue().equals(value)){
					head=head.getNext();
					return true;
				}
				Element actElem=head;
				while(actElem.getNext()!=null && !actElem.getNext().getValue().equals(value)) actElem=actElem.getNext();
				if(actElem.getNext()==null)	return false;
				actElem.setNext(actElem.getNext().getNext());
				return true;
			}
			
			private class InnerIterator implements Iterator<E>{
				Element actElem;
				
				public InnerIterator() {
					actElem = head;
				}
				
				@Override
				public boolean hasNext() {
					return actElem != null;
				}
				
				@Override
				public E next() {
					E value = (E) actElem.getValue();
					actElem = actElem.getNext();
					return value;
				}
			}
			
			public Iterator<E> iterator() {
				return new InnerIterator();
			}

			@Override
			public int size() {
				int pos=0;
				Element actElem=head;
				while(actElem!=null)
				{
					pos++;
					actElem = actElem.getNext();
				}
				return pos;
			}


}			
			
