package poised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Abstract class with the responsibility of reading Project information from 
 * a text file, populating objects with those details and adding those objects
 * to an Arraylist.
 * 
 * @author Nadia
 * @version 1.0
 */
public abstract class ReadTextFile {
	// ################### Constants and Constructor ####################
	/* create ArrayList for storing project objects created from reading 
	 * "Current projects.txt"
	 */
	static ArrayList<Project> projListFromFile = new ArrayList<>();

	/**
	 * Formats numbers used for currency to two decimal places as 
	 * {@value #DATE}
	 */
	private static final String DATE = "yyyy-MM-dd";
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE);

	/**
	 * A regular expression with named capture groups to label segments of 
	 * the comma separated values read from the text file. Each line of the 
	 * text file contains all project, customer, contractor and 
	 * architect information. Value is {@value #TEXT_REGEX}
	 */
	private static final String TEXT_REGEX = "(?<projNum>\\d*),\\s" 
			+ "(?<projName>\\w*[\\s]*[\\w]*),\\s"
			+ "(?<projType>\\w*),\\s"
			+ "(?<projAddr>[^,]+),\\s" // match anything except for commas
			+ "(?<projERF>\\w*),\\s"
			+ "(?<projCost>\\d+[,.]\\d+),\\s"
			+ "(?<projPaid>\\d+[,.]\\d+),\\s"
			+ "(?<projDue>\\d{4}-\\d{2}-\\d{2}),\\s"
			+ "(?<projIsDone>\\w+),\\s"
			+ "(?<customerFName>.*),\\s"
			+ "(?<customerLName>.*),\\s"
			+ "(?<customerPhone>.*),\\s"
			+ "(?<customerEmail>.*),\\s"
			+ "(?<customerAddr>.*),\\s"
			+ "(?<contractFName>.*),\\s"
			+ "(?<contractLName>.*),\\s"
			+ "(?<contractPhone>.*),\\s"
			+ "(?<contractEmail>.*),\\s"
			+ "(?<contractAddr>.*),\\s"
			+ "(?<architectFName>.*),\\s"
			+ "(?<architectLName>.*),\\s"
			+ "(?<architectPhone>.*),\\s"
			+ "(?<architectEmail>.*),\\s"
			+ "(?<architectAddr>.*),\\s";
	
	/**
	 * Object to compile the regular expression.
	 */
	public static final Pattern TEXT_PAT = Pattern.compile(TEXT_REGEX);
	// object to match the regular expression pattern
	public static Matcher textMatch;

	/**
	 * Constructor made explicit and private so the class can't be instantiated
	 * by the implicit public one.
	 */
	private ReadTextFile() {
	}

	// ###################### Method ############################
	/**
	 * Creates new objects and passes in details read from the text file into 
	 * respective attributes before adding objects to a list.
	 * A line of text from <code>Current projects.txt</code> contains details
	 * appearing in the order outlined by a regular expression with named 
	 * capture groups. The regex is used to parse data and set them to 
	 * the related attributes of the Project and Person instantiations.
	 * 
	 * @return a List of project objects 
	 * @throws IOException 	if the file can't be located and read from
	 */
	// read each line of Current projects.txt to create an ArrayList of project objects
	public static List<Project> createProjList() {
		try {
			FileReader file = new FileReader("Current projects.txt");
			BufferedReader buffReader = new BufferedReader(file);
			// parse each line from the text file into their respective attributes
			while (buffReader.ready()) {
				String projectText = buffReader.readLine();
				textMatch = TEXT_PAT.matcher(projectText);
				if (textMatch.find()) {
					// create objects and set the people as attributes to the project
					Project aNewProject = new Project();
					Person customerObj = new Customer();
					Person contractorObj = new Contractor();
					Person architectObj = new Architect();
					aNewProject.setContractor(contractorObj);
					aNewProject.setCustomer(customerObj);
					aNewProject.setArchitect(architectObj);

					// set all project details read from file
					aNewProject.setProjNumber(textMatch.group("projNum"));
					aNewProject.setProjName(textMatch.group("projName"));
					aNewProject.setProjType(textMatch.group("projType"));
					aNewProject.setProjAddress(textMatch.group("projAddr"));
					aNewProject.setProjErf(textMatch.group("projERF"));
					// for the prices, convert the Strings to Doubles
					double feeDouble = Double.parseDouble(textMatch.group("projCost"));
					aNewProject.setFeeTotal(feeDouble);
					double paidDouble = Double.parseDouble(textMatch.group("projPaid"));
					aNewProject.setFeePaid(paidDouble);
					// convert the String to LocalDate
					LocalDate deadlineLD = LocalDate.parse(textMatch.group("projDue"), formatter);
					aNewProject.setProjDeadline(deadlineLD);
					// mark project as complete
					if (textMatch.group("projIsDone").equals("true")) {
						aNewProject.setProjFinalised();
					}
					// set customer details
					customerObj.setFirstName(textMatch.group("customerFName"));
					customerObj.setLastName(textMatch.group("customerLName"));
					customerObj.setPhoneNumber(textMatch.group("customerPhone"));
					customerObj.setEmail(textMatch.group("customerEmail"));
					customerObj.setWorkAddress(textMatch.group("customerAddr"));
					// set contractor details
					contractorObj.setFirstName(textMatch.group("contractFName"));
					contractorObj.setLastName(textMatch.group("contractLName"));
					contractorObj.setPhoneNumber(textMatch.group("contractPhone"));
					contractorObj.setEmail(textMatch.group("contractEmail"));
					contractorObj.setWorkAddress(textMatch.group("contractAddr"));
					// set architect details
					architectObj.setFirstName(textMatch.group("architectFName"));
					architectObj.setLastName(textMatch.group("architectLName"));
					architectObj.setPhoneNumber(textMatch.group("architectPhone"));
					architectObj.setEmail(textMatch.group("architectEmail"));
					architectObj.setWorkAddress(textMatch.group("architectAddr"));

					// add the projects to an ArrayList
					projListFromFile.add(aNewProject);
				}
			}
			buffReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return projListFromFile;
	}

}
