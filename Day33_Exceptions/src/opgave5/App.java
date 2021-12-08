package opgave5;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String file = "day33_exceptions/src/opgave5/tal.txt";
            PrintWriter writer = new PrintWriter(file);

            boolean end = false;
            while (!end && scanner.hasNextLong()) {
                long next = scanner.nextLong();

                if (next < -1) {
                    System.out.println("Tallene skal være positive!");
                } else if (next == -1) {
                    end = true;
                } else {
                    writer.println(next);
                }
            }

            writer.flush();
            writer.close();
            scanner.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}
