package p6_2;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer representing the nth Fibonacci number (3-inf): ");
        int number = scanner.nextInt();

        long fibo1 = 1;
        long fibo2 = 1;
        for(int i=2; i<number; i++) {
            long nextFibo = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = nextFibo;
        }

        System.out.println(fibo2);
    }
}
