
public class Cuboid implements Solids {
	private double length, width, height;
	
	public Cuboid(double length, double width, double height){
		this.length = length;
		this.width = width;
		this.height = height;
	
	}
	
	public double getVolume() {
		return length*width*height;
	}
	public double getSurfaceArea() {
		return 2*(length*width + width*height + length*height);
	}
	
	//SurfaceArea = 2(length*width + width*height + length*height)

}
