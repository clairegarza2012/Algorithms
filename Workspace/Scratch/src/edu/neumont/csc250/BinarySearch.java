package edu.neumont.csc250;

import java.util.ArrayList;

public class BinarySearch {

	public static void main(String[] args){

		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(5);
		nums.add(7);
		nums.add(11); //
		nums.add(13); //
		nums.add(17);
		nums.add(19);
		nums.add(23); //
		nums.add(27);
		nums.add(31);
		nums.add(35);
		nums.add(38);
		nums.add(40);
		nums.add(45);

		int k = 45;

		int kIndex = findKIterative(nums, k);
		int kIndex2 = findKRecursive(nums, k);

		System.out.println("kIndex: " + kIndex);
		System.out.println("kIndex2: " + kIndex2);
	}

	private static int findKIterative(ArrayList<Integer> nums, int k) {

		int low = 0;
		int high = nums.size();

		boolean found = false;

		while (!found){

			int med = (high - low) / 2 + low;

			if ( nums.get(med) < k)
				low = med;
			else if ( nums.get(med) >  k)
				high = med;
			else{
				found = true;
				return med;	
			}

			if (med <= 0){
				found = true;
				return -1;
			}
		}

		return 0;
	}

	private static int findKRecursive(ArrayList<Integer>nums, int k){

		int i = nums.size()/ 2;
		int index = i;

		index = findkRecursiveHelper(nums, k, 0, nums.size());

		return index;
	}

	private static int findkRecursiveHelper(ArrayList<Integer> nums, int k, int low, int high){

		int med = (high - low) / 2 + low;

		if (nums.get(med) < k)
			low = med;
		else if (nums.get(med) > k)
			high = med;
		else
			return med;

		if (med <= 0)
			return med;

		return findkRecursiveHelper(nums, k, low, high);
	}







}
