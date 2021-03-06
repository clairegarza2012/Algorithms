package edu.neumont.csc250.test;

import junit.framework.Assert;
import org.junit.Test;

import edu.neumont.csc250.LinkedList;

public class LinkedListTest {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	@Test
	public void test() {
		
		list.poll();
		
		list.offer(5);
		list.offer(3);
		list.offer(6);
		list.offer(8);
		
		Assert.assertEquals((Integer)5, (Integer)list.poll());
		
		list.poll();
		
		Assert.assertEquals((Integer)6, list.peek());
		
	}

}
