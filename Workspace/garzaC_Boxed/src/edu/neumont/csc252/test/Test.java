package edu.neumont.csc252.test;

import java.util.List;
import edu.neumont.csc252.BfsGraphTraversal;
import edu.neumont.csc252.Graph;

public class Test {

	@org.junit.Test
	public void test() {

		Graph g = new Graph(5);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		g.addEdge(2, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);

		BfsGraphTraversal bfs = new BfsGraphTraversal();
		List<List<Integer>> list = bfs.traverse(g);

		int count = 0;
		for (List<Integer> l : list){
			System.out.print(count++ + " ==> ");
			for (Integer i : l){
				System.out.print(i + ", ");
			}
			System.out.println();
		}

		System.out.println("\nEdge#: " + g.ecount());
	}

}