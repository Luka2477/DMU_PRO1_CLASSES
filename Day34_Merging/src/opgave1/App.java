package opgave1;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ArrayList<Customer> customers1 = new ArrayList<>(Arrays.asList(
                new Customer("Lukas", 21),
                new Customer("Nikolai", 28),
                new Customer("Lasse", 25),
                new Customer("Dorte", 58),
                new Customer("Per", 59),
                new Customer("Jeppe", 24),
                new Customer("Omar", 19),
                new Customer("Sidsel", 30),
                new Customer("Morten", 26)
        ));
        customers1.sort(Customer::compareTo);
        ArrayList<Customer> customers2 = new ArrayList<>(Arrays.asList(
                new Customer("Markus", 23),
                new Customer("Morten", 26),
                new Customer("Mads", 24)
        ));
        customers2.sort(Customer::compareTo);

        System.out.println(customers1);
        System.out.println(customers2);
        System.out.println();
        System.out.println(fletAlleKunder(customers1, customers2));
    }

    public static ArrayList<Customer> fletAlleKunder (ArrayList<Customer> l1, ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();
        int i1 = 0, i2 = 0;

        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).compareTo(l2.get(i2)) < 0) {
                result.add(l1.get(i1));
                i1++;
            } else {
                result.add(l2.get(i2));
                i2++;
            }
        }

        if (i1 > l1.size()) {
            result.addAll(l2.subList(i2, l2.size()-1));
        } else {
            result.addAll(l1.subList(i1, l1.size()-1));
        }

        return result;
    }

}
