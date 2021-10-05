package p5_10;

import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer to be converted to roman numerals (0-3999): ");
        int number = scanner.nextInt();
        StringBuilder roman = new StringBuilder();

        if(number > 3999) return;

        roman.append("M".repeat(Math.max(0, number / 1000)));

        number %= 1000;
        roman.append(romanConditions(number / 100, "C", "D", "M"));
        number %= 100;
        roman.append(romanConditions(number / 10, "X", "L", "C"));
        number %= 10;
        roman.append(romanConditions(number, "I", "V", "X"));

        System.out.printf("The integer you entered equals %s in Roman Numerals!", roman);
    }

    private static String romanConditions(int number, String one, String five, String ten) {
        StringBuilder roman = new StringBuilder();

        if(number == 9)
            roman.append(one).append(ten);
        else if(number >= 5) {
            roman.append(five);
            roman.append(String.valueOf(one).repeat(number - 5));
        } else if(number == 4)
            roman.append(one).append(five);
        else
            roman.append(String.valueOf(one).repeat(Math.max(0, number)));

        return roman.toString();
    }
}
