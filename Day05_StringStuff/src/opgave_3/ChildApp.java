package opgave_3;

public class ChildApp {
	public static void main(String[] args) {
		Child[] children = new Child[10];
		for(int i=0; i<10; i++) children[i] = new Child(i * 2, true);

		for(int i=0; i<children.length; i++)
			System.out.printf(
					"Child %d is %d years old, is a %s and has this institution: %s%n",
					i,
					children[i].getAge(),
					children[i].gender(),
					children[i].institution()
			);
	}
}
