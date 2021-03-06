package edu.neumont.csc250;

import java.util.Iterator;

import edu.neumont.util.Queue;

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

	private AttritionNode<T> head = null;
	
	@Override
	public Iterator<T> iterator() {

		return new MyIterator();
	}

	@Override
	public T poll() {
		
		if(head == null){
			return null;
		}

		AttritionNode<T> temp = head;
		head = head.getNext();

		return temp.getValue();
	}

	@Override
	public boolean offer(T t) {
		
		if(t == null){
			return false;
		}
		
		AttritionNode<T> newNode = new AttritionNode<T>(t);
		AttritionNode<T> temp = head;
		
		if(head == null){
			head = newNode;
			
		}else if(head.getNext() == null){
			
			if(head.compareTo(newNode) > 0){
				head = newNode;
				head.setNext(temp);
			}
			else{
				head.setNext(newNode);
			}
		}
		else{
						
			while (true){
			
				if(temp.compareTo(newNode) > 0 && temp == head){
					
					head = newNode;
					head.setNext(temp);
					break;
				}
				else if(temp.getNext() == null){
					
					if(temp.compareTo(newNode) > 0){
						AttritionNode<T> save = temp;
						temp = newNode;
						temp.setNext(save);
					}
					else{
						temp.setNext(newNode);
					}
					break;
				}
				else if (temp.getNext().compareTo(newNode) > 0){
					
					AttritionNode<T> saveNext = temp.getNext();
					temp.setNext(newNode);
					newNode.setNext(saveNext);
				    
					break;
				}
				
				temp = temp.getNext();
			}
		}

		return true;
	}

	@Override
	public T peek() {

		return head.getValue();
	}
	
	class MyIterator implements Iterator<T>{

		AttritionNode<T> node = head;
		
		@Override
		public boolean hasNext() {

			return node != null;
		}

		@Override
		public T next() {
			
			AttritionNode<T> temp = node;
			node = node.getNext();

			return (T) temp.getValue();
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}
		
	}

}
