package Zadanie5;

import java.util.Comparator;

public class BubbleSortInteger {

	private Integer [] array;
	
	public BubbleSortInteger() {}
	
	public Integer [] sort() {
		for (int pass = 1; pass < array.length; ++pass) {
			for(int left = 0; left < (array.length - pass); ++left) {
				int right = left + 1;
				if (array[left] > array[right]) swapArray(left, right);
			}
		}
		
		return array;
	}
	
	private void swapArray(int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public void fillArray(Integer[] array) {
		this.array = array;
	}
}
