package Zadanie1;

import java.util.Comparator;

public class BubbleSort<T extends Comparable<T>> {

	T[] t;
	
	public BubbleSort(T[] t) {
		this.t = t;
	}
	
	public T[] bubbleSort() {
		int x = t.length - 1;
		for(int j = 0; j < t.length; j++) {	
			for(int i = 0; i < x; i++) {
				swap(i, i+1, t[i].compareTo(t[i+1]));	
			}
			x = x - j;
		}
		return t;
	}
	
	public T[] bubbleSort(Comparator comparator) {
		int x = t.length - 1;
		for(int j = 0; j < t.length; j++) {	
			for(int i = 0; i < x; i++) {
				swap(i, i+1, comparator.compare(t[i], t[i+1]));	
			}
			x = x - j;
		}
		return t;
	}
	
	public void swap(int firstIndex, int secondIndex, int compareTo) {
		if(compareTo <= 0) {
			return;
		}
		else {
			T element = (T) t[firstIndex];
			t[firstIndex] = t[secondIndex];
			t[secondIndex] = element;
		}
	}
	

}
