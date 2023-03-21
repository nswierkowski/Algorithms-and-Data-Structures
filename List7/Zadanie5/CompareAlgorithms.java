package Zadanie5;

import java.util.Random;

import Zadanie4.SelectSort;

public class CompareAlgorithms {

	double maxInsert = 0;
	double maxSelect = 0;
	double maxBubble = 0;
	double minInsert = 1000000;
	double minSelect = 1000000;
	double minBubble = 1000000;
	int size;
	Integer[] tabInt;
	Float[] tabFloat;
	Character[] tabChar;
	
	public CompareAlgorithms(int size) {
		this.size = size;
	}

	void reset() {
		maxInsert = 0;
		maxSelect = 0;
		maxBubble = 0;
		minInsert = 1000000;
		minSelect = 1000000;
		minBubble = 1000000;
	}
	
	void show(int [] t) {
		for(int i = 0; i < t.length; i++) {
			System.out.print(t[i] +", ");
		}
		System.out.println("\n");
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	void compareInteger(int n) {
		for(int i = 0; i < n; i++) {
			generateInteger();
			
	//		Integer[] t1 = copyInt(tabInt);
	//		Integer[] t2 = copyInt(tabInt);
			Integer[] t3 = copyInt(tabInt);
	//		checkInsertSortInteger(t1);
	//		checkSelectSortInteger(t2);
			checkBubbleSortInteger(t3);
			System.out.println();
		}
		
		System.out.println("maxInsert: " + maxInsert);
		System.out.println("maxSelect: " + maxSelect);
		System.out.println("maxBubble: " + maxBubble);
		System.out.println("minInsert: " + minInsert);
		System.out.println("minSelect: " + minSelect);
		System.out.println("minBubble: " + minBubble);
		System.out.println("\n");
		reset();
	}
	
	void compareFloat(int n) {
		for(int i = 0; i < n; i++) {
			generateFloat();
			
	//		Float[] t1 = copyFloat(tabFloat);
	//		Float[] t2 = copyFloat(tabFloat);
			Float[] t3 = copyFloat(tabFloat);
	//		checkInsertSortFloat(t1);
	//		checkSelectSortFloat(t2);
			checkBubbleSortFloat(t3);
			System.out.println();
		}
		
		System.out.println("maxInsert: " + maxInsert);
		System.out.println("maxSelect: " + maxSelect);
		System.out.println("maxBubble: " + maxBubble);
		System.out.println("minInsert: " + minInsert);
		System.out.println("minSelect: " + minSelect);
		System.out.println("minBubble: " + minBubble);
		System.out.println("\n");
		reset();
	}
	
	void compareChar(int n) {
		for(int i = 0; i < n; i++) {
			generateCharacter();
			
			Character[] t1 = copyChar(tabChar);
			Character[] t2 = copyChar(tabChar);
			Character[] t3 = copyChar(tabChar);
			checkInsertSortChar(t1);
			checkSelectSortChar(t2);
			checkBubbleSortChar(t3);
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
		tabChar = new Character[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			tabChar[i] =(Character) (char) (g.nextInt(94) + 33);
		}		
	}
	
	void generateInteger(){
		tabInt = new Integer[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			tabInt[i] = g.nextInt(94);
		}
	}
	
	void generateFloat(){
		tabFloat = new Float[size];
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			tabFloat[i] = g.nextFloat();
		}		
	}
	
	Integer [] copyInt(Integer[] tabInt2){
		Integer[] newT = new Integer[tabInt2.length];
		for(int i = 0; i < tabInt2.length; i++) {
			newT[i] = tabInt2[i];
		}
		return newT;
	}
	
	Float [] copyFloat(Float [] t){
		Float[] newT = new Float[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = t[i];
		}
		return newT;
	}
	
	Character [] copyChar(Character [] t){
		Character[] newT = new Character[t.length];
		for(int i = 0; i < t.length; i++) {
			newT[i] = t[i];
		}
		return newT;
	}
	
	void checkInsertSortInteger(Integer [] t) {
		InsertSortInteger isfl = new InsertSortInteger();		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxInsert) maxInsert = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minInsert) minInsert = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkInsertSortFloat(Float [] t) {
		InsertSortFloat isfl = new InsertSortFloat();		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxInsert) maxInsert = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minInsert) minInsert = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkInsertSortChar(Character [] t) {
		InsertSortChar isfl = new InsertSortChar();		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxInsert) maxInsert = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minInsert) minInsert = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkSelectSortInteger(Integer [] t) {
		SelectSortInteger isfl = new SelectSortInteger();	
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxSelect) maxSelect = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minSelect) minSelect = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkSelectSortFloat(Float [] t) {
		SelectSortFloat isfl = new SelectSortFloat();	
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxSelect) maxSelect = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minSelect) minSelect = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkSelectSortChar(Character [] t) {
		SelectSortChar isfl = new SelectSortChar();	
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxSelect) maxSelect = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minSelect) minSelect = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkBubbleSortInteger(Integer [] t) {
		BubbleSortInteger isfl = new BubbleSortInteger();		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxBubble) maxBubble = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minBubble) minBubble = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkBubbleSortFloat(Float [] t) {
		BubbleSortFloat isfl = new BubbleSortFloat();		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxBubble) maxBubble = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minBubble) minBubble = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkBubbleSortChar(Character [] t) {
		BubbleSortChar isfl = new BubbleSortChar();		
		isfl.fillArray(t);
		long startTime = System.currentTimeMillis();
		t = isfl.sort();
		long endTime = System.currentTimeMillis();
		if(0.001*(endTime - startTime) > maxBubble) maxBubble = 0.001*(endTime - startTime);
		if(0.001*(endTime - startTime) < minBubble) minBubble = 0.001*(endTime - startTime);
		System.out.print(0.001*(endTime - startTime) + "	");
	}
}
