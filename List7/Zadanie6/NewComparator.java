package Zadanie6;

import java.util.Comparator;

public class NewComparator<T extends Comparable> implements Comparator<T>{

	@Override
	public int compare(T elemL, T elemR) {
		return elemL.compareTo(elemR);
	}

}
