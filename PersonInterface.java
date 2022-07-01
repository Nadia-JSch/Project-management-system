package poised;

// interface for use in the factory design pattern for creating Person objects
public interface PersonInterface {
	

	// Getters and setters for all attributes
	String getName();

	void setName(String name);

	String getPhoneNumber();

	void setPhoneNumber(String phoneNumber);

	String getEmail();

	void setEmail(String email);

	String getWorkAddress();

	void setWorkAddress(String workAddress);
	
	boolean isCaptured();
	
	void setCaptured(boolean isCaptured) ;
	
	// overriding the toString() method to print attribute information
	String toString();

	// refactor: create method to set Person object attributes
	void addPersonInfo(PersonInterface personObjName);

	// refactor: create method to view and edit phone number
	void editPersonPhone(PersonInterface personObjName);

	// refactor: create method to view and edit email address
	void editPersonEmail(PersonInterface personObjName);

	// refactor: create method to view and edit work address
	void editPersonAddress(PersonInterface personObjName);

}