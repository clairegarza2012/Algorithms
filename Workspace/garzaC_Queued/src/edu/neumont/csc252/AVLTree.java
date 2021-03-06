package edu.neumont.csc252;

public class AVLTree<T extends Comparable<T>> {

	private AVLNode<T> root = null;

	public AVLTree(){ }

	public int height() {
		return height(root);
	}

	private int height(AVLNode<T> root) {
		if ( root == null ) return -1;
		return Math.max(height(root.getRight()), height(root.getLeft())) + 1;
	}

	public int balance() {
		return height(root.getLeft()) - height(root.getRight());
	}

	public boolean insert(T t){

		AVLNode<T> node = new AVLNode<>(t);
		if (root == null){
			root = node;
		}
		else {
			insertNode(root, node);
		}
		
		this.balanceTree(root, null);

		return true;
	}

	private boolean insertNode(AVLNode<T> root, AVLNode<T> node){

		if (root.getLeft() == null && root.getRight() == null){
			if (root.compareTo(node) > 0){
				root.setLeft(node);
			}else if (root.compareTo(node) <= 0){
				root.setRight(node);
			}
			return true;
		}

		if (root.compareTo(node) > 0){
			if (root.getLeft() == null){
				root.setLeft(node);
				return true;
			}
			return insertNode(root.getLeft(), node);
		}else if (root.compareTo(node) <= 0){
			if (root.getRight() == null){
				root.setRight(node);
				return true;
			}
			return insertNode(root.getRight(), node);
		}

		return false;
	}

	private void balanceTree(AVLNode<T> root, AVLNode<T> parent){

		if (root == null){
			return;
		}

		balanceTree(root.getLeft(), root);
		balanceTree(root.getRight(), root);
		
		int leftHeight = 0;
		int rightHeight = 0;
		
		if (root.getLeft() != null){
			leftHeight = this.height(root.getLeft());
		}
		if (root.getRight() != null){
			rightHeight = this.height(root.getRight());
		}
		
		int balanceFactor = leftHeight - rightHeight;
		
		if (balanceFactor >= 2 || balanceFactor <= -2){
			this.balance(root, parent);
		}
	}

	private void balance(AVLNode<T> node, AVLNode<T> parent){
	
		if (this.height(node.getLeft()) - this.height(node.getRight()) > 0){

			if (this.height(node.getLeft().getLeft()) - this.height(node.getLeft().getRight()) < 0){
				rotateLeft(node.getLeft(), parent);
				rotateRight(node, parent);
				System.out.println("I'm getting called");
			}
			else{
				rotateRight(node, parent);
			}
		}

		else{
			if (this.height(node.getRight().getLeft()) - this.height(node.getRight().getRight()) > 0){
				rotateRight(node.getRight(), parent);
				rotateLeft(node, parent);
			}
			else{
				rotateLeft(node, parent);
			}
		}
	}
	
	private void rotateRight(AVLNode<T> node, AVLNode<T> parent){

		AVLNode<T> pivot = node.getLeft();

		if (parent != null){
			if (parent.getRight() == node){
				parent.setRight(pivot);
			}
			else{
				parent.setLeft(pivot);
			}
		}

		//if (leftSub.getRight() != null)
		node.setLeft(pivot.getRight());
		pivot.setRight(node);
		//		else{
		//			node.setLeft(null);
		//		}

		if (parent == null){
			root = pivot;
		}
	}

	private void rotateLeft(AVLNode<T> node, AVLNode<T> parent){

		AVLNode<T> pivot = node.getRight();

		if (parent != null){
			if (parent.getRight()== node){
				parent.setRight(pivot);
			}
			else{
				parent.setLeft(pivot);
			}
		}

		//if (leftSub.getRight() != null)
		node.setRight(pivot.getLeft());
		pivot.setLeft(node);
		//		else{
		//			node.setLeft(null);
		//		}

		if (parent == null){
			root = pivot;
		}
	}

	public T delete(){

		if(root == null){
			return null;
		}

		T temp = deleteHelper(root, null, this.getSmallest()).getValue();
		this.balanceTree(root, null);
		//this.balancer(root, null, true);

		return temp;
	}

	private AVLNode<T> deleteHelper(AVLNode<T> root, AVLNode<T> parent, AVLNode<T> node) {

		if (root == null){
			return null;
		}
		else if (root.getLeft() == null && root.getRight() == null){
			if (parent == null){
				AVLNode<T> temp = root;
				root = null;
				this.root = null;
				return temp;
			}else{
				parent.setLeft(null);
				return root;
			}
		}
		else if (root.getLeft() == null){
			AVLNode<T> temp = root;
			if (parent == null){
				this.root = root.getRight();
				return temp;
			}
			parent.setLeft(temp.getRight());
			return temp;
		}

		return deleteHelper(root.getLeft(), root, node);
	}

	public AVLNode<T> getSmallest(){

		if (root == null){
			return null;
		}
		return getSmallestValue(root);
	}

	private AVLNode<T> getSmallestValue(AVLNode<T> root){

		if (root.getLeft() == null && root.getRight() == null){
			return root;
		}
		else if (root.getLeft() == null){
			return root;
		}
		return getSmallestValue(root.getLeft());
	}

	public void printTree(){
		printHelper(root);
	}

	private void printHelper(AVLNode<T> root){

		if (root == null){
			return;
		}
		if(root.getLeft() == null && root.getRight() == null){
			System.out.println(root.toString());
			return;
		}
		System.out.println(root.toString());
		printHelper(root.getLeft());
		printHelper(root.getRight());

	}

	public int size(){
		return sizeHelper(root, 0);
	}

	public int sizeHelper(AVLNode<T> root, int size){

		if (root == null){
			return 0;
		}
		if (root.getLeft() == null && root.getRight() == null){
			return 1;
		}

		return sizeHelper(root.getLeft(), size) + sizeHelper(root.getRight(), size) + 1;
	}

}
