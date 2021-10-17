package opgave1;

public class Person {
    private final String name;
    private final String title;
    private final boolean senior;

    public Person(String name, String title, boolean senior) {
        this.name = name;
        this.title = title;
        this.senior = senior;
    }

    @Override
    public String toString() {
        return String.format("%s %s%s%n", this.title, this.name, (this.senior) ? " (senior)" : "");
    }
}
