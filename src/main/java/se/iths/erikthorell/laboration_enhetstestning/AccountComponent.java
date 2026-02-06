package se.iths.erikthorell.laboration_enhetstestning;

public class AccountComponent {
    private double balance = 0.0;

    public void withdraw(double amount) {
        balance -= amount;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public double getBalance() {
        return balance;
    }
}
