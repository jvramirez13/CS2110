import java.util.*;
import java.io.*;

public class Point implements Comparable<Point> {
	
	private double x, y;

	public double getX() {
		return x;
	}
	
	public int compareTo(Point p) {
		if (this.x > p.x) return 1;
		if(p.x > this.x) return -1;
		if(this.y > p.y) return 1;
		if(p.y > this.y) return -1;
		return 0;
		
	}
	
	public double distance(Point p) {
//		double xdiff = this.x = p.x;
//		double ydiff = this.y - p.y;
//		return Math.sqrt(xdiff*xdiff + ydiff*ydiff);
		Point o = new Point(0,0);
		double thisDis = this.distance(o);
		double pDis = p.distance(o);
		if(thisDis > pDis) return 1;
		if (pDis > thisDis) return -1;
		return 0;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override //annotation(@)
	public String toString() {
		return "(" + x + ", " + y +")";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Point) {
			Point p2 = (Point) o; //object o is referencing object so we have to cast it as a point
			return (this.x == p2.x) && (this.y == p2.y); //this. is referencing which object the method is calling
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Point p = new Point(4,6);
		Point p1 = new Point(1,1);
		
		System.out.println(p);
		System.out.println(p1);
	}
	
	public static 

}
