package opgave6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public abstract class WriteFiles {

    public static void main(String[] args) {
        writeToFiles("numbers1.txt", "numbers2.txt", 100, 1000);
    }

    public static void writeToFiles (String fileName1, String fileName2, int minBound, int maxBound) {
        try {
            PrintWriter writer1 = new PrintWriter("day34_merging/src/opgave6/" + fileName1);
            PrintWriter writer2 = new PrintWriter("day34_merging/src/opgave6/" + fileName2);
            Random random = new Random();

            ArrayList<Integer> l1 = new ArrayList<>();
            ArrayList<Integer> l2 = new ArrayList<>();
            int rand = (int) (minBound + Math.random() * (maxBound-minBound));
            for (int i = 0; i < rand; i++) {
                l1.add(Integer.MIN_VALUE / 2 + random.nextInt(Integer.MAX_VALUE));
            }
            l1.sort(Integer::compareTo);

            rand = (int) (minBound + Math.random() * (maxBound-minBound));
            for (int i = 0; i < rand; i++) {
                l2.add(Integer.MIN_VALUE / 2 + random.nextInt(Integer.MAX_VALUE));
            }
            l2.sort(Integer::compareTo);

            for (Integer integer : l1) {
                writer1.println(integer);
            }

            for (Integer integer : l2) {
                writer2.println(integer);
            }

            writer1.flush();
            writer1.close();
            writer2.flush();
            writer2.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
