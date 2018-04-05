//John Ramirez, jr5xw

import java.awt.Color;

public class Recursion {

	//method that takes in a string and returns the reverse of the string
	public static String reverseString(String s) {
		if(s.length() == 0) {
			return s;
		} else {
			return reverseString(s.substring(1)) + s.charAt(0);
		}
	}

	//method that takes in the number of stairs and see how many ways it can be climbed with two strides:
	//small stride goes over one step and large stride goes over two steps
	public static int countWays(int numStairs) {
		if(numStairs < 4) {
			return numStairs;
		} else {
			return countWays(numStairs-1) + countWays(numStairs - 2);
		}
	}

	//method that takes in two integers and is used to test how well a computer performs recursion
	public static int Ackermann(int m, int n) {
		if (m == 0) {
			return n + 1;
		} else if(m > 0 && n == 0) {
			return Ackermann(m - 1, 1);
		} else {
			return Ackermann(m -1, Ackermann(m,n-1));
		}
	}

	//method that takes in the number of people and determines how many handshakes can be made within the group of people
	public static int handShakes(int n) {
		if(n == 2) {
			return 1;
		} else {
			return handShakes(n - 1) + n-1;
		}
	}

	//method that utilizes the Greek's way of computing square roots
	public static double squareRootGuess(double x) {
		return squareRootGuess(x, 5);
	}

	//recursive helper method
	public static double squareRootGuess(double x, double g) {
		final double epsilon = .0001;
		if (Math.abs(x - g *g) < epsilon) {
			return g;
		} else {
			return squareRootGuess(x, 0.5 * (g + x / g));
		}
	}

	//method that draws the snowflake
	public static void drawSnowflake(Turtle t, int n, int sideLength) {

		for (int j = 0; j < 3; j++) {
			drawSegment(t, n, sideLength);
			t.right(120);
		}
	}

	//recursive method that sets up the drawing of the snowflake
	public static void drawSegment(Turtle t, int n, int length) {

		if (n <= 0) {
			t.forward(length);
		}
		else {
			drawSegment(t, n - 1, length);
			t.left(60);
			drawSegment(t, n - 1, length);
			t.right(120);
			drawSegment(t, n - 1, length);
			t.left(60);
			drawSegment(t, n - 1, length);
		}
	}

	public static void main(String[] args) {
		System.out.println(reverseString("goodbye"));
		System.out.println(countWays(5));
		System.out.println(Ackermann(2,4));
		System.out.println(handShakes(10));
		System.out.println(squareRootGuess(16));
		
		World myWorld = new World(1500,1500,Color.WHITE);
		Turtle bob = new Turtle(myWorld);
		bob.setDelay(0);
		drawSnowflake(bob, 5, 2);
	}

}
