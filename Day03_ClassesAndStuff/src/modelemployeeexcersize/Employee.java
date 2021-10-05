package modelemployeeexcersize;

public class Employee {
    private String name;
    private double salary;

    public Employee(String employee_name, double current_salary) {
        name = employee_name;
        salary = current_salary;
    }

    public String getName() { return name; }
    public double getSalary() { return salary; }
    public void raiseSalary(double by_percent) { salary *= 1 + by_percent * 0.01; }
}
