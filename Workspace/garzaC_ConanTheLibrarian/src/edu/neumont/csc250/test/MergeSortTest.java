package edu.neumont.csc250.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import edu.neumont.csc250.MergeSorter;

public class MergeSortTest {

	private MergeSorter<Integer> sorter = new MergeSorter<Integer>();
	@Test
	public void test() {

		List<Integer> list = new ArrayList<Integer>();

		list.add(5);
		list.add(4);
		list.add(6);
		list.add(6);
		list.add(4);
		list.add(5);
		
		Assert.assertEquals((Integer) 5, list.get(0));
		
		Assert.assertEquals((Integer) 6, list.get(2));
		
		Assert.assertEquals((Integer) 4, list.get(4));
		
		sorter.sort(list);
		
		Assert.assertEquals((Integer) 6, list.get(0));

		Assert.assertEquals((Integer) 5, list.get(2));

		Assert.assertEquals((Integer) 4, list.get(4));
				
		System.out.println(list);
	}

}
