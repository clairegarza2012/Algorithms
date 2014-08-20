package edu.neumont.csc252;

public class HeapBasedPriorityQueue<T extends Comparable<T>>{

	private Heap<T> heap;
	
	public HeapBasedPriorityQueue(){
		heap = new Heap<T>();
	}
	
	public HeapBasedPriorityQueue(int initialSize){
		heap = new Heap<T>(initialSize);
	}
	
	public boolean offer(T t){
		return heap.insert(t);
	}
	
	public T peek(){
		return heap.getSmallest();
	}
	
	public T poll(){
		return heap.removeSmallest();
	}
	
	public int size(){
		return heap.size();
	}
}
