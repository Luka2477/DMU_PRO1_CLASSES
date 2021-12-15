package opgave7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String person = linSearchPerson("personer.txt", "Thomsen");
        System.out.println(person);
    }

    public static String linSearchPerson (String fileName, String target) {
        String result = "";

        try {
            File file = new File("day34_merging/src/opgave7/" + fileName);
            Scanner scanner = new Scanner(file);

            while (result.isEmpty() && scanner.hasNextLine()) {
                String[] split = scanner.nextLine().split(" ");

                if (split[2].equals(target)) {
                    result = split[1] + " " + split[2];
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }
}
