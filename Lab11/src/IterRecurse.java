
public class IterRecurse {
	public static int factorialRecursive(int n) {
		if(n == 0 || n == 1) {
			return 1;
		} else {
			n = n * factorialRecursive(n-1);
		}
		return n;
	}

	public static int factorialIterative(int n) {
		int answer = 1;
		for (int i = 1; i <= n; i++) {
			answer = answer * i;
		}
		return answer;
	}

	public static int bunnyEars2Recursive(int bunnies) {
		if (bunnies == 0) {
			return 0;
		} else if (bunnies % 2 == 1) {
			return 2 + bunnyEars2Recursive(bunnies - 1);
		} else {
			return 3 + bunnyEars2Recursive(bunnies - 1);
		}
	}
	
	public static int bunnyEars2Iterative(int bunnies) {
		int sum = 0;
		for (int i = 0; i <= bunnies; i++) {
			if (i%2 == 1) {
				sum = sum + 2;
			} else {
				sum = sum + 3;
			}
			
		}
		return sum;
	}
	
	public static 

// this part took most of my time during lab????
	public static alternativeFibonacci(int n) {
		
	}
	
	public static void main(String[] args) {
		System.out.println(factorialIterative(4));

	}

}
