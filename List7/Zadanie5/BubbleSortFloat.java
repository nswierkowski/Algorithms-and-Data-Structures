package Zadanie5;

import java.util.Comparator;

public class BubbleSortFloat {

	private Float [] array;
	
	public BubbleSortFloat() {}
	
	public Float [] sort() {
		for (int pass = 1; pass < array.length; ++pass) {
			for(int left = 0; left < (array.length - pass); ++left) {
				int right = left + 1;
				if (array[left] > array[right]) swapArray(left, right);
			}
		}
		
		return array;
	}
	
	private void swapArray(int left, int right) {
		float temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public void fillArray(Float[] array) {
		this.array = array;
	}
}
