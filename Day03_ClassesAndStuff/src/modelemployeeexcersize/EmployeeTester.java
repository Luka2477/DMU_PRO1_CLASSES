package modelemployeeexcersize;

public class EmployeeTester {
    final private Employee employee;

    public EmployeeTester(Employee input_employee) {
        employee = input_employee;
    }

    public void test() {
        printEmployee();
        employee.raiseSalary(10);
        printEmployee();
    }

    private void printEmployee() { System.out.println("Name: " + employee.getName() + " | Salary: " + employee.getSalary()); }
}
