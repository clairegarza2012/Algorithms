package edu.neumont.csc250;

import java.util.ArrayList;

public class PrimeNumbers {

	public static void main(String[] args) {

		int max = 300 * 300;

		ArrayList<Integer> primes = findPrimes(max);
		//ArrayList<Integer> primes2 = findPrimesNoMod(max);

		print(primes);
		//print(primes2);
	}

	private static ArrayList<Integer> findPrimesNoMod(int max) {
		ArrayList<Integer> nums = new ArrayList<Integer>();

		int num = 2;
		while(num < max){
			nums.add(num);
			num++;
		}

		for (int i = 2; i <= Math.sqrt(max); i++){	
			for (int j = (int)Math.pow((double)i, 2d); j < max; j+=i){
				if(nums.contains(j)){
					int jIndex = nums.indexOf(j);
					nums.remove(jIndex);
				}
			}
		}

		return nums;
	}

	private static ArrayList<Integer> findPrimes(int max) {

		ArrayList<Integer> nums = new ArrayList<Integer>();

		int num = 2;
		while(num < max){
			nums.add(num);
			num++;
		}

		//int numOfIts = 0;

		for (int i = 2; i <= Math.sqrt(max); i++){	
			for (int j = i + 1; j < max; j++){
				if(j % i == 0){
					if(nums.contains(j)){
						int jIndex = nums.indexOf(j);
						nums.remove(jIndex);
					}
				}
			}
			//numOfIts++;
		}
		//System.out.println("Number of Iterations: " + numOfIts);

		return nums;
	}


	private static void print(ArrayList<Integer> primes) {
		primes.add(0, 0);
		int count = 0;
		for (Integer i : primes){
			System.out.print(i + ",\t");
			count++;
			if (count % 10 == 0)
				System.out.println();
		}		
		System.out.println("\nsize: " + (primes.size()-1));
	}
}