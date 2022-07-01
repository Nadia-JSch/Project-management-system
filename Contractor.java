package poised;

public class Contractor extends Person implements PersonInterface {

	//  constructor with all attributes
	public Contractor(String name, String phoneNumber, String email, String workAddress) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.workAddress = workAddress;
	}

	// 'empty' constructor
	public Contractor() {
		super();
	}


}
