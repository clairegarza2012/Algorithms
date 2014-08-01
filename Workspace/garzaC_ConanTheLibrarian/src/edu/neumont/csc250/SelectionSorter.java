package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;

public class SelectionSorter<T extends Comparable<T>> implements Sorter<T>{

	@SuppressWarnings("unchecked")
	@Override
	public void sort(List<T> unsorted) {

		int minIndex = -1;
		for (int i = 0; i < unsorted.size(); i++){

			minIndex = i;
			for (int j = i + 1; j < unsorted.size(); j++){

				if (unsorted.get(minIndex).compareTo(unsorted.get(j)) < 0 ){
					minIndex = j;
				}

			}
			
			T temp = unsorted.get(i);
			unsorted.set(i, unsorted.get(minIndex));
			unsorted.set(minIndex, temp);

		}
	}

}
