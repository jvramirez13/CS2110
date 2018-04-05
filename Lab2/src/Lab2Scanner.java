import java.util.*;
import java.io.*;

public class Lab2Scanner {

	public static void main(String[] args) {
		/*
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter five numbers: ");
		while (keyboard.hasNextDouble()) {
			double a1 = keyboard.nextDouble();
			double a2 = keyboard.nextDouble();
			double a3 = keyboard.nextDouble();
			double a4 = keyboard.nextDouble();
			double a5 = keyboard.nextDouble();
			System.out.println("The average of the five numbers are: " + ((a1+a2+a3+a4+a5)/5));
		}
		keyboard.close();
		*/
		
		File theFile = new File("data1.txt");
		Scanner fileScnr;
		try {
			fileScnr = new Scanner(theFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(theFile.length());
		System.out.println(theFile.getAbsolutePath());

	}
	

}
