package Zadanie6;

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
			generateFloat();
			
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
	
	void generateFloat(){
		List<Float> floats = new ArrayList<Float>();
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			floats.add(g.nextFloat());
		}
		
		list  = (List<T>) floats;
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
