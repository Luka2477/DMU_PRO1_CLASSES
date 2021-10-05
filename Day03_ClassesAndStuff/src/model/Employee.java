package model;

public class Employee {
    private String name;
    private boolean trainee;

    public Employee(String input_name) {
        name = input_name;
        trainee = true;
    }

    public String getName() { return name; }
    public boolean isTrainee() { return trainee; }

    public void setName(String input_name) { name = input_name; }
    public void setTrainee(boolean input_trainee) { trainee = input_trainee; }

    public void printEmployee() {
        System.out.println("****************************************");
        System.out.println("Employee name: " + name);
        System.out.println("Is employee a trainee: " + trainee);
        System.out.println("****************************************");
    }
}
