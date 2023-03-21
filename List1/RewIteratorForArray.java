package lab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RewIteratorForArray<E> implements Iterator<E>{

	private ArrayRow[] array;
	private int row;
	private int col;

	public RewIteratorForArray(ArrayRow anArray[]) {
		array = anArray;
		row = anArray.length - 1;
		col = array[row].length() - 1;
	}
	
	@Override
	public boolean hasNext() {
		if(row == 0 && col == -1) return false;
		return true;
	}

	@Override
	public E next() {
		if(hasNext()) {
			if(col > -1) {
				col--;
				return (E) array[row].getAt(col + 1);
			}
			else if(col == -1) {
				row--;
				col = array[row].length() - 2;
				return (E) array[row].getAt(col + 1);
			}
		} else {
			throw new NoSuchElementException();
		}
		return null;
	}

}
