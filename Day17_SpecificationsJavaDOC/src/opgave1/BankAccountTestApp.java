package opgave1;

/**
 * Models a bank account test application.
 */
public class BankAccountTestApp {
    /**
     * Main method that tests the bank account class.
     *
     * @param args string arguments the system passes to main method
     */
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount(1000);
        System.out.println(ba1.getId());

        System.out.println(BankAccount.getIdCount());

        BankAccount ba2 = new BankAccount(500);
        System.out.println(ba2.getId());

        System.out.println(BankAccount.getIdCount());

        System.out.println(ba1.getBalance());
        ba1.withdraw(ba2.getBalance());
        System.out.println(ba1.getBalance());

        ba2.deposit(250);
        System.out.println(ba2.getBalance());
    }
}
