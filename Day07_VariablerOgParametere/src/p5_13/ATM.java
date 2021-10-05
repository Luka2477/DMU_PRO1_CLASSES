package p5_13;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tries = 0;

        while(tries <= 3) {
            tries++;

            System.out.print("Please enter your PIN: ");
            if(scanner.next().equals("1234")) {
                System.out.println("Your PIN is correct");
                break;
            } else System.out.println("Your PIN is incorrect");
        }

        if(tries > 3) System.out.println("Your bank card is locked");
    }
}
