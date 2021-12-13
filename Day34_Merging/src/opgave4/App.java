package opgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println(linFileSearch("numbers.txt", 1000));
    }

    public static boolean linFileSearch (String fileName, int target) {
        boolean found = false;

        try {
            File file = new File("day34_merging/src/opgave4/" + fileName);
            Scanner scanner = new Scanner(file);

            while (!found && scanner.hasNextInt()) {
                if (scanner.nextInt() == target) {
                    found = true;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return found;
    }
}
