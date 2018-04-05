import java.util.Scanner;

public class SocSecProcessor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isValid(String number) throws SocSecException {
		boolean validity = true;
		if(number.length() != 9) {
			validity = false;
			System.out.println("The Social Security cannot have more than or less than nine numbers");
			throw new SocSecException();
		} else if( !(number.charAt(3) == '-' && number.charAt(6)=='-')) {
			System.out.println("The placement of dashes are wrong");
			throw new SocSecException();
		} else {
			for(int i=0; i < number.length();i++) {
				if(number.charAt(i)>'A' && number.charAt(i) < 'z') {
					validity=false;
					System.out.println("The Social Security cannot include letters");
					throw new SocSecException();
				}
			}
		}
		return validity;
	}

}
