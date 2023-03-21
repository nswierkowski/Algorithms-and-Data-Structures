package Zadanie5;

import java.util.Comparator;

public class InsertSortChar {
	
	private Character [] array;
	
	public InsertSortChar(){}
	
	public Character [] sort() {
		for (int i = 1; i < array.length; ++i) {
			char value = array[i];
			int j;
			for (j = i; j > 0 && value < array[j - 1]; --j) array[j] = array[j - 1];
			array[j] = value;
		}
		return array;
	}
	
	public void fillArray(Character [] array) {
		this.array = array;
	}

}
