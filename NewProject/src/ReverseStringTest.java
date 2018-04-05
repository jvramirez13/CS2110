import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ReverseStringTest {
	String s, t;
	
	@Before
	public void setUp() {
		s = "Hellow WOrld!";
		t = "!dlroW olleH";
	}
	
	@Test
	public void reverseTest() {
		assertEquals("reverseSTring returned an incorrect value for Hello World!", t, ReverseString(s));
	}

}
