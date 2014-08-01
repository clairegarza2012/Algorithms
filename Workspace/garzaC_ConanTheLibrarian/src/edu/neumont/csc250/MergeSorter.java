package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<T extends Comparable<T>> implements Sorter<T>{

	@Override
	public void sort(List<T> unsorted) {
	
	}

	public void sortHelper(List<T> original, int startIndex, int endIndex){
		
		if (startIndex + 1 >= endIndex ){
			if (original.get(startIndex).compareTo(original.get(startIndex + 1)) > 0){
				T temp = original.get(startIndex);
				original.set(startIndex, original.get(startIndex + 1));
				original.set(startIndex + 1, temp);
			}
				
			return;
		}
		
		
		sortHelper(original, startIndex, endIndex / 2);
		sortHelper(original, endIndex / 2 + 1, endIndex);
		
		
	}
	
}
