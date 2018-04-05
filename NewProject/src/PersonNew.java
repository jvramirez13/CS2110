
public class PersonNew {
	protected String name, homeAddress;
	
	public PersonNew(String n, String ha) {
		this.name = n;
		this.homeAddress = ha;
	}
	public String getMailingAddress() {
		return this.name + ", " + this.homeAddress;
	}

}
