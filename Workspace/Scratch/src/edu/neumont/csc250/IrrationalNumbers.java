package edu.neumont.csc250;

public class IrrationalNumbers {

	public static void main(String[] args){
		
		double a = Math.PI;
		double b = Math.E;
		
		double piToE = findProduct(a, b);
		double eToPi = findProduct(b, a);
		
		double rt2 = Math.sqrt(2);
		
		double piTo2 = findProduct(a, rt2);
		double rt2ToPi = findProduct(rt2, a);
		
		System.out.println(rt2ToPi);
	}

	private static double findProduct(double a, double b) {
		
		return Math.pow(a, b);
	}
	
}
