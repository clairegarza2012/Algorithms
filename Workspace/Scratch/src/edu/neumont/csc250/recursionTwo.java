package edu.neumont.csc250;

public class recursionTwo {

	public static void main(String[] args){
				
		int n = 5;
		int value = fastFib(n);
		
		System.out.println(value);
	}
	
	public static int fibinacci(int n){
		
		if (n < 2){
			return n;
		}
		
		return fibinacci(n-1) + fibinacci(n - 2);
	}
	
	public static int fastFib(int n){
		
		int[] fibs = new int[n + 1];
		return fastFib(n, fibs);
	}
	
	private static int fastFib(int n, int[] fibs){
		
		if (n < 2) return n;
		
		if (fibs[n] != 0){
			return fibs[n];
		}
		
		return fibs[n] = fastFib(n-1, fibs) + fastFib(n-2, fibs);
	}
	
	public static int aBetterFib(int n){
		
		if (n < 2) return n;
		
		int[] fibs = new int[n+1];
		
		fibs[0] = 0;
		fibs[1] = 1;
		
		for (int i = 2; i <= n; i++){
			fibs[i] = fibs[i-2] + fibs[i-1];
		}
		
		return fibs[n];
	}
	
}
