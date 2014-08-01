package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSorter<T extends Comparable<T>> implements Sorter<T>{
	
	@Override
	public void sort(List<T> unsorted) {

		sortHelper(unsorted, 0, unsorted.size());
	}

	private void sortHelper(List<T> original, int startIndex, int endIndex){

		if (startIndex + 1 >= endIndex )
			return;

		T pivot = original.get(startIndex);

		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();
		List<T> same = new ArrayList<T>();

		//System.out.println("pivot: " + pivot + " " + startIndex + " " + endIndex + "\n\t" + original.toString());
		for (int i = startIndex + 1; i < endIndex; i++){
			
			if (pivot.compareTo(original.get(i)) < 0){
				left.add(original.get(i));
			}
			else if (pivot.compareTo(original.get(i)) > 0){
				right.add(original.get(i));
			}
			else if (pivot.compareTo(original.get(i)) == 0){
				same.add(original.get(i));
			}
		}
		
		int count = 0;
		for (int i = 0; i < left.size(); i++){
			original.set(i + startIndex, left.get(i));
			count ++;
		}
		
		original.set(startIndex + count++, pivot);
		
		for(int i = count; i <= left.size() + same.size(); i++){
			original.set(i + startIndex, same.get(i - count));
			count++;
		}
		
		for (int i = count; i <= left.size() + same.size() + right.size(); i++){
			original.set(i + startIndex, right.get(i - count));
		}
		
		sortHelper(original, startIndex, startIndex + (count - same.size()));
		sortHelper(original, startIndex + count , endIndex);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
