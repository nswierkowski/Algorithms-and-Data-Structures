package Zadanie3;

import java.util.Comparator;

public class NewComparator<T extends Comparable> implements Comparator<T>{

	@Override
	public int compare(T arg0, T arg1) {
		return arg0.compareTo(arg1);
	}

}
