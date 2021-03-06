package edu.neumont.csc252;

import java.awt.Color;

import edu.neumont.ui.Picture;

public class SeamCarver {

	private Picture picture;
	private Node[] nodes;

	public SeamCarver(Picture pic){
		picture = pic;
		nodes = new Node[pic.width() * pic.height()];
	}

	public Picture getPicture(){
		// get the current image
		return picture;
	}

	public int width(){
		return picture.width();
	}

	public int height(){
		return picture.height();
	}

	private double energy(int x, int y){
		// the energy of a pixel at (x,y)

		if (x > picture.width() || y > picture.height()){
			throw new IndexOutOfBoundsException();
		}
		Color left = (x - 1 < 0) ? picture.get(picture.width() - 1, y) : picture.get(x - 1, y);			
		Color right = (x + 1 == picture.width()) ? picture.get(0, y) : picture.get(x + 1, y);		

		int redX = left.getRed() - right.getRed();
		int greenX = left.getGreen() - right.getGreen();
		int blueX = left.getBlue() - right.getBlue();

		double changeX = Math.pow(redX, 2) + Math.pow(greenX, 2) + Math.pow(blueX, 2);

		Color top = (y - 1 < 0) ? picture.get(x, picture.height() - 1) : picture.get(x, y - 1);		
		Color bottom = (y + 1 == picture.height()) ? picture.get(x, 0) : picture.get(x, y + 1);		

		int redY = top.getRed() - bottom.getRed();
		int greenY = top.getGreen() - bottom.getGreen();
		int blueY = top.getBlue() - bottom.getBlue();

		double changeY = Math.pow(redY, 2) + Math.pow(greenY, 2) + Math.pow(blueY, 2);

		double energy = changeY + changeX;

		return energy;
	}

	public int[] findHorizontalSeam(){
		// the sequence of indices for a horizontal seam
		int[] path = new int[picture.width()];

		for (int index = 0; index < picture.width() * picture.height(); index++){	
			int y = index / picture.width();
			int x = index - (picture.width() * y);
			Node node = new Node(this.energy(x, y));
			if (x == 0){
				node.setWeight(0);
			}else{
				node.setWeight(Double.MAX_VALUE);
			}
			nodes[index] = node;
		}

		for (int index = 0; index < picture.width(); index++){
			for(int index2 = 0; index2 < picture.height(); index2++)
			{
				int y = index2;
				int x = index;
				int newIndex = picture.width()*y+x;

				if (x != picture.width() -1){
					if (y == 0){
						int mid = newIndex + 1;
						int bottom = newIndex + picture.width() + 1;

						this.setBetterParent(mid, newIndex);
						this.setBetterParent(bottom, newIndex);
					}else if (y == picture.height() - 1){
						int mid = newIndex + 1;
						int top = newIndex - picture.width() + 1;

						this.setBetterParent(mid, newIndex);
						this.setBetterParent(top, newIndex);

					}else{
						int mid = newIndex + 1;
						int bottom = newIndex + picture.width() + 1;
						int top = newIndex - picture.width() + 1;

						this.setBetterParent(mid, newIndex);
						this.setBetterParent(bottom, newIndex);
						this.setBetterParent(top, newIndex);
					}
				}
			}
		}

		for (int i = picture.width() - 1; i < picture.width() * picture.height(); i += picture.width()){

			nodes[i].setWeight(nodes[i].getEnergy() + nodes[i].getWeight());
		}

		int minIndex = picture.width() - 1;
		for (int i = picture.width() - 1; i < picture.width() * picture.height(); i += picture.width()){

			if (nodes[i].getWeight() < nodes[minIndex].getWeight()){
				minIndex = i;
			}
		}


		int index = picture.width() - 1;
		int parentIndex = minIndex;

		while (parentIndex != -1){

			path[index] = parentIndex; 
			parentIndex = nodes[parentIndex].getParent();

			index--;
		}

		return path;
	}


	private void setBetterParent(int nIndex, int pIndex){

		if (nodes[nIndex].getWeight() > (nodes[pIndex].getWeight() + nodes[pIndex].getEnergy()) ){
			nodes[nIndex].setWeight(nodes[pIndex].getWeight() + nodes[pIndex].getEnergy());
			nodes[nIndex].setParent(pIndex);
		}
	}

