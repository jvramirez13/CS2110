import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class testBook {
	
	Book b1, b2;
	
	@Before
	public void setUp() {
		b1 = new Book("My Life", "John Ramirez", 654321, 22.0);
		b2 = new Book("My Life", "John Ramirez", 654322, 22.0);
		
	}
		
	@Test
	public void bookTest() {
		assertFalse("These books are not equal", b1.equals(b2));
	}


	}
	


