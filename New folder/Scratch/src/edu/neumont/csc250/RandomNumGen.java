package edu.neumont.csc250;

public class RandomNumGen {
	
	public static void main(String[] args) {
		int i = (int) (Math.random()* 100);
		int j = (int) (Math.random()* 100);
		
		System.out.println(i + "\t" + j);
	}

}
