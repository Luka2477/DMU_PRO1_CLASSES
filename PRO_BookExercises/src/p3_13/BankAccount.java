package p3_13;

public class BankAccount {
    private double balance = 0;
    final private int monthlyCharges;
    private int monthlyChargesLeft;
    final private double chargeFee;
    private double charge = 0;

    public BankAccount(int monthlyCharges, double chargeFee) {
        this.monthlyCharges = monthlyCharges;
        this.monthlyChargesLeft = this.monthlyCharges;
        this.chargeFee = chargeFee;
    }

    private void calculateCharge() {
        if(this.monthlyChargesLeft > 0) this.monthlyChargesLeft--;
        else this.charge += this.chargeFee;
    }

    public void deposit(double amount) { this.balance += amount; this.calculateCharge(); }
    public void withdraw(double amount) { this.balance -= amount; this.calculateCharge(); }

    public void deductMonthlyCharge() {
        this.balance -= this.charge;
        this.charge = 0;
        this.monthlyChargesLeft = this.monthlyCharges;
    }

    public void addInterest(double rate) { this.balance *= 1 + rate * 0.01; }

    public void printBalance() { System.out.println(this.balance); }
}
