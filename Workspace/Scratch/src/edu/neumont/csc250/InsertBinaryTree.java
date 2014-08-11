package edu.neumont.csc250;

public class InsertBinaryTree<T extends Comparable<T>> {

	TreeNode<T> root;

	public boolean insert(T data){

		if (root == null){
			root = new TreeNode<T>(data);
		}
		else{
			return insert(root, null, data);
		}

		return false;
	}

	private boolean insert(TreeNode<T> root, TreeNode<T> parent, T k){

		if (root == null){
			TreeNode<T> newNode = new TreeNode<T>(k);

			if (parent.compareTo(k) > 0){
				parent.leftDecsendent = newNode;
			}
			else if (parent.compareTo(k) < 0){
				parent.rightDecsendent = newNode;
			}
			return true;
		}
		else{

			if (root.compareTo(k) > 0){

				if (parent == null){
					parent = root;
				}
				insert(root.leftDecsendent, parent, k);
			}
			else if (root.compareTo(k) < 0){

				if (parent == null){
					parent = root;
				}
				insert(root.rightDecsendent, parent, k);
			}
			else{
				return false;
			}
		}
		
		return false;
	}
}
