package Opgave1;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Hans");
        names.add("Viggo");
        names.add("Jens");
        names.add("Børge");
        names.add("Bent");

        System.out.println(names);

        names.add(2, "Jane");

        System.out.println(names);

        names.remove(1);
        names.add(0, "Pia");
        names.add("Ib");

        System.out.println(names.toArray().length);

        names.set(2, "Hansi");

        System.out.println(names.toArray().length);
        System.out.println(names);

        for(int i=0; i<names.toArray().length; i++)
            System.out.println(names.get(i).length());

        for(String name : names)
            System.out.println(name.length());
    }
}
