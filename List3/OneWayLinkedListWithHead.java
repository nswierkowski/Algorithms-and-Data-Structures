package lab3;

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
			public boolean remove(Element e) {
				E value = (E) e.getValue();
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

			@Override
			public void reverseInPlace() {
				//odwraca kolejność elementów w liście
				
				Element<E> temp1 = null; //previous
				Element<E> temp2 = head; //current
				Element<E> temp3; // next
				
				while(temp2 != null) {
					temp3 =  temp2.getNext();
					temp2.setNext(temp1);
					temp1 = temp2;
					temp2 = temp3;
				}
				
				head = temp1;
			}

			@Override
			public IList<E> reverseCreate() {
				// tworzy obiekt nowej listy o odwróconej kolejności elementów,
				// oryginalna lista nie jest zmieniana
				IList<E> revList = new OneWayLinkedListWithHead<E>();
				
				//Kopiujemy zawartość Listy
				Element<E> actEl = head;
				while(actEl != null) {
					revList.add(actEl.getValue());
					actEl = actEl.getNext();
				}
				
				//Wykorzystujemy gotową metode by odwrócić jej zawartość
				revList.reverseInPlace();
				return revList;
			}

			@Override
			public void decimate(boolean del_even) {
				// usuwa co drugi element z listy, jeśli del_even == true usuwany
				// element o indeksach 0,2,4 .. w p.p. 1,3,5,...
				
				Element lastEl = head;
				Element actEl = head.getNext();
				Element nextEl;
				
				if(del_even) {
					nextEl = actEl.getNext();
					lastEl = actEl;
					actEl = nextEl;
					head = lastEl;
				}
				
				while(actEl != null) {
					nextEl = actEl.getNext();
					lastEl.setNext(nextEl);
					lastEl = actEl;
					actEl = nextEl;
				}	
			}

			@Override
			public int moveToBegin(Element e) {
				// przesuwa na początek listy wszystkie elementy równe e; zwraca
				// liczbę przesuniętych elementów
				
				E value = (E) e.getValue();
				int numberOfElement = 0;
				Element firstEl = head;
				Element lastElWithNoValueE = null;
				
				Element actEl = head;
				Element nextEl;
				
				while(actEl != null) {
					nextEl =  actEl.getNext();
					if(actEl.getValue().equals(value)) {
						remove(actEl);
						numberOfElement++;
					}	
					actEl = nextEl;
				}
									
				for(int i = 0; i < numberOfElement; i++) {
					add(0, value);
				}
				
				return numberOfElement;
			}

			@Override
			public IList<E> merge(IList<E> other, boolean append) {
				// tworzy nowy obiekt listy będący połączeniem samej siebie i listy
				// other, jeśli append==true to other dołączany jest na końcu,
				// w p.p. na początku
				
				IList<E> list = new OneWayLinkedListWithHead();
				
				if(append) {
					for(int i = 0; i < size(); i++) {
						list.add(get(i));
					}
					for(int i = 0; i < other.size(); i++) {
						list.add(other.get(i));
					}
				}
				else {
					for(int i = 0; i < other.size(); i++) {
						list.add(other.get(i));
					}
					for(int i = 0; i < size(); i++) {
						list.add(get(i));
					}
				}
				return list;
			}

			@Override
			public IList<E> sublist(int start_ind, int end_ind) {
				// tworzy nową listę zawierającą element o indeksach od start_ind do
				// end_ind, jeśli start_ind jest powyżej size to zwracana jest lista
				// pusta, jeśli end_ind jest powyżej size to zwracane są elementy od
				// start_ind do końca listy.
				
				IList<E> list = new OneWayLinkedListWithHead<E>();
				if(start_ind >= size()) return list;
				for(int i = start_ind; i <= Math.min(end_ind, size()-1); i++) {
					list.add(get(i));
				}
				return list;
			}
			
}			
			
