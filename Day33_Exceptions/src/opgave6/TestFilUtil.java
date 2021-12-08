package opgave6;

import java.io.IOException;

public class TestFilUtil {

    public static void main(String[] args) throws IOException {
        WriteNumbers.generateIntFiles();

        String fileName10 = "day33_exceptions/src/opgave6/10tal.txt";
        String fileName2500 = "day33_exceptions/src/opgave6/2500tal.txt";

        System.out.println(FilUtil.max(fileName10));
        System.out.println(FilUtil.min(fileName10));
        System.out.println(FilUtil.gennemsnit(fileName10));
        System.out.println();
        System.out.println(FilUtil.max(fileName2500));
        System.out.println(FilUtil.min(fileName2500));
        System.out.println(FilUtil.gennemsnit(fileName2500));
    }
}