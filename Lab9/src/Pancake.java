
public class Pancake implements Comparable<Pancake> {

	String color;
	int radius;
	public Pancake() {
		
	}
	

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public int getRadius() {
		return radius;
	}


	public void setRadius(int radius) {
		this.radius = radius;
	}


	@Override
	public int compareTo(Pancake o) {
		if (this.getColor < o)
	}
	

}
