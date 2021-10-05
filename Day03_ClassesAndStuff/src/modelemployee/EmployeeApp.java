package modelemployee;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 12);
		e1.printEmployee();
		e1.setFirstName("Viggo");
		e1.printEmployee();
		e1.setLastName("Knudsen");
		e1.printEmployee();
		System.out.println(e1.getFirstName() + " " + e1.getLastName());
		e1.setAge(32);
		e1.printEmployee();
		e1.birthday();
		e1.printEmployee();
	}

}
