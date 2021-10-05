package p3_13;

public class BackAccountTester {
    public static void main(String[] args) {
        BankAccount bat = new BankAccount(10, 4.95);
        bat.deposit(1000);
        bat.withdraw(500);
        bat.printBalance();
        bat.addInterest(1000);
        bat.printBalance();

        for(int i=0; i<15; i++) bat.deposit(10);
        bat.printBalance();
        bat.deductMonthlyCharge();
        bat.printBalance();
    }
}
