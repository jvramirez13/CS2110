//John Ramirez, jr5xw, Homework 4

import java.util.Comparator;

public class compareByName implements Comparator<Playable> {

	@Override
	public int compare(Playable o1, Playable o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
