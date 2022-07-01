package poised;

/* refactoring: use the Factory pattern to enable loose coupling 
and create multiple Person objects at runtime */

public class PersonFactory {
	
	// use getPerson method to get an object of type Person
	public PersonInterface getPerson(String personType) {
		if (personType == null) {
			return null;
		}
		if (personType.equalsIgnoreCase("Customer")) {
			return new Customer();
		}
		else if (personType.equalsIgnoreCase("Contractor")) {
			return new Contractor();
		}
		else if (personType.equalsIgnoreCase("Architect")) {
			return new Architect();
		}
		return null;		
	}
}
