import java.util.Arrays;

/*
Name: John Ramirez
Computing ID: jr5xw

Answers to reading questions:

 */


public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;

	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}

	public void add(String s){
		growIfNecessary();
		currentSize++;
		elements[tail] = s;
		tail = (tail + 1) % elements.length;

	}

	public String remove(){
		if (currentSize == 0) {
			return null;
		} else {
			String removed = elements[head];
			head = (head+1) % elements.length;
			currentSize--;
			return removed;
		}
	}

	private void growIfNecessary(){
		if(currentSize == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.add("Lorna");
		q.add("Sandy");
		q.add("Lucas");
		q.add("Zach");
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		q.add("Help");
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());


	}

}
