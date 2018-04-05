//John Ramirez jr5xw

public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode(){
		this(null,null,null);
	}

	public BinaryTreeNode(T theData){
		this(theData,null,null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	//helper method that returns an int which represents the number of nodes in a binary tree
	public int size(){
		int size = 0; //the size of the tree

		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	//helper method that returns a deep copy of the calling object
	public BinaryTreeNode<T> deepCopy(){
		BinaryTreeNode<T> deepCopy = new BinaryTreeNode<T>();
		deepCopy.left = null;
		deepCopy.right = null;
		deepCopy.data = null;
		if (this.getLeft() != null) {
			deepCopy.left = this.getLeft().deepCopy();
		}
		if (this.getRight() != null) {
			deepCopy.right = this.getRight().deepCopy();
		}
		if (this.getData() != null) {
			deepCopy.data = this.getData();
		}
		return deepCopy;
	}

	//helper method that returns a boolean on whether or not two nodes are equal
	@Override
	public boolean equals(Object o){
		if (o instanceof BinaryTreeNode) {
			BinaryTreeNode t1 = (BinaryTreeNode) o;
			if ((left == null) && (right != null)) {
				return (this.getRight().equals(t1.getRight()) && this.getData().equals(t1.getData()));
			} else if ((left != null) && (right == null)) {
				return (this.getLeft().equals(t1.getLeft()) && this.getData().equals(t1.getData()));
			} else if ((left == null) && (right == null)) {
				return this.getData().equals(t1.getData());
			} else {
				return this.getData().equals(t1.getData()) && this.getLeft().equals(t1.getLeft())
						&& this.getRight().equals(t1.getRight());
			}
		} else {
			return false;
		}
	}

	//helper method that returns an int that represents the height of the subtree with this current node as the "root"
	public int height(){
		if (this.left != null && this.right == null) {
			return 1 + this.getLeft().height();
		} else if (this.right != null && this.left == null) {
			return 1 + this.getRight().height();
		} else if (this.right != null && this.left != null) {
			return 1 + Math.max(this.getRight().height(), this.getLeft().height());
		} else if (this.right == null && this.left == null) {
			return 1;
		} else {
			return 0;
		}
	}

	//helper method that returns true if the node has two children and false otherwise
	public boolean full(){
		boolean confirm = false;
		if (this.left != null && this.right != null) {
			confirm = true;
		}
		return confirm;
	}

	//helper method that creates another node opposite of the calling object
	public void mirror(){
		BinaryTreeNode<T> copy = new BinaryTreeNode<T>();
		if (this.left == null && this.right != null) {
			copy = this.getRight().deepCopy();
			this.setLeft(copy);
			this.setRight(null);
			this.left.mirror();
		} else if (this.left != null && this.right == null) {
			copy = this.getLeft().deepCopy();
			this.setLeft(null);
			this.setRight(copy);
			this.right.mirror();
		} else if (this.left != null && this.right != null) {
			copy = this.getLeft().deepCopy();
			this.setLeft(this.getRight().deepCopy());
			this.setRight(copy);
			this.right.mirror();
			this.left.mirror();
		}
	}

	//helper method that returns a string that represents the data held at each node 
	//starting with all the nodes of the left child followed by the root 
	//then finally all the nodes of the right child
	public String inOrder(){
		String retVal = "";
		if (this.left != null) {
			retVal = retVal + this.getLeft().inOrder();
		}
		retVal = retVal + "(" + this.getData() + ")";
		if (this.right != null) {
			retVal = retVal + this.getRight().inOrder();
		}
		return retVal;
	}

}
