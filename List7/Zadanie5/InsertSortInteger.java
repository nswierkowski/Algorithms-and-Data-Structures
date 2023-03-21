package Zadanie5;

import java.util.Comparator;

public class InsertSortInteger {
	
	private Integer [] array;
	
	public InsertSortInteger(){}
	
	public Integer [] sort() {
		for (int i = 1; i < array.length; ++i) {
			int value = array[i];
			int j;
			for (j = i; j > 0 && value < array[j - 1]; --j) array[j] = array[j - 1];
			array[j] = value;
		}
		return array;
	}
	
	public void fillArray(Integer [] array) {
		this.array = array;
	}

}
