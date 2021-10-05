package modelbank;

public class BankAccountTesterApp {
    public static void main(String[] args) {
        BankAccountTester bat = new BankAccountTester();
        bat.deposit(1000);
        bat.withdraw(500);
        bat.withdraw(400);
        bat.printBalance();
        bat.addInterest(10);
        bat.printBalance();
    }
}
