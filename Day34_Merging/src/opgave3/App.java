package opgave3;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ArrayList<Customer> l1 = new ArrayList<>(Arrays.asList(
                new Customer("Lukas", 21),
                new Customer("Nikolai", 28),
                new Customer("Lasse", 25),
                new Customer("Jeppe", 24),
                new Customer("Omar", 19),
                new Customer("Sidsel", 30)
        ));
        Customer c1 = new Customer("Dorte", 58);
        Customer c2 = new Customer("Per", 59);
        l1.add(c1);
        l1.add(c2);
        l1.sort(Customer::compareTo);

        Customer[] l2 = {c1, c2};

        System.out.println(l1);
        System.out.println(Arrays.toString(l2));
        System.out.println();
        System.out.println(goodCustomers(l1, l2));
    }

    public static ArrayList<Customer> goodCustomers (ArrayList<Customer> l1, Customer[] l2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0, i2 = 0;

        while (i1 < l1.size() && i2 < l2.length) {
            if (l1.get(i1).compareTo(l2[i2]) == 0) {
                i1++;
                i2++;
            } else if (l1.get(i1).compareTo(l2[i2]) < 0) {
                result.add(l1.get(i1));
                i1++;
            } else {
                result.add(l1.get(i1));
                i2++;
            }
        }

        if (i1 < l1.size()) {
            result.addAll(l1.subList(i1, l1.size()));
        }

        return result;
    }
}
