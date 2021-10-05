package opgave_2;

public class ChildApp {
	public static void main(String[] args) {
		Child[] children = new Child[10];
		for(int i=0; i<10; i++) children[i] = new Child(i * 2, false);

		for(int i=0; i<children.length; i++)
			System.out.printf(
					"Child %d is %d years old and has this institution: %s%n",
					i,
					children[i].getAge(),
					children[i].institution()
			);
	}
}
