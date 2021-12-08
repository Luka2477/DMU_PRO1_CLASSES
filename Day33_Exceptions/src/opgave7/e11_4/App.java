package opgave7.e11_4;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class App {

    public static Scanner openFileWithScanner (String fileName) throws IOException {
        File file = new File(fileName);
        return new Scanner(file);
    }

    public static void addLineNumbersToFile (String fileNameIn, String fileNameOut) throws IOException {
        Scanner scanner = openFileWithScanner(fileNameIn);
        PrintWriter writer = new PrintWriter(fileNameOut);

        int lineNumber = 1;
        while (scanner.hasNextLine()) {
            writer.println("/* " + lineNumber + " */ " + scanner.nextLine());
            lineNumber++;
        }

        writer.flush();
        writer.close();
        scanner.close();
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter file name to read: ");
        String fileNameIn = scanner.nextLine();

        System.out.print("Please enter file name to write to: ");
        String fileNameOut = scanner.nextLine();

        addLineNumbersToFile("day33_exceptions/src/opgave7/e11_4/text_files/" + fileNameIn + ".txt", "day33_exceptions/src/opgave7/e11_4/text_files/" + fileNameOut + ".txt");
    }

}
