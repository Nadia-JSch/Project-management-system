package poised;

import java.util.Scanner;

public class Person {

	Scanner userInput = new Scanner(System.in);
	protected String name;
	protected String phoneNumber;
	protected String email;
	protected String workAddress;
	private boolean isCaptured = false;

	public Person() {
		super();
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

	public boolean isCaptured() {
		return isCaptured;
	}

	public void setCaptured(boolean isCaptured) {
		this.isCaptured = isCaptured;
	}

	public String toString() {
		String output = "\n--- Customer's Personal Information ---";
		output += "\nName: " + name;
		output += "\nPhone number: " + phoneNumber;
		output += "\nEmail address: " + email;
		output += "\nWork address: " + workAddress;
		return output;
	}

	public void addPersonInfo(PersonInterface personObjName) {
		// add name
		System.out.println("Please enter the name: ");
		String userPersName = userInput.nextLine();
		personObjName.setName(userPersName);
		// add phone number
		System.out.println("Please enter the contact number: ");
		String userPersNum = userInput.nextLine();
		personObjName.setPhoneNumber(userPersNum);
		// add their email address
		System.out.println("Please enter the email address: ");
		String userEmail = userInput.nextLine();
		personObjName.setEmail(userEmail);
		// add the work address
		System.out.println("Please enter the work address: ");
		String userAddress = userInput.nextLine();
		personObjName.setWorkAddress(userAddress);
	}

	public void editPersonPhone(PersonInterface personObjName) {
		// show the current number
		System.out.println("Current phone number: " + personObjName.getPhoneNumber());
		// capture new number
		System.out.println("Please enter the new phone number: ");
		String userPhoneNum = userInput.nextLine();
		personObjName.setPhoneNumber(userPhoneNum);
		// show updated user profile
		System.out.println("Phone number updated\n" + personObjName.toString());
	}

	public void editPersonEmail(PersonInterface personObjName) {
		// show current email address
		System.out.println("Current email address: " + personObjName.getPhoneNumber());
		// capture new number
		System.out.println("Please enter the new email address: ");
		String userEmail = userInput.nextLine();
		personObjName.setEmail(userEmail);
		// show updated user profile
		System.out.println("Email address updated\n" + personObjName.toString());
	}

	public void editPersonAddress(PersonInterface personObjName) {
		// show current address
		System.out.println("Current work address: " + personObjName.getWorkAddress());
		// capture new number
		System.out.println("Please enter the new email address: ");
		String userAddress = userInput.nextLine();
		personObjName.setWorkAddress(userAddress);
		// show updated user profile
		System.out.println("Work address updated\n" + personObjName.toString());
	}

}