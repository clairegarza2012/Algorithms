package edu.neumont.csc252.test;

import java.util.List;
import edu.neumont.csc252.BfsGraphTraversal;
import edu.neumont.csc252.DfsGraphTraversal;
import edu.neumont.csc252.DotsAndBoxes;
import edu.neumont.csc252.Graph;

public class Test {

	@org.junit.Test
	public void test() {

		/* Test dfs and bfs */
		Graph g = new Graph(7);
		g.addEdge(0, 1, 1);
		//g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		//g.addEdge(0, 2, 1);
		//g.addEdge(2, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(4, 5, 1);

		DfsGraphTraversal bfs = new DfsGraphTraversal();
		List<List<Integer>> list = bfs.traverse(g);

		int count = 0;
		for (List<Integer> li : list){
			System.out.print(count++ + ": ");
			for (Integer i : li){
				System.out.print(i + ", ");
			}
			System.out.println();
		}
		
		/* Test drawLine, score, moves left, double crosses */
		DotsAndBoxes dab = new DotsAndBoxes(3, 3);
				
		dab.drawLine(1, 1, 0, 1, 1);
		dab.drawLine(2, 0, 0, 1, 0);
		dab.drawLine(1, 0, 1, 1, 1);
		dab.drawLine(2, 0, 0, 0, 1);
		
		dab.drawLine(1, 1, 0, 2, 0);
		dab.drawLine(2, 2, 0, 2, 1);
		dab.drawLine(1, 1, 1, 2, 1);
		
		dab.drawLine(2, 0, 1, 0, 2);
		dab.drawLine(1, 0, 2, 1, 2);
		dab.drawLine(2, 1, 2, 2, 2);
		dab.drawLine(1, 2, 2, 2, 1);
		//dab.drawLine(2, 1, 1, 1, 2);
		
		System.out.println(dab.score(1));
		System.out.println(dab.score(2));
		
		System.out.println(dab.areMovesLeft());
		
		System.out.println(dab.countDoubleCrosses());
		
		/* Cycle Test */
//		DotsAndBoxes dab = new DotsAndBoxes(3, 3);
//		
//		dab.drawLine(1, 0, 0, 1, 0);
//		dab.drawLine(2, 1, 0, 2, 0);
//		dab.drawLine(1, 0, 0, 0, 1);
//		dab.drawLine(2, 0, 1, 0, 2);
//		dab.drawLine(1, 0, 2, 1, 2);
//		dab.drawLine(2, 1, 2, 2, 2);
//		dab.drawLine(1, 2, 0, 2, 1);
//		dab.drawLine(2, 2, 1, 2, 2);
//		
//		System.out.println(dab.countCycles());
		
		/* Chain Test */
//		DotsAndBoxes dab = new DotsAndBoxes(3, 3);
//		dab.drawLine(1, 0, 0, 1, 0);
//		dab.drawLine(2, 1, 0, 2, 0);
//		dab.drawLine(1, 0, 0, 0, 1);
//		dab.drawLine(2, 0, 1, 0, 2);
//		dab.drawLine(1, 0, 2, 1, 2);
//		dab.drawLine(2, 1, 2, 2, 2);
//		dab.drawLine(1, 1, 1, 2, 1);
//		
//		System.out.println(dab.countOpenChains());
	}

	
	
	
	
	
	
	
}
