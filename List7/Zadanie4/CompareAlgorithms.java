package Zadanie4;

import java.util.Random;

public class CompareAlgorithms<T> {

	double maxInsert = 0;
	double maxSelect = 0;
	double maxBubble = 0;
	double minInsert = 1000000;
	double minSelect = 1000000;
	double minBubble = 1000000;
	int size;
	T[] t;
	
	public CompareAlgorithms(int size) {
		this.size = size;
		t = (T[]) new Object[size];
	}

	void reset() {
		maxInsert = 0;
		maxSelect = 0;
		maxBubble = 0;
		minInsert = 1000000;
		minSelect = 1000000;
		minBubble = 1000000;
	}
	
	void compare(NewComparator comparator, int n) {
		for(int i = 0; i < n; i++) {
			if(t instanceof Character[]) generateCharacter();
			if(t instanceof Integer[]) generateInteger();
			if(t instanceof Float[]) generateFloat();
			
			T[] t1 = copy(t);
			T[] t2 = copy(t);
			T[] t3 = copy(t);
			checkInsertSort(t1, comparator);
			checkSelectSort(t2, comparator);
			checkBubbleSort(t3, comparator);
			System.out.println();
		}
		
		System.out.println("maxInsert: " + maxInsert);
		System.out.println("maxSelect: " + maxSelect);
		System.out.println("maxBubble: " + maxBubble);
		System.out.println("minInsert: " + minInsert);
		System.out.println("minSelect: " + minSelect);
		System.out.println("minBubble: " + minBubble);
		System.out.println("\n");
	}
	
	void generateCharacter(){
		Character [] chars = new Character[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			chars[i] = (char) (g.nextInt(94) + 33);
		}
		
		t = (T[]) chars;
	}
	
	void generateInteger(){
		Integer [] integers = new Integer[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			integers[i] = g.nextInt(94);
		}
		
		t = (T[]) integers;
	}
	
	void generateFloat(){
		Float [] floats = new Float[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			floats[i] = g.nextFloat();
		}
		
		t = (T[]) floats;
	}
	
	void show() {
		for(int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
		System.out.println("\n");
	}
	
	T [] copy(T [] t){
		T[] newT = (T[]) new Object[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = t[i];
		}
		return newT;
	}
	
	void checkInsertSort(T [] t, NewComparator comparator) {
		InsertSort<T> isfl = new InsertSort<T>(comparator);		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxInsert) maxInsert = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minInsert) minInsert = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkSelectSort(T [] t, NewComparator comparator) {
		SelectSort<T> isfl = new SelectSort<T>(comparator);	
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxSelect) maxSelect = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minSelect) minSelect = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkBubbleSort(T [] t, NewComparator comparator) {
		BubbleSort<T> isfl = new BubbleSort<T>(comparator);		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxBubble) maxBubble = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minBubble) minBubble = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
}
