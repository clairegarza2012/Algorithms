package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;

public class MergeSorter<T extends Comparable<T>> implements Sorter<T>{

	@Override
	public void sort(List<T> unsorted) {
	
		List<T> temp = sortHelper(unsorted);
		unsorted.clear();
		unsorted.addAll(temp);
	}

	public List<T> sortHelper(List<T> original){
		
		if (original.size() <= 1 )
			return original;

		int middleIndex = original.size() / 2;

		List<T> left = new ArrayList<T>();
		List<T> right = new ArrayList<T>();

		for (int i = 0; i < original.size(); i++){
			
			if (i >= middleIndex){
				left.add(original.get(i));
			}
			else if (i < middleIndex){
				right.add(original.get(i));
			}

		}
		
		left = sortHelper(left);
		right = sortHelper(right);
		
		return merge(left, right);
	}

	private List<T> merge(List<T> left, List<T> right) {
		
		List<T> result = new ArrayList<T>();
		
		int leftIndex = 0;
		int rightIndex = 0;

		while (leftIndex < left.size() || rightIndex < right.size()){
			if (leftIndex < left.size() && rightIndex < right.size()){
				if (left.get(leftIndex).compareTo(right.get(rightIndex)) >= 0){
					result.add(left.get(leftIndex++));
				}
				else{
					result.add(right.get(rightIndex++));
				}
			}
			else if (leftIndex < left.size()) {
				result.add(left.get(leftIndex++));
			}
			else if (rightIndex < right.size()){
				result.add(right.get(rightIndex++));
			}
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
}
