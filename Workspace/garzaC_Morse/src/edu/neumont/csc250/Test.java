package edu.neumont.csc250;

import java.util.List;

public class Test {

	public static void main(String[] args){
		
		ExhaustiveDecoder decoder = new ExhaustiveDecoder();
		
		List<String> possibilities = decoder.decode("....-.-.-.---..--.-..--..-...--..-.........");
		List<String> possibilities2 = decoder.decode("-.....-.-.----.........-----.-.-.-...-.--.");
		List<String> possibilities3 = decoder.decode(".--..-...-..-..----..");
		List<String> possibilities4 = decoder.decode(".--.-...--..-.-.--.-.----.");

		//List<String> possibilities = decoder.decode(".......---.----.-.....------..-.-.");
		
		for ( int i = 0; i < possibilities.size(); i++ ) {
			System.out.println(i + 1 + ": " + possibilities.get(i));
		}
		System.out.println();
		for ( int i = 0; i < possibilities2.size(); i++ ) {
			System.out.println(i + 1 + ": " + possibilities2.get(i));
		}
		System.out.println();
		for ( int i = 0; i < possibilities3.size(); i++ ) {
			System.out.println(i + 1 + ": " + possibilities3.get(i));
		}
		System.out.println();
		for ( int i = 0; i < possibilities4.size(); i++ ) {
			System.out.println(i + 1 + ": " + possibilities4.get(i));
		}
		
	}
}
