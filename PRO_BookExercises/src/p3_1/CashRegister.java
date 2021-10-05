package p3_1;

/**
 A cash register totals up sales and computes change due.
 */
public class CashRegister {
    private double purchase;
    private double payment;
    private double itemCount;

    /**
     Constructs a cash register with no money in it.
     */
    public CashRegister() {
        this.purchase = 0;
        this.payment = 0;
        this.itemCount = 0;
    }

    /**
     Records the sale of an item.
     @param amount the price of the item
     */
    public void recordPurchase(double amount) {
        this.purchase = this.purchase + amount;
        this.itemCount++;
    }

    /**
     Processes a payment received from the customer.
     @param amount the amount of the payment
     */
    public void receivePayment(double amount) {
        this.payment = this.payment + amount;
    }

    /**
     Computes the change due and resets the machine for the next customer.
     @return the change due to the customer
     */
    public double giveChange() {
        double change = this.payment - this.purchase;
        this.purchase = 0;
        this.payment = 0;
        return change;
    }

    /**
     Returns the amount of items that have been purchased.
     @return the amount of items purchased
     */
    public double getItemCount() {
        return this.itemCount;
    }
}