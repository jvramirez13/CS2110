import java.util.Arrays;

public class HW1 {

	public static void main(String[] args) {
		//pi method
		System.out.println(pi(3)); //expect 3.142
		System.out.println(pi(2)); //expect 3.14
		//easter method
		System.out.println(easter(2001)); //expect "April 15"
		System.out.println(easter(2012)); //expect "April 8"
		//escape method
		System.out.println(escape(7.0)); //expect that the astronaut will not return
		System.out.println(escape(500000)); //expect that the astronaut will return
		//random method
		System.out.println(Arrays.toString(random(2,3,2,9000))); //expect random numbers
		System.out.println(Arrays.toString(random(2,3,2,1000))); //expect random numbers

	}
	 public static double pi(int n) {
		double digits = Math.pow(10, n);
		double digitsNegative = Math.pow(10, -n);
		double piOne = 4;
		Boolean check = false;
		for (int i = 3; i < 1000000000; i+=2) {
			if (check) {
				piOne += 4.0/i;
			} else {
				piOne -= 4.0/i;
			}
			check = !check;
		}
		piOne = Math.round(piOne * digits) * digitsNegative;
		return piOne;
	
	
	}
	public static String easter(int y) {
		String month = "";
		int a = y%19;
		int b = y/100;
		int c = y%100;
		int d = b/4;
		int e = b%4;
		int g = (8 * b + 13)/25;
		int h = (19*a+b-d-g+15)%30;
		int j = c/4;
		int k = c%4;
		int m = (a+11*h)/319;
		int r = (2*e+2*j-k-h+m+32)%7;
		int n = (h-m+r+90)/25;
		int p = (h-m+r+n+19)%32;
		if (n == 1) {
			month = "January";
		}
		if (n == 2) {
			month = "February";
		}
		if (n == 3) {
			month = "March";
		}
		if (n == 4) {
			month = "April";
		}
		if (n == 5) {
			month = "May";
		}
		if (n == 6) {
			month = "June";
		}
		if (n == 7) {
			month = "July";
		}
		if (n == 8) {
			month = "August";
		}
		if (n == 9) {
			month = "September";
		}
		if (n == 10) {
			month = "October";
		}
		if (n == 11) {
			month = "November";
		}
		if (n == 12) {
			month = "December";
		}
		return month + " " + p;
		
		
	}
	public static String escape(double v) {
		v = v * 2.2369; // velocity in mph
		String statement = "";
		double mass = ((Math.pow(v,2)*1.153e6)/(2*6.67e-11));
		if (mass < 5.2e25) {
			String massTwo = Double.toString(mass);
			statement = "The astronaut will not return to Halley's Comet! The comet has a mass " + massTwo + " which is smaller than 5.2e25";
		} 
		if (mass >= 5.25e25) {
			String massTwo = Double.toString(mass);
			statement = "The astronaut will return to Halley's Comet! The comet has a mass " + massTwo + "which is equal to or larger than 5.2e25";
		} 
		return statement;
		
	}
	public static int[] random(int r, int a, int b, int m) {
		int [] randomNumbers = new int[25];
		for (int i = 0; i < randomNumbers.length; i++) {
			int rNew = (a * r + b)%m;
			randomNumbers[i] = rNew;
			r = rNew;
		}
		return randomNumbers;
	}
 
}
