package edu.neumont.csc252;

import java.util.Arrays;

public class FrequencyNode implements Comparable<FrequencyNode>{ 

	private FrequencyNode left = null;
	private FrequencyNode right = null;
	
	private double frequency = 0;
	private byte[] value;
		
	public FrequencyNode(double frequency, byte[] value){
		
		this.frequency = frequency;
		this.value = value;
	}

	public FrequencyNode getLeft() {
		return left;
	}

	public void setLeft(FrequencyNode left) {
		this.left = left;
	}

	public FrequencyNode getRight() {
		return right;
	}

	public void setRight(FrequencyNode right) {
		this.right = right;
	}

	public double getFrequency() {
		return frequency;
	}

	public byte[] getValue() {
		return value;
	}

	@Override
	public int compareTo(FrequencyNode o) {
		return new Double(frequency).compareTo(new Double(o.frequency));
	}

	@Override
	public String toString() {
		return "FrequencyNode [left=" + left + ", right=" + right
				+ ", frequency=" + frequency + ", value="
				+ Arrays.toString(value) + "]";
	}
	
}
