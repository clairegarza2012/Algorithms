package edu.neumont.csc250;

public class TreeNode<T extends Comparable<T>> implements Comparable<T>{

	public T data;
	public TreeNode<T> leftDecsendent;
	public TreeNode<T> rightDecsendent;
	
	public TreeNode(T value){
		this.data = value;
	}
	
	@Override
	public int compareTo(T o) {
		return this.data.compareTo(o);
	}
	
	
}
