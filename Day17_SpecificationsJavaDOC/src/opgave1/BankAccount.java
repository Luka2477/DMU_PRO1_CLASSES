package opgave1;

/**
 * Models a bank account.
 */
public class BankAccount {
    private double balance;
    private final int id;
    private static int idCount;

    /**
     * Initializes a new bank account with initial balance and generates an ID.
     * Pre: initialBalance >= 0
     *
     * @param initialBalance is the initial balance of the bank account
     */
    public BankAccount (double initialBalance) {
        this.balance = initialBalance;
        this.id = BankAccount.idCount;
        BankAccount.idCount++;
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
        return this.balance;
    }

    /**
     * Returns the bank accounts ID.
     *
     * @return the bank accounts ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the amount of bank accounts initialized.
     *
     * @return the amount of bank accounts initialized
     */
    public static int getIdCount() {
        return BankAccount.idCount;
    }
}
