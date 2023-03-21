package Zadanie2;

import java.util.Comparator;

public class BubbleSort<T> {

	private final Comparator<T> _comparator;
	private T [] array;
	
	public BubbleSort() { 
		_comparator = null;
	}
	
	public BubbleSort(Comparator<T> comparator) { 
		_comparator = comparator;
	}
	
	public OneWayLinkedListWithHead<T> sort(OneWayLinkedListWithHead<T> list) {
		int size = list.size();
		for (int pass = 1; pass < size; ++pass) {
			for (int left = 0; left < (size - pass); ++left) {
				int right = left + 1;
				if (_comparator.compare(list.get(left), list.get(right)) > 0) swap(list, left, right);
			}
		}
		return list;
	}
	
	private void swap(OneWayLinkedListWithHead<T> list, int left, int right) {
		T temp = list.get(left);
		list.set(left, list.get(right));
		list.set(right, temp);
	}
	
	public OneWayLinkedListWithHead<T> sortArray(OneWayLinkedListWithHead<T> list) {
		int size = list.size();
		array = (T[]) new Object[size];
		fillArray(list);
		
		for (int pass = 1; pass < size; ++pass) {
			for(int left = 0; left < (size - pass); ++left) {
				int right = left + 1;
				if (_comparator.compare(array[left], array[right]) > 0) swapArray(left, right);
			}
		}
		
		return newList(list);
	}
	
	private void swapArray(int left, int right) {
		T temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	private void fillArray(OneWayLinkedListWithHead<T> list) {
		int i = 0;
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
