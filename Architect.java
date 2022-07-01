package poised;

public class Architect extends Person implements PersonInterface {

	// constructor with all attributes
	public Architect(String name, String phoneNumber, String email, String workAddress) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.workAddress = workAddress;
	}

	// 'empty' constructor
	public Architect() {
		super();
	}


}
