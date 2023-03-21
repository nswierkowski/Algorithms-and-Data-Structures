package Zadanie4;

import java.util.Comparator;

public class SelectSort<T> {

	private final Comparator<T> _comparator;
	private T [] array;
	
	public SelectSort(Comparator<T> comparator) {
		_comparator = comparator;
	}
	
	public T[] sort() {
		for (int slot = 0; slot < array.length - 1; ++slot) {
			int smallest = slot; 
			for (int check = slot + 1; check < array.length; ++check)
				if (_comparator.compare(array[check], array[smallest]) < 0) smallest = check;
				swapArray(smallest, slot);
			}
		return array;
	}
	
	private void swapArray(int left, int right) {
		if (left != right) {
			T temp = array[left];
			array[left] = array[right];
			array[right] = temp;
		}
	}
	
	public void fillArray(T[] array) {
		this.array = array;
	}
}
