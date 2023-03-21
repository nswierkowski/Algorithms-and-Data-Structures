package Zadanie4;

import java.util.Comparator;

public class BubbleSort<T> {

	private final Comparator<T> _comparator;
	private T [] array;
	
	public BubbleSort(Comparator<T> comparator) { 
		_comparator = comparator;
	}
	
	public T [] sort() {
		for (int pass = 1; pass < array.length; ++pass) {
			for(int left = 0; left < (array.length - pass); ++left) {
				int right = left + 1;
				if (_comparator.compare(array[left], array[right]) > 0) swapArray(left, right);
			}
		}
		
		return array;
	}
	
	private void swapArray(int left, int right) {
		T temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public void fillArray(T[] array) {
		this.array = array;
	}
}
