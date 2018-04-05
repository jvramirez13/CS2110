package lab62017;

public class Student extends Person{
	private String campusAddress;
	private double gpa;
	
	
	public Student(String campusAddress, double gpa) {
		this.gpa = gpa;
		this.campusAddress = campusAddress;
		gpa = 0;
		campusAddress = "";
	}

}
