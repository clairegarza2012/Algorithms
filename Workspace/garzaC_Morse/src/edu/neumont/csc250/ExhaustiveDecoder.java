package edu.neumont.csc250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import edu.neumont.nlp.DecodingDictionary;

public class ExhaustiveDecoder  {

	private DecodingDictionary dd = new DecodingDictionary();

	public List<String> decode(String message) {

		ArrayList<String> possibilities = new ArrayList<String>();
		ArrayList<String> soFar = new ArrayList<String>();

		decodeHelper(soFar, message, possibilities);

		HashMap<Float, String> idk = new HashMap<Float, String>();

		for (String s : possibilities){
			String [] strings = s.split(" ");
			
			float freq = 1;
			for (int i = 1; i < strings.length; i++){
				
				freq *= ((float)dd.frequencyOfFollowingWord(strings[i - 1], strings[i])) / 1000f;
			}
			idk.put(freq, s);
		}
		
		HashMap<Float, String> idk2 = new HashMap<Float, String>(20);

		int count = 0;
		for (Float i : idk.keySet()){
			
			if (count == 20){
				float remove = 1.5f;
				for (Float i2 : idk2.keySet()){
					if (i > i2){
						remove = i2;
					}
				}
				if (remove != 1.5){
					idk2.remove(remove);
					idk2.put(i, idk.get(i));
				}
			}
			else {
				idk2.put(i, idk.get(i));
				count ++;
			}
		}
		
		possibilities.clear();
		for (String i : idk2.values()){
			possibilities.add(i);
		}
		
		return possibilities;
	}

	private void decodeHelper(ArrayList<String> soFar, String toGo, List<String> possibilities){
		if (toGo.isEmpty() ){
			String ans = "";
			for (String i : soFar){
				ans += i + " ";
			}
			possibilities.add(ans);

			return;
		}

		for (int index = 1; index <= toGo.length(); index++){

			Set<String> words = dd.getWordsForCode(toGo.substring(0, index));

			String last = "";
			Iterator<String> it = soFar.iterator();

			while (it.hasNext()){
				last = it.next();
			}

			if (words != null){
				for (String s : words){

					float freq = 0f;

					if (!last.equals("")){
						freq = (float)dd.frequencyOfFollowingWord(last, s);
					}
					if(last.equals("") || freq > 400)
					{
						ArrayList<String> newSoFar = new ArrayList<String>();
						newSoFar.addAll(soFar);
						newSoFar.add(s);

						String newToGo = toGo.substring(index);

						decodeHelper(newSoFar, newToGo, possibilities);
					}
				}
			}
		}
	}
}







