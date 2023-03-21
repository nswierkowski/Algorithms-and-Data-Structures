package Zadanie2;

import java.util.Iterator;

public interface IList<E> extends Iterable<E> {
	// FUNKCJONALNOŚĆ PODSTAWOWA
	
	boolean add(E e);
	// dodanie elementu na koniec listy
	
	void clear();
	// skasowanie wszystkich elementów
	
	boolean contains(E element);
	// czy lista zawiera podany element (equals())
	
	E get(int index);
	// pobranie elementu z podanej pozycji
	
	E set(int index, E element);
	// ustawienie nowej wartości na pozycji
	
	int indexOf(E element);
	// pozycja szukanego elementu (equals())
	
	boolean isEmpty();
	// czy lista jest pusta
	
	Iterator<E> iterator();
	// zwraca iterator przed pierwszą pozycją
	
	E remove(int index);
	// usuwa element z podanej pozycji
	
	boolean remove(E e);
	// usuwa element (equals())
	
	int size(); // rozmiar listy
	
}