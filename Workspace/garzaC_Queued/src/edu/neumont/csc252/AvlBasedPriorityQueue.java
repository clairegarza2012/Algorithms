package edu.neumont.csc252;

public class AvlBasedPriorityQueue<T extends Comparable<T>> {

	private AVLTree<T> tree = new AVLTree<T>();
	
	public boolean offer(T t){
		return tree.insert(t);
	}
	
	public T peek(){
		return tree.getSmallest().getValue();
	}
	
	public T poll(){
		return tree.delete();
	}
	
	public int size(){
		return tree.size();
	}
}
