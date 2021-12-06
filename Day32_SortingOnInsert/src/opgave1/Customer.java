package opgave1;

import java.util.ArrayList;

public class Customer implements Comparable<Customer> {

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo (Customer customer) {
        int comp = this.name.compareTo(customer.getName());
        return (comp != 0) ? comp : this.age - customer.getAge();
    }

    @Override
    public String toString () {
        return this.name + " " + this.age;
    }

    //---------------------------------------------------------------

    /**
     * Inserts a customer in customers.
     * Pre: customers is sorted
     *
     * @param customers the customers list
     * @param customer the customer to be inserted in customers
     */
    public static void insertCustomer (ArrayList<Customer> customers, Customer customer) {
        boolean found = false;
        int i = 0;
        while (i < customers.size() && !found) {
            if (customer.compareTo(customers.get(i)) < 0) {
                customers.add(i, customer);
                found = true;
            } else {
                i++;
            }
        }

        if (!found) {
            customers.add(customer);
        }
    }

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Berta Vazquez", 20));
        customers.add(new Customer("Lasse Knudsen", 25));
        customers.add(new Customer("Lukas Knudsen", 21));
        customers.add(new Customer("Nicolai Knudsen", 28));

        System.out.println(customers);
        insertCustomer(customers, new Customer("Dorte Knudsen", 58));
        System.out.println(customers);
        insertCustomer(customers, new Customer("Per Knudsen", 59));
        System.out.println(customers);
    }

}
