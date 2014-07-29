package edu.neumont.csc250;

import java.util.Arrays;
import java.util.Iterator;
import edu.neumont.util.List;

public class ArrayList<T> implements List<T> {

	private T[] array;
	private int size = 10;
	private int index = 0;

	@SuppressWarnings("unchecked")
	public ArrayList(){
		array = (T[]) new Object[size];
	}

	public Iterator<T> iterator() {

		return new MyIterator();
	}

	@Override
	public boolean add(T t) {

		if (t == null){
			return false;
		}

		if (index == size){
			size += size;
			array = Arrays.copyOf(array, size);
		}

		array[index] = t;
		index++;

		return true;
	}

	@Override
	public T get(int index) {

		return array[index];
	}

	@Override
	public boolean remove(T t) {

		for (int i = 0; i < array.length; i++){
			if (t == array[i]){
				break;
			}else if(i == array.length -1){
				return false;
			}
		}

		boolean removed = false;
		for (int i = 0; i < index; i++){

			if (removed){
				array[i] = array[i+1];
			}
			else if (array[i] == t){
				array[i] = array[i + 1];
				index--;
				removed = true;
			}

		}

		return true;
	}

	public int size() {

		return index;
	}

	public boolean addAll(List<T> list){

		if (list.size() <= 0 || list == null)
			return false;

		for (T t : list){
			this.add(t);
		}

		return true;
	}

	public boolean clear(){

		while (this.size > 0){
			this.remove(this.get(0));
		}
		return true;
	}

	class MyIterator implements Iterator<T>{

		int i = 0;

		@Override
		public boolean hasNext() {

			return array[i] != null;
		}

		@Override
		public T next() {

			T t = array[i];
			i++;

			return t;
		}

		@Override
		public void remove() {

		}

	}

}
