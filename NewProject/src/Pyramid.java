
public class Pyramid implements Solids {
	private double length, width, height;


	public Pyramid(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}
	public double getVolune() {
		return (length*width*height)/3;
	}
	
	public double getSurfaceArea() { 
		return (length * width) + (length*Math.sqrt(Math.pow(width/2, 2)) + width * Math.sqrt(Math.pow(length/2, 2) + Math.pow(h, 2)));
	}

	//Volume = length*width*height/3

	//Surface Area length*width + length*sqrt((width/2)^2 + h^2) + width*sqrt((length/2)^2 + h^2)

}
