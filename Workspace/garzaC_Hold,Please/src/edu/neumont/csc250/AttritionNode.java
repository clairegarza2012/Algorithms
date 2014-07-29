package edu.neumont.csc250;

public class AttritionNode<T extends Comparable<T>>{

	private T value;
	private AttritionNode<T> next;
	private AttritionNode<T> before;
	
	public AttritionNode<T> getBefore() {
		return before;
	}

	public void setBefore(AttritionNode<T> before) {
		this.before = before;
	}

	public AttritionNode(T item){
		value = item;
	}

	public AttritionNode<T> getNext() {
		return next;
	}

	public void setNext(AttritionNode<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}

	public int compareTo(AttritionNode<T> o) {

		return value.compareTo(o.value);
	}
}
