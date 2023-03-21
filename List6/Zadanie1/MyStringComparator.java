package Zadanie1;

import java.util.Comparator;

public class MyStringComparator implements Comparator<MyString>{

	@Override
	public int compare(MyString arg0, MyString arg1) {
		return arg0.myCompareTo(arg1);
	}

}
