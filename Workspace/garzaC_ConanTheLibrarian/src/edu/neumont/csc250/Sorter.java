package edu.neumont.csc250;

import java.util.List;

public interface Sorter<T extends Comparable<T>> {

	public void sort(List<T> unsorted);
}
