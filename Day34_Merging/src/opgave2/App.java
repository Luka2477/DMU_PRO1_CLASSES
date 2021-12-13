package opgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main (String[] args) {
        int[] l1 = {2, 4, 6, 8, 10, 12, 14};
        int[] l2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(l1));
        System.out.println(Arrays.toString(l2));
        System.out.println();
        System.out.println(Arrays.toString(fællesTal(l1, l2)));
    }

    public static Integer[] fællesTal (int[] l1, int[] l2) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int i1 = 0, i2 = 0;

        while (i1 < l1.length && i2 < l2.length) {
            if (l1[i1] < l2[i2]) {
                i1++;
            } else if (l1[i1] > l2[i2]) {
                i2++;
            } else {
                resultList.add(l1[i1]);
                i1++;
                i2++;
            }
        }

        return resultList.toArray(new Integer[0]);
    }

}
