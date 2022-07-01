
package poised;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
/**
 * Writes Project attribute information to <code>Current projects.txt</code>
 * either by appending a single line from a single Project, or by overwriting 
 * the entire text file with information from all current projects in a List.
 * 
 * @author Nadia
 * @version 1.0
 *
 */
// abstract class won't create objects but have static methods
public abstract class WriteTextFile {

	// ################ Constants and Constructor #################
	/**
	 * Formats numbers used for currency to two decimal places {
	 * @value #DEC_FORMATTER}
	 */
	static final NumberFormat DEC_FORMATTER = new DecimalFormat("#0.00");   
	
	/**
	 * Constructor made explicit and private so the class can't be instantiated
	 * by the implicit public one.
	 */
	private WriteTextFile() {
	}

	// ####################### Methods ###########################
	// method that gets details and makes a long string
	/**
	 * Gets and concatenates Project details into a long sting for writing to
	 * <code>Current projects.txt</code>.
	 * 
	 * @param projObj 		a Project object with captured fields 
	 * @return 				a string of Project details in the order that matches the 
	 * 						<code>TEXT_REGEX</code> pattern of the 
	 * 						<code>ReadTextFile class</code>. 
	 */
	private static String projectText(Project projObj) {
		return projObj.getProjNumber() + ", "
				+ projObj.getProjName() + ", "
				+ projObj.getProjType() + ", "
				+ projObj.getProjAddress() + ", "
				+ projObj.getProjErf() + ", "
				/* format prices to 2 decimals and change the default 
				 * comma separator into a period to be recogised by the regex
				 */
				+ DEC_FORMATTER.format(projObj.getFeeTotal()).replace(',', '.') + ", "
				+ DEC_FORMATTER.format(projObj.getFeePaid()).replace(',', '.') + ", "
				+ projObj.getProjDeadline() + ", "
				+ projObj.isProjFinalised() + ", "
				// customer
				+ projObj.getCustomer().getFirstName() + ", "
				+ projObj.getCustomer().getLastName() + ", "
				+ projObj.getCustomer().getPhoneNumber() + ", "
				+ projObj.getCustomer().getEmail() + ", "
				+ projObj.getCustomer().getWorkAddress() + ", "
				// contractor
				+ projObj.getContractor().getFirstName() + ", "   
				+ projObj.getContractor().getLastName() + ", "    
				+ projObj.getContractor().getPhoneNumber() + ", " 
				+ projObj.getContractor().getEmail() + ", "       
				+ projObj.getContractor().getWorkAddress() + ", " 
				// architect
				+ projObj.getArchitect().getFirstName() + ", "   
				+ projObj.getArchitect().getLastName() + ", "    
				+ projObj.getArchitect().getPhoneNumber() + ", " 
				+ projObj.getArchitect().getEmail() + ", "       
				+ projObj.getArchitect().getWorkAddress() + ", " 
				+ "\r\n";
	}

	/**
	 * Writes the details of a single project in a string of one line that is
	 * appended to <code>Current projects.txt</code>.
	 * Calls the <code>projectText</code> method to obtain the string
	 * 
	 * @param projObj    	the Project to pass into the <code>projectText</code>
	 * 						method that this method calls
	 * @throws IOException if the file could not be located and written to
	 */
	// append the details of single project to text file
	public static void writeNewProjectToFile(Project projObj) {
		try {
			// create FileWriter with 'true' argument to append line to file
			FileWriter outputFile = new FileWriter("Current projects.txt", true);
			// a return a string of all project info and write to file
			outputFile.write(projectText(projObj));
			outputFile.close();	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Overwrites <code>Current projects.txt</code> with the details 
	 * of all Projects stored in a List to update it when changes are
	 * made to one more projects in the List.
	 * 
	 * @param projList		an ArrayList of updated Project objects
	 * @throws IOException if the file could not be located and written to
	 */
	public static void writeProjListToFile(List<Project> projList) {
		String veryLongString = "";
		try {
			// create FileWriter to write to file 
			FileWriter outputFile = new FileWriter("Current projects.txt");
			// make a long string of all the info of each project in the list 
			for (Project project : projList) {
				veryLongString += projectText(project);
			}
			// write to the long string to file and close writer object
			outputFile.write(veryLongString);
			outputFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
