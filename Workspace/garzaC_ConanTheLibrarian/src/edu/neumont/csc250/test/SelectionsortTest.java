package edu.neumont.csc250.test;

import java.util.ArrayList;

import junit.framework.Assert;
import org.junit.Test;
import edu.neumont.csc250.SelectionSorter;

public class SelectionSortTest {

	private SelectionSorter<Integer> sorter = new SelectionSorter<>();
	
	@Test
	public void test() {
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(10);
		list.add(5);
		list.add(6);
		list.add(3);
		
		Assert.assertEquals((Integer) 10, list.get(0));
		
		Assert.assertEquals((Integer) 3, list.get(3));

		sorter.sort(list);
		
		Assert.assertEquals((Integer) 3, list.get(3));
		
		Assert.assertEquals((Integer) 10, list.get(0));

		System.out.println(list.toString());
	}

}
