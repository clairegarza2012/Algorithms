package edu.neumont.csc252;

import java.util.Arrays;
import java.util.Iterator;

public class Heap<T extends Comparable<T>> {

	private T[] heap;
	private int index = 1;

	@SuppressWarnings("unchecked")
	public Heap(){
		heap = (T[]) new Comparable[8];
	}

	@SuppressWarnings("unchecked")
	public Heap(int initialSize){
		heap = (T[]) new Comparable[initialSize];
	}

	public Iterator<T> getIterator(){
		return new MyIterator();
	}

	public int size(){
		return index - 1;
	}
	
	public boolean insert(T t){

		if (index >= heap.length){
			heap = Arrays.copyOf(heap, heap.length * 2);
		}

		heap[index] = t;

		if (index > 1){
			insertHelper(index);
		}

		index++; 

		return true;
	}

	private void insertHelper(int index){

		if (index < 2){
			return;
		}
		if (heap[index] == null){
			return;
		}

		if (heap[index].compareTo(heap[index/2]) > 0){
			T temp = heap[index];
			heap[index] = heap[index/2];
			heap[index/2] = temp;
			insertHelper(index/2);
		}

	}

	public T getSmallest(){

		return heap[getSmallestIndex(heap.length)];
	}

	private int getSmallestIndex(int length) {

		if (length < 2){
			return 1;
		}

		if (heap[length/2] == null){
			return getSmallestIndex(length / 4 + 1);
		}

		int minIndex = length/2;

		for (int i = length / 2 + 1; i < length; i++){
			if (heap[i] != null && heap[i - 1] != null){
				if (heap[i].compareTo(heap[i-1]) < 0){
					minIndex = i;
				}
			}
		}

		return minIndex;
	}

	public T removeSmallest(){

		int i = getSmallestIndex(heap.length);
		T temp = heap[i];
		heap[i] = null;

		while (i < heap.length - 1){
			heap[i] = heap[++i];
		}
		heap[i] = null;

		index--; 
		
		return temp;
	}

	class MyIterator implements Iterator<T>{

		int i = 1;
		@Override
		public boolean hasNext() {
			return i < heap.length;
		}

		@Override
		public T next() {
			return heap[i++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
		}

	}


}
