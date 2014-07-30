package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;

public class QuickSorter<T extends Comparable<T>> implements Sorter<T>{

	@Override
	public void sort(List<T> unsorted) {

		sortHelper(unsorted, unsorted);
	}
	
	private void sortHelper(List<T> original, List<T> partial){
		
		if (partial.size() == 1)
			return;
		
		int pivotIndex = partial.size() / 2;
		T pivot = partial.get(pivotIndex);
		
		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();

		for(T t : partial){
			if (t.compareTo(pivot) <= 0){
				left.add(t);
			}else{
				right.add(t);
			}
		}
		sortHelper(original, left);
		sortHelper(original, right);
	}

}
