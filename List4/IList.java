package lab4;

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
	
	
	// ===================================================
	// FUNKCJONALNOŚĆ ROZSZERZONA
	// ===================================================
	
	void reverseInPlace();
	// odwraca kolejność elementów w liście
	
	IList<E> reverseCreate();
	// tworzy obiekt nowej listy o odwróconej kolejności elementów,
	// oryginalna lista nie jest zmieniana
	
	void decimate( boolean del_even );
	// usuwa co drugi element z listy, jeśli del_even == true usuwany
	// element o indeksach 0,2,4 .. w p.p. 1,3,5,...
	
	int moveToBegin(E e );
	// przesuwa na początek listy wszystkie elementy równe e; zwraca
	// liczbę przesuniętych elementów
	
	IList<E> merge( IList<E> other, boolean append );
	// tworzy nowy obiekt listy będący połączeniem samej siebie i listy
	// other, jeśli append==true to other dołączany jest na końcu,
	// w p.p. na początku
	
	IList<E> sublist( int start_ind, int end_ind );
	// tworzy nową listę zawierającą element o indeksach od start_ind do
	// end_ind, jeśli start_ind jest powyżej size to zwracana jest lista
	// pusta, jeśli end_ind jest powyżej size to zwracane są elementy od
	// start_ind do końca listy.
	
	Iterator<E> revIterator();
	//Zwrava iterator odwrotny
	
}