
public class TextExpression {

	public static void main(String[] args) {
		int whichVersion = 18;         // a number such that 0 <= whichVersion < 37
		String anExpression = "1+*3";  // a String that may or may not be an expression
		boolean valid = Expression.isValid(whichVersion, anExpression);
		System.out.println(valid);


	}

}
