/**
 * The poised package contains the source code of a project management system.
 * It is created for a fictitious structural engineering firm; "Poised".
 * <p>
 * Details about a project and its customer, contractor and architect 
 * are captured and written to <code>Current projects.txt</code> in the poised 
 * package's parent folder. Details of completed projects are removed 
 * from "Current projects.txt" and written to <code>Completed projects.txt</code>.
 * Projects can be searched for and edited.
 * <p>
 * The poised package structure:<br>
 * <code>Person</code> is the abstract parent class of 
 * <code>Customer</code>, <code>Contractor.java</code> and 
 * <code>Architect</code>. <code>Project</code> is the parent class
 * of the abstract <code>FinaliseProject</code> class.
 * Therefore, the following are abstract classes dependent on 
 * <code>Project</code> and <code>Person.java</code> and 
 * <code>Person</code>'s subclasses:
 * <ul>
 * <li><code>WriteTextFile</code>
 * <li><code>ReadTextFile</code>
 * <li><code>SearchProjectList</code>
 * <li><code>EditFinaliseMenu</code>
 * <li><code>FinaliseProject</code>
 * </ul>
 * <p>
 * The program is run from <code>MainMenu</code>.<br>
 * The user chooses various options from the main menu 
 * and it's sub menu <code>EditFinaliseMenu</code>.<br>
 * Main menu functionalities:<br>
 * <ul>
 * <li> View Current Projects
 * <li> View Overdue Projects
 * <li> Create a New Project
 * <li> Search / Edit / Finalise projects
 * <li> Exit 
 * </ul>
 * Sub menu functionalities:<br>
 * <ul>
 * <li>Edit project cost
 * <li>Edit project fee paid
 * <li>Edit project deadline
 * <li>Edit customer phone number
 * <li>Edit customer email address
 * <li>Edit contractor phone number
 * <li>Edit contractor email address
 * <li>Edit architect phone number
 * <li>Edit architect email address
 * </ul>
 * Currencies are in ZAR (South African Rand) written with a period before 
 * two decimal places (cents).<br>Dates are input by the user as "dd/MM/yyyy" 
 * and written to file as "yyyy-MM-DD".
 * 
 * @author Nadia-Jasmine Schmidtke
 * @version 1.00, 20 May 2022
 * @see Architect
 * @see Customer
 * @see Contractor
 * @see WriteTextFile
 * @see ReadTextFile
 * @see SearchProjectList
 * @see EditFinaliseMenu
 * @see	FinaliseProject
 */
package poised;
