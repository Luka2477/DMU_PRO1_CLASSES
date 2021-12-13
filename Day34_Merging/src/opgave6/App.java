package opgave6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        WriteFiles.writeToFiles("numbers1.txt", "numbers2.txt", 10000, 100000);
        findFællesTal("numbers1.txt", "numbers2.txt", "result.txt");
    }

    public static Scanner openFileWithScanner (String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        return new Scanner(file);
    }

    public static void findFællesTal (String fileName1, String fileName2, String fileNameResult) {
        try {
            Scanner scanner1 = openFileWithScanner("day34_merging/src/opgave6/" + fileName1);
            Scanner scanner2 = openFileWithScanner("day34_merging/src/opgave6/" + fileName2);
            PrintWriter writer = new PrintWriter("day34_merging/src/opgave6/" + fileNameResult);

            int next1 = scanner1.nextInt(), next2 = scanner2.nextInt();
            while (scanner1.hasNextInt() && scanner2.hasNextInt()) {
                if (next1 < next2) {
                    next1 = scanner1.nextInt();
                } else if (next1 > next2) {
                    next2 = scanner2.nextInt();
                } else {
                    writer.println(next1);
                    next1 = scanner1.nextInt();
                    next2 = scanner2.nextInt();
                }
            }

            if (next1 == next2) {
                writer.println(next1);
            }

            writer.flush();
            writer.close();
            scanner1.close();
            scanner2.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
