
public class Rectangle {
	private double length, width;
	
	public Rectangle () {
		length = width = 1.0;
	}
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	
	public void setLenght(double length) {
		if(length > 0) {
			this.length = length;
		}
	}
	
	public void setWidth (double width) {
		if(width > 0) {
			this.width = width;
		}
	}
	
	public double area() {
		return length * width;
	}
	
	public double perimeter() {
		return 2*length + 2 * width;
	}
	
	public static void main(String[] args) {
		Rectangle rec = new Rectangle(3,5);
		Rectangle rec1 = new Rectangle();
		
		System.out.println(rec.getLength());
		System.out.println(rec1.getLength());
	}

}
