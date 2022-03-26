package poised;

import java.time.LocalDate;    	// for using dates 
import java.time.format.DateTimeFormatter;  // for use in parsing String to LocalDate
import java.util.Scanner;    	// for reading user input

public class Main {

	public static void main (String[] args) {

		// new scanner object to read user input
		Scanner userInput = new Scanner(System.in);                 

// === Variables ===
		// declare variables to hold attribute data for creating a Project object 
		String menuChoice = null;
		String inputNum = null;
		String inputProName = null;
		String inputProType = null;
		String inputAddress = null;
		String inputErf = null;

		// variables to hold string input and Double input after parsing it (for money-related attributes)
		String inputFee = null;
		Double feeDouble = null;
		String inputPaid = null;
		Double paidDouble = null;

		// variables to handle dates - input string in formatter parsed to DateTime
		String inputDate = null;
		LocalDate formattedDated = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");

		// variables to hold input used to create a Person object
		String personName = null;
		String personPhone = null;
		String personEmail = null;
		String personWorkAdd = null;


// === Capturing Project and Person Data ===

		System.out.println("=== Enter information about the new project ===");

		System.out.println("Enter the project's number: ");   			// project number
		inputNum = userInput.nextLine();

		System.out.println("Enter the project's name: ");				// project name 
		inputProName = userInput.nextLine();


		System.out.println("Enter the building's type: ");				// building type (house, office ...)
		inputProType = userInput.nextLine();


		System.out.println("Enter the property's address: ");			// building street address
		inputAddress = userInput.nextLine();


		System.out.println("Enter the property's ERF number: ");		// property's ERF number
		inputErf = userInput.nextLine();


		System.out.println("Enter the customer's total amount payable: "); // total cost to the customer
		inputFee = userInput.nextLine();
		if (inputFee != null) {
			// cast input from String to double if a number is entered
			try {
				feeDouble = Double.parseDouble(inputFee);
			} catch (NumberFormatException e) {
				System.out.println(inputFee + " is not a valid number");
			} 
		}
		
		System.out.println("Enter the amount the customer has paid: ");		// amount customer has paid
		inputPaid = userInput.nextLine();
		if (inputPaid != null) {
			// cast input to double if a number is entered
			try {
				paidDouble = Double.parseDouble(inputPaid);
			} catch (NumberFormatException e) {
				System.out.println(inputFee + " is not a valid number");
			} 
		}
		
		System.out.println("Enter the project deadline (dd/MM/yyyy): ");	// project deadline
		inputDate = userInput.nextLine();
		// try change string date input into LocalDate class type
		try {
			formattedDated = LocalDate.parse(inputDate, formatter);
//			System.out.println("Local Date " + formattedDated); // checking the date
		} catch (Exception e) {
			System.out.println(inputDate + "is not a valide date");
		}

		// create a project object
		Project projectTest = new Project(inputNum, inputProName, inputProType, 
				inputAddress, inputErf, feeDouble, paidDouble, formattedDated);
		// toString() will print out project information
		System.out.println(projectTest); 
	

		System.out.println("\n=== Enter the CUSTOMER's details ===");
		System.out.println("Enter the person's name: ");				// person's name 
		personName = userInput.nextLine();
		System.out.println("Enter the person's email address: ");		// person's email  
		personEmail = userInput.nextLine();
		System.out.println("Enter the person's phone number: ");		// person's phone number
		personPhone = userInput.nextLine();
		System.out.println("Enter the person's work address: ");		// person's work address
		personWorkAdd = userInput.nextLine();

		
		// create customer object
		Person customer1 = new Person(personName, personPhone, personEmail, personWorkAdd);
		System.out.println(customer1);  // toString() will print out entered project information

		// set customer to project
		projectTest.setCustomer(customer1);
		
		System.out.println("\n=== Enter the CONTRACTOR's details ===");
		System.out.println("Enter the person's name: ");				// person's name 
		personName = userInput.nextLine();
		System.out.println("Enter the person's email address: ");		// person's email  
		personEmail = userInput.nextLine();
		System.out.println("Enter the person's phone number: ");		// person's phone number
		personPhone = userInput.nextLine();
		System.out.println("Enter the person's work address: ");		// person's work address
		personWorkAdd = userInput.nextLine();

		// instantiate customer
		Person contractor1 = new Person(personName, personPhone, personEmail, personWorkAdd);
		System.out.println(contractor1);  // toString() will print out entered project information

		// set customer to project
		projectTest.setContractor(contractor1);
	
// === Edit attributes and finalise project options ===
		do {
			String menu = """
					\nMenu Options: 
				cd - Change project due date
				cp - Change total fee paid 
				up - Update Contractor's phone number
				ue - Update Contractor's email address
				ua - Update Contractor's work address
				fi - Finalise project
				ex - Exit\n""";
			
			// print out menu and user's input
			System.out.println(menu);
			menuChoice = userInput.nextLine();
			System.out.println("Menu selection: " + "'" + menuChoice + "'");
			
			switch (menuChoice) {
			// === Edit Project Attributes ===
			// change the due date
			case "cd":
				System.out.println();
				System.out.println("Update due date");
				System.out.println("Current due date: " + projectTest.getProjDeadline()); // display old deadline
				System.out.println("Enter the new project deadline (dd/MM/yyyy): ");
				String newDeadline = userInput.nextLine();
				// try change string date input into LocalDate class type
				try {
					formattedDated = LocalDate.parse(newDeadline, formatter);
//					System.out.println("Local Date " + formattedDated); // checking the date
					System.out.println("New due date: " + projectTest.getProjDeadline()); // display new deadline
				} catch (Exception e) {
					System.out.println(inputDate + "is not a valid date");
				}
				break;  // case break for "cd"
				
			// change the amount paid 
			case "cp":
				System.out.println();
				System.out.println("Update amount paid");
				System.out.println("Amount already paid: R" + projectTest.getFeePaid()); // display old amount
				System.out.println("Enter the new total amount paid: ");
				double updatePaid = userInput.nextDouble();
				System.out.println(updatePaid);
				projectTest.setFeePaid(updatePaid);
				System.out.println("Updated amount already paid: R" + projectTest.getFeePaid()); // display new amount
				break;  // case break for "cp"
				
			// === Edit Contractor Attributes ===
			// update phone number
			case "up":
				System.out.println();
				System.out.println("Update phone number");
				System.out.println("Current phone number: " + contractor1.getPhoneNumber()); // display old phone number
				System.out.println("Enter the new phone number: ");
				String updatePhone = userInput.nextLine();
				System.out.println(updatePhone);
				contractor1.setPhoneNumber(updatePhone);
				System.out.println("Updated phone number: " + contractor1.getPhoneNumber()); // display new phone number
				break;  // case break for "up"
				
			// update email address
			case "ue":
				System.out.println();
				System.out.println("Update email address");
				System.out.println("Current email address: " + contractor1.getEmail()); // display old email address
				System.out.println("Enter the new email address: ");
				String updateEmail = userInput.nextLine();
				System.out.println(updateEmail);
				contractor1.setEmail(updateEmail);
				System.out.println("Updated email address: " + contractor1.getEmail()); // display new email address
				break;  // case break for "ue"
				
			// update work address
			case "ua":
				System.out.println();
				System.out.println("Update work address");
				System.out.println("Current work address: " + contractor1.getWorkAddress()); // display old email address
				System.out.println("Enter the new work address: ");
				String updateWork = userInput.nextLine();
				System.out.println(updateWork);
				contractor1.setEmail(updateWork);
				System.out.println("Updated work address: " + contractor1.getWorkAddress()); // display new email address
				break;  // case break for "ua"
				
			// === Finalise Project ===
			// add date completed and parse String input to LocalDate 
			case "fi":
				System.out.println("Enter the project's date of completion (dd/MM/yyyy): ");
				inputDate = userInput.nextLine();
				// try change string date input into LocalDate class type
				try {
					formattedDated = LocalDate.parse(inputDate, formatter);
//					System.out.println("Local Date " + formattedDated); // checking the date
				} catch (Exception e) {
					System.out.println(inputDate + "is not a valide date");
				}
				
				// set date to Project attribute dateCompleted
				projectTest.setDateCompleted(formattedDated);
				// change projFinalised to true
				projectTest.setProjFinalised();
				System.out.println("Project marked complete");
				System.out.println("Date completed: " + projectTest.getDateCompleted());
				
				// check if the customer has an outstanding payment and generate invoice 
				double owing = projectTest.getFeeTotal() - projectTest.getFeePaid();
				if (owing > 0) {
					//print customer details and amount outstanding
					System.out.println("=== Customer Invoice ===\n");
					System.out.println("Amount outstanding: R" + owing);
					System.out.println(customer1.toString());
					
				}
				// display project information
				System.out.println(projectTest.toString());
				return;  // exit program after finalising project
				
			// print goodbye message
			case "ex":
				System.out.println("Thanks for using the project manager.");
		
			} 
		} while (!(menuChoice.equals("ex")));  // exit when user enters "ex"
	}
} 



