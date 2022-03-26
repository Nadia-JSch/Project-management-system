
package poised;

import java.time.LocalDate;

public class Project {
	
	// Project attributes - in the constructor
	String projNumber;
	String projName;
	String projType;
	String projAddress;
	String projErf;
	double feeTotal;
	double feePaid;
	LocalDate projDeadline;
	
	// Attributes related to the Person class - not in the constructor
	Person customer;
	Person contractor;
	Person architect;

	// Project finialisation attributes - also not in the constructor
	boolean projFinalised = false;       // default is false
	LocalDate dateCompleted;
	
	
	// constructor - no arguments
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

	public String getProjAdress() {
		return projAddress;
	}

	public void setProjAdress(String projAdress) {
		this.projAddress = projAdress;
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
		
	public Person getCustomer() {
		return customer;
	}

	public void setCustomer(Person customer) {
		this.customer = customer;
	}

	public Person getContractor() {
		return contractor;
	}

	public void setContractor(Person contractor) {
		this.contractor = contractor;
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

	
	// toString override method that returns attributes as a string
	@Override
	public String toString() {
		String output = "\n--- Project Information ---";
		output += "\nProject number : " + projNumber;
		output += "\nProject name : " + projName; 
		output += "\nProperty type: " + projType;
		output += "\nProperty address: " + projAddress; 
		output += "\nProperty ERF number: " + projErf; 
		//TODO format to display two decimal places
		output += "\nProject total cost: R" + feeTotal; 
		output += "\nProject amount paid: R" + feePaid;
		output += "\nProject deadline: " + projDeadline;
		
		// print "no" if project is not yet finalised, and "yes" if it is
		if (!this.isProjFinalised()) {
			output += "\nProject finalised: No";
		}
		else {
			output += "\nProject finalised: Yes";
		}
		return output;
	}
}
