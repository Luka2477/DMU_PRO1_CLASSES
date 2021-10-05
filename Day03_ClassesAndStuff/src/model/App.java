package model;

public class App {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Lukas Orluff Knudsen");
        System.out.println(employee1.getName() + " is " + (employee1.isTrainee() ? "a trainee!" : "not a trainee!"));
        employee1.setName("Mads B Halløjsa");
        employee1.setTrainee(false);
        System.out.println(employee1.getName() + " is " + (employee1.isTrainee() ? "a trainee!" : "not a trainee!"));
        employee1.printEmployee();
    }
}
