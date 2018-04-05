
public class Employee extends PersonNew {
	private String workAddress;
	private int employeeId;
	
	public Employee(String n, String ha) {
		super(n,ha);
		this.workAddress = ha;
		this.employeeId = 1;
	}
	
	public Employee(String n, String ha, String wa, int id) {
		super(n, ha);
		this.workAddress = wa;
		this.employeeId = id;
	}
	@Override
	public String getMailingAddress() {
		return this.name + ", " + this.workAddress;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", Work Address: " + this.workAddress;
	}

}
