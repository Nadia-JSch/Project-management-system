package poised;

import java.util.Scanner;

/**
 * Abstract class that prints the edit and finalisation sub menu options and 
 * uses a <code>switch</code> block to perform the user specified action(s).
 * Calls functions that use getters and setters as defined in the 
 * <code>Project</code> and 
 * <code>Person</code> classes, to edit attributes.
 * Calls methods from the <code>FinaliseProject</code> class that mark projects
 * as complete, set date of completion, generate an invoice if there is an 
 * outstanding amount, write project information from file and remove the 
 * project from the current objects List.
 * 
 * @author Nadia
 * @version 1.0
 * @see Project.addPaidAmount
 * @see Project.addProjCost
 * @see Project.addDeadline
 * @see Person.editPersonPhone
 * @see Person.editPersonEmail
 * @see Project.getCustomer
 * @see Project.getContractor
 * @see FinaliseProject.finaliseDate
 * @see FinaliseProject.generateInvoice
 * @see FinaliseProject.writeCompletedProjToFile
 * 				
 */
public abstract class EditFinaliseMenu {

	/**
	 * Constructor made explicit and private so the class can't be instantiated
	 * by the implicit public one.
	 */
	private EditFinaliseMenu() {
	}

	// new scanner object to read user input
	static Scanner userEntry = new Scanner(System.in); 

	/**
	 * A string of sub menu options used exclusively 
	 * for passing into the <code>edits</code> method of the same class.
	 * @value #EDITING_MENU}
	 */
	private static final String EDITING_MENU = """

			=== Editing Options === 
			(1)  -  Edit project cost
			(2)  -  Edit project fee paid
			(3)  -  Edit project deadline
			(4)  -  Edit customer phone number
			(5)  -  Edit customer email address
			(6)  -  Edit contractor phone number 
			(7)  -  Edit contractor email address
			(8)  -  Edit architect phone number 
			(9)  -  Edit architect email address
			(f)  -  Finalise Project
			(mm) -  Return to the main menu

			Please enter your selection: """;

	/**
	 * Displays a sub menu with options to alter selected details of a Project
	 * or to mark it as complete. 
	 * <p>
	 * Calls methods from the <code>FinalisePrject</code> class. That is, 
	 * the <code>finaliseDate</code> method to 
	 * record the Project's date of completion, the <code>generateInvoice</code> 
	 * method to display  an invoice to the user if there is still an amount 
	 * owing, and the <code>writeCompletedProjToFile</code> method to write 
	 * information to <code>Completed projects.txt</code>.
	 * 
	 * @param project returned Project from of <code>searchProjects</code> method
	 */
	public static void edits(Project project) {
		String menuChoice;
		do {
			// print out menu and user's input
			System.out.println(EDITING_MENU);
			menuChoice = userEntry.nextLine().toLowerCase();
			System.out.printf("Menu selection: \'%s\'%n", menuChoice);

			switch (menuChoice) {
			case "1" -> project.addProjCost(project);
			case "2" -> project.addPaidAmount(project);
			case "3" -> project.addDeadline(project);
			case "4" -> project.getCustomer()
						.editPersonPhone(project.getCustomer(), "Customer");
			case "5" -> project.getCustomer()
						.editPersonEmail(project.getCustomer(), "Customer");
			case "6" -> project.getContractor()
						.editPersonPhone(project.getContractor(), "Contractor");
			case "7" -> project.getContractor()
						.editPersonEmail(project.getContractor(), "Contractor");
			case "8" -> project.getArchitect()
						.editPersonPhone(project.getArchitect(), "Architect");
			case "9" -> project.getArchitect()
						.editPersonEmail(project.getArchitect(), "Architect");
			
			// #### Finalising project ###
			case "f" -> {
				// call method to add date completed and mark project as complete
				FinaliseProject.finaliseDate(project);
				// check if the customer has an outstanding payment and generate invoice 
				FinaliseProject.generateInvoice(project);
				// display project information
				FinaliseProject.writeCompletedProjToFile(project);
			} 
			case "mm" -> System.out.println();
			default -> System.out.println("Invalid selection. Please try again");
			}
			// exit to main menu
		} while (!menuChoice.equals("mm"));
	}
}
