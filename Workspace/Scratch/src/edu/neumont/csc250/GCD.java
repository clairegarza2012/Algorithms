package edu.neumont.csc250;

public class GCD {

	public static void main(String[] args) {
	
		int m = 12;
		int n = 56;
		int result = findGCD(m, n);
		
		System.out.println(result);
	}

	private static int findGCD(int m, int n) {
		
		if (n > m){
			int temp = m;
			m = n;
			n = temp;
		}
		
		if(n == 0)
		{
			return m;
		}
		
		return findGCD(n, m % n);
	}

}
