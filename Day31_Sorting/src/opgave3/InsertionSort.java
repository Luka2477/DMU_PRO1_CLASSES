package opgave3;

import java.util.ArrayList;

public abstract class InsertionSort {

    public static void sort (String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String next = arr[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(arr[j-1]) >= 0) {
                    found = true;
                } else {
                    arr[j] = arr[j-1];
                    j--;
                }
            }
            arr[j] = next;
        }
    }

    public static void sort (ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list.get(j-1)) >= 0) {
                    found = true;
                } else {
                    list.set(j, list.get(j-1));
                    j--;
                }
            }
            list.set(j, next);
        }
    }

}
