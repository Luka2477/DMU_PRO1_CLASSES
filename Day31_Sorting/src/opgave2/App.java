package opgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};
        ArrayList<Customer> c = new ArrayList<>(Arrays.asList(
                new Customer("Knudsen", "Lukas", 21),
                new Customer("Lazar", "Omar", 19),
                new Customer("Vazquez", "Berta", 20),
                new Customer("Ploughstrup", "Lasse", 22)));

        System.out.println(Arrays.toString(s));
        SelectionSort.sort(s);
        System.out.println(Arrays.toString(s));
        System.out.println();
        System.out.println(c);
        SelectionSort.sort(c);
        System.out.println(c);
    }

}
