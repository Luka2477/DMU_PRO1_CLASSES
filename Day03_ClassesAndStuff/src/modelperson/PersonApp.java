package modelperson;

public class PersonApp {
    public static void main(String[] args) {
        Person p1 = new Person("Lukas Orluff Knudsen");
        p1.printPerson();
        p1.setName("Mads Byggaard Petersen");
        p1.printPerson();
        p1.setAddress("46 Risdalsvej, 8260 Viby J");
        p1.printPerson();
        p1.setMonthlySalary(40000);
        p1.printPerson();
        System.out.println(p1.getYearlySalary());
        p1.addCompany("PROSA");
        p1.addCompany("Arla");
        p1.addCompany("EAAA");
        p1.addCompany("Starbucks");
        p1.printPerson();
    }
}
