package oevelser;

public class Person {

    private String name;
    private int birthday;

    public Person (String name, int birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString () {
        return this.name + " | " + this.birthday;
    }

}
