package edu.neumont.csc250;

import java.util.ArrayList;

public class FindK {

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

		int k = 40;

		int kIndex = findKIterative(nums, k);
		int kIndex2 = findKRecursive(nums, k);

		System.out.println("kIndex: " + kIndex);
		System.out.println("kIndex2: " + kIndex2);
	}

	private static int findKIterative(ArrayList<Integer> nums, int k) {

		int i = nums.size() / 2;
		int index = i;
		int count = 1;
		boolean found = false;

		while (!found){
			if ((nums.get(index)) == k){
				found = true;
				return index;
			}
			else if ((nums.get(index)) < k){
				i = i / 2;
				index += i;
			}
			else if ((nums.get(index)) >  k){
				i = i / 2;
				index -= i;
			}
			
			if (i == 0){
				if (count == 2){
					found = true;
					return -1;
				}else{
					count ++;
					index = 0;
				}
			}
		}

		return 0;
	}

	private static int findKRecursive(ArrayList<Integer>nums, int k){

		int i = nums.size()/ 2;
		int index = i;

		index = findK(nums, k, i, index);

		return index;
	}

	private static int findK(ArrayList<Integer> nums, int k, int i, int index) {
		
		i = i / 2;
		
		if (nums.get(index) == k){
			return index;
		}
		else if(nums.get(index) < k){		
			index += i;
		}else if (nums.get(index) > k){
			index -= i;
		}
		
		if(i <= 0){
			return -1;
		}
		
		return findK(nums, k, i, index);
	}







}
