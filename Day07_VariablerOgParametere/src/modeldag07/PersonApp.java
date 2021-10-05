package modeldag07;

public class PersonApp {

    public static void main(String[] args) {
        Person p = new Person("Bent", "Januss", "Christensen", 21, 9, 1995);
        p.printPerson();
        System.out.println("Initialer: " + p.getInit());
        System.out.println("Username: " + p.getUserName());

        System.out.println("Age: " + p.age(20, 9, 2021)); // p's age today
        int year = 1900;
        System.out.println("Er " + year + " skudår: " + p.leapYear(year));

        Person p1 = new Person("Bent", "Christensen", 21, 9, 1995);
        p1.printPerson();
        System.out.println("Initialer: " + p1.getInit());
        System.out.println("Username: " + p1.getUserName());

        System.out.println("Age: " + p1.age(20, 9, 2021)); // p's age today
        int year1 = 2000;
        System.out.println("Er " + year1 + " skudår: " + p1.leapYear(year1));

        int year2 = 2024;
        System.out.printf("Weekday of birthday in %d is %s%n", year2, p1.weekdayHack(year2));
        System.out.printf("Weekday of birthday in %d is %s%n", year2, p1.weekday("Torsdag", year2));
    }
}
