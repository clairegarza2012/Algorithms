package edu.neumont.csc252;

import java.util.ArrayList;
import java.util.List;

public class DfsGraphTraversal {

	public List<List<Integer>> traverse(Graph g){

		List<List<Integer>> list = new ArrayList<>();

		int v;
		for (v=0; v < g.vcount(); v++) {
			g.setMark(v, 0);
		}
		for (v=0; v < g.vcount(); v++) {

			if (g.getMark(v) == 0){
				List<Integer> a = new ArrayList<>();
				list.add(traverseHelper(g, v, a));
			}
		}

		return list;
	}

	private List<Integer> traverseHelper(Graph g, int v, List<Integer> a){
		if(a.size() == 0)
		{
			a.add(v);
		}
		
		g.setMark(v, 1);
		for (int w = g.first(v); w < g.vcount() ; w = g.next(v, w)){

			if (g.getMark(w) == 0){
				a.add(w);
				traverseHelper(g, w, a);
			}
		}

		return a;
	}

}
