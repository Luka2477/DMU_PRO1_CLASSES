package modelperson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String name;
    private String address;
    private double monthly_salary;
    final private List<String> companies = new ArrayList<>();

    public Person(String input_name) { name = input_name; }

    public void setName(String input_name) { name = input_name; }
    public String getName() { return name; }

    public void setAddress(String input_address) { address = input_address; }
    public String getAddress() { return address; }

    public void setMonthlySalary(double input_monthly_salary) { monthly_salary = input_monthly_salary; }
    public double getMonthlySalary() { return monthly_salary; }

    public double getYearlySalary() { return (monthly_salary * 12) * 1.025; }

    public void addCompany(String input_company_name) { companies.add(input_company_name); }

    public void printPerson() { System.out.println("Name: " + name + " | Address: " + address + " | Mothly Salary: " + monthly_salary + "\nCompanies worked at: " + companies); }
}
