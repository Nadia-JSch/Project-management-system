package poised;


public class Customer extends Person implements PersonInterface  {
	// Person constructor with all attributes
	public Customer(String name, String phoneNumber, String email, String workAddress) {

		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.workAddress = workAddress;
	}

	// 'empty' Person constructor
	public Customer() {
		super();
	}
}
