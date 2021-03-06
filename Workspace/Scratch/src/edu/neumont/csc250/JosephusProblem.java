package edu.neumont.csc250;

import java.util.ArrayList;

public class JosephusProblem {

	public static void main(String[] args){
		int n = 16;

		ArrayList<Integer> endNumbers = new ArrayList<Integer>();
		
		for (int i = 2; i <= 25; i++){
			int lastNumber = findLast(i);
			endNumbers.add(lastNumber);
		}
		
		for (Integer i : endNumbers){
			System.out.println(i);
		}
	}

	private static int findLast(int n) {

		ArrayList<Integer> nums = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++){
			nums.add(i);
		}

		int size = nums.size() - 1;
		
		int index = 1;
		for (int i = 0; i < size; i++){
			
			if(index == nums.size()){
				index = 0;
			}else if (index > nums.size()){
				index = 1;
			}
			nums.remove(index);
			
			index += 1;
		}

		return nums.get(0);
	}
}
