package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;

public class SelectionSorter<T extends Comparable<T>> implements Sorter<T>{

	@SuppressWarnings("unchecked")
	@Override
	public void sort(List<T> unsorted) {

		List<T> temp = new ArrayList<T>();

		for (int i = 1; i < unsorted.size(); i++){
			T min = null;

			for (int j = i; j < unsorted.size(); j++){
				if (min == null){
					min = unsorted.get(j);
				}
				else if (array[minIndex].compareTo(array[j]) > 0 ){
					minIndex = j;
				}
			}
			
			T temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}

		unsorted.clear();
		
		for (T i : array){
			unsorted.add(i);
		}
	}

}
