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
		
		list.add(10);
		list.add(5);
		list.add(3);
		list.add(6);
		list.add(2);
			
		Assert.assertEquals((Integer) 10, list.get(0));
		
		Assert.assertEquals((Integer) 2, list.get(4));
		
		Assert.assertEquals((Integer) 3, list.get(2));
		
		sorter.sort(list);
		
		Assert.assertEquals((Integer) 2, list.get(0));
		
		Assert.assertEquals((Integer) 10, list.get(4));
		
		Assert.assertEquals((Integer) 5, list.get(2));
		
		for(Integer i : list){
			System.out.println(i);
		}

	}

}
