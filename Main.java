package poised;

// for using dates
import java.time.LocalDate;
// for parsing String to LocalDate
import java.time.format.DateTimeFormatter;  
// for reading user input to console
import java.util.Scanner;    	

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
		
		// money-related attributes:
		// variables to hold string input and Double input after parsing it 
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

		// project number
		System.out.println("Enter the project's number: ");   			
		inputNum = userInput.nextLine();
		
		// project number
		System.out.println("Enter the project's name: ");				
		inputProName = userInput.nextLine();

		// building type (house, office ...)
		System.out.println("Enter the building's type: ");				
		inputProType = userInput.nextLine();

		// building street address
		System.out.println("Enter the property's address: ");			
		inputAddress = userInput.nextLine();

		// property's ERF number
		System.out.println("Enter the property's ERF number: ");		
		inputErf = userInput.nextLine();

		// total cost to the customer
		System.out.println("Enter the customer's total amount payable: "); 
		inputFee = userInput.nextLine();
		if (inputFee != null) {
			// cast input from String to double if a number is entered
			try {
				feeDouble = Double.parseDouble(inputFee);
			} catch (NumberFormatException e) {
				System.out.println(inputFee + " is not a valid number");
			} 
		}
		// amount customer has paid
		System.out.println("Enter the amount the customer has paid: ");		
		inputPaid = userInput.nextLine();
		if (inputPaid != null) {
			// cast input to double if a number is entered
			try {
				paidDouble = Double.parseDouble(inputPaid);
			} catch (NumberFormatException e) {
				System.out.println(inputFee + " is not a valid number");
			} 
		}
		// project deadline
		System.out.println("Enter the project deadline (dd/MM/yyyy): ");	
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
		// person's name
		System.out.println("Enter the person's name: ");				 
		personName = userInput.nextLine();
		// person's email
		System.out.println("Enter the person's email address: ");		  
		personEmail = userInput.nextLine();
		// person's phone number
		System.out.println("Enter the person's phone number: ");		
		personPhone = userInput.nextLine();
		// person's work address
		System.out.println("Enter the person's work address: ");		
		personWorkAdd = userInput.nextLine();

		
		// create customer object
		Person customer1 = new Person(personName, personPhone, personEmail, personWorkAdd);
		// toString() will print out entered project information
		System.out.println(customer1);  
		// set customer to project
		projectTest.setCustomer(customer1);
		
		System.out.println("\n=== Enter the CONTRACTOR's details ===");
		// person's name
		System.out.println("Enter the person's name: ");				 
		personName = userInput.nextLine();
		// person's email 
		System.out.println("Enter the person's email address: ");		 
		personEmail = userInput.nextLine();
		// person's phone number
		System.out.println("Enter the person's phone number: ");		
		personPhone = userInput.nextLine();
		// person's work address
		System.out.println("Enter the person's work address: ");		
		personWorkAdd = userInput.nextLine();

		// instantiate customer
		Person contractor1 = new Person(personName, personPhone, personEmail, personWorkAdd);
		System.out.println(contractor1);  

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
				// display old deadline
				System.out.println("Current due date: " 
				+ projectTest.getProjDeadline()); 
				
				// get new deadline
				System.out.println("Enter the new project deadline (dd/MM/yyyy): ");
				String newDeadline = userInput.nextLine();
				
				// try change string date input into LocalDate class type
				try {
					formattedDated = LocalDate.parse(newDeadline, formatter);
					// display new deadline
					System.out.println("New due date: " + projectTest.getProjDeadline()); 
				} catch (Exception e) {
					System.out.println(inputDate + "is not a valid date");
				}
				break;  // case break for "cd"
				
			// change the amount paid 
			case "cp":
				System.out.println();
				System.out.println("Update amount paid");
				
				// display old amount
				System.out.println("Amount already paid: R" + projectTest.getFeePaid()); 
				
				System.out.println("Enter the new total amount paid: ");
				double updatePaid = userInput.nextDouble();
				
				System.out.println(updatePaid);
				projectTest.setFeePaid(updatePaid);
					
				// display new amount
				System.out.println("Updated amount already paid: R" + projectTest.getFeePaid()); 
				
				break;  // case break for "cp"
				
			// === Edit Contractor Attributes ===
			// update phone number
			case "up":
				System.out.println();
				System.out.println("Update phone number");
				
				// display old phone number
				System.out.println("Current phone number: " + contractor1.getPhoneNumber()); 
				
				// get new phone number from user 
				System.out.println("Enter the new phone number: ");
				String updatePhone = userInput.nextLine();
				System.out.println(updatePhone);
				contractor1.setPhoneNumber(updatePhone);
				
				// display new phone number
				System.out.println("Updated phone number: " + contractor1.getPhoneNumber()); 
				break;  // case break for "up"
				
			// update email address
			case "ue":
				System.out.println();
				System.out.println("Update email address");
				
				// display old email address
				System.out.println("Current email address: " + contractor1.getEmail()); 
				
				System.out.println("Enter the new email address: ");
				String updateEmail = userInput.nextLine();
				System.out.println(updateEmail);
				contractor1.setEmail(updateEmail);
				
				// display new email address
				System.out.println("Updated email address: " + contractor1.getEmail()); 
				break;  // case break for "ue"
				
			// update work address
			case "ua":
				System.out.println();
				System.out.println("Update work address");
				
				// display old email address
				System.out.println("Current work address: " + contractor1.getWorkAddress()); 

				// get new address from user input
				System.out.println("Enter the new work address: ");
				String updateWork = userInput.nextLine();
				System.out.println(updateWork);
				contractor1.setEmail(updateWork);
				
				// display new email address
				System.out.println("Updated work address: " + contractor1.getWorkAddress()); 
				break;  // case break for "ua"
				
			// === Finalise Project ===
			// add date completed and parse String input to LocalDate 
			case "fi":
				System.out.println("Enter the project's date of completion (dd/MM/yyyy): ");
				inputDate = userInput.nextLine();
				// try change string date input into LocalDate class type
				try {
					formattedDated = LocalDate.parse(inputDate, formatter);
				} catch (Exception e) {
					System.out.println(inputDate + "is not a valide date");
				}
				
				// set date to Project attribute dateCompleted
				projectTest.setDateCompleted(formattedDated);
				
				// change projFinalised to true
				projectTest.setProjFinalised();
				
				// printing date of completion
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



