package Zadanie1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		sortStrings();
		sortMyStrings();
		sortMyStringsWithComparator();
	}
	
	static void sortStrings() {
		String [] strings = new String[10];
		
		strings[0] = "Alicja";
		strings[1] = "Alicj";
		strings[2] = "Alic";
		strings[3] = "Ali";
		strings[4] = "Al";
		strings[5] = "A";
		strings[6] = "Marek";
		strings[7] = "Franek";
		strings[8] = "Ewa";
		strings[9] = "Przemek";
		
		long startTime1 = System.nanoTime();
		BubbleSort<String> bs1 = new BubbleSort<String>(strings);
		strings = bs1.bubbleSort();
		long endTime1 = System.nanoTime();
		System.out.println("Czas jaki zajeło posortowanie zwykłych obiektów typu String " + (endTime1 - startTime1));
		
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println("\n");
		
	}
	
	static void sortMyStrings() {
		MyString [] myStrings = new MyString[10];
		
		myStrings[0] = new MyString("Alicja");
		myStrings[1] = new MyString("Alicj");
		myStrings[2] = new MyString("Alic");
		myStrings[3] = new MyString("Ali");
		myStrings[4] = new MyString("Al");
		myStrings[5] = new MyString("A");
		myStrings[6] = new MyString("Marek");
		myStrings[7] = new MyString("Franek");
		myStrings[8] = new MyString("Ewa");
		myStrings[9] = new MyString("Przemek");
		
		long startTime2 = System.nanoTime();
		BubbleSort<MyString> bs2 = new BubbleSort<MyString>(myStrings);
		myStrings = bs2.bubbleSort();
		long endTime2 = System.nanoTime();
		System.out.println("Czas jaki zajeło posortowanie MyString z natywną metodą compareTo " + (endTime2 - startTime2));
		
		for(int i = 0; i < myStrings.length; i++) {
			System.out.println(myStrings[i]);
		}
		System.out.println("\n");
	}
	
	static void sortMyStringsWithComparator() {
		MyString [] myStrings2 = new MyString[10];
		
		myStrings2[0] = new MyString("Alicja");
		myStrings2[1] = new MyString("Alicj");
		myStrings2[2] = new MyString("Alic");
		myStrings2[3] = new MyString("Ali");
		myStrings2[4] = new MyString("Al");
		myStrings2[5] = new MyString("A");
		myStrings2[6] = new MyString("Marek");
		myStrings2[7] = new MyString("Franek");
		myStrings2[8] = new MyString("Ewa");
		myStrings2[9] = new MyString("Przemek");

		MyStringComparator msc = new MyStringComparator();
		
		long startTime3 = System.nanoTime();
		BubbleSort<MyString> bs3 = new BubbleSort<MyString>(myStrings2);
		myStrings2 = bs3.bubbleSort(msc);
		long endTime3 = System.nanoTime();
		System.out.println("Czas jaki zajeło posortowanie przez zewnętrzny komperator " + (endTime3 - startTime3));
		
		for(int i = 0; i < myStrings2.length; i++) {
			System.out.println(myStrings2[i]);
		}
	}
	
	static String [] generate2(int size){
		String [] strings = new String[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			String s = "abcdefghijklmnoprstuwyz";
			int longestPossibleWords = g.nextInt(s.length() - 1) + 1;
			char [] chars = new char[longestPossibleWords];
			for(int j = 0; j < longestPossibleWords; j++){
				chars[j] = s.charAt(g.nextInt(s.length()));
			}
			strings[i] = new String(chars);
		}
		
		return strings;
	}
}
