package edu.neumont.csc250;

public class Summations {

	public static void main(String[] args){

//		int oddSum = oddSum(999);
//		int evenSum = evenSum(1024);
//
//		int n = 10;
//		int start = 3;
//		int constantSum = constantSum(start, n + 1);
//
//		int in = 5;
//		int istart = 3;
//		int iSum = iSum(istart, in + 1);

		int max = 5;
//		int someSum = someSum(max);
//
//		int doubleSum = doubleSum(max);
//
//		int polySquaredSum = polySquaredSum(max - 1); 

		//double logSum = logSum(max - 1);
		
		//int sum = innerSum(max - 1);
		
		int sum = squaredSum(max);
		
		//int sum = addedSum(max - 1);
		
		System.out.println(sum);
	}

	private static int addedSum(int max) {

		int sum = 0;
		
		for (int i = 0; i <= max; i++){
			System.out.print(i +  " ");
			for (int j = 0; j <= i - 1; j++){
				sum += 1;
				System.out.print(j);
			}
			System.out.println();
		}
		
		return sum;
	}

	private static int squaredSum(int max) {

		int sum = 0;
		
		for (int i = 0; i < max; i++){
			sum += i * i;
			System.out.println(i + " " + sum);
		}
		
		return sum;
	}

	private static int innerSum(int max) {

		int sum = 0;
		
		for (int i = 0; i <= max; i++){
			System.out.print("i: " + i + " ");
			for (int j = 0; j <= i - 1; j++){
				sum += i+j;
				System.out.print("j: " + j + ", ");
			}
			System.out.println();
		}
		
		return sum;
	}

	private static double logSum(int max) {
		
		double sum = 0;
		
		for (int i = 2; i <= max; i++){
			sum += (Math.log10(i)/Math.log10(2)) * 2d;
			System.out.println("sum "+ sum + " i:" + i);
		}
		
		return sum; 
	}

	private static int polySquaredSum(int max) {

		int sum = 0;

		for (int i = 0; i <= max; i++){
				sum += Math.pow(i, 4) + (2 * (i * i)) + 1;
		}

		return sum;
	}

	private static int doubleSum(int max) {

		int sum = 0;

		for (int i = 1; i <= max; i++){
			for(int j = 1; j <= max; j++){
				sum += i*j;
				//System.out.println("sum:" + sum + " i:" + i + " j:" + j);
			}
		}

		return sum;
	}

	private static int someSum(int max) {

		int sum = 0;

		for (int i = 0; i <= max - 1; i++){
			sum += (i * i) + i;
		}

		return sum;
	}

	public static int oddSum(int max){

		int sum = 0;

		for(int i = 1; i <= max; i += 2){
			sum += i;
		}

		return sum;
	}

	public static int evenSum(int max){

		int sum = 0;

		for(int i = 2; i <= max; i += 2){
			sum += i;
		}

		return sum;
	}

	public static int constantSum(int start, int max){

		int sum = 0;

		for(int i = start; i <= max; i ++){
			sum ++;
		}

		return sum;
	}

	public static int iSum(int start, int max){

		int sum = 0;

		for(int i = start; i <= max; i ++){
			sum += i;
		}

		return sum;
	}
}
