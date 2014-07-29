package edu.neumont.csc250.test;

import org.junit.Assert;
import org.junit.Test;

import edu.neumont.csc250.PriorityQueue;

public class PriorityQueueTest {

	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
	
	@Test
	public void test() {
		
		queue.poll();
		
		queue.offer(10);
		queue.offer(2);
		queue.offer(1);
		queue.offer(4);
		queue.offer(8);
		queue.offer(6);

		Assert.assertEquals((Integer)1, (Integer)queue.peek());
		
		Assert.assertEquals((Integer)1, (Integer)queue.poll());
		
		Assert.assertEquals((Integer)2, (Integer)queue.poll());
		
		Assert.assertEquals((Integer)4, (Integer)queue.peek());
	}

}
