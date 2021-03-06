package edu.neumont.csc252;

import java.util.List;

public class DotsAndBoxes {

	private Graph g;
	private int[] players;
	private int columnNum;
	private int numberOfVerticies;

	public DotsAndBoxes(int rows, int columns){

		this.columnNum = columns + 1;
		players = new int[2];
		this.numberOfVerticies = (rows + 1) * (columns + 1);

		g = new Graph( numberOfVerticies );

		for (int j = 0; j < g.vcount(); j++){

			if (j - (columnNum) > 0 
					&& j + (columnNum) < numberOfVerticies - 1
					&& (j + 1)  % (columnNum) != 0 
					&& j % (columnNum) != 0){

				g.addEdge(j, j - (columnNum) , 1);
				g.addEdge(j, j + (columnNum), 1);
				g.addEdge(j, (j - 1) , 1);
				g.addEdge(j, (j + 1), 1);
			}

		} 

	}

	public int drawLine(int player, int x1, int y1, int x2, int y2){

		x2 = Math.max(x1, x2);
		y2 = Math.max(y1, y2);

		int points = 0;

		int v = x2 + (y2 * columnNum);
		int w = -1;

		if (x1 == x2){
			w = v + 1;
		}
		else if (y1 == y2){
			w = v + columnNum;
		}

		if ( w != -1){

			g.removeEdge(v, w);
			int vDeg = g.degree(v);
			int wDeg = g.degree(w);

			if (vDeg == 0 && !(this.onOutside(v)) ){
				points++;
			}
			if (wDeg == 0 && !(this.onOutside(w)) ){
				points++;
			}
			players[player - 1] = players[player - 1] + points;

			return points;
		}

		return -1;
	}

	public int score(int player){
		return players[player - 1];
	}

	public boolean areMovesLeft(){ 

		DfsGraphTraversal dgt = new DfsGraphTraversal();
		List<List<Integer>> forest = dgt.traverse(g);

		return forest.size() != this.numberOfVerticies;
	}

	public int countDoubleCrosses(){

		DfsGraphTraversal dgt = new DfsGraphTraversal();
		List<List<Integer>> forest = dgt.traverse(g);

		int count = 0;

		for (List<Integer> i : forest){
			if (i.size() == 2){
				if (!this.onOutside(i.get(0)) && !this.onOutside(i.get(1)) ){
					count ++;
				}
			}
		}

		return count;
	}

	public int countCycles(){
		// returns the number of cycles on the board
		DfsGraphTraversal dgt = new DfsGraphTraversal();
		List<List<Integer>> forest = dgt.traverse(g);
		
		int count = 0;
		
		for (List<Integer> i : forest){
			
			boolean all2 = true;
			for (int j = 0; j < i.size() && all2; j++){
				
				if (g.degree(i.get(j)) == 2){
					System.out.println(i.get(j) + " " + i.get(0));
					if (j == i.size() - 1){
						System.out.println(i.get(j) + " " + i.get(0));
						if (g.isEdge(i.get(0), i.get(j) )){
							count++;
						}
					}
				}
				else{
					all2 = false;
				}
			}
		}
		
		return count;
	}

	public int countOpenChains(){
		// returns the number of open chains on the board
		return -1;
	}

	private boolean onOutside(int v){

		if (v < this.columnNum){
			return true;
		}
		else if (v % this.columnNum == 0 ){
			return true;
		}
		else if ((v + 1) % this.columnNum == 0  ){
			return true;
		}
		else if (v > (this.numberOfVerticies - 1) - this.columnNum){
			return true;
		}

		return false;
	}

}
