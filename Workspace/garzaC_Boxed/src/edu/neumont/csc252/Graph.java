package edu.neumont.csc252;

import java.util.Arrays;

public class Graph {

	int[][] graph;
	int[] colors;
	
	public Graph(int v){
		// initializes a graph of v vertices with no edges
		graph = new int[v][v];
		colors = new int[v];
	}
	
	public int vcount(){
		// returns number of vertices (whether connected or not) in the graph
		return colors.length;
	}
	
	public int ecount(){
		// returns the number of edges in the graph
		int count = 0;
		
		for (int i = 0; i < colors.length; i++){
			for (int j = i; j < colors.length; j++){
				if (graph[i][j] > 0){
					count ++;
				}
			}
		}
		
		return count;
	}
	
	public int first(int v){
		return next(v, -1);
	}
	
	public int next(int v, int w){
		// returns the vertex (in natural order) connected to vertex v after vertex w.  If there are no more edges after w, vcount() is returned
		for (int i = w + 1; i < colors.length; i++){
			if (graph[v][i] > 0){
				return i;
			}
		}
		
		return colors.length;
	}
	
	public void addEdge(int v, int w, int wt){
		// adds an edge between vertex v and vertex w.
		graph[v][w] = wt;	
		graph[w][v] = wt;
	}

	public void removeEdge(int v, int w){
		// removes edge between vertex v and vertex w.
		graph[v][w] = 0;
		graph[w][v] = 0;
	}
	
	public boolean isEdge(int v, int w){
		// returns whether there is a connection between vertex v and vertex w
		return graph[v][w] != 0 || graph[w][v] != 0;
	}
	
	public int degree(int v){
		// returns how many edges depart from vertex v
		int count = 0;
		
		for (int i = 0; i < colors.length; i++){
			if (graph[v][i] != 0){
				count++;
			}
		}
		
		return count;
	}
	
	public int getMark(int v){
		// returns any graph coloring for this vertex
		return colors[v];
	}
	
	public void setMark(int v, int m){
		// colors vertex v color m
		colors[v] = m;
	}

	public void resetColors(){
		for (int i = 0; i < colors.length; i++){
			colors[i] = 0;
		}
	}

	@Override
	public String toString() {
		String s = "";
		
		for (int i = 0; i < this.vcount(); i++){
			
			for (int j = 0; j < this.vcount(); j++){
								
				if (this.isEdge(i, j)){
					System.out.print("1.");
				}
				else {
					System.out.print("0.");
				}
			}
			System.out.println();
		}			
		
		return s;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
