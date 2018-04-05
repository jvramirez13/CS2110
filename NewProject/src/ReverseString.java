public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("Hello World!"));
		System.out.println(reverseString("a")); //should be just "a"
		System.out.println(reverseString("")); //should be ""
	}
	/* Supppse s = "hello" t = " ",
	 * t = "H" +" " = "H"
	 * t = "e: + "H" = "eH"
	 */
	public static String reverseString(String s) {
		String t = "";
		for(int i = 0; i < s.length(); i++) {
			t = s.charAt(i) + t;
		}
		return t;
	}
}
