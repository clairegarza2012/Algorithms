package edu.neumont.csc250.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.neumont.csc250.MergeSorter;

public class MergeSortTest {

	private MergeSorter<Integer> sorter = new MergeSorter<Integer>();
	@Test
	public void test() {

		List<Integer> list = new ArrayList<Integer>();

		list.add(5);
		list.add(4);
		//list.add(3);
		
		sorter.sort(list);
		
		System.out.println(list);
	}

}
