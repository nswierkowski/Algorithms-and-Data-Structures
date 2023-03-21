package Zadanie6;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class QuickSort<T extends Comparable> {

	Random g;
	
	public List<T> sort(List<T> list) {
		g = new Random();
		quicksort(list, 0, list.size());
		return list;
	}
		
	private void quicksort(List<T> list, int startIndex, int endIndex) {
		if (endIndex - startIndex > 1) {
			int partition = partition(list, startIndex, endIndex);
			quicksort(list, startIndex, partition );
			quicksort(list, partition + 1, endIndex);
		}
	}
	
	private int partition(List<T> list, int nFrom, int nTo) {
		//jako element dzielący bierzemy losowy
		int rnd=nFrom+g.nextInt(nTo-nFrom);
		swap(list,nFrom,rnd);
		T value=list.get(nFrom);
		int idxBigger=nFrom+1, idxLower=nTo-1;
		do{
			while(idxBigger<=idxLower && list.get(idxBigger).compareTo(value)<=0) idxBigger++;
			while(list.get(idxLower).compareTo(value)>0) idxLower--;
			if(idxBigger<idxLower) swap(list,idxBigger,idxLower);
		}while(idxBigger<idxLower);
		swap(list,idxLower,nFrom);
		return idxLower;
	}
		
	
	private void swap(List<T> list, int left, int right) {
		if (left != right) {
			T temp = list.get(left);
			list.set(left, list.get(right));
			list.set(right, temp);
		}
	}
}
