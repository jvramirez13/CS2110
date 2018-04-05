package lab62017;

public class Person {
	protected String name;
	protected String homeAddress;
	
	public Person(String name, String address) {
        this.name = name;
		this.homeAddress = address;
	}

	// NOTE: Best practice to include a default constructor in superclasses
	public Person() {
		this.name = "?";
		this.homeAddress = "?";
	}

	public String getMailingAddress() {
		return homeAddress;
	}
	
	public String toString() {
		return "{Person: name=" + name + ", homeAddress=" + homeAddress + "|";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public String getAddress() {
		return homeAddress;
	}

	public void setAddress(String address) {
		this.homeAddress = address;
	}
	
	
	public int compareTo(Person p1, Person p2) {
		if(p1.getName().compareTo(p2.getName()) < 0) {
			return -1;
		} else if(p1.getName().compareTo(p2.getName()) == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("p1", "addr1");
		System.out.println(p1);
	}
}
