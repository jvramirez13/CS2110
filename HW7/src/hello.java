
public class hello {
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
		public static void main(String[] args) {
			System.out.println(pi(8));

		}

	}
