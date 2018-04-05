package lab62017;
import java.util.Comparator;

public class CmpByAddress implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if(o1.getAddress().compareTo(o2.getAddress()) < 0) {
			return -1;
		} else if(o1.getAddress().compareTo(o2.getAddress()) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
}


