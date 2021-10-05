package e5_7;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[3];
        for(int i=0; i<3; i++) {
            System.out.print("Please give me a number (-inf - inf): ");
            numbers[i] = scanner.nextInt();
        }

        String order;
        if(numbers[0] < numbers[1] && numbers[1] < numbers[2]) order = "increasing";
        else if(numbers[0] > numbers[1] && numbers[1] > numbers[2]) order = "decreasing";
        else order = "not in order";

        System.out.printf("Then numbers you gave are %s!%n", order);
    }
}
