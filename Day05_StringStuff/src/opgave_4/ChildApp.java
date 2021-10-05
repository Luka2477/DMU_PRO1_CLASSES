package opgave_4;

public class ChildApp {
	public static void main(String[] args) {
		Child[] children = new Child[10];
		for(int i=0; i<10; i++) children[i] = new Child(i * 2, true);

		for(int i=0; i<children.length; i++)
			System.out.printf(
					"***%nChild %d is %d years old and is a %s%nThe child has this institution: %s%nThe child goes to this team: %s%n",
					i,
					children[i].getAge(),
					children[i].gender(),
					children[i].institution(),
					children[i].team()
			);
	}
}
