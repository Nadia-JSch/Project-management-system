package poised;
/**
 * Creates Contractor objects to represent and hold information about the person
 * in charge of building a property for the firm "Poised". 
 * An objects fof this class are set as an attribute of the Project 
 * object's <code>contractor</code> attribute. Inherits all attributes and 
 * methods from the Person super class. 
 * 
 * @author Nadia 
 * @version 1.0
 * @see Person {@link poised.Task 24.javadoc.Person}
 */
public class Contractor extends Person {

	/**
	 * An explicit constructor without parameters. Contractor
	 * objects are instantiated before attribute data is set to 
	 * allow for flexibility in creating instances.
	 * @return Contractor an object of the Person data type
	 */
	// 'empty' constructor
	public Contractor() {
	}
	
	/**
	 * Displays each attribute of a Contractor on it's own line. Contains Windows' 
	 * <code>\r</code> to display information on new lines when written 
	 * to the <code>Completed projects.txt</code> file.
	 * 
	 * @return output 	a formatted string of the contractor's name, surname, 
	 * 					phone number, email address and work address
	 * @since 1.0					
	 */
	@Override
	public String toString() {
		String output = "\n--- Contractor's Information ---\r";
		output += "\nName: \t\t" + firstName + "\r";
		output += "\nSurname: \t" + lastName + "\r";
		output += "\nPhone number: \t" + phoneNumber + "\r";
		output += "\nEmail address: \t" + email + "\r";
		output += "\nWork address: \t" + workAddress + "\r";
		return output;
	}

}
