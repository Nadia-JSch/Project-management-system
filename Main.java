package poised;

// import libraries 
import java.util.Scanner;

public class Main {

	// refactor: make a constant instead of repeating string literal
	private static final String CAPTURE_PROJECT = "\nNOTE: Please capture project details first\n";

	public static void main (String[] args) {

		// new scanner object to read user input
		Scanner userInput = new Scanner(System.in); 

		// display welcome message
		System.out.println("Welcome to the Poised Project Manager!\n");
		
		// create method to take in a project object and then call project methods
		Project project1 = new Project();
		
		// Refactoring: create PersonFactory object as per factory design pattern
		PersonFactory personFactory = new PersonFactory();
		PersonInterface customerObj = personFactory.getPerson("Customer");
		PersonInterface contractorObj = personFactory.getPerson("Contractor");
		PersonInterface architectObj = personFactory.getPerson("Architect");

		
		// === Main menu options ===
		String menuChoice;
		do {
			String mainMenu = """
					 === Main Menu Options === 
					1 - Create a new Project
					2 - Add Contractor to Project
					3 - Add Architect to Project
					4 - Change Project due date
					5 - Change total fee paid 
					6 - Update Contractor details
					7 - Finalise Project
					e - Exit 
					Please enter your selection: """;

			// sub menu options - for editing contractor details
			String conMenu = """
					1 - Update Contractor's phone number
					2 - Update Contractor's email address
					3 - Update Contractor's work address """;

			// print out menu and user's input
			System.out.println(mainMenu);
			menuChoice = userInput.nextLine();
			System.out.printf("Menu selection: \'%s\'%n", menuChoice );
			
			switch (menuChoice) {
			case  "1" -> {
				// === Capturing Project & Customer Data ===
				// capture data & set project number, name, type, address and ERF number
				project1.addProjectInfo(project1);
				// capture data and set the project's cost
				project1.addProjCost(project1);
				// capture and set the amount paid
				project1.addPaidAmount(project1);
				// method to capture and set the project deadline
				project1.addDeadline(project1);

				// display project info
				System.out.println("Project Information\n" + project1.toString());
				
				// call the Person method to capture data and set as project attribute
				System.out.println();
				System.out.println("=== Adding customer details ===");
				customerObj.addPersonInfo(customerObj);
				project1.setCustomer(customerObj);
				// flag Project and Customer as having captured information
				project1.setCaptured(true);
				customerObj.setCaptured(true);
			}

			case "2" -> {
				/* add contractor info and set as project attribute 
				 * if project data is captured and the contractor info is not yet captured*/
				if (project1.isCaptured()) {
					System.out.println("=== Adding contractor details ===");
					contractorObj.addPersonInfo(contractorObj);
					project1.setContractor(contractorObj);
					// flag that contractor info has been captured
					contractorObj.setCaptured(true);
				}
				else {
					System.out.println(CAPTURE_PROJECT);
				}
			}
			case "3" -> {
				/* if project data is captured then can add architect 
				 info and set it as project attribute */
				if (project1.isCaptured()) {
					System.out.println("=== Adding architect details ===");
					architectObj.addPersonInfo(architectObj);
					project1.setArchitect(architectObj);
					architectObj.setCaptured(true);
				}
				else {
					System.out.println(CAPTURE_PROJECT);
				}
			}

			// change the due date if project data is capture
			case "4" -> {
				if (project1.isCaptured()) {
					// refactor: replaced repeated code with a method to capture and set the due date
					System.out.println("Update due date\nCurrent due date: " 
					+ project1.getProjDeadline());
					// call method to capture and set new deadline
					project1.addDeadline(project1);
				}
				else {
					System.out.println(CAPTURE_PROJECT);
				}
			}
			// change the amount paid 
			case "5" -> {
				if (project1.isCaptured()) {
					// display current amount paid
					System.out.println("Update amount paid\\n Amount already paid: R" 
					+ project1.getFeePaid());
					project1.addPaidAmount(project1);
					// display project information
					System.out.println(project1.toString());
				}
				else {
					System.out.println(CAPTURE_PROJECT);
				}
			} 
			// === Edit Contractor Attributes ===
			case "6" -> {
				if (contractorObj.isCaptured()) {
					System.out.println("Please enter an option\n" + conMenu);
					String conChoice = userInput.nextLine();
					switch (conChoice) {
						case "1" -> // update phone number
							contractorObj.editPersonPhone(contractorObj);
						case "2" -> // update email address
							contractorObj.editPersonEmail(contractorObj);
						case "3" -> // update work address
							contractorObj.editPersonAddress(contractorObj);
						default ->
							System.out.println("Please enter a valid menu choice");
					} 
				} else {
					System.out.println("\nPlease capture contractor details first\n");
				}
			}	

			// === Finalise Project ===
			case "7" -> {
				if (contractorObj.isCaptured()) {
					// refactor: call method to add date completed and mark project as completed
					project1.finaliseDate(project1);
					// check if the customer has an outstanding payment and generate invoice 
					project1.generateInvoice(project1);
					// display project information
					System.out.println(project1.toString());
					// exit program after finalising project
				}
				else {
					System.out.println(CAPTURE_PROJECT);
				}
			}
			// print goodbye message
			case "e" -> 
			System.out.println("Thank you for using the project manager!");

			// refactor: added a default case to switch
			default -> 
			System.out.println("Incorrect selection. Please try again.");
			} 
			// exit loop when user enters "ex"
		} while (!(menuChoice.equals("e")));  
	}
} 



