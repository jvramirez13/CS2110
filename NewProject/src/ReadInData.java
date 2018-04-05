import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadInData {
	
	public static double readData(String fileName) {
		File file = new File(fileName);
		Scanner scan;
		double sum = 0;
		try {
			scan = new Scanner(file);
			int numOfValues = Integer.parseInt(scan.nextLine());
			for(int i = 0; i < numOfValues; i++) {
				sum += scan.nextDouble();
			}
			scan.close();
			return sum;
		} catch(FileNotFoundException exception) {
			System.out.println("File not found!");
		} catch(NumberFormatException exception) {
			System.out.println(exception.getMessage());
		} catch(InputMismatchException exception) {
			System.out.println("Number Mismatch Error!");
		} catch(RuntimeException exception) {
			System.out.println("Runtime Error!");
		} catch(Exception exception) {
			System.out.println("Error detected!");
		} return sum;
	} 
	
	public static void main(String[] args) {
		System.out.println(readData("Test3.txt"));
		System.out.println(readData("Test2.txt"));
		System.out.println(readData("Text4.txt"));
		System.out.println(readData("Test4.txt"));
	}

}
