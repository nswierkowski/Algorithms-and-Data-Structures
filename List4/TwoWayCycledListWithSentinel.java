package lab4;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TwoWayCycledListWithSentinel<E> extends AbstractList<E>{

	private class Element{
		
		private E value;
		private Element next;
		private Element prev;
		
		public E getValue() {
			return value; 
		}
		
		public void setValue(E value) {
			this.value = value; 
		}
		
		public Element getNext() {
			return next;
		}
		
		public void setNext(Element next) {
			this.next = next;
		}
		
		public Element getPrev() {
			return prev;
		}
		
		public void setPrev(Element prev) {
			this.prev = prev;
		}
		
		Element(E data){
			this.value=data;
		}
		/** elem będzie stawiony <b> za this </b>*/
		
		public void insertAfter(Element elem){
			elem.setNext(this.getNext());
			elem.setPrev(this);
			this.getNext().setPrev(elem);
			this.setNext(elem);
		}
			/** elem będzie stawiany <b> przed this </b>*/
		
		public void insertBefore(Element elem){
			elem.setNext(this);
			elem.setPrev(this.getPrev());
			this.getPrev().setNext(elem);
			this.setPrev(elem);
		}
		/** elem będzie usuwany z listy w której jest <p>
		* <b>Założenie:</b> element jest już umieszczony w liście i nie jest to sentinel */
		
		public void remove(){
			this.getNext().setPrev(this.getPrev());
			this.getPrev().setNext(this.getNext());
			}
		}
	
	Element sentinel = null;
	List<change>iterators;
	
	public TwoWayCycledListWithSentinel() {
		sentinel= new Element(null);
		sentinel.setNext(sentinel);
		sentinel.setPrev(sentinel);
		iterators = new ArrayList<change>();
	}
	
	private Element getElement(int index){
		if(index<0) throw new IndexOutOfBoundsException();
		Element elem=sentinel.getNext();
		int counter=0;
		while(elem!=sentinel && counter<index){
			counter++;
			elem=elem.getNext();
		}
		if(elem==sentinel) throw new IndexOutOfBoundsException();
		return elem;
		}
	
	private Element getSentinel() {
		return sentinel;
	}
	
	private Element getElement(E value){
		Element elem=sentinel.getNext();
		while(elem!=sentinel && !value.equals(elem.getValue())){
			elem=elem.getNext();
		}
		if(elem==sentinel)	return null;
		return elem;
		}
	
	public boolean isEmpty() {
		return sentinel.getNext()==sentinel;
	}
		
	public void clear() {
		sentinel.setNext(sentinel);
		sentinel.setPrev(sentinel);
	}
		
	public boolean contains(E value) {
		return indexOf(value)!=-1;
	}
		
	public E get(int index) {
		Element elem=getElement(index);
		return elem.getValue();
	}
	
	public E set(int index, E value) {
		Element elem=getElement(index);
		E retValue=elem.getValue();
		elem.setValue(value);
		change();
		return retValue;
	}
		
	public boolean add(E value) {
		Element newElem=new Element(value);
		sentinel.insertBefore(newElem);
		change();
		return true;
	}
		
	public boolean add(int index, E value) {
		Element newElem=new Element(value);
		if(index==0) sentinel.insertAfter(newElem);
		else{
			Element elem=getElement(index-1);
			elem.insertAfter(newElem);
		}
		change();
		return true;
		}
	
	public int indexOf(E value) {
		Element elem=sentinel.getNext();
		int counter=0;
		while(elem!=sentinel && !elem.getValue().equals(value)) {
			counter++;
			elem=elem.getNext();
		}
		if(elem==sentinel) return -1;
		return counter;
		}
		
	public E remove(int index) {
		Element elem=getElement(index);
		elem.remove();
		change();
		return elem.getValue();
	}
			
	public boolean remove(E value) {
		Element elem=getElement(value);
		if(elem==null) return false;
		elem.remove();
		change();
		return true;
	}
			
	public int size() {
		Element elem=sentinel.getNext();
		int counter=0;
		while(elem!=sentinel){
			counter++;
			elem = elem.getNext();
		}
			return counter;
	}
			
	public Iterator<E> iterator() {
		Iterator<E> it = new TWCIterator();
		iterators.add((change) it);
		return it;
	}
	
	private class TWCIterator implements Iterator<E>, change{
		Element _current=sentinel;
		boolean wasAChange = false;
		
		public void change() {
			wasAChange = true;
		}
		
		public boolean hasNext() throws ConcurrentModificationException{
			if(wasAChange) throw new ConcurrentModificationException();
			return _current.getNext()!=sentinel;
		}
		
		public E next() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			_current=_current.getNext();
			return _current.getValue();
		}
		
	}
		
	public ListIterator<E> listIterator() {
		ListIterator<E> li = new TWCListIterator();
		iterators.add((change) li);
		return li;
	}
		
	private class TWCListIterator implements ListIterator<E>, change{
		boolean wasNext=false;
		boolean wasPrevious=false;
		/** strażnik */
		Element _current=sentinel;
		boolean wasAChange = false;
		
		public void change() {
			wasAChange = true;
		}
		
		public boolean hasNext() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			return _current.getNext()!=sentinel;
		}
		
		public boolean hasPrevious() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			return _current!=sentinel;
		}
		
		public int nextIndex() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			throw new UnsupportedOperationException();
		}
		
		public int previousIndex() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			throw new UnsupportedOperationException();
		}
		
		public E next() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			wasNext=true;
			wasPrevious=false;
			_current=_current.getNext();
			return _current.getValue();
		}
			
		public E previous() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			wasNext=false;
			wasPrevious=true;
			E retValue=_current.getValue();
			_current=_current.getPrev();
			return retValue;
		}
		
		public void remove() throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			if(wasNext){
				Element curr=_current.getPrev();
				_current.remove();
				_current=curr;
				wasNext=false;
			}
			if(wasPrevious){
				_current.getNext().remove();
				wasPrevious=false;
			}
		}
			
		public void add(E data) throws ConcurrentModificationException{
			if(wasAChange) new ConcurrentModificationException();
			Element newElem=new Element(data);
			_current.insertAfter(newElem);
			_current=_current.getNext();
		}
		
			public void set(E data) throws ConcurrentModificationException{
				if(wasAChange) new ConcurrentModificationException();
				if(wasNext){
					_current.setValue(data);
					wasNext=false;
				}
				if(wasPrevious){
					_current.getNext().setValue(data);
					wasNext=false;
					}
				}
	}

	@Override
	public void reverseInPlace() {
		// odwraca kolejność elementów w liście
		TwoWayCycledListWithSentinel<E> revList = new TwoWayCycledListWithSentinel<E>();
		Element lastElement = sentinel;
		Element nextElement = lastElement.getPrev();
		while(nextElement != sentinel) {
			revList.add(nextElement.getValue());
			lastElement = nextElement;
			nextElement = lastElement.getPrev();
		}
		
		change();
		sentinel = revList.getSentinel();
	}

	@Override
	public IList<E> reverseCreate() {
		// tworzy obiekt nowej listy o odwróconej kolejności elementów,
		// oryginalna lista nie jest zmieniana
		TwoWayCycledListWithSentinel<E> revList = new TwoWayCycledListWithSentinel<E>();
		Element lastElement = sentinel;
		Element nextElement = lastElement.getPrev();
		while(nextElement != sentinel) {
			revList.add(nextElement.getValue());
			lastElement = nextElement;
			nextElement = lastElement.getPrev();
		}
		
		return revList;
	}

	@Override
	public void decimate(boolean del_even) {
		// usuwa co drugi element z listy, jeśli del_even == true usuwany
		// element o indeksach 0,2,4 .. w p.p. 1,3,5,...
		TwoWayCycledListWithSentinel<E> newList = new TwoWayCycledListWithSentinel<E>();
		Element actualElement = sentinel.getNext();
		
		int k = 0;
		if(del_even) {
			k = 1;
		}
		int i = 0;
		while(actualElement != sentinel) {
			if(i%2 == k) newList.add(actualElement.getValue());
			actualElement = actualElement.getNext();
			i++;
		}
		
		change();
		sentinel = newList.getSentinel();
	}
	

	@Override
	public int moveToBegin(E e) {
		// przesuwa na początek listy wszystkie elementy równe e; zwraca
		// liczbę przesuniętych elementów
		int number = 0;
		Element actualElement = sentinel.getNext();
		Element nextElement = actualElement;
		Element firstElement = sentinel;
		while(actualElement != sentinel) {
			nextElement = nextElement.getNext();
			if(actualElement.getValue().equals(e)) {
				Element newElement = new Element(e);
				sentinel.insertAfter(newElement);
				actualElement.getPrev().setNext(actualElement.getNext());
				actualElement.getNext().setPrev(actualElement.getPrev());
				if(number == 0) firstElement = newElement;
				number++;
			}
			actualElement = nextElement;
		}

		change();
		return number;
	}

	@Override
	public IList<E> merge(IList<E> other, boolean append) {
		// tworzy nowy obiekt listy będący połączeniem samej siebie i listy
		// other, jeśli append==true to other dołączany jest na końcu,
		// w p.p. na początku
		TwoWayCycledListWithSentinel<E> newList = new TwoWayCycledListWithSentinel<E>();
		Element actualElement = sentinel.getNext();
		
		if(append) {
			while(actualElement != sentinel) {
				newList.add(actualElement.getValue());
				actualElement = actualElement.getNext();
			}
			for(E e : other) {
				newList.add(e);
			}
		}
		else {
			for(E e : other) {
				newList.add(e);
			}
			while(actualElement != sentinel) {
				newList.add(actualElement.getValue());
				actualElement = actualElement.getNext();
			}
		}
		return newList;
	}

	@Override
	public IList<E> sublist(int start_ind, int end_ind) {
		// tworzy nową listę zawierającą element o indeksach od start_ind do
		// end_ind, jeśli start_ind jest powyżej size to zwracana jest lista
		// pusta, jeśli end_ind jest powyżej size to zwracane są elementy od
		// start_ind do końca listy.
		TwoWayCycledListWithSentinel<E> newList = new TwoWayCycledListWithSentinel<E>();
		if(start_ind >= size()) return newList;
		int i = 0;
		Element actualElement = sentinel.getNext();
		while(i <= end_ind && actualElement != sentinel) {
			if(i >= start_ind) {
				newList.add(actualElement.getValue());
			}
			i++;
			actualElement = actualElement.getNext();
		}
		
		return newList;
	}

	@Override
	public Iterator<E> revIterator() {
		// TODO Auto-generated method stub
		Iterator<E> it = new RevIterator<E>();
		iterators.add((change) it);
		return it;
	}	
	
	public void change() {
		if(!iterators.isEmpty()) {
			for(change t : iterators) {
				t.change();
			}
		}
	}
	
	private class RevIterator<E> implements Iterator<E>, change {
		Element current;
		boolean wasAChange;
		
		public RevIterator(){
			current = sentinel;
			wasAChange = false;
		}
		
		public boolean hasNext() throws ConcurrentModificationException{
			if(wasAChange) throw new ConcurrentModificationException();
			return current.getPrev() != sentinel && !wasAChange;
		}
	
		public void change() {
			wasAChange = true;
		}
		
		public E next() throws ConcurrentModificationException{
			if(wasAChange) throw new ConcurrentModificationException();
			current = current.getPrev();
			return (E) current.getValue();
		}
	
		public void remove() throws ConcurrentModificationException{
			if(wasAChange) throw new ConcurrentModificationException();
			if(current.getNext() != sentinel) current.getNext().remove();
			else throw new UnsupportedOperationException();
		}
	}
}
