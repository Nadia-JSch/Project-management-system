package poised;

public class Person {
	String name;
	String phoneNumber;
	String email;
	String workAddress;

	
	public Person(String name, String phoneNumber, String email, String workAddress) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.workAddress = workAddress;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getWorkAddress() {
		return workAddress;
	}


	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}


	@Override
	public String toString() {
		String output = "\n--- Personal Information ---";
		output += "\nName: " + name;
		output += "\nPhone number: " + phoneNumber;
		output += "\nEmail address: " + email;
		output += "\nWork address: " + workAddress;
		return output;
	}
	
}
