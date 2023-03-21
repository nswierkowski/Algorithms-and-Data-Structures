package Zadanie7;

import java.util.Comparator;

public class RevComparator<T extends Comparable> implements Comparator<T>{

	@Override
	public int compare(T elemL, T elemR) {
		return - elemL.compareTo(elemR);
	}

}
