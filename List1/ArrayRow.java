package lab2;

import java.lang.reflect.Array;

public class ArrayRow<E> {

	E [] rows;
	
	@SuppressWarnings("unchecked")
	ArrayRow( int len ){
		rows = (E []) new Object [len]; 
	}
	
	void resize( int new_len ) {
		E [] newRows = (E []) new Object [new_len];
		for(int i = 0; i < Math.min(newRows.length, rows.length); i++) {
			if(rows[i] != null) newRows[i] = rows[i]; 
		}
		rows = newRows;
	}
	
	void setAt( int pos, E e ) throws ArrayIndexOutOfBoundsException{
		rows[pos] = e;
	}
	
	E getAt( int pos ) throws ArrayIndexOutOfBoundsException{
		return rows[pos];
	}
	
	int length() {
		//metoda moja
		return rows.length;
	}
}