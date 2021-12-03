package opgave1;

public abstract class BubbleSort {

    public static void sort (String[] arr) {
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    BubbleSort.swap(arr, j, j+1);
                }
            }
        }
    }

    private static void swap (String[] arr, int index1, int index2) {
        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
