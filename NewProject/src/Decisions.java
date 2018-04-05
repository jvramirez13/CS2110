import java.util.Scanner;

public class Decisions {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner (System.in);
		
		int coldStartsAt = 45;
		System.out.println("What is the current temp?");
		
		int temp = keyboard.nextInt();
		
		if(temp >= 100) {
			System.out.println("Wow! That's hot!");
		} else if(temp < 0) {
			System.out.println("Man that's cold!");
		} else {
			System.out.println("Probably ok.");
		}

	}

}
