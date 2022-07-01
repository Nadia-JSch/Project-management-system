# Project-management-system

A project management system for a fictitious structural engineering firm to keep track of the many building projects that would be worked on. 

## Description

Attributes about the project are captured, they include:
- Project Name
- Project Number
- Building type
- Physical address
- ERF number
- Total cost to the customer
- Amount paid by the customer to date
- Deadline
- The name, phone number, email address and work address of the:
	* Customer
	* Architect
	* Contractor
		
For the final version, functionality includes generating a name for the project if one wasn't entered, updating project information, marking a project as finialised with a date of completion and an invoice generated to the customer if necessary, viewing current projects, and viewing overdue projects. Project information is read from and stored in a text file. Another text file of completed projects is used for record keeping purposes for the company.

## Project Deliverables
### First Submission

A Project and Person class were created to capture project information, edit the deadline, edit the contractor's information and mark a project as final as well as generate a customer invoice if there is an amount outstanding. 
This project builds upon fundamental Java programming concepts: classes, objects, try-catch, the LocalDate class and input. 

### Second Submission

Added input verification and exception handling.

Largely refacted the code:
- Reduced the procedural programming orientation to a more OOP one:
	* created more classes with better levels of cohesion and weak coupling 
	* used inheritance  
	* used the factory design pattern to instantiate objects
	* set fields as private as well as methods not used outside the class
- Made the code more modular and reduced some repetition
- Added more descriptive names


### Third Submission (final version )
Multiple projects are finally able to be created, which allowed for the functionality of searching through project to view and edit them. Also, the funcionality to see over due and current projects were added as a result of utilizing the Java Collections Framework.

A further addition, is the ability to store data by writing (and reading) object information to text files.

A submenu for editing projects was created and more editing options were added. 

Java docs were added to classes, methods and the poised package.


### Dependencies

* import java.time.LocalDate
* import java.util*
* import java.io*
* import java.text.DecimalFormat;
* import java.text.NumberFormat;


### Search Menu Screenshot
![Poised search menu](https://github.com/Nadia-JSch/Project-management-system/blob/master/Poised%20search%20menu.png)

### Code Snippet

``` java
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
```

