package edu.neumont.csc250;

public class LCF {

	public static void main(String[] args){
		
		int a = 178;
		int b = 275;
		
		int resultIt = findLCFIterative(a, b);
		int resultRec = findLCFRecursive(a, b); 
		
		System.out.println(resultIt);
		System.out.println(resultRec);
	}
	
	public static int findLCFIterative(int a, int b){
		
		int lcf = -1;
		
		if (b > a){
			int temp = b;
			b = a;
			a = temp;
		}
		
		boolean numIsFound = false;
		
		while (!numIsFound){

			if(a % b == 0 || a == b){
				lcf = b;
				numIsFound = true;
			}
			else{
				int temp = a;
				a = b;
				b = temp % b;
			}
		}
		
		return lcf;
	}
	
	public static int findLCFRecursive(int a, int b){
	
		if (b > a){
			int temp = b;
			b = a;
			a = temp;
		}
		System.out.println("a: " + a + " b: " + b);
		if(a % b == 0 || a == b){
			return b;
		}
		
		return findLCFRecursive(b, a % b);
	}
	
}
