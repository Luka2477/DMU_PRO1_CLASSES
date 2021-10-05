package modelemployeeexcersize;

public class EmployeeApp {
    public static void main(String[] args) {
        Employee e1 = new Employee("Lukas Orluff Knudsen", 40000);
        EmployeeTester e1t = new EmployeeTester(e1);
        e1t.test();
    }
}
