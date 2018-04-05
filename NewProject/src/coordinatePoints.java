
public class coordinatePoints {

	public static void main(String[] args) {
		//test cases
		System.out.println(points(3,5));
		System.out.println(points(-1, 5));
		System.out.println(points(-2, -5));
		System.out.println(points(0, 0));
		System.out.println(points(6, -2));

	}
	
	public static double points(double x, double y) {
		if (x >= 0 && y >= 0 ) {
				return (x*y);
			}
		if ( x < 0 && y >= 0)	{
				return x-y;
			}
		if (y < 0 && x < 0) {
			return x/y;
			}
		return x + y;
		} 
		
	}

