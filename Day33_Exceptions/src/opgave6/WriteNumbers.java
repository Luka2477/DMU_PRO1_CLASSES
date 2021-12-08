package opgave6;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class WriteNumbers {

    public static void generateIntFiles() throws FileNotFoundException {
        String fileName10 = "day33_exceptions/src/opgave6/10tal.txt";
        String fileName2500 = "day33_exceptions/src/opgave6/2500tal.txt";

        PrintWriter writer10 = new PrintWriter(fileName10);
        PrintWriter writer2500 = new PrintWriter(fileName2500);

        for (int i = 0; i < 2500; i++) {
            if (i < 10) {
                writer10.println(-Integer.MAX_VALUE / 4 + new Random().nextInt(Integer.MAX_VALUE / 2));
            }

            writer2500.println(-Integer.MAX_VALUE / 4 + new Random().nextInt(Integer.MAX_VALUE / 2));
        }

        writer10.flush();
        writer10.close();
        writer2500.flush();
        writer2500.close();
    }

}
