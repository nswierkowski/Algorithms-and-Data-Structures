package Zadanie1;

public class MyString implements Comparable<MyString>{

	String inner_string;
	
	public MyString( String inner_string ) {
		this.inner_string = inner_string;
	}
	
	public int myCompareTo( MyString other_string ) {
		for(int i = 0; i < Math.min(inner_string.length(), other_string.inner_string.length()); i++) {
			if(inner_string.charAt(i) != other_string.inner_string.charAt(i)) return (int)inner_string.charAt(i) - (int)other_string.inner_string.charAt(i);
		}
		return inner_string.length() - other_string.inner_string.length();
	}
	
	public String toString() {
		return inner_string;
	}

	@Override
	public int compareTo(MyString arg0) {
		return inner_string.compareTo(arg0.inner_string);
	}
}
