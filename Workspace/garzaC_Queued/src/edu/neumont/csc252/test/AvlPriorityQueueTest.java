package edu.neumont.csc252.test;

import java.util.Iterator;
import java.util.Random;

import org.junit.Test;

import edu.neumont.csc252.AVLNode;
import edu.neumont.csc252.AVLTree;
import edu.neumont.csc252.AvlBasedPriorityQueue;
import edu.neumont.csc252.Heap;
import edu.neumont.csc252.HeapBasedPriorityQueue;

public class AvlPriorityQueueTest {

	@Test
	public void test() {

		//		Heap<Integer> heap = new Heap<>();
		//		
		//		heap.insert(4);
		//		heap.insert(1);
		//		heap.insert(3);
		//		heap.insert(2);
		//		heap.insert(6);
		//		heap.insert(8);
		//		heap.insert(7);
		//		heap.insert(5);
		//		heap.insert(9);
		//
		//		System.out.println(heap.size());
		//		
		//		Iterator<Integer> it = heap.getIterator();
		//		while (it.hasNext()){
		//			System.out.print(it.next() + ", " + heap.size());
		//		}
		//		
		//		HeapBasedPriorityQueue<Integer> heap = new HeapBasedPriorityQueue<>();
		//		heap.offer(3);
		//		heap.offer(4);
		//		heap.offer(2);
		//		heap.offer(5);
		//		heap.offer(7);
		//		heap.offer(1);
		//		heap.offer(6);
		//		
		//		System.out.println(heap.size());
		//		
		//		while (heap.peek() != null){
		//			System.out.println(heap.poll() + ", " + heap.size() );
		//		}

		System.out.println("Full Tree:");
		AVLTree<Integer> tree = new AVLTree<>();

		for ( int i = 0 ; i < 32; i++ ) {
			tree.insert(new Random().nextInt(1000));
		}

//		tree.insert(5);
//		tree.insert(3);
//		tree.insert(4);
//		tree.insert(6);		
//		tree.insert(7);
//		tree.insert(2);
//		tree.insert(1);
//		tree.insert(8);
//		tree.insert(9);
//		tree.insert(10);
//		tree.insert(11);
//		tree.insert(12);
//		tree.insert(13);

		tree.printTree();
		System.out.println("Height: " + tree.height());
		System.out.println("Balance Factor: " + tree.balance());

//		Heap<Integer> heap = new Heap<>();
//		
//		heap.insert(4);
//		heap.insert(1);
//		heap.insert(3);
//		heap.insert(2);
//		heap.insert(6);
//		heap.insert(8);
//		heap.insert(7);
//		heap.insert(5);
//		heap.insert(9);
//
//		System.out.println(heap.size());
//		
//		Iterator<Integer> it = heap.getIterator();
//		while (it.hasNext()){
//			System.out.print(it.next() + ", " + heap.size());
//		}
//		
//		HeapBasedPriorityQueue<Integer> heap = new HeapBasedPriorityQueue<>();
//		heap.offer(3);
//		heap.offer(4);
//		heap.offer(2);
//		heap.offer(5);
//		heap.offer(7);
//		heap.offer(1);
//		heap.offer(6);
//		
//		System.out.println(heap.size());
//		
//		while (heap.peek() != null){
//			System.out.println(heap.poll() + ", " + heap.size() );
//		}
		
//		AVLTree<Integer> tree = new AVLTree<>();
//		
//		tree.insert(5);
//		tree.insert(3);
//		tree.insert(4);
//		tree.insert(6);		
//		tree.insert(7);
//		tree.insert(2);
//		tree.insert(1);
//		tree.insert(8);
//		tree.insert(9);
//		tree.insert(10);
//		tree.insert(11);
//		tree.insert(12);
//		tree.insert(13);
//		
//		tree.printTree(); // prints out as pre-order traversal
//		
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		tree.delete();
//		
//		tree.printTree();
		
//		AvlBasedPriorityQueue<Integer> queue = new AvlBasedPriorityQueue<>();
//		
//		queue.offer(1);
//		queue.offer(2);
//		queue.offer(3);
//		queue.offer(4);
//		queue.offer(5);
//		queue.offer(6);
//
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());
//		System.out.println(queue.poll());


	}

}
