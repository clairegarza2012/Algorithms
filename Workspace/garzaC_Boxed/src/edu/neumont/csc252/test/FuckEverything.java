package edu.neumont.csc252.test;

import java.util.List;

import org.junit.Test;

import edu.neumont.csc252.BfsGraphTraversal;
import edu.neumont.csc252.DfsGraphTraversal;
import edu.neumont.csc252.DotsAndBoxes;
import edu.neumont.csc252.Graph;

public class FuckEverything {

	@Test
	public void test() {
		
		Graph g = new Graph(7);
		g.addEdge(0, 1, 1);
		//g.addEdge(2, 1, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(5, 6, 1);
		
		BfsGraphTraversal bfs = new BfsGraphTraversal();
		
		List<List<Integer>> list = bfs.traverse(g);
		
		int count = 0;
		for (List<Integer> i: list){
			System.out.print(count++ + ": ");
			for (Integer i4: i){
				System.out.print(i4 + ", ");
			}
			System.out.println();
		}
		
//		DotsAndBoxes dab = new DotsAndBoxes(3, 3);
//		
//		dab.drawLine(1, 1, 0, 1, 1);
//		dab.drawLine(2, 0, 0, 1, 0);
//		dab.drawLine(1, 0, 1, 1, 1);
//		dab.drawLine(2, 0, 0, 0, 1);
//		
//		dab.drawLine(1, 1, 0, 2, 0);
//		dab.drawLine(2, 2, 0, 2, 1);
//		dab.drawLine(1, 1, 1, 2, 1);
//		
//		dab.drawLine(2, 0, 1, 0, 2);
//		dab.drawLine(1, 0, 2, 1, 2);
//		dab.drawLine(2, 1, 2, 2, 2);
//		dab.drawLine(1, 2, 2, 2, 1);
//		//dab.drawLine(2, 1, 1, 1, 2);
//		
//		System.out.println(dab.score(1));
//		System.out.println(dab.score(2));
//		
//		System.out.println(dab.areMovesLeft());
//		
//		System.out.println(dab.countDoubleCrosses());
		
	}

}
