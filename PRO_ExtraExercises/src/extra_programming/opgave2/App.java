package extra_programming.opgave2;

import java.util.Arrays;

public class App {

    public static int højesteAntalBenbrud(int[][] values) {
        int max = 0;
        for (int[] row : values) {
            for (int col : row) {
                if (col > max) {
                    max = col;
                }
            }
        }
        return max;
    }

    public static int[] samledeAntalBenbrudPrÅr(int[][] values) {
        int[] sums = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int sum = 0;
            for (int col : values[i]) {
                sum += col;
            }
            sums[i] = sum;
        }
        return sums;
    }

    public static int[] samledeAntalBenbrudPrMåned(int[][] values) {
        int[] sums = new int[values[0].length];
        for (int i = 0; i < values[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < values.length; j++) {
                sum += values[j][i];
            }
            sums[i] = sum;
        }
        return sums;
    }

    public static int månedMedHøjstAntalBenbrud(int[][] values) {
        int max = 0, maxIndex = 0;
        for (int i = 0; i < values[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < values.length; j++) {
                sum += values[j][i];
            }
            if (sum > max) {
                max = sum;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void udskrivArray(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.print("År " + (2015 + i) + ": ");
            for (int j = 0; j < values[i].length; j++) {
                System.out.printf("%5d", values[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] benbrud = {
                { 98, 117, 120, 80, 98, 56, 66, 45, 78, 86, 89, 99 },
                { 101, 99, 75, 67, 79, 56, 50, 57, 88, 77, 75, 96 },
                { 112, 95, 110, 97, 89, 65, 44, 56, 88, 67, 45, 80 },
                { 89, 92, 89, 89, 89, 89, 89, 89, 89, 89, 89, 89 }
        };
        udskrivArray(benbrud);
        System.out.println();
        System.out.print("Max antal benbrud i en måned: " );
        System.out.println(højesteAntalBenbrud(benbrud));
        System.out.print("Samlede antal benbrud pr. år: " );
        System.out.println(Arrays.toString(samledeAntalBenbrudPrÅr(benbrud)));
        System.out.print("Samlede antal benbrud pr. måned: " );
        System.out.println(Arrays.toString(samledeAntalBenbrudPrMåned(benbrud)));
        System.out.print("Indeks for måneden med max antal benbrud pr. måned: "
        );
        System.out.println(månedMedHøjstAntalBenbrud(benbrud));
    }

}
