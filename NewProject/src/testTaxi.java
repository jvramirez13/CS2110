import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class testTaxi {
	Taxi b1, b2;
	
	@Before
	public void setUp() {
		b1 = new Taxi(15, true);
		b2 = new Taxi(15, false);
	}
	
	@Test
	public void testTaxi() {
		assertFalse("This should return true", makeReservation(b1));
	}

}
