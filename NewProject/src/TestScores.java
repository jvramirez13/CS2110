import java.util.Scanner;

public class TestScores {

	public static void main(String[] args) {
		int numTest;
		int[] tests;
		
		Scanner key = new Scanner(System.in);
		numTest = key.nextInt();
		
		tests = new int[numTest];
		// tests = [5,6,7,8,9,1,2];
		
		for (int index = 0; index < tests.length; index++) {
			// .length tells us how many elements in the array
			System.out.println("Enter test score" + (index + 1) + ": ");
			tests[index] = key.nextInt();
		}
		for(int i = 0; i < tests.length; i++) {
			System.out.println(tests[i]);
		}

	}

}
