package opgave4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class App {

    public static void main(String[] args) {
        ArrayList<Customer> c = new ArrayList<>(Arrays.asList(
                new Customer("Knudsen", "Lukas", 21),
                new Customer("Lazar", "Omar", 19),
                new Customer("Vazquez", "Berta", 20),
                new Customer("Ploughstrup", "Lasse", 22)));

        System.out.println(c);
        Collections.sort(c);
        System.out.println(c);
    }

}
