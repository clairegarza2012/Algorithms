package edu.neumont.csc250;

public class Summation {

	public static void main(String[] args){
	
		int sum = 0;
		int n = 63;
		int i = 1;
		sum = doubled(i, n);
		
		System.out.println(sum + 1);
	}

	private static int doubled(int i, int n) {
		int sum = 0;
		for (int j = i; j <= n; j++ ){
			i *= 2;
			System.out.println(i);
			sum += i;
		}
		return sum;
	}
	
}
