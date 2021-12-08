package opgave3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try {
            ArrayList<Integer> lst = new ArrayList<>();

            File file = new File("day33_exceptions/src/opgave2/tal.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                lst.add(Integer.parseInt(scanner.nextLine().trim()));
            }

            for (int i = lst.size()-1; i >= 0; i--) {
                System.out.println(lst.get(i));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
