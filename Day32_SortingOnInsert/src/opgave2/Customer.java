package opgave2;

import java.util.ArrayList;
import java.util.Arrays;

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
    public static void insertCustomer (Customer[] customers, Customer customer) {
        boolean found = false;
        int i = 0;

        while (i < customers.length && !found) {
            if (customers[i] == null) {
                customers[i] = customer;
                found = true;
            } else if (customer.compareTo(customers[i]) < 0) {
                shiftCustomers(customers, i);
                customers[i] = customer;
                found = true;
            } else {
                i++;
            }
        }

        if (!found) {
            System.out.println("There is no room for " + customer + " in the array!");
        }
    }

    private static void shiftCustomers (Customer[] customers, int i) {
        boolean foundNull = false;
        Customer last = null;

        while (i < customers.length && !foundNull) {
            if (customers[i] == null) {
                customers[i] = last;
                foundNull = true;
            } else {
                Customer temp = customers[i];
                customers[i] = last;
                last = temp;
                i++;
            }
        }

        if (!foundNull) {
            System.out.println(last + " was removed from the array!");
        }
    }

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Berta Vazquez", 20));
        customers.add(new Customer("Lasse Knudsen", 25));
        customers.add(new Customer("Lukas Knudsen", 21));
        customers.add(new Customer("Nicolai Knudsen", 28));
        Customer[] customersArr = customers.toArray(new Customer[6]);

        System.out.println(Arrays.toString(customersArr));
        insertCustomer(customersArr, new Customer("Dorte Knudsen", 58));
        System.out.println(Arrays.toString(customersArr));
        insertCustomer(customersArr, new Customer("Per Knudsen", 59));
        System.out.println(Arrays.toString(customersArr));
    }

}
