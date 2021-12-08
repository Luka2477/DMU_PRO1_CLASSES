package opgave6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public abstract class FilUtil {

    public static Scanner openFileWithScanner (String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        return new Scanner(file);
    }

    public static int max (String fileName) throws IOException {
        Scanner scanner = openFileWithScanner(fileName);

        int max = Integer.MIN_VALUE;
        while (scanner.hasNextInt()) {
            int next = scanner.nextInt();

            if (next > max) {
                max = next;
            }
        }

        return max;
    }

    public static int min (String fileName) throws IOException {
        Scanner scanner = openFileWithScanner(fileName);

        int min = Integer.MAX_VALUE;
        while (scanner.hasNextInt()) {
            int next = scanner.nextInt();

            if (next < min) {
                min = next;
            }
        }

        return min;
    }

    public static double gennemsnit (String fileName) throws IOException {
        Scanner scanner = openFileWithScanner(fileName);

        int sum = 0;
        int count = 0;
        while (scanner.hasNextInt()) {
            sum += scanner.nextInt();
            count++;
        }

        return (double) sum / count;
    }

}
