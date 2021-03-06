package edu.neumont.csc252.test;

import java.util.List;

import org.junit.Test;

import edu.neumont.csc252.Graph;
import edu.neumont.csc252.SeamCarver;
import edu.neumont.csc252.TopologicalSort;
import edu.neumont.ui.Picture;

public class test {

	@Test
	public void test() {

		/* Topological Sort Test */
		Graph g = new Graph(7);
		g.addEdge(0, 1, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(1, 3, 1);
		//g.addEdge(0, 2, 1);
		//g.addEdge(2, 4, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 4, 1);
		g.addEdge(5, 6, 1);
		g.addEdge(4, 5, 1);

		TopologicalSort topSort = new TopologicalSort();
		List<Integer> topSorted = topSort.sort(g);

		System.out.print("Topo Sorted: ");
		for (Integer i : topSorted){
			System.out.print(i + ", ");
		}

		//		Picture pic = new Picture("overlayimagewithhiddenmessage.png");
		//		
		//		SeamCarver carve = new SeamCarver(pic);
		//
		//		for (int i = 0; i < 150; i++){
		//			int[] path = carve.findHorizontalSeam();
		//			carve.removeHorizontalSeam(path);
		////			path = carve.findVerticalSeam();
		////			carve.removeVerticalSeam(path);
		//		}
		//		
		//		for (int i = 0; i < 170; i++){
		//			int[] path = carve.findVerticalSeam();
		//			carve.removeVerticalSeam(path);
		//		}
		//		
		//		Picture newPic = carve.getPicture();
		//		newPic.save("TestPic.png");
		//		
		//		System.out.println("I Finished!!");
		
		
	}

}
