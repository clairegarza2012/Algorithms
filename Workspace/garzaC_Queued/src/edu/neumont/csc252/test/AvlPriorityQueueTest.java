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

		System.out.println("Full Tree:");
		AVLTree<Integer> tree = new AVLTree<>();

		/*for ( int i = 0 ; i < 16; i++ ) {
			int num = new Random().nextInt(100);
			tree.insert(num);
			System.out.println(i + ": " + num + ", ");
		}*/
		System.out.println("\n");
				tree.insert(5);
				tree.insert(3);
				tree.insert(4);
				tree.insert(6);		
				tree.insert(7);
				tree.insert(2);
				tree.insert(1);
				tree.insert(8);
				tree.insert(9);
				tree.insert(10);
				tree.insert(11);
				tree.insert(12);
				tree.insert(13);
				tree.insert(5);
				tree.insert(3);
				tree.insert(4);
				tree.insert(6);		
				tree.insert(7);
				tree.insert(2);
				tree.insert(1);
				tree.insert(8);
				tree.insert(9);
				tree.insert(10);
				tree.insert(11);
				tree.insert(12);
				tree.insert(13);

		tree.printTree();
		System.out.println("Height: " + tree.height());
		System.out.println("Balance Factor: " + tree.balance());
		System.out.println("Size: " + tree.size());

	}

}
