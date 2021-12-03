package opgave5;

public class SortMethods {
    
    public static void bubbleSort(String[] arr) {
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = 0; j < i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    SortMethods.swap(arr, j, j+1);
                }
            }
        }
    }
    
    public static void insertionSort(String[] arr) {
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
    
    public static void selectionSort(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SortMethods.swap(arr, i, minIndex);
        }
    }

    private static void swap (String[] arr, int index1, int index2) {
        String temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
}
