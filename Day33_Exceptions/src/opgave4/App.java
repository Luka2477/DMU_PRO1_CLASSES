package opgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App {

    public static void main(String[] args) {
        try {
            String file = "day33_exceptions/src/opgave4/tal.txt";
            PrintWriter writer = new PrintWriter(file);

            for (int i = 99; i >= 1; i -= 2) {
                writer.println(i);
            }

            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
