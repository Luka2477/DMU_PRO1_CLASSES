package oevelser;

public class Instructor extends Person {

    private double salary;

    public Instructor (String name, int birthday, double salary) {
        super(name, birthday);

        this.salary = salary;
    }

    @Override
    public String toString () {
        return super.toString() + " | " + this.salary;
    }

}
