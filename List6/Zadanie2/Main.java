package Zadanie2;

import java.util.Comparator;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		OneWayLinkedListWithHead<Integer> list = generate(1000);
		OneWayLinkedListWithHead<Integer> list2 = copy(list);
		OneWayLinkedListWithHead<Integer> list3 = copy(list);
		
		NewComparator<Integer> comparator = new NewComparator<Integer>();
		checkInsertSort(list, comparator);
		checkSelectSort(list2, comparator);
		checkBubbleSort(list3, comparator);
	}

	static OneWayLinkedListWithHead<Integer> generate(int size){
		OneWayLinkedListWithHead<Integer> list = new OneWayLinkedListWithHead<Integer>();
		Random g = new Random();
		for(int i = 0; i < size; i++) {
			list.add(g.nextInt(100));
		}
		
		return list;
	}
	
	static void show(OneWayLinkedListWithHead<Integer> list) {
		for(Integer i : list) {
			System.out.println(i);
		}
		System.out.println("\n");
	}
	
	static OneWayLinkedListWithHead<Integer> copy(OneWayLinkedListWithHead<Integer> list){
		OneWayLinkedListWithHead<Integer> newList = new OneWayLinkedListWithHead<Integer>();
		for(Integer i : list) {
			newList.add(i);
		}
		
		return newList;
	}
	
	static void checkInsertSort(OneWayLinkedListWithHead<Integer> list, NewComparator comparator) {
		InsertSort<Integer> isfl = new InsertSort<Integer>(comparator);
		OneWayLinkedListWithHead<Integer> list2 = copy(list);
		
		long startTime = System.currentTimeMillis();
		list = isfl.sort(list);
		long endTime = System.currentTimeMillis();
		System.out.println("InsertSort dla sortowania na liście: " + 0.001*(endTime - startTime));

		long startTime2 = System.currentTimeMillis();
		list2 = isfl.sortArray(list2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("InsertSort dla sortowania na tablicy: " + 0.001*(endTime2 - startTime2));
		System.out.println("\n");
	}
	
	static void checkSelectSort(OneWayLinkedListWithHead<Integer> list, NewComparator comparator) {
		SelectSort<Integer> isfl = new SelectSort<Integer>(comparator);
		OneWayLinkedListWithHead<Integer> list2 = copy(list);
		
		long startTime = System.currentTimeMillis();
		list = isfl.sort(list);
		long endTime = System.currentTimeMillis();
		System.out.println("SelectSort dla sortowania na liście: " + 0.001*(endTime - startTime));

		long startTime2 = System.currentTimeMillis();
		list2 = isfl.sortArray(list2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("SelectSort dla sortowania na tablicy: " + 0.001*(endTime2 - startTime2));
		System.out.println("\n");
	}
	
	static void checkBubbleSort(OneWayLinkedListWithHead<Integer> list, NewComparator comparator) {
		BubbleSort<Integer> isfl = new BubbleSort<Integer>(comparator);
		OneWayLinkedListWithHead<Integer> list2 = copy(list);
		
		long startTime = System.currentTimeMillis();
		list = isfl.sort(list);
		long endTime = System.currentTimeMillis();
		System.out.println("BubbleSort dla sortowania na liście: " + 0.001*(endTime - startTime));

		long startTime2 = System.currentTimeMillis();
		list2 = isfl.sortArray(list2);
		long endTime2 = System.currentTimeMillis();
		System.out.println("BubbleSort dla sortowania na tablicy: " + 0.001*(endTime2 - startTime2));
		System.out.println("\n");
	}
}
