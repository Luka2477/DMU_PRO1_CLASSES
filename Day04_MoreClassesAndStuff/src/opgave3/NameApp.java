package opgave3;

public class NameApp {
    public static void main(String[] args) {
        Name name = new Name("Lukas", "Orluff", "Knudsen");

        System.out.printf(
                "%s %s %s has the initials %s and username %s%n",
                name.getFirstName(),
                name.getMiddleName(),
                name.getLastName(),
                name.getInit(),
                name.getUsername()
        );
    }
}
