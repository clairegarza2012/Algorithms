package edu.neumont.csc252;

public class DotsAndBoxes {

	public DotsAndBoxes(int rows, int columns){
		
	}
	
	public int drawLine(int player, int x1, int y1, int x2, int y2){
		// draws a line from (x1, y1) to (x2, y2) (0,0) is in the upper-left corner, returning how many points were earned, if any
		return -1;
	}
	
	public int score(int player){
		// returns the score for a player
		return -1;
	}
	
	public boolean areMovesLeft(){ // returns whether or not there are any lines to be drawn
		return false;
	}
	
	public int countDoubleCrosses(){
		// returns the number of double-crosses on the board
		return -1;
	}
	
	public int countCycles(){
		// returns the number of cycles on the board
		return -1;
	}
	
	public int countOpenChains(){
		// returns the number of open chains on the board
		return -1;
	}

}