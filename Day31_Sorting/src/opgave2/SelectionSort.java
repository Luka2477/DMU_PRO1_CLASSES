package opgave2;

import java.util.ArrayList;

public abstract class SelectionSort {

    public static void sort (String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SelectionSort.swap(arr, i, minIndex);
        }
    }

    public static void sort (ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minIndex = i;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            SelectionSort.swap(list, i, minIndex);
        }
    }

    private static void swap (String[] arr, int index1, int index2) {
        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static void swap (ArrayList<Customer> list, int index1, int index2) {
        Customer temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

}
