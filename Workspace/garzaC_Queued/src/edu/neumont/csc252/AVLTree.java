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
		//this.balancer(root, null, true);

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
		if (root.getLeft() == null && root.getRight() == null){
			root.setHeight(0);
			root.setBalanceFactor(0);
			return;
		}

		int leftHeight = 0;
		if (root.getLeft() != null){
			leftHeight = this.height(root.getLeft());
		}
		int rightHeight = 0;
		if (root.getRight() != null){
			rightHeight = this.height(root.getRight());
		}
		int balanceFactor = leftHeight - rightHeight;
		root.setBalanceFactor(balanceFactor);
		root.setHeight(this.height(root));
		
		balanceTree(root.getLeft(), root);
		this.balanceHelper(root, parent, true);

		leftHeight = 0;
		if (root.getLeft() != null){
			leftHeight = this.height(root.getLeft());
		}
		rightHeight = 0;
		if (root.getRight() != null){
			rightHeight = this.height(root.getRight());
		}
		balanceFactor = leftHeight - rightHeight;
		root.setBalanceFactor(balanceFactor);
		root.setHeight(this.height(root));

		balanceTree(root.getRight(), root);
		this.balanceHelper(root, parent, false);
	}

	private void balancer(AVLNode<T> root, AVLNode<T> parent, boolean goLeft){
		if (root == null){
			return;
		}
		if (root.getLeft() == null && root.getRight() == null){
			return;
		}
		
		int leftHeight = 0;
		if (root.getLeft() != null){
			leftHeight = this.height(root.getLeft());
		}
		int rightHeight = 0;
		if (root.getRight() != null){
			rightHeight = this.height(root.getRight());
		}
		int balanceFactor = leftHeight - rightHeight;
		root.setBalanceFactor(balanceFactor);
		root.setHeight(this.height(root));

		balancer(root.getLeft(), root, true);
		balanceHelper(root, parent, goLeft);

		leftHeight = 0;
		if (root.getLeft() != null){
			leftHeight = this.height(root.getLeft());
		}
		rightHeight = 0;
		if (root.getRight() != null){
			rightHeight = this.height(root.getRight());
		}
		balanceFactor = leftHeight - rightHeight;
		root.setBalanceFactor(balanceFactor);
		root.setHeight(this.height(root));
		
		balancer(root.getRight(), root, false);
		balanceHelper(root, parent, goLeft);
	}

	private void balanceHelper(AVLNode<T> root, AVLNode<T> parent, boolean goLeft){

		if (root.getBalanceFactor() >= 2){

			if (root.getLeft().getBalanceFactor() == -1){

				AVLNode<T> leftSub = root.getLeft().getRight();
				AVLNode<T> rightSub = root.getLeft();
				AVLNode<T> prevRoot = root;

				if (leftSub.getLeft() != null)
					rightSub.setRight(leftSub.getLeft());
				else
					rightSub.setRight(null);
				if (leftSub.getRight() != null)
					prevRoot.setLeft(leftSub.getRight());
				else
					prevRoot.setLeft(null);

				if (parent == null){
					this.root = leftSub;
					this.root.setLeft(rightSub);
					this.root.setRight(prevRoot);
				}
				else{
					root = leftSub;
					root.setLeft(rightSub);
					root.setRight(prevRoot);

					if (goLeft){
						parent.setLeft(root);
					}else{
						parent.setRight(root);
					}
				}
			}
			else if (root.getLeft().getBalanceFactor() == 1 || root.getLeft().getBalanceFactor() == 0){

				AVLNode<T> leftSub = root.getLeft();
				AVLNode<T> prevRoot = root;

				if (root.getLeft().getRight() != null)
					prevRoot.setLeft(root.getLeft().getRight());
				else{
					prevRoot.setLeft(null);
				}
				if (parent == null){
					this.root = leftSub;
					this.root.setRight(prevRoot);
				}
				else{
					root = leftSub;
					root.setRight(prevRoot);

					if (goLeft){
						parent.setLeft(root);
					}
					else{
						parent.setRight(root);
					}
				}
			}
		}
		else if (root.getBalanceFactor() <= -2){

			if (root.getRight().getBalanceFactor() == -1 || root.getRight().getBalanceFactor() == 0){

				AVLNode<T> leftSub = root.getRight();
				AVLNode<T> prevRoot = root;

				if (leftSub.getLeft() != null){
					prevRoot.setRight(leftSub.getLeft());
				}else{
					prevRoot.setRight(null);
				}

				if (parent == null){
					this.root = leftSub;
					this.root.setLeft(prevRoot);
				}
				else{
					root = leftSub;
					root.setLeft(prevRoot);

					if (goLeft){
						parent.setLeft(root);
					}else{
						parent.setRight(root);
					}
				}

			}
			else if (root.getRight().getBalanceFactor() == 1){

				AVLNode<T> leftSub = root.getRight().getLeft();
				AVLNode<T> rightSub = root.getRight();
				AVLNode<T> prevRoot = root;

				if (leftSub.getLeft() != null){
					prevRoot.setRight(leftSub.getLeft());
				}else{
					prevRoot.setRight(null);
				}
				if (leftSub.getRight() != null)
					rightSub.setLeft(leftSub.getRight());
				else{
					rightSub.setLeft(null);
				}

				if (parent == null){
					this.root = leftSub;
					this.root.setLeft(prevRoot);
					this.root.setRight(rightSub);
				}
				else{
					root = leftSub;
					root.setLeft(prevRoot);
					root.setRight(rightSub);

					if (goLeft){
						parent.setLeft(root);
					}else{
						parent.setRight(root);
					}
				}

			}
		}

	}

	public T delete(){

		if(root == null){
			return null;
		}

		T temp = deleteHelper(root, null, this.getSmallest()).getValue();
		this.balanceTree(root, null);
		this.balancer(root, null, true);

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
