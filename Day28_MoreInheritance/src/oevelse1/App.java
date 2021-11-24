package oevelse1;

public class App {
    public static void main(String[] args) {
        Person p = new Person("Lukas Knudsen", 2000);
        Student s = new Student("Mads", 1996, "PRO1");
        Instructor i = new Instructor("Margrethe", 1975, 40000);

        System.out.println(p);
        System.out.println(s);
        System.out.println(i);
    }
}
