
public class Octahedron implements Solids {
	private double edge;

	public Octahedron(double edge){
		this.edge = edge;
	}
	
	public double getVolume() {
		return (Math.sqrt(2)/3)*Math.pow(edge, 3);
	}
	
	public double getSurfaceArea() {
		return 2*(Math.sqrt(3)*Math.pow(edge, 2));
	}


	//Surface Area 2*sqrt(3)*edge^2

}
