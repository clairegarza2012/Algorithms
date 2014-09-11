package edu.neumont.csc250;

public class Multiples {

	
	public static void main(String[] args){
		
		int num = 2;
		int min = 1; 
		int max = 1000;
		
		//int ans = numberOfMultiples(num, min, max);
		int ans = numForPS();
		
		System.out.println(ans);
		
	}
	
	private static int numForPS(){
		int count = 0;
		
		for (int i = 1; i < 1000; i++){
			if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0){
				
			}
			else {
				count ++;
			}
		}
		
		return count;
	}
	
	private static int numberOfMultiples(int num, int min, int max){
		
		int count = 0;
		
//		if (min > max){
//			int temp = min;
//			min = max;
//			max = temp;
//		}
		
		for (int i = min; i < max; min++){
			if (i % num == 0){
				count ++;
			}
		}
		
		return count;
	}
}
