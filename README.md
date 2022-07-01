# Project-management-system

The first part of a project management system for a fictitious structural engineering firm

## Description

This is the first part of an ongoing project. The user is able to create a new project, view and edit some of that information. There is an option to finalise the project which will generate a customer invoice if there is an outstanding amount.

This project exercises fundamental Java programming concepts: classes, objects, try-catch, the LocalDate class and input. 

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
