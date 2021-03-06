package edu.neumont.csc250;

import java.util.Iterator;

import edu.neumont.util.Queue;

public class LinkedList<T> implements Queue<T>{

	Node<T> head = null;
	Node<T> tail = null;

	@Override
	public Iterator<T> iterator() {
		return new MyIterator();
	}

	@Override
	public T poll() {
		
		if (head == null){
			return null;
		}
		T t = head.getValue();

		head = head.getNext();

		return t;
	}

	@Override
	public boolean offer(T t) {

		if(t == null){
			return false;
		}
		
		if(head == null){
			head = new Node<T>(t);
			tail = head;
			head.setNext(tail);
		}else{
			Node<T> newNode = new Node<T>(t);
			tail.setNext(newNode);
			tail = newNode;
		}

		return true;
	}

	@Override
	public T peek() {

		return head.getValue();
	}

	class MyIterator implements Iterator<T>{

		Node<T> node = head;

		@Override
		public boolean hasNext() {

			return node != null;
		}

		@Override
		public T next() {

			Node<T> temp = node;

			node = node.getNext();

			return temp.getValue();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}

	}

}
