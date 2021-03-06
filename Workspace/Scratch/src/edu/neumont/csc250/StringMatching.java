package edu.neumont.csc250;

public class StringMatching {

	public static void main(String[] args) {

		String text = "racecaracar";
		String pattern = "car";
		
		int count = findPattern(text, pattern);
		
		System.out.println(count);
	}

	private static int findPattern(String text, String pattern) {
		int count = 0;
		
		if(pattern.length() > text.length()) return 0;
		
		for(int i = 0; i < text.length(); i++){

			if(text.charAt(i) == pattern.charAt(0))
			{				
				int size = 0;
				for (int k = 0; text.charAt(i) == pattern.charAt(k); k++){
					size++;
					
					if((i+1) <= text.length()-1 && k+1 < pattern.length()){
						i++;
					}else{
						break;
					}
				}
				if(size == pattern.length())
					count++;
			}
		}
		
		return count;
	}

}
