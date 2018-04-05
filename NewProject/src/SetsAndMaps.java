import java.util.HashMap;
import java.util.HashSet;


public class SetsAndMaps {
	
	public static HashSet<String> names(HashSet<String> sticky, HashSet<String> common) {
		HashSet<String> namesNeeded = new HashSet <String>();
		for (String i : common) {
			if (common.contains(i) != sticky.contains(i)) {
				namesNeeded.add(i);
			} 
		}
		return  namesNeeded;
	}
	
	public static HashMap<Integer, String> reverseBook(HashMap<String, Integer> phonebook) {
		HashMap<Integer, String> koob = new HashMap<Integer, String>();
		for (String i : phonebook.keySet()) {
			koob.put(phonebook.get(s), s);
		}
		return koob;
	}

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("Hi");
		set.add("Hey");
		set.add("Hi");
		set.add("im confusion");
		System.out.println(set.size());
		HashSet<String> set1 = new HashSet<String>();
		set.add("Hi");
		set.add("Hello");
		set.add("Goodbye");
		
		System.out.println(names(set1, set));
		

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("David", 987654);
		System.out.println(map);

	}

}
