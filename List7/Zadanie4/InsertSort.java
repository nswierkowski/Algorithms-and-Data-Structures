package Zadanie4;

import java.util.Comparator;

public class InsertSort<T> {
	
	private final Comparator<T> _comparator;
	private T [] array;
	
	public InsertSort(Comparator<T> comparator)
	{
		_comparator = comparator;
	}
	
	public T [] sort() {
		for (int i = 1; i < array.length; ++i) {
			T value = array[i];
			int j;
			for (j = i; j > 0 && _comparator.compare(value, array[j - 1]) < 0; --j) array[j] = array[j - 1];
			array[j] = value;
		}
		return array;
	}
	
	public void fillArray(T[] array) {
		this.array = array;
	}

}
