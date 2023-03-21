package Zadanie5;

import java.util.Comparator;

public class BubbleSortChar {

	private Character [] array;
	
	public BubbleSortChar() {}
	
	public Character [] sort() {
		for (int pass = 1; pass < array.length; ++pass) {
			for(int left = 0; left < (array.length - pass); ++left) {
				int right = left + 1;
				if (array[left] > array[right]) swapArray(left, right);
			}
		}
		
		return array;
	}
	
	private void swapArray(int left, int right) {
		Character temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public void fillArray(Character[] array) {
		this.array = array;
	}
}
