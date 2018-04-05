
public class Sphere implements Solids {

	private double radius;

	public Sphere(double radius){
		this.radius = radius;

	}
	
	public double getVolume() {
		return (4/3)*Math.PI*Math.pow(radius, 2);
	}
	


	public double getSurfaceArea() {
		return 4*Math.PI*Math.pow(radius, 2);
	}


}
