package edu.neumont.csc250;

import java.util.HashMap;
import java.util.Iterator;

public class PrimeIterator implements Iterator<Integer>{

	private HashMap<Integer, Boolean> primes = new HashMap<Integer, Boolean>();
	int index = 1;
	
	public PrimeIterator(int max){
		
		primes = findPrimes(max);
	}
	
	@Override
	public boolean hasNext() {

		boolean primeFound = false;
		
		while(!primeFound){
			index++;
			if (primes.get(index))
				primeFound = true;
		}
		return index < primes.size();
	}

	@Override
	public Integer next() {
		
		System.out.println(index);
		return index;
	}

	@Override
	public void remove() {

		
	}
	
	private HashMap<Integer, Boolean> findPrimes(int max) {
		
		HashMap<Integer, Boolean> nums = new HashMap<Integer, Boolean>();
		// create a list of consecutive integers from 2 to n
		int num = 2;
		while(num < max){
			// assume all numbers are prime
			nums.put(num, true);
			num++;
		}

		for (int i = 2; i <= Math.sqrt(max); i++){	
			for (int j = 2 * i; j < max; j += i){
				nums.put(j, false);
			}
		}

		return nums;
	}

}
