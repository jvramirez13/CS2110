

public class LinkedNode<T> {
	
	/* Fields */
	private LinkedNode<T> next;
	private T data;
	// ---------------------------------------
	
	/* Constructors */
	public LinkedNode(){
		next = null;
		data = null;
	}
	
	public LinkedNode(T data){
		this.data = data;
		next = null;
	}
	
	public LinkedNode(T data, LinkedNode<T> next){
		this.data = data;
		this.next = next;
	}
	// ---------------------------------------
	
	/* toString() */
	@Override
	public String toString() {
		return "LinkedNode [data=" + this.data + "] ";
	}	
	// ---------------------------------------
	
	/* Getters and Setters */
	public LinkedNode<T> getNext() {
		return next;
	}

	public void setNext(LinkedNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}

