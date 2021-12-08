package opgave7.e11_6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {

    public static Scanner openFileWithScanner (String fileName) throws IOException {
        File file = new File(fileName);
        return new Scanner(file);
    }

    public static void writeRandomTwoFloatingColumns (String fileName, int lines) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);

        for (int i = 0; i < lines; i++) {
            writer.println(Math.random() * 999 + "-" + (Math.random() * 999));
        }

        writer.flush();
        writer.close();
    }

    public static double[] averageOfColumns (String fileName) throws IOException {
        Scanner scanner = openFileWithScanner(fileName);

        double sumCol1 = 0, sumCol2 = 0;
        int count = 0;
        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split("-");
            sumCol1 += Double.parseDouble(strings[0]);
            sumCol2 += Double.parseDouble(strings[1]);
            count++;
        }

        scanner.close();
        return new double[]{sumCol1 / count, sumCol2 / count};
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("File name to read from: ");
        String fileName = "day33_exceptions/src/opgave7/e11_6/text_files/" + scanner.nextLine() + ".txt";

        System.out.print("Number of lines to make: ");
        int lines = Integer.parseInt(scanner.nextLine());

        writeRandomTwoFloatingColumns(fileName, lines);

        double[] averages = averageOfColumns(fileName);
        System.out.println(averages[0] + " " + averages[1]);
    }
}
