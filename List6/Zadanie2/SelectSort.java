package Zadanie2;

import java.util.Comparator;

public class SelectSort<T> {

	private final Comparator<T> _comparator;
	private T [] array;
	
	public SelectSort(Comparator<T> comparator) {
		_comparator = comparator;
	}
	
	public OneWayLinkedListWithHead<T> sort(OneWayLinkedListWithHead<T> list) {
		int size = list.size();
		for (int slot = 0; slot < size - 1; ++slot) {
			int smallest = slot; // pozycja wartości minimalnej
			for (int check = slot + 1; check < size; ++check)
				if (_comparator.compare(list.get(check), list.get(smallest)) < 0) smallest = check;
				swap(list, smallest, slot);
			}
		return list;
	}
	
	public OneWayLinkedListWithHead<T> sortArray(OneWayLinkedListWithHead<T> list) {
		int size = list.size();
		array = (T[]) new Object[size];
		fillArray(list);
		for (int slot = 0; slot < size - 1; ++slot) {
			int smallest = slot; 
			for (int check = slot + 1; check < size; ++check)
				if (_comparator.compare(array[check], array[smallest]) < 0) smallest = check;
				swapArray(smallest, slot);
			}
		return newList(list);
	}
	
	private void swap(OneWayLinkedListWithHead<T> list, int left, int right) {
		if (left != right) {
			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
		}
	}

	private void swapArray(int left, int right) {
		if (left != right) {
			T temp = array[left];
			array[left] = array[right];
			array[right] = temp;
		}
	}
	
	private void fillArray(OneWayLinkedListWithHead<T> list) {
		int i  = 0;
		for(T t : list) {
			array[i] = t;
			i++;
		}
		list.clear();
	}
	
	private OneWayLinkedListWithHead<T> newList(OneWayLinkedListWithHead<T> list) {
		for(int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}
}
