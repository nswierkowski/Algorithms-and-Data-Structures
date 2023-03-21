package Zadanie6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import Zadanie6.*;

public class MergeSort<T extends Comparable> {

	public List<T> sort(List<T> list)
	{
		return mergeSort(list, list.size());
	}
	
	public List<T> mergeSort(List<T> a, int n) {
	    if (n < 2) {
	        return null;
	    }
	    int mid = n / 2;
	    List<T> l = new ArrayList<T>();
	    List<T> r = new ArrayList<T>();

	    for (int i = 0; i < mid; i++) {
	        l.add(a.get(i));
	    }
	    for (int i = mid; i < n; i++) {
	        r.add(a.get(i));
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);

	   return merge(a, l, r, mid, n - mid);
	}
	
	public List<T> merge(List<T> a, List<T> l, List<T> r, int left, int right) {
			    int i = 0, j = 0, k = 0;
			    a.clear();
			    while (i < left && j < right) {
			        if (l.get(i).compareTo(r.get(j)) <= 0) {
			            a.add(k++, l.get(i++));
			        }
			        else {
			            a.add(k++, r.get(j++));
			        }
			    }
			    while (i < left) {
			        a.add(k++, l.get(i++));
			    }
			    while (j < right) {
			        a.add(k++, r.get(j++));
			    }
			    return a;
			}

}
