
public class Palindrome {
	public static boolean testForPalindrome(String s) {
		System.out.println(s);
		if((s.length() == 0) || (s.length() == 1)) {
			return true;
		}
		char first = s.charAt(0);
		char last = s.charAt(s.length() - 1);
		if(Character.toLowerCase(first) != Character.toLowerCase(last)) {
			return false;
		}
		else {
			return testForPalindrome(s.substring(1, s.length() - 1));
		}
	}

	public static void main(String[] args) {
		System.out.println(testForPalindrome("EvaCanIStabBatsInACave"));
		System.out.println(testForPalindrome("AManAPlanACanalPanama"));
		System.out.println(testForPalindrome("YoBananaBoy"));
		System.out.println(testForPalindrome("BorrowOrRob"));

	}

}
