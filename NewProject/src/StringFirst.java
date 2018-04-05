public class StringFirst {

	public static void main(String str, boolean front) {
		String t = "";
		
		if (front) {
			t = str.charAt(0) + t;
		}
	}

}
