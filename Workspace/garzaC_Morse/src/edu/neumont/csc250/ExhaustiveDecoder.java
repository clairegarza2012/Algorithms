package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.List;
import edu.neumont.nlp.DecodingDictionary;

public class ExhaustiveDecoder  {

	private ArrayList<String> list = new ArrayList<String>();
	
	public List<String> decode(String message) {
		
		DecodingDictionary dd = new DecodingDictionary();
		ExhaustiveDecoder decoder = new ExhaustiveDecoder();
		List<String> possibilities = decoder.decode(".......---.----.-.....------..-.-.");
		
		for ( int i = 0; i < possibilities.size(); i++ ) {
			System.out.println(i + ": " + possibilities.get(i));
		}
		
		return null;
	}
	
	public void decodeHelper(){
		
		
	}
}
