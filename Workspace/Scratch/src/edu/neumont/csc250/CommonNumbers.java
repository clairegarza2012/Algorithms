package edu.neumont.csc250;

import java.util.ArrayList;

public class CommonNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(3);
		list1.add(4);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(5);
		list2.add(6);
		list2.add(8);
		list2.add(9);
		list2.add(1);

		ArrayList<Integer> commonNums = findCommonNums(list1, list2);
		print(commonNums);
	}

	private static ArrayList<Integer> findCommonNums(ArrayList<Integer> list1,
			ArrayList<Integer> list2) {

		ArrayList<Integer> commonNums = new ArrayList<Integer>();
		
		int count = 0;
		for(int i = 0; i < list1.size(); i++){
			for (int j = 0; j < list2.size(); j++){
				count++;
				if(list1.get(i) == list2.get(j)){
					commonNums.add(list1.get(i));
					list1.remove(i);
					list2.remove(j);
				}
			}
		}
		System.out.println(count);
		
		return commonNums;
	}

	private static void print(ArrayList<Integer> commonNums) {
		for (Integer i : commonNums){
			System.out.print(i +", ");
		}
	}
}
