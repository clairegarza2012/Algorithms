package edu.neumont.csc250;

public class Graphs {

	private int[][] matrix;
	private int[] marks;
	
	public Graphs(int n){
		matrix = new int[n][n];
		marks = new int[n];
	}
	
	public int vCount(){
		return marks.length;
	}
	
	public int first(int v){
		
		for (int i = 0; i < vCount(); i++){
			if (matrix[v][i] != 0){
				return i;
			}
		}
		return vCount();
	}
	
	public int next(int v, int w){
		
		// returns next neighbor of w that is not v
		for (int i = v + 1; i < vCount(); i++){
			if (matrix[w][i] != 0 /*&& i != v */){
				return i;
			}
		}
		
		/* Teacher Code */
		// returns next neighbor of v that is not w
//		for (int i = w + 1; i < vCount(); i++){
//			if (matrix[v][i] != 0){
//				return i;
//			}
//		}
		
		return vCount();
	}
	
	public void addEdge(int vertex, int neighbor, int weight){
		// of adding weight is 0, complain
		matrix[vertex][neighbor] = weight;
	}
	
	public void removeEdge(int vertex, int neighbor){
		matrix[vertex][neighbor] = 0;
	}
	
	public boolean isEdge(int vertex, int neighbor){
		// > 0 is false because we can have negative weights
		return matrix[vertex][neighbor] != 0;
	}
	
	public int getMark(int v){
		return marks[v];
	}
	
	public void setMark(int v, int mark){
		marks[v] = mark;
	}
	
	
	
	
	
	
	
}
