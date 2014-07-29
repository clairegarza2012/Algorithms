package edu.neumont.csc250;

public class Node<T> {

	private T value;
	private Node<T> next;
	
	public Node(T item){
		value = item;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getValue() {
		return value;
	}
}
