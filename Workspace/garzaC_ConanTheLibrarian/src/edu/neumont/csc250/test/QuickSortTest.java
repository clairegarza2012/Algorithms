package edu.neumont.csc250.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import edu.neumont.csc250.QuickSorter;

public class QuickSortTest {

	private QuickSorter<Integer> sorter = new QuickSorter<Integer>();
	@Test
	public void test() {
		
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(7);
		list.add(6);
		list.add(5);
		list.add(38);
		list.add(4);
		list.add(5);
		
//		list.add(5);
//		list.add(4);
//		list.add(3);
//		list.add(7);
//		list.add(6);
//		list.add(5);
//		list.add(38);
//		list.add(4);
//		list.add(5);

		Assert.assertEquals((Integer) 5, list.get(0));
		
		Assert.assertEquals((Integer) 5, list.get(5));
		
		Assert.assertEquals((Integer) 5, list.get(8));
		
		sorter.sort(list);
		
		Assert.assertEquals((Integer) 3, list.get(8));

		Assert.assertEquals((Integer) 5, list.get(4));

		Assert.assertEquals((Integer) 7, list.get(1));
		
		Assert.assertEquals((Integer) 38, list.get(0));

		System.out.println(list.toString());

	}

}
