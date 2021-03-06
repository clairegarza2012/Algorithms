package edu.neumont.csc252;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BfsGraphTraversal {

	public List<List<Integer>> traverse(Graph g){

		List<List<Integer>> list = new ArrayList<>();

		Queue<Integer> queue = new LinkedList<Integer>();
		int v;
		for (v=0; v < g.vcount(); v++) {
			g.setMark(v, 0);
		}

		while (allMarked(g) != -1) {
			List<Integer> tree = new ArrayList<Integer>();
			queue.add(allMarked(g));
			while (queue.size() > 0){
				v = queue.poll();
				if(tree.size() == 0)
				{
					tree.add(v);
					g.setMark(v,1);
				}


				for (int w = g.first(v); w < g.vcount(); w = g.next(v, w)) {

					if (g.getMark(w) == 0){
						g.setMark(w, 1);
						queue.add(w);
						tree.add(w);
					}
				}

			}
			list.add(tree);
		}
		return list;
	}


	private int allMarked(Graph g){
		
		int value = -1;
		
		for (int i = 0; i < g.vcount() && value == -1; i++) {
			value = (g.getMark(i) == 0)?i:value;
		}
		
		return value;
	}


}
