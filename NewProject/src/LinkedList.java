
import java.util.NoSuchElementException;

public class LinkedList<T> {

	private LinkedNode<T> first;
	private LinkedNode<T> last;
	private LinkedNode<T> cursor;
	private int count;
	
	public LinkedList(){
		this.first = null;
		this.cursor = null;
		this.last = null;
		this.count = 0;
	}
	
	public LinkedList(LinkedNode<T> node){
		this.first = node;
		this.cursor = node;
		this.last = node;
		this.count = 1;
	}
	
	public void setFirst(LinkedNode<T> node){
		node.setNext(this.first);
		this.first = node;
		this.count++;
		if(this.cursor == null){
			this.cursor = this.first;
		}
		if(this.last == null){
			this.last = node;
		}
	}
	
	public LinkedNode<T> removeFirst(){
		if(this.first == null){
			throw new NoSuchElementException();
		}
		if(this.cursor == this.first){
			this.cursor = this.first.getNext();
		}
		if(this.last == this.first){
			this.last = null;
		}
		LinkedNode<T> retVal = this.first;
		this.first = this.first.getNext();
		this.count--;
		retVal.setNext(null);
		return retVal;
	}
	
	public void setLast(LinkedNode<T> node){
		if(this.last == null){
			this.setFirst(node);
			return;
		}
		this.last.setNext(node);
		this.last = node;
		this.count++;
		if(this.cursor == null){
			this.cursor = this.last;
		}
		if(this.first == null){
			this.first = this.last;
		}
	}
	
	public LinkedNode<T> removeLast(){
		if(this.last == null){
			throw new NoSuchElementException();
		}
		if(this.first == this.last){
			LinkedNode<T> retVal = this.last;
			this.first = null;
			this.last = null;
			this.cursor = null;
			return retVal;
		}
		if(this.cursor == this.last){
			this.moveCursorBack();
		}
		LinkedNode<T> retVal = this.last;
		LinkedNode<T> cursorValue = this.cursor;
		this.cursor = this.last;
		this.moveCursorBack();
		this.last = this.cursor;
		this.cursor = cursorValue;
		this.count--;
		return retVal;
	}
	
	public boolean moveCursorForward(){
		boolean retVal = false;
		if(this.cursor.getNext() != null){
			this.cursor = this.cursor.getNext();
			retVal = true;
		}
		return retVal;
	}
	
	public boolean moveCursorBack(){
		if(this.cursor == this.first){
			return false;
		}
		LinkedNode<T> one = this.first;
		LinkedNode<T> two = this.first.getNext();
		while(this.cursor != two){
			one = two;
			two = two.getNext();
		}
		this.cursor = one;
		return true;
	}
	
	/* Add node between current cursor and next node */
	public void add(LinkedNode<T> node){
		if(this.cursor == this.first) {
			this.first.setNext(node);
		} if (this.cursor == this.last) {
			this.last.setNext(node);
		}
	}
	
	/* Add node at a particular index location */
	public void add(LinkedNode<T> node, int index){
		if(index >= this.count){
			this.setLast(node);
			return;
		}
		if(index == 0){
			this.setFirst(node);
			return;
		}
		LinkedNode<T> one = this.first;
		LinkedNode<T> two = this.first.getNext();
		for(int i =1; i < index; i++){
			one = two;
			two = two.getNext();
		}
		one.setNext(node);
		node.setNext(two);
		this.count++;
	}
	
	/* Remove node pointed to by current cursor */
	public LinkedNode<T> remove(){
		if(cursor == null){
			throw new NoSuchElementException();
		}
		if(cursor == first){
			return this.removeFirst();
		}
		if(cursor == last){
			return this.removeLast();
		}
		LinkedNode<T> retVal = cursor;
		this.moveCursorBack();
		cursor.setNext(retVal.getNext());
		retVal.setNext(null);
		count--;
		return retVal; 
	}
	
	@Override
	public String toString(){
		String str = "";
		if(this.first == null){
			return str;
		}
		LinkedNode<T> node = this.first;
		str += node.getData().toString() + " ";
		while(node.getNext() != null){
			node = node.getNext();
			str += node.getData().toString() + " ";
		}
		return str;
		
	}
	
	public static void main(String[] args){
		LinkedNode<String> n1 = new LinkedNode<String>("Hello");
		LinkedList<String> llist = new LinkedList<String>(n1);
		LinkedNode<String> n2 = new LinkedNode<String>("Hey");
		LinkedNode<String> n3 = new LinkedNode<String>("Hi");
		LinkedNode<String> n4 = new LinkedNode<String>("Hola");
		
		llist.setLast(n3);	// set last: n3 ("Hi")
		llist.add(n2);		// add: n2 ("Hey")
		
		System.out.println("Printing llist: " + llist);
		llist.moveCursorForward();
		System.out.println(llist.first + " " + llist.cursor + " " + llist.last);
		
		System.out.println("Removing node at position of cursor...");
		llist.remove();
		System.out.println("Printing llist (after remove): " + llist);
		
		System.out.println(llist.first + " " + llist.cursor + " " + llist.last);
		llist.setLast(new LinkedNode<String>("GoodDay"));
		System.out.println("Printing llist: " + llist);
		
		
	}
	
}

