package Zadanie3;

import java.util.Comparator;
import java.util.Random;

public class Main {

	static double maxInsert = 0;
	static double maxSelect = 0;
	static double maxBubble = 0;
	static double minInsert = 100000;
	static double minSelect = 100000;
	static double minBubble = 100000;;
	
	public static void main(String[] args) {
		for(int i = 0; i < 20; i++) {	
			String [] strings = generate2(70000);
			String [] strings2 = copy(strings);
			String [] strings3 = copy(strings);
		
			NewComparator<Integer> comparator = new NewComparator<Integer>();
			checkInsertSort(strings, comparator);
			checkSelectSort(strings2, comparator);
			checkBubbleSort(strings3, comparator);
		}
		
		System.out.println("maxInsert " + (1000*maxInsert));
		System.out.println("maxSelect " + (1000*maxSelect));
		System.out.println("maxBubble " + (1000*maxBubble));
		System.out.println("minInsert " + (1000*minInsert));
		System.out.println("minSelect " + (1000*minSelect));
		System.out.println("minBubble " + (1000*minBubble));
		
	}

	static String [] generate(int size){
		String [] strings = new String[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			int longestPossibleWords = g.nextInt(25) + 1;
			char [] chars = new char[longestPossibleWords];
			for(int j = 0; j < longestPossibleWords; j++){
				chars[j] = (char)  (g.nextInt(25) + 97);
			}
			strings[i].copyValueOf(chars);
		}
		
		return strings;
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
	
	static void show(String [] strings) {
		for(int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		System.out.println("\n");
	}
	
	static String[] copy(String [] strings){
		String[] newStrings = new String[strings.length];
		for(int i = 0; i < strings.length; i++) {
			newStrings[i] = strings[i];
		}
		return newStrings;
	}
	
	static void checkInsertSort(String [] strings, NewComparator comparator) {
		InsertSort<String> isfl = new InsertSort<String>(comparator);		
		isfl.fillArray(strings);
		long startTime = System.currentTimeMillis();
		strings = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxInsert) maxInsert = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minInsert) minInsert = 0.001*(endTime - startTime);
		System.out.println("InsertSort dla sortowania na liście: " + 0.001*(endTime - startTime));
		System.out.println("\n");
	}
	
	static void checkSelectSort(String [] strings, NewComparator comparator) {
		SelectSort<String> isfl = new SelectSort<String>(comparator);	
		isfl.fillArray(strings);
		long startTime = System.currentTimeMillis();
		strings = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxSelect) maxSelect = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minSelect) minSelect = 0.001*(endTime - startTime);
		System.out.println("SelectSort dla sortowania na liście: " + 0.001*(endTime - startTime));
		System.out.println("\n");
	}
	
	static void checkBubbleSort(String [] strings, NewComparator comparator) {
		BubbleSort<String> isfl = new BubbleSort<String>(comparator);		
		isfl.fillArray(strings);
		long startTime = System.currentTimeMillis();
		strings = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxBubble) maxBubble = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minBubble) minBubble = 0.001*(endTime - startTime);
		System.out.println("BubbleSort: " + 0.001*(endTime - startTime));
		System.out.println("\n");
	}
}
