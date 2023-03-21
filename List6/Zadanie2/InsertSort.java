package Zadanie2;

import java.util.Comparator;

public class InsertSort<T> {
	
	private final Comparator<T> _comparator;
	private T [] array;
	
	public InsertSort(Comparator<T> comparator)
	{
		_comparator = comparator;
	}
	
	public OneWayLinkedListWithHead<T> sort(OneWayLinkedListWithHead<T> list) {
		for (int i = 1; i < list.size(); ++i) {
			T value = list.get(i),temp;
			int j;
			for (j = i; j > 0 && _comparator.compare(value, temp=list.get(j - 1))< 0; --j) list.set(j,temp);
			list.set(j, value);
		}
		return list;
	}
	
	public OneWayLinkedListWithHead<T> sortArray(OneWayLinkedListWithHead<T> list) {
		array = (T[]) new Object[list.size()];
		fillArray(list);
		for (int i = 1; i < array.length; ++i) {
			T value = array[i];
			T temp;
			int j;
			for (j = i; j > 0 && _comparator.compare(value, array[j - 1]) < 0; --j) array[j] = array[j - 1];
			array[j] = value;
		}
		return newList(list);
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
