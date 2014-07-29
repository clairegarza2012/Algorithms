package edu.neumont.csc250;

import edu.neumont.util.Client;

public class MyClient extends Client implements Comparable<Object>{

	private int attritionTime;
	
	public MyClient(int expectedServiceTime, int attritionTime) {
		super(expectedServiceTime);
		this.attritionTime = attritionTime;
	}

	public int getAttritionTime(){
		return attritionTime;
	}
	
	public int waitedMinute(){
		attritionTime--;
		return attritionTime;
	}
	
	@Override
	public int compareTo(Object o) {
		return this.compareTo(o);
	}

}