	public int[] findVerticalSeam(){

		int[] path = new int[picture.height()];

		for (int index = 0; index < picture.width() * picture.height(); index++){	
			int y = index / picture.width();
			int x = index - (picture.width() * y);

			Node node = new Node(this.energy(x, y));
			if (y == 0){
				node.setWeight(0);
			}else{
				node.setWeight(Double.MAX_VALUE);
			}
			nodes[index] = node;
		}

		for (int index = 0; index < picture.width() * picture.height() - picture.width(); index++){
			int y = index / picture.width();
			int x = index - (picture.width() * y);

			if (x == 0){
				int childBottom = index + picture.width();
				int childRight = index + picture.width() + 1;

				this.setBetterParent(childBottom, index);
				this.setBetterParent(childRight, index);
			}
			else if (x == picture.width() - 1){
				int childBottom = index + picture.width();
				int childLeft = index + picture.width() - 1;

				this.setBetterParent(childBottom, index);
				this.setBetterParent(childLeft, index);
			}
			else{
				int childLeft = index + picture.width() - 1;
				int childBottom = index + picture.width();
				int childRight = index + picture.width() + 1;

				this.setBetterParent(childLeft, index);
				this.setBetterParent(childBottom, index);
				this.setBetterParent(childRight, index);
			}		
		}

		for (int i = picture.width() * picture.height()- picture.width(); i < picture.width() * picture.height(); i++){

			nodes[i].setWeight(nodes[i].getWeight() + nodes[i].getEnergy());
		}

		int minIndex = picture.width() * picture.height() - picture.width();
		for (int i = picture.width() * picture.height()- picture.width(); i < picture.width() * picture.height(); i++){

			if (nodes[i].getWeight() < nodes[minIndex].getWeight()){
				minIndex = i;
			}
		}

		int index = picture.height() - 1;
		int parentIndex = minIndex;
		while (parentIndex != -1){

			path[index] = parentIndex; 
			parentIndex = nodes[parentIndex].getParent();

			index--;
		}

		return path;
	}

	public void removeHorizontalSeam(int[] indices){

		if (indices.length != picture.width() || picture.height() == 1){
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < indices.length; i++){
			int index = indices[i];

			if (index > picture.width() * picture.height() || index < 0){
				throw new IndexOutOfBoundsException();
			}

			for (int j = index + picture.width(); j < (picture.height() * picture.width()) - picture.width(); j += picture.width()){
				int y2 = j / picture.width();
				int x2 = j - (picture.width() * y2);
				Color color = picture.get(x2, y2);

				int y1 = y2-1;
				int x1 = x2;

				if ( x2 < x1 - 1 || x2 > x1 + 1 || y2 != y1 + 1 ){
					throw new IllegalArgumentException();
				}

				picture.set(x1, y1, color);
			}
		}

		this.resizePictureHeight();
	}

	public void removeVerticalSeam(int[] indices){

		if (indices.length != picture.height() || picture.width() == 1){
			throw new IllegalArgumentException();
		}

		for (int i = 0; i < indices.length; i++){
			int index = indices[i];

			if (index > picture.width() * picture.height() || index < 0){
				throw new IndexOutOfBoundsException();
			}

			for (int j = index + 1; j % picture.width() != 0; j++){
				int y2 = j / picture.width();
				int x2 = j - (picture.width() * y2);
				Color color = picture.get(x2, y2);

				int y1 = (j - 1) / picture.width();
				int x1 = (j - 1) - (picture.width() * y1);

				if (x2 != x1 + 1 || y2 < y1 - 1 || y2 > y1 + 1 ){
					throw new IllegalArgumentException();
				}

				picture.set(x1, y1, color);
			}
		}		

		this.resizePictureWidth();
	}

	private void resizePictureHeight(){
		Picture pic = new Picture(picture.width(), picture.height() - 1);

		for (int i = 0; i < pic.width(); i++){
			for (int j = 0; j < pic.height(); j++){
				Color color = picture.get(i, j);
				pic.set(i, j, color);
			}
		}

		picture = pic;
		nodes = new Node[pic.width() * pic.height()];

	}

	private void resizePictureWidth(){
		Picture pic = new Picture(picture.width() - 1, picture.height());

		for (int i = 0; i < pic.width(); i++){
			for (int j = 0; j < pic.height(); j++){
				Color color = picture.get(i, j);
				pic.set(i, j, color);
			}
		}

		picture = pic;
		nodes = new Node[pic.width() * pic.height()];

	}



























}
