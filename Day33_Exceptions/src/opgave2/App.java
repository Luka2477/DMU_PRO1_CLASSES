package opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            File file = new File("day33_exceptions/src/opgave2/tal.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                System.out.println(Integer.parseInt(scanner.nextLine().trim()) * 2);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
