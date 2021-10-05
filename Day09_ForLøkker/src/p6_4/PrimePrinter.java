package p6_4;

import java.util.Scanner;

public class PrimePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a max integer for primes: ");
        int number = scanner.nextInt();

        int currPrime = 2;
        PrimeGenerator pg = new PrimeGenerator(currPrime);

        while(currPrime <= number) {
            System.out.println(currPrime);
            currPrime = pg.nextPrime();
        }
    }
}
