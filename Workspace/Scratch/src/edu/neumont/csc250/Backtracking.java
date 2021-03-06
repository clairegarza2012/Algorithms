package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

	public static void main(String[] args){

		Integer[] nums = {1, 2, 3, 4, 5};
		Integer[][] permutations  = findPermutatons(nums);

		print(permutations);
	}

	private static void print(Integer[][] permutations) {

		for (int i = 0; i < permutations.length; i++){
			for (int j = 0; j < permutations[i].length; j++){
				System.out.print(permutations[i][j] + ", ");
			}
			System.out.println();
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Integer[][] findPermutatons(Integer[] array){

		ArrayList soFar = new ArrayList();
		ArrayList toGo = new ArrayList();
		ArrayList successes = new ArrayList();

		for (int j = 0; j < array.length; j++){
			toGo.add(array[j]);
		}

		findPermutationsHelper(soFar, toGo, successes);

		int size = 1;
		
		for (int i = array.length; i > 0; i--){
			size *= i;
		}
		
		Integer[][] twoDArray = new Integer[size][array.length];

		int count = 0;
		for(int j = 0; j < twoDArray.length; j++){
			for (int k = 0; k < twoDArray[j].length; k ++){
				twoDArray[j][k] = (Integer)successes.get(count++);
			}				
		}

		return twoDArray;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void findPermutationsHelper(List soFar, List toGo, List successes){
		// success case
		// if toGO is empty, success!
		if (toGo.isEmpty() ){
			successes.addAll(soFar);
			return;
		}

		// failure case

		// for loop to try each element of toGO
		// "try" here means make a recursive call with a larger soFar and a smaller toGo

		for (int index = 0; index < toGo.size(); index++){

			Integer i  = (Integer)toGo.get(index);
			List newSoFar = new ArrayList(soFar);
			newSoFar.add(i);

			List newToGo = new ArrayList();
			newToGo.addAll(toGo);
			newToGo.remove(i);

			findPermutationsHelper(newSoFar, newToGo, successes);

		}
	}
}
