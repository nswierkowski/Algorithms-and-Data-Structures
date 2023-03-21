package Zadanie7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Zadanie4.BubbleSort;
import Zadanie4.InsertSort;
import Zadanie6.NewComparator;
import Zadanie4.SelectSort;

public class CompareAlgorithms<T extends Comparable> {

	int size;
	List<T> list;
	
	public CompareAlgorithms(int size) {
		this.size = size;
	}

	void setSize(int size) {
		this.size = size;
	}
	
	void compare(int n) {
		List<T> t1 = new ArrayList<T>();
		List<T> t2 = new ArrayList<T>();
		List<T> t3 = new ArrayList<T>();
		for(int i = 0; i < n; i++) {
			generateInt();
			t1 = copy(list);
			t2 = copy(list);
			t3 = copy(list);
			checkMergeSort(t1);
			checkHeapSort(t2);
			checkQuickSort(t3);

			System.out.println();
		}
		
//		System.out.println("maxInsert: " + maxInsert);
//		System.out.println("maxSelect: " + maxSelect);
//		System.out.println("maxBubble: " + maxBubble);
//		System.out.println("minInsert: " + minInsert);
//		System.out.println("minSelect: " + minSelect);
//		System.out.println("minBubble: " + minBubble);
//		System.out.println("\n");
	}
	
	
	
	void compareSorted(int n) {
		List<T> t1 = new ArrayList<T>();
		List<T> t2 = new ArrayList<T>();
		List<T> t3 = new ArrayList<T>();
		for(int i = 0; i < n; i++) {
			generateSortedInt();
			t1 = copy(list);
			t2 = copy(list);
			t3 = copy(list);
			checkMergeSort(t1);
			checkHeapSort(t2);
			checkQuickSort(t3);

			System.out.println();
		}
		System.out.println("\n");
	}
	
	void compareRevSorted(int n) {
		List<T> t1 = new ArrayList<T>();
		List<T> t2 = new ArrayList<T>();
		List<T> t3 = new ArrayList<T>();
		for(int i = 0; i < n; i++) {
			generateReverseSortedInt();
			t1 = copy(list);
			t2 = copy(list);
			t3 = copy(list);
			checkMergeSort(t1);
			checkHeapSort(t2);
			checkQuickSort(t3);
			
			System.out.println();
		}
		System.out.println("\n");
	}
	
	void compareBucket(int n) {
		List<T> t1 = new ArrayList<T>();
		List<T> t2 = new ArrayList<T>();
		List<T> t3 = new ArrayList<T>();
		for(int i = 0; i < n; i++) {
			generateBucketInt(4);
			t1 = copy(list);
			t2 = copy(list);
			t3 = copy(list);
			checkMergeSort(t1);
			checkHeapSort(t2);
			checkQuickSort(t3);
			
			System.out.println();
		}
		System.out.println("\n");
	}
	
	void compareRevBucket(int n) {
		List<T> t1 = new ArrayList<T>();
		List<T> t2 = new ArrayList<T>();
		List<T> t3 = new ArrayList<T>();
		for(int i = 0; i < n; i++) {
			generateRevBucketInt(4);
			t1 = copy(list);
			t2 = copy(list);
			t3 = copy(list);
			checkMergeSort(t1);
			checkHeapSort(t2);
			checkQuickSort(t3);

			System.out.println();
		}
		System.out.println("\n");
	}
	
	void generateInt(){
		List<Integer> ints = new ArrayList<Integer>();
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			ints.add(g.nextInt(1000000));
		}
		
		list  = (List<T>) ints;
	}
	
	void generateFloat(){
		List<Float> floats = new ArrayList<Float>();
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			floats.add(g.nextFloat());
		}
		
		list  = (List<T>) floats;
	}
	
	
	void generateSortedInt(){
		List<Integer> ints = new ArrayList<Integer>();
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			ints.add(g.nextInt(1000000));
		}
		
		list  = (List<T>) ints;
		QuickSort<T> qs = new QuickSort<T>();
		qs.sort(list);
	}
	
	void generateReverseSortedInt(){
		List<Integer> ints = new ArrayList<Integer>();
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			ints.add(g.nextInt(1000000));
		}
		
		list  = (List<T>) ints;
		QuickSort<T> qs = new QuickSort<T>();
		qs.revSort(list);
	}
	
	void generateBucketInt(int numberOfBucket){
		List<Integer> ints = new ArrayList<Integer>();
		Random g = new Random();
		int endIndex = 0;
		for(int j = 1; j <= numberOfBucket; j++) {
			int startIndex = endIndex;
			endIndex += size/numberOfBucket;
			for(int i = startIndex; i < endIndex; i++) {
				ints.add(g.nextInt(1000000/numberOfBucket) +1000000*(j-1)/numberOfBucket);
			}
		}
		list  = (List<T>) ints;
	}
	
	void generateRevBucketInt(int numberOfBucket){
		List<Integer> ints = new ArrayList<Integer>();
		Random g = new Random();
		int endIndex = 0;
		for(int j = numberOfBucket; j >= 1; j--) {
			int startIndex = endIndex;
			endIndex += size/numberOfBucket;
			for(int i = startIndex; i < endIndex; i++) {
				ints.add(g.nextInt(1000000/numberOfBucket) +1000000*(j-1)/numberOfBucket);
			}
		}
		list  = (List<T>) ints;
	}
	
	void show(List<T> list2) {
		System.out.println();
		for(int i = 0; i < list2.size(); i++) {
			System.out.print(list2.get(i) + ", ");
		}
		System.out.println("\n");
	}
	
	List<T> copy(List<T> t){
		List<T> newT = new ArrayList<T>();
		for(int i = 0; i < t.size(); i++) {
			newT.add(t.get(i));
		}
		return newT;
	}
	
	void checkMergeSort(List<T> t) {
		MergeSort<T> isfl = new MergeSort<T>();		
		long startTime = System.currentTimeMillis();
		t = isfl.sort(t);
		long endTime = System.currentTimeMillis();
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkHeapSort(List<T> t) {
		HeapSort<T> isfl = new HeapSort<T>();	
		long startTime = System.currentTimeMillis();
		t = isfl.sort(t);
		long endTime = System.currentTimeMillis();
		System.out.print(0.001*(endTime - startTime) + "	");
	}
	
	void checkQuickSort(List<T> t) {
		QuickSort<T> isfl = new QuickSort<T>();		
		long startTime = System.currentTimeMillis();
		t = isfl.sort(t);
		long endTime = System.currentTimeMillis();
		System.out.print(0.001*(endTime - startTime) + "	");
	}


}
