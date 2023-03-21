package lab2;

import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Unbalanced2DArray<E> implements Iterable<E>{
	
	int wasAChange;
	ArrayRow [] array;
	
	Unbalanced2DArray( int row_cnt ){
	// tworzy tablicę o zadanej liczbie wierszy, każdy wiersz
	// początkowo jest pusty
		array = new ArrayRow[row_cnt]; 
		wasAChange = 0;
	}
	
	void insertRow( int pos ) throws ArrayIndexOutOfBoundsException {
	// wstawia wiersz tak aby po wstawieniu, jego indeks był
	// równy pos, rzuca wyjątek jeśli pos > size
		if(wasAChange == -1) wasAChange = 1;
		array[pos] = new ArrayRow(1);
	}
	
	void setRowSize( int row_ind, int new_size ) throws ArrayIndexOutOfBoundsException {
	// zmienia rozmiar wskazanego wiersza, istniejące elementy
	// wiersza powinny zostać przepisane
		if(row_ind >= array.length || row_ind < 0) throw new ArrayIndexOutOfBoundsException();
		if(wasAChange == -1) wasAChange = 1;
		if(array[row_ind] == null)  array[row_ind] = new ArrayRow(1);
		array[row_ind].resize(new_size);
	}
	
	void deleteRow( int row_ind ) throws ArrayIndexOutOfBoundsException {
	// usuwa wskazany wiersz, rzuca wyjątek w przypadku
	// nieprawidłowego indeksu
		if(row_ind >= array.length || row_ind < 0) throw new ArrayIndexOutOfBoundsException();
		if(wasAChange == -1) wasAChange = 1;
		ArrayRow [] newArray = new ArrayRow[array.length - 1];
		for(int i = 0; i < array.length; i++) {
			if(i < row_ind) newArray[i] = array[i];
			else if(i > row_ind) newArray[i - 1] = array[i]; 
		}
		array = newArray;
	}
	
	void setAt( int row_ind, int col_ind, E e ) throws ArrayIndexOutOfBoundsException {
	// przypisuje wartość na wskazanej pozycji tablicy,
	// rzuca wyjątek w przypadku nieprawidłowych indeksów
		if(row_ind >= array.length || row_ind < 0 || col_ind >= array[row_ind].length() || col_ind < 0) throw new ArrayIndexOutOfBoundsException();
		if(wasAChange == -1) wasAChange = 1;
		array[row_ind].setAt(col_ind, e);
	}
	
	E getAt( int row_ind, int col_ind ) throws ArrayIndexOutOfBoundsException {
	// pobiera wartość ze wskazanej pozycji tablicy, rzuca
	// wyjątek w przypadku nieprawidłowych indeksów;
		if(row_ind < array.length || row_ind >= 0 || col_ind < array[row_ind].length() || col_ind >= 0) throw new ArrayIndexOutOfBoundsException();
		return (E) array[row_ind].getAt(col_ind);
	}
	
	public Iterator<E> iterator(){
		//if(wasAChange == 1) throw new ConcurrentModificationException(); 
		//else if(wasAChange == 0) wasAChange = -1;
		return new IteratorForArray(array);
	}
	// zwraca zwykły iterator
	
	Iterator<E> rewIterator() {
		//if(wasAChange == 1) throw new ConcurrentModificationException(); 
		//else if(wasAChange == 0) wasAChange = -1;
		return new RewIteratorForArray(array);
	// zwraca iterator odwrotny
	}

	ArrayRow[] getArray() {
		return array;
	}
	
	int length() {
		return array.length;
	}
}
