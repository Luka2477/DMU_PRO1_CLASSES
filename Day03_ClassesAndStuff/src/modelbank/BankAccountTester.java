package modelbank;

public class BankAccountTester {
    private double balance = 0;

    public void deposit(double amount) { balance += amount; }
    public void withdraw(double amount) { balance -= amount; }

    public void addInterest(double rate) { balance *= 1 + rate * 0.01; }

    public void printBalance() { System.out.println(balance); }
}
