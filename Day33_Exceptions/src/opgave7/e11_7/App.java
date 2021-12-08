package opgave7.e11_7;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static Scanner openFileWithScanner (String fileName) throws IOException {
        File file = new File(fileName);
        return new Scanner(file);
    }

    public static void generateFile (String fileName, int lines) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);

        for (int i = 0; i < lines; i++) {
            if (Math.random() < 0.05) {
                writer.println();
            } else {
                StringBuilder str = new StringBuilder();

                for (int j = 0; j < new Random().nextInt(50); j++) {
                    str.append(new Random().nextInt(1000)).append(" ");
                }

                writer.println(str.toString().trim());
            }
        }

        writer.flush();
        writer.close();
    }

    public static void averageOfEachRow (String fileName) throws IOException {
        Scanner scanner = openFileWithScanner(fileName);

        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split(" ");

            if (strings[0].isEmpty()) {
                System.out.println(0);
            } else {
                int sum = 0;

                for (String str : strings) {
                    sum += Integer.parseInt(str);
                }

                System.out.println(sum / strings.length);
            }
        }

        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File name to read from: ");
        String fileName = "day33_exceptions/src/opgave7/e11_7/text_files/" + scanner.nextLine() + ".txt";

        System.out.print("Number of lines to make: ");
        int lines = Integer.parseInt(scanner.nextLine());

        generateFile(fileName, lines);

        averageOfEachRow(fileName);
    }
}
