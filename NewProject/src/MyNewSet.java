import java.util.*;

public class MyNewSet<T> extends ArrayList<T> implements Set<T>{
	//the reason as to why the red went away after extending ArrayList
	//is because the superclass already implements Set<T> i think??
	
	public MyNewSet(){
		super();
	}
	
	@Override
	public boolean add(T e) {
		if(!super.contains(e)) {
			super.add(e);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean addAll(Collection<T> c) {
		//didnt have time left i was going to reuse ovverride add method to implement addAll
	}

		
	public static void main(String[] args) {
		MyNewSet<String> test = new MyNewSet<String>();
		String h = "Hello";
		String n = "Hey";
		String i = "Hello";
		test.add(h);
		test.add(n);
		test.add(i);
		System.out.println(test);
		
		ArrayList<String> test1 = new ArrayList<String>();
		String g = "Goodbye";
		test1.add(g);
		test1.add(n);
		test1.addAll(test);
		System.out.println(test1);
		//no it works like a set would because it did not add duplicates
		
	}

}