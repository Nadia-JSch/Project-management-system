
package poised;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Project {
	// constant to use in formatting dates
	private static final String DATE_FORMAT = "dd/MM/yyyy";

	// new scanner object to read user input
	Scanner userInput = new Scanner(System.in); 
	
	// Refactor: set attributes to private and methods to public
	// Project attributes - in the constructor
	private String projNumber = "none";
	private String projName = "none";
	private String projType = "none";
	private String projAddress = "none";
	private String projErf = "none";
	private double feeTotal = -1;
	private double feePaid = -1;
	private LocalDate projDeadline;
	// flag for the above attributes being captured
	private boolean isCaptured = false;

	// Attributes related to the Person class - not in the constructor
	private PersonInterface customer;
	private PersonInterface contractor;
	private PersonInterface architect;

	// Project finialisation attributes - also not in the constructor
	private boolean projFinalised = false;       // default is false
	private LocalDate dateCompleted;

	// constructor - no parameters
	public Project() {
	}

	// full constructor - arguments excluding completed date and finalised boolean
	public Project(String projNumber, String projName, String projType, String projAddress, String projErf, Double inputFee,
			Double inputPaid, LocalDate projDeadline) {
		this.projNumber = projNumber;
		this.projName = projName;
		this.projType = projType;
		this.projAddress = projAddress;
		this.projErf = projErf;
		this.feeTotal = inputFee;
		this.feePaid = inputPaid;
		this.projDeadline = projDeadline;
	}


	// getters and setters for all attributes
	public String getProjNumber() {
		return projNumber;
	}


	public void setProjNumber(String projNumber) {
		this.projNumber = projNumber;
	}

	public String getProjName() {
		return projName;
	}


	public void setProjName(String projName) {
		this.projName = projName;
	}


	public String getProjType() {
		return projType;
	}

	public void setProjType(String projType) {
		this.projType = projType;
	}


	public String getProjErf() {
		return projErf;
	}

	public void setProjErf(String projErf) {
		this.projErf = projErf;
	}

	public double getFeeTotal() {
		return feeTotal;
	}

	public void setFeeTotal(double feeTotal) {
		this.feeTotal = feeTotal;
	}

	public double getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(double feePaid) {
		this.feePaid = feePaid;
	}

	public LocalDate getProjDeadline() {
		return projDeadline;
	}

	public void setProjDeadline(LocalDate projDeadline) {
		this.projDeadline = projDeadline; 
	}

	public String getProjAddress() {
		return projAddress;
	}

	public void setProjAddress(String projAddress) {
		this.projAddress = projAddress;
	}
	// getters and setters for the customer, contractor and architect
	public PersonInterface getCustomer() {
		return customer;
	}

	public void setCustomer(PersonInterface customer) {
		this.customer = customer;
	}

	public PersonInterface getContractor() {
		return contractor;
	}

	public void setContractor(PersonInterface contractor) {
		this.contractor = contractor;
	}

	
	public PersonInterface getArchitect() {
		return architect;
	}

	public void setArchitect(PersonInterface architect) {
		this.architect = architect;
	}

	public boolean isProjFinalised() {
		return projFinalised;
	}

	public void setProjFinalised() {
		this.projFinalised = true;
	}

	public LocalDate getDateCompleted() {
		return dateCompleted;
	}

	public void setDateCompleted(LocalDate dateComplete) {
		this.dateCompleted = dateComplete;
	}

	public boolean isCaptured() {
		return isCaptured;
	}
	
	public void setCaptured(boolean isCaptured) {
		this.isCaptured = isCaptured;
	}
	
	
	// toString override method that returns attributes as a string
	@Override
	public String toString() {
		String output = "\nProject Information \n";
		output += "\nProject number : \t" + projNumber;
		output += "\nProject name : \t\t" + projName; 
		output += "\nProperty type: \t\t" + projType;
		output += "\nProperty address: \t" + projAddress; 
		output += "\nProperty ERF number: \t" + projErf; 
		output += "\nProject total cost: \tR" + feeTotal; 
		output += "\nProject amount paid: \tR" + feePaid;
		output += "\nProject deadline: \t" + projDeadline;

		// print "no" if project is not yet finalised, and "yes" if it is
		if (!this.isProjFinalised()) {
			output += "\nProject finalised: \tNo";
		}
		else {
			output += "\nProject finalised: \tYes";
		}
		return output;
	}
	


	// Refactor: create a method to add some basic project information to a created object 
	public void addProjectInfo(Project projectObjName) {
		// set project number
		System.out.println("Please enter a unique project number: ");
		String userProjNum = userInput.nextLine();
		projectObjName.setProjNumber(userProjNum);
		// set project name
		System.out.println("Please enter the project's name: ");
		String userProjName = userInput.nextLine();
		projectObjName.setProjName(userProjName);
		// set property type
		System.out.println("Enter the building type (house, apartment, office etc.): ");
		String userProjType = userInput.nextLine();
		projectObjName.setProjType(userProjType);
		// set building address
		System.out.println("Enter the building's street address: ");
		String userProjAddress = userInput.nextLine();
		projectObjName.setProjAddress(userProjAddress);
		// set ERF number
		System.out.println("Enter the property's ERF number: ");
		String userProjErf = userInput.nextLine();
		projectObjName.setProjErf(userProjErf);
	}

	// Refactor: create a method to set project cost after checking if input is valid
	public void addProjCost(Project projectObjName) {
		// flag to check if the user input is valid
		boolean isValid = false;
		while (!isValid) {
			// total cost to the customer
			System.out.println("Enter the customer's total amount payable: ");
			String userProjCost = userInput.nextLine();
			try {
				Double feeDouble = Double.parseDouble(userProjCost);
				projectObjName.setFeeTotal(feeDouble);
				isValid = true;
			} catch (NumberFormatException e) {
				System.out.println(userProjCost + " is not a valid number");
			} 
		}
	}

	// Refactor: method to validate and set the amount paid by the customer
	public void addPaidAmount(Project projectObjName) {
		
		// flag to check if the user input is valid
		boolean isValid = false;
		while (!isValid) {
			System.out.println("Enter the amount the customer has paid: ");
			String userPaid = userInput.nextLine();
			
			try {
				Double paidDouble = Double.parseDouble(userPaid);
				projectObjName.setFeeTotal(paidDouble);
				// mark isValid as true
				isValid = true;
				
			} catch (NumberFormatException e) {
				System.out.println(userPaid + " is not a valid number");
			} 
		}
	}


	// Refactor: method to validate input and set the project deadline
	public void addDeadline(Project projectObjName) {
		// declare input date's format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

		// request input until it's valid
		while (projectObjName.getProjDeadline() == null) {
			System.out.println("Enter the project deadline (dd/MM/yyyy)");
			String userDeadline = userInput.nextLine();
			// try change string date input into LocalDate class type
			try {
				LocalDate formattedDate = LocalDate.parse(userDeadline, formatter);
				projectObjName.setProjDeadline(formattedDate);
			} catch (Exception e) {
				System.out.println(userDeadline + " is not a valid date");
			}
		}
	}

	// refactor: create a method to mark a project as completed, capture and add completed date
	public void finaliseDate(Project projectObjName) {
		// declare input date's format 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		String userDateComplete = userInput.nextLine();
		
		// capture user input
		System.out.println("Please enter the project's date of completion (dd/MM/yyyy)");
	
		// request input until it's valid
		while (projectObjName.getDateCompleted() == null) {
			try {
				LocalDate formattedDate = LocalDate.parse(userDateComplete, formatter);
				// set date to Project object
				projectObjName.setDateCompleted(formattedDate);
				// if the completion date is successfully set, then set Boolean projFinalised to true
				projectObjName.setProjFinalised();
				// display success message
				System.out.println("Project marked complete\nDate completed: " 
				+ projectObjName.getDateCompleted());
	
			} catch (Exception e) {
				System.out.println(userDateComplete + " is not a valid date");
			}
		}
	}

	// refactor: create a Project method to generate an invoice if necessary
	public void generateInvoice(Project projectObjName) {
		// calculate the difference between the total and paid amounts
		double owing = projectObjName.getFeeTotal() - projectObjName.getFeePaid();
		if (owing > 0) {
			// display customer details and amount owing
			System.out.println("=== Customer Invoice ===\nAmount outstanding: R" + owing + "\n"
							+ getCustomer().toString());
		}
	}

}
