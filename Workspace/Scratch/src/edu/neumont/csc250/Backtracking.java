package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {

	public static void main(String[] args){

		Integer[] nums = {1, 2, 3, 4, 5};
		findPermutatons(nums);
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

		for(int j = 0; j < successes.size(); j++){
			System.out.print(successes.get(j) + ", ");
		}

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void findPermutationsHelper(List soFar, List toGo, List successes){
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
			//Integer j = toGo.indexOf(i);
			toGo.remove(i);

			findPermutationsHelper(newSoFar, toGo, successes);

		}
	}
}
