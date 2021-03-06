package edu.neumont.csc250.test;

import junit.framework.Assert;

import org.junit.Test;

import edu.neumont.csc250.ArrayList;

public class ArrayListTest {

	private ArrayList<Integer> list = new ArrayList<Integer>();
	
	@Test
	public void test() {
		list.remove(10);
		
		list.add(10);
		list.add(1);
		list.add(5);
		list.add(8);
		list.add(6);
		list.add(3);
		list.add(2);
		list.add(5);

		Assert.assertEquals(8, list.size());

		Assert.assertEquals((Integer) 10, list.get(0));
		Assert.assertEquals((Integer) 8, list.get(3));
		Assert.assertEquals((Integer) 2, list.get(6));		
		Assert.assertEquals((Integer)5, list.get(2));
		
		list.remove(5);
		
		Assert.assertEquals(7, list.size());
	}

}
