package modelemployee;

/**
 * Klasse der beskriver en ansat
 *
 * @author mad
 *
 */
public class Employee {
	/*
	 * Attributter der beskriver den ansattes tilstand
	 */
	private String first_name;
	private String last_name;
	private boolean trainee;
	private int age;

	/*
	 * Constructor, når den ansatte oprettes, skal den have et navn. Ved
	 * oprettelse er den ansatte en trainee
	 */
	public Employee(String input_first_name, String input_last_name, int input_age) {
		first_name = input_first_name;
		last_name = input_last_name;
		trainee = true;
		age = input_age;
	}

	/*
	 * Den ansattes navn kan ændres ved kald af setName metoden
	 */
	public void setFirstName(String input_first_name) {
		first_name = input_first_name;
	}

	/*
	 * Man kan få oplyst den ansattes navn, ved at kalde metoden getName
	 */
	public String getFirstName() {
		return first_name;
	}

	public void setLastName(String input_last_name) { last_name = input_last_name; }
	public String getLastName() { return last_name; }

	/*
	 * Den ansatte kan få ændret trainee status ved at kalde metoden setTrainess
	 */
	public void setTrainee(boolean isTrainee) {
		trainee = isTrainee;
	}

	/*
	 * Man kan få oplyst den ansatte er trainess aktivitet, ved at kalde metoden
	 * isTrainee
	 */
	public boolean isTrainee() {
		return trainee;
	}

	public int getAge() { return age; }
	public void setAge(int input_age) { age = input_age; }

	public void birthday() { age++; }

	public void printEmployee() {
		System.out.println("*******************");
		System.out.println("Fornavn: " + first_name);
		System.out.println("Efternavn: " + last_name);
		System.out.println("Trainee " + trainee);
		System.out.println("Alder: " + age);
		System.out.println("*******************");
	}
}
