package opgave2;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Customer c1 = new Customer("Lukas", "Knudsen", 21);
        Customer c2 = new Customer("Berta", "Vazquez", 20);
        Customer c3 = new Customer("Jens", "Moss", 22);
        Customer c4 = new Customer("Lasse", "Knudsen", 25);
        Customer c5 = new Customer("Nicolai", "Knudsen", 28);

        Customer[] customers = {c1, c2, c3, c4, c5};

        System.out.println(Arrays.asList(customers));
        System.out.println(App.lastCustomer(customers).getFirstName());
        System.out.println(Arrays.asList(App.afterCustomer(customers, App.lastCustomer(customers))));
    }

    public static Customer lastCustomer (Customer[] customers) {
        Customer result = customers[0];
        for (int i = 1; i < customers.length; i++) {
            if (result.compareTo(customers[i]) < 0) {
                result = customers[i];
            }
        }
        return result;
    }

    public static Customer[] afterCustomer (Customer[] customers, Customer customer) {
        int index = -1;
        Customer[] result = new Customer[0];
        for (int i = 0; i < customers.length; i++) {
            if (index == -1) {
                if (customers[i] == customer) {
                    index = i + 1;
                    result = new Customer[customers.length - i - 1];
                }
            } else {
                result[i - index] = customers[i];
            }
        }
        return result;
    }

}
