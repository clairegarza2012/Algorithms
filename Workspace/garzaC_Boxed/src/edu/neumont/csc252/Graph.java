package edu.neumont.csc252;

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
		return graph.length;
	}
	
	public int ecount(){
		// returns the number of edges in the graph
		int count = 0;
		
		for (int i = 0; i < graph.length; i++){
			for (int j = i; j < graph.length; j++){
				if (graph[i][j] > 0){
					count ++;
				}
			}
		}
		
		return count;
	}
	
	public int first(int v){
		// returns the first vertex (in natural order) connected to vertex v.  If there are none, then vcount() is returned
		for (int i = 0; i < graph.length; i++){
			if (graph[v][i] > 0){
				return graph[v][i];
			}
		}
		
		return graph.length;
	}
	
	public int next(int v, int w){
		// returns the vertex (in natural order) connected to vertex v after vertex w.  If there are no more edges after w, vcount() is returned
		for (int i = w + 1; i < graph.length; i++){
			if (graph[v][i] > 0){
				return graph[v][i];
			}
		}
		
		return graph.length;
	}
	
	public void addEdge(int v, int w, int wt){
		// adds an edge between vertex v and vertex w.
		graph[v][w] = wt;		
	}

	public void removeEdge(int v, int w){
		// removes edge between vertex v and vertex w.
		graph[v][w] = 0;
	}
	
	public boolean isEdge(int v, int w){
		// returns whether there is a connection between vertex v and vertex w
		return graph[v][w] != 0;
	}
	
	public int degree(int v){
		// returns how many edges depart from vertex v
		int count = 0;
		
		for (int i = 0; i < graph.length; i++){
			if (graph[v][i] >= 0){
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
}
