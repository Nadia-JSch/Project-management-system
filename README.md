# Project-management-system

A project management system for a fictitious structural engineering firm that stores information about a project. 

## Description

With the second update to this project users can do the following:
- Create a new Project
- Add Contractor to Project
- Add Architect to Project
- Change Project due date
- Change total fee paid 
- Update Contractor details
- Finalise Project

This project builds upon fundamental Java programming concepts: classes, objects, try-catch, the LocalDate class and input. 

### Dependencies

* import LocalDate

### Running the program

* Run the main.java file in any Java IDE. 

### Preview

``` java
	// check if the customer has an outstanding payment and generate invoice 
				double owing = projectTest.getFeeTotal() - projectTest.getFeePaid();
				if (owing > 0) {
					//print customer details and amount outstanding
					System.out.println("=== Customer Invoice ===\n");
					System.out.println("Amount outstanding: R" + owing);
					System.out.println(customer1.toString());
```
