package poised;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Child class of Project Class to handle finalising requirments of 
 * marking a project as complete, generating invoice if there's an amount 
 * owing and writing finalised project information to file
 * 
 * @author Nadia
 * @version 1.0
 *
 */
public abstract class FinaliseProject extends Project{
	
	
	/**
	 * Marks a project as complete by capturing the date of completion,
	 * and setting the <code>projFinalised</code> Project attribute to 
	 * <code>true</code>. 
	 * 
	 * @param projectObjName	the Project to be finalised
	 * @throws Exception 		If the input can't be parsed from a string to 
	 * 						 	LocalDate type in the dd/MM/yyyy format
	 */
	// method to mark a project as completed, capture and add completed date
	public static void finaliseDate(Project projectObjName) {
		
		// date format  
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		
		// request date from user in dd/MM/yyyy format
		System.out.println(""
				+ "Please enter the project's date of completion (dd/MM/yyyy)");
		String userDateComplete = userText.nextLine();
	
		// keep requesting input until a date in dd/MM/yyyy format is entered
		while (projectObjName.getDateCompleted() == null) {
			try {
				LocalDate formattedDate = LocalDate.parse(userDateComplete, formatter);
				// set date to Project object
				projectObjName.setDateCompleted(formattedDate);
				/* if the completion date is successfully set, 
				 * then set Boolean projFinalised to true */
				projectObjName.setProjFinalised();
				// display success message
				System.out.println("Project marked complete\nDate completed: " 
				+ projectObjName.getDateCompleted());
	
			} catch (Exception e) {
				System.out.println(userDateComplete + " is not a valid date");
			}
		}
	}
	/**
	 * Checks if there is a difference between and <code>feeTotal</code> 
	 * and <code>feePaid</code> and prints that difference along with 
	 * the Customer details as an invoice.
	 * 
	 * @param projectObjName	the Project to be finalised
	 */
	// create a method to generate an invoice if necessary
	public static void generateInvoice(Project projectObjName) {
		// for formatting numbers to 2 decimal places
		NumberFormat formatter = new DecimalFormat("#0.00");
		
		// calculate the difference between the total and paid amounts
		double owing = projectObjName.getFeeTotal() - projectObjName.getFeePaid();
		if (owing > 0) {
			// display customer details and amount owing
			System.out.println("=== Customer Invoice ===\nAmount outstanding: R" 
					+ formatter.format(owing) + "\n"
					+ projectObjName.getCustomer());
		}
	}
	
	
	/**
	 * Writes the  completed project information to 
	 * <code>Completed projects.txt<code>
	 * by appending the details of single project to the text file.
	 * 
	 * @param projObj
	 * @throws IOException
	 */
	public static void writeCompletedProjToFile(Project projObj) {
		
		String veryLongString = 
				"----------------------- "
				+ "COMPLETED PROJECT DETAILS "
				+ "-----------------------\r"
				+ projObj.toString()
				+ "\r\n"
				+ projObj.getCustomer() 
				+ "\r\n"
				+ projObj.getContractor() 
				+ "\r\n"
				+ projObj.getArchitect()
				+ "\r\n";
		System.out.println(veryLongString);
		
		try {
			// create FileWriter with 'true' argument to append line to file
			FileWriter outputFile = new FileWriter("Completed projects.txt", true);
			// a return a string of all project info and write to file
			outputFile.write(veryLongString);
			outputFile.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Removes the completed project from the List of current projects.
	 * 
	 * @param theList		a List of current projects
	 * @param project		the project to be removed from the List
	 * @return 				an update list of current projects
	 */
	public static List<Project> removeCompletedProj(List<Project> theList, Project project) {
		if (project.isProjFinalised()) {
			theList.remove(project);
		}
		return theList;
	}
}
