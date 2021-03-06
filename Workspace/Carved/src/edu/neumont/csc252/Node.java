package edu.neumont.csc252;

public class Node {

	private int parent = -1;
	private double weight;
	private double energy;
	
	public Node(double energy){
		this.energy = energy;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double getEnergy(){
		return this.energy;
	}
	
}
