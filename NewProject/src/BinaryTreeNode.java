public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	private T data;

	public BinaryTreeNode() {
		this(null, null, null);
	}

	public BinaryTreeNode(T theData) {
		this(theData, null, null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild,
			BinaryTreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size() {
		int size = 0;
		if(left != null) {
			size += left.size();
		}
		
		if (right != null) {
			size+= right.size();
		}
		return size + 1;
	}


	public BinaryTreeNode<T> find(T target) {
		BinaryTreeNode<T> location = null;
		
		if(target.equals(data)) {
			location = this;
		}
		if((location == null) && (left != null)) {
			location = left.find(target);
		}
		if((location == null) && (right != null)) {
			location = right.find(target);
		}
		
		return location;

	}

	public BinaryTreeNode<T> findParent(BinaryTreeNode<T> target) {
	
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
	
}
