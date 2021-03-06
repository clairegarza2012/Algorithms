package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.HashMap;

public class PrimeNumbers {

	public static void main(String[] args) {

		int max = 300;

		ArrayList<Integer> primes = findPrimes(max);
		HashMap<Integer, Boolean> primes2 = findPrimesNoMod(max);

		print(primes);
		printHash(primes2);
	}

	private static HashMap<Integer, Boolean> findPrimesNoMod(int max) {

		HashMap<Integer, Boolean> nums = new HashMap<Integer, Boolean>();
		// create a list of consecutive integers from 2 to n
		int num = 2;
		while(num < max){
			// assume all numbers are prime
			nums.put(num, true);
			num++;
		}
		int jIndex = 2;
		for (int i = 2; i <= Math.sqrt(max); i = jIndex){
			
			boolean foundPrime = false;
			while(!foundPrime){
				if( (nums.get(jIndex)) ){
					foundPrime = true;
				}else{
					jIndex++;
				}
			}
			
			for (int j = (int) Math.pow(jIndex, 2); j < max; j += jIndex){
				nums.put(j, false);
			}
			jIndex ++;
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

	private static void printHash(HashMap<Integer, Boolean> nums){
		nums.put(0, true);
		int count = 1;
		for (Integer i : nums.keySet()){
			if (nums.get(i)){
				System.out.print(i + "\t");
				count++;
			}
			if (count % 11 == 0){
				System.out.println();
				count = 1;
			}
		}
		System.out.println("\nsize: " + (nums.size() -1));
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
