import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class testPerson {
	
	@Before
	public void setUp() {
		Person p1 = new Person("John Ramirez", 654321);
		Person p2 = new Person("John Ramirez", 654322);
	}
	
	@Test
	public void testPerson() {
		assertFalse("These person are not the same" p1.equals(p2));
	}

}
