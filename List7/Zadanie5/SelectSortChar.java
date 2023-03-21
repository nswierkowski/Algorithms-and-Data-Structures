package Zadanie5;

import java.util.Comparator;

public class SelectSortChar{

	private Character [] array;
	
	public SelectSortChar() {}
	
	public Character[] sort() {
		for (int slot = 0; slot < array.length - 1; ++slot) {
			int smallest = slot; 
			for (int check = slot + 1; check < array.length; ++check)
				if (array[check] < array[smallest]) smallest = check;
				swapArray(smallest, slot);
			}
		return array;
	}
	
	private void swapArray(int left, int right) {
		if (left != right) {
			Character temp = array[left];
			array[left] = array[right];
			array[right] = temp;
		}
	}
	
	public void fillArray(Character[] array) {
		this.array = array;
	}
}
