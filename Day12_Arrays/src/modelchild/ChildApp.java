package modelchild;

public class ChildApp {

	public static void main(String[] args) {
		double[] weight = {4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9, 35.1, 37.3};
		Child c1 = new Child(0, true, weight);// boy 4 years old
		Child c2 = new Child(2, false, weight);// girl 2 years old

		System.out.println("Et barn på " + c1.getAge());

		//--------------------------------------------------------------------------------------

		Institution institution = new Institution("EAAA", "Sønderhøj 30, 8260 Viby J");
		institution.addChild(c1);
		institution.addChild(c2);

		System.out.printf("Den gennemsnitte alder er %d.%n", institution.averageAge());
		System.out.printf("Piger: %d | Drenge: %d.%n", institution.numberOfGirls(), institution.numberOfBoys());
	}

}
