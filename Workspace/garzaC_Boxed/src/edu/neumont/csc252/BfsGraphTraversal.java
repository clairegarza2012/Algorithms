package edu.neumont.csc252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BfsGraphTraversal {

	public List<List<Integer>> traverse(Graph g){

		List<List<Integer>> list = new ArrayList<List<Integer>>();

		List<Integer> queue = new ArrayList<>();

		for (int v = 0; v < g.vcount(); v++){// gets each vertex
			System.out.print(v + " ==> ");
			//queue.add(v);
			for (int w = 0; w < g.vcount(); w++){
				if (g.isEdge(v, w)){
					queue.add(w);
					System.out.print(w + ", ");
				}
			}
			
			List<Integer> quee = new ArrayList<>();
			quee.addAll(queue);
			boolean a = list.add(quee);

			System.out.println(a);
//			while (queue.peek() != null){
//				System.out.print(queue.poll() + ", ");
//			}
			queue.clear();
			System.out.println();
		}

		return list;
	}
	
	private List<List<Integer>> BsfHelper(){
		
		
		return null;
	}
	
}
