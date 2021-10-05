package e5_1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please give me a number (-inf - inf): ");
        int number = scanner.nextInt();

        String sign;
        if(number < 0) sign = "negative";
        else if(number == 0) sign = "zero";
        else sign = "positive";

        System.out.printf("The number that you gave is %s!%n", sign);
    }
}
