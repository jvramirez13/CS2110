import java.util.Scanner;

public class OneDArrayActivity {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many values do you want in the array?");
		int x = keyboard.nextInt();
		int[] values = new int[x];
		for(int i = 0; i < x; i++){
			System.out.println("Enter the " + i + " value in the array");
			values[i] = keyboard.nextInt();
		}
		
		boolean nondecreasing = false ;
		
		for(int j = 0; j < values.length; j++){
			System.out.print(values[j] + " ");
		}
		
		for(int j = 0; j < values.length - 1; j++) {
			if (values[j+1] > values[j]) {
				nondecreasing = true;
			} else {
				nondecreasing = false;
			}
		}
		if (nondecreasing) {
			System.out.println("The array is non-decreasing");
		} else {
			System.out.println("The array is decreasing");
		}
		keyboard.close();
		}
	}

