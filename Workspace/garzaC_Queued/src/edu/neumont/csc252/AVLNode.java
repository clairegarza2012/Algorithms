package edu.neumont.csc252;

public class AVLNode<T extends Comparable<T>> implements Comparable<AVLNode<T>>{

	private AVLNode<T> left = null;
	private AVLNode<T> right = null;
	
	// number of children levels
	private int height;
	private T value;
	// left child height = right child height
	private int balanceFactor;
	
	public AVLNode(T value){
		this.value = value;
	}
	
	public AVLNode<T> getLeft() {
		return left;
	}

	public void setLeft(AVLNode<T> left) {
		this.left = left;
	}

	public AVLNode<T> getRight() {
		return right;
	}

	public void setRight(AVLNode<T> right) {
		this.right = right;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public T getValue() {
		return value;
	}
	
	public int getBalanceFactor() {
		return balanceFactor;
	}

	public void setBalanceFactor(int balanceFactor) {
		this.balanceFactor = balanceFactor;
	}

	@Override
	public int compareTo(AVLNode<T> o) {
		return this.value.compareTo(o.getValue());
	}

	@Override
	public String toString() {
		return "AVLNode [height="
				+ height + ", value=" + value + ", balanceFactor="
				+ balanceFactor + "]";
	}
	
}