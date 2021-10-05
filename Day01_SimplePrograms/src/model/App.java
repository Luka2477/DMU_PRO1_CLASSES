package model;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        E1_1();
        E1_2();
        E1_3();
        E1_4();
        E1_5();
        E1_6();
        E1_8();
        E1_10();
        E1_11();
        E1_12();
        E1_13();
        E1_14();
        E1_15();
        E1_16();
        P1_1(10, 3);
        P1_2(25, 3, 119000, 120000);
        P1_3();
    }

    private static void E1_1() {
        System.out.println("Hej med dig min ven!");
    }

    private static void E1_2() {
        System.out.println(1+2+3+4+5+6+7+8+9+10);
    }

    private static void E1_3() {
        System.out.println(2*3*4*5*6*7*8*9*10);
    }

    private static void E1_4() {
        int balance = 1000;
        for(int i=0; i<3; i++) {
            balance *= 1.05;
            System.out.println("After " + i + " years, your balance will be " + balance);
        }
    }

    private static void E1_5() {
        System.out.println("+------+");
        System.out.println("| Dave |");
        System.out.println("+------+");
    }

    private static void E1_6() {
        System.out.println("*      *   *  *   *      *      *****");
        System.out.println("*      *   *  * *       * *     *    ");
        System.out.println("*      *   *  *        *****    *****");
        System.out.println("*      *   *  * *     *     *       *");
        System.out.println("*****  *****  *   *  *       *  *****");
    }

    private static void E1_8() {
        System.out.println("  \\\\\\\\\\  ");
        System.out.println(" +-----+ ");
        System.out.println("(| 0 0 |)");
        System.out.println(" |  ^  | ");
        System.out.println(" | vvv | ");
        System.out.println(" +-----+ ");
    }

    private static void E1_10() {
        System.out.println("   +   ");
        System.out.println("  + +  ");
        System.out.println(" +   + ");
        System.out.println("+-----+");
        System.out.println("| .-. |");
        System.out.println("| | | |");
        System.out.println("+-+-+-+");
    }

    private static void E1_11() {
        System.out.println(" /\\_/\\     -------");
        System.out.println("( ' ' )  /  Hello  \\");
        System.out.println("(  -  ) <   there   |");
        System.out.println(" | | |   \\ Mister! /");
        System.out.println("(__|__)    -------");
    }

    private static void E1_12() {
        System.out.println("Limitless");
        System.out.println("Lasse Ploughstrup");
        System.out.println("Berta Vázquez de Zubiaurre");
    }

    private static void E1_13() {
        System.out.println("Den som aldrig");
        System.out.println("lever nu,     ");
        System.out.println("lever aldrig -");
        System.out.println("hvad gør du?  ");
    }

    private static void E1_14() {
        System.out.println("******=========");
        System.out.println("******=========");
        System.out.println("******=========");
        System.out.println("===============");
        System.out.println("===============");
    }

    private static void E1_15() {
        JOptionPane.showMessageDialog(null, "Hello, Lukas!");
    }

    private static void E1_16() {
        String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showMessageDialog(null, "Hello " + name + "!");
    }

    private static void P1_1(double distance, double ticket_price) {
        double gas_price = 4;
        double maintenance_price = 0.05;
        double driving_price = distance * gas_price + distance * maintenance_price;

        if(driving_price < ticket_price) {
            System.out.println("Driving is cheaper! Cheaper by " + (ticket_price - driving_price));
        } else if(ticket_price < driving_price) {
            System.out.println("Taking the train is cheaper! Cheaper by " + (driving_price - ticket_price));
        } else {
            System.out.println("It's actually exactly the same price! WOW!");
        }
    }

    private static void P1_2(double distance, int working_days, double odometer_start, double odometer_end) {
        double distance_driven_to_work = distance * 2 * working_days;
        double distance_driven_outside_of_work = odometer_end - odometer_start - distance_driven_to_work;

        if(distance_driven_to_work < distance_driven_outside_of_work) {
            System.out.println("You have driven " + (distance_driven_outside_of_work - distance_driven_to_work) + " miles more outside of work!");
        } else if(distance_driven_outside_of_work < distance_driven_to_work) {
            System.out.println("You have driven " + (distance_driven_to_work - distance_driven_outside_of_work) + " miles more to work!");
        } else {
            System.out.println("You've driving the exact same amount out of work as in work.");
        }
    }

    private static void P1_3() {
        double pi_over_four = 3.14159265359 / 4;

        double pi_approximate = 1.00000000000;
        double denominator = -3;
        while((long)(pi_over_four * Math.pow(10, 6)) != (long)(pi_approximate * Math.pow(10, 6))) {
            pi_approximate += (1 / denominator);
            denominator *= -1;
            denominator += (denominator < 0) ? -2 : 2;
        }

        System.out.println("Approximate: " + (pi_approximate * 4));
    }
}











