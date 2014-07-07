package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer>{

	private ArrayList<Integer> primes = new ArrayList<Integer>();
	int index = 0;
	
	public PrimeIterator(int max){
		
		primes = findPrimes(max);
	}
	
	@Override
	public boolean hasNext() {

		return index < primes.size();
	}

	@Override
	public Integer next() {
		
		return primes.get(index++);
	}

	@Override
	public void remove() {

		
	}
	
	private static ArrayList<Integer> findPrimes(int max) {

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
					System.out.println("looping: " + j);
				}
			}
		}

		return nums;
	}

}
