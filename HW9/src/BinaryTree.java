//John Ramirez jr5xw

public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	//method that calls upon the helper method in the BinaryTreeNode class that returns true if two trees are equal
	@Override
	public boolean equals(Object o) {
		if (o instanceof BinaryTree) {
			BinaryTree t1 = (BinaryTree) o;
			return this.getRoot().equals(t1.getRoot());
		} else {
			return false;
		}
	}

	//method that calls upon the helper method in the BinaryTreeNode class that returns a deepCopy of a binary tree
	public BinaryTree<T> deepCopy() {
		BinaryTree<T> deepCopy = new BinaryTree<T>();
		deepCopy.setRoot(this.getRoot().deepCopy());
		return deepCopy;
	}

	//method that calls upon the helper method in the BinaryTreeNode class that determines 
	//if the calling tree is the left child (true) or the right child (false)
	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,
			boolean left) {
		BinaryTree<T> newTree = new BinaryTree<T>();
		if (left) {
			newTree.setRoot(newRoot.deepCopy());
			newRoot.setLeft(t.getRoot().deepCopy());
			newRoot.setRight(this.getRoot().deepCopy());
		} else {
			newTree.setRoot(newRoot.deepCopy());
			newRoot.setRight(t.getRoot().deepCopy());
			newRoot.setLeft(this.getRoot().deepCopy());
		}
		return newTree;
	}

	//method that calls upon the helper method in the BinaryTreeNode class that determines the number of nodes in a binary tree
	public int size(){
		if(root == null) {
			return 0;
		} else {
			return root.size();
		}
	}

	//method that calls upon the helper method in the BinaryTreeNode class that returns an int that represents
	//the height of the subtree with this current node as the "root"
	public int height(){
		if(root == null) {
			return 0;
		} else {
			return root.height();
		}
	}

	//method that calls upon the helper method in the BinaryTreeNode class that returns true if the binary tree is full 
	//and complete and false otherwise
	public boolean full(){
		return this.getRoot().getLeft().full() && this.getRoot().getRight().full();
	}

	//method that calls upon the helper method in the BinaryTreeNode class that creates a mirror tree of the calling binary tree
	public void mirror(){
		if (this.getRoot() != null) {
			this.getRoot().mirror();
		}
	}

	//method that calls upon the helper method in the BinaryTreeNode class returns a string that
	//represents the data held at each node 
	//starting with all the nodes of the left child followed by the root 
	//then finally all the nodes of the right child
	public String inOrder(){
		if (this.getRoot() != null) {
			return this.getRoot().inOrder();
		} else {
			return null;
		}
	}

}
