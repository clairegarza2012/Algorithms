package edu.neumont.csc252;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

	public List<Integer> sort(Graph g){
		
		
		
		// Do a dfs traversal
		List<List<Integer>> list = this.traverse(g);
		List<Integer> dfs = list.get(0);
		
		// reverse the dfs traversal
		List<Integer> top = dfs;
		for (int i = 0; i < dfs.size()/2; i++){
			int temp = dfs.get(i);
			top.set(i, dfs.get(dfs.size() - 1 - i));
			top.set(dfs.size() - 1 - i, temp);
		}
		
		return top;
	}
	
	private List<List<Integer>> traverse(Graph g){

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
