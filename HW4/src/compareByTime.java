//John Ramirez, jr5xw, Homework 4

import java.util.Comparator;

public class compareByTime implements Comparator<Playable> {

	@Override
	public int compare(Playable o1, Playable o2) {
		if(o1.getPlayTimeSeconds() < o2.getPlayTimeSeconds()) {
			return -1;
		} else if (o1.getPlayTimeSeconds() > o2.getPlayTimeSeconds()) {
			return 1;
		} else {
			return 0;
		}
	}

}
