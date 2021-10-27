package opgave1;

/**
 * Models a bank account.
 */
public class BankAccount {
    private double balance;

    /**
     * Initializes a new bank account with initial balance.
     * Pre: initialBalance >= 0
     *
     * @param initialBalance is the initial balance of the bank account
     */
    public BankAccount (double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Adds amount to the bank accounts balance.
     *
     * @param amount is the amount to be added
     */
    public void deposit (double amount) {
        this.balance += amount;
    }

    /**
     * Subtracts amount from the bank accounts balance.
     *
     * @param amount is the amount to be subtracted
     */
    public void withdraw (double amount) {
        this.balance -= amount;
    }

    /**
     * Returns the bank accounts balance.
     *
     * @return the bank accounts balance
     */
    public double getBalance () {
        return balance;
    }
}
