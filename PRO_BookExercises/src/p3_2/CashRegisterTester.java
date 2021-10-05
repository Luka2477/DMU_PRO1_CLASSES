package p3_2;

/**
    A class to test the CashRegister class.
 */
public class CashRegisterTester {
    public static void main(String[] args) {
        CashRegister register = new CashRegister(25);

        register.recordPurchase(29.50);
        register.recordPurchase(9.25);
        register.receivePayment(50);

        double change = register.giveChange();
        System.out.println(change);
        System.out.println("Expected: 1.5625");
        double itemCount = register.getItemCount();
        System.out.println(itemCount);
        System.out.println("Expected: 2.0");

    }
}