package lab2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorForArray<E> implements Iterator<E>{

	private ArrayRow array[];
	private int row;
	private int col;
	private int wasAChange;
	
	public IteratorForArray(ArrayRow anArray[]) {
	    array = anArray;
	    row = 0;
	    col = 0;
	    wasAChange = 0;
	  }
	
	@Override
	public boolean hasNext() {
		if(row == array.length - 1 && col == array[row].length()) return false;
		return true;
	}

	@Override
	public E next(){
		if(hasNext() && wasAChange != 1) {
			if(col < array[row].length()) {
				col++;
				return (E) array[row].getAt(col - 1);
			}
			else if(col == array[row].length()) {
				col = 1;
				row++;
				return (E) array[row].getAt(0);
			}
		} else {
			throw new NoSuchElementException();
		}
		return null;
	}
	
	public void setChange(int change) {
		wasAChange = change;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}
