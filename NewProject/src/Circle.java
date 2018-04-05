
public class Circle {
	private double radius;
	private Point center;
	
	public Circle(double radius, Point center) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle() {
		radius = 1.0;
		center = new Point(4,6);
	}
	
	public String toString() {
		return "Center: " + center + " , Radius: " + radius;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Circle) {
			Circle p2 = (Circle) o;
			return (this.center == p2.center) && (this.radius == p2.radius);
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Circle c = new Circle();
		Point p = new Point(4,6);
		Point p1 = new Point(1,1);
		Circle d = new Circle(3.0, p1);
		Circle d2 = new Circle(3.0, p1);
		System.out.println(d.equals(d2)); //two circles that have the same values but are different objects
		System.out.println(c.equals(c)); //two references to the same circle
		System.out.println(c.equals(d2)); //two circles that have different values
		
	}

}
