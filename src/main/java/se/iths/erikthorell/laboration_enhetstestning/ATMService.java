package se.iths.erikthorell.laboration_enhetstestning;

import se.iths.erikthorell.laboration_enhetstestning.exception.InsufficientFundsException;
import se.iths.erikthorell.laboration_enhetstestning.exception.InvalidAmountException;
import se.iths.erikthorell.laboration_enhetstestning.exception.MaxWithdrawalExceededException;

public class ATMService {
    private final AccountComponent accountComponent;

    double maxWithdrawAmount = 2000.0;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void depositFunds(double amount) {
        if(amount > 0){
            accountComponent.deposit(amount);
        } else {
            throw new InvalidAmountException("Uttag måste överstiga 0kr");
        }
    }

    public void withdrawFunds(double amount) {
        if(amount <= 0){
            throw new InvalidAmountException("Uttag måste överstiga 0kr");
        } else if (amount > maxWithdrawAmount) {
            throw new MaxWithdrawalExceededException("Max per uttag: 2000kr");
        } else if (amount > accountComponent.getBalance()){
            throw new InsufficientFundsException("Otillräckligt saldo.");
        } else {
            accountComponent.withdraw(amount);
        }
    }

    public Double getBalance() {
        return accountComponent.getBalance();
    }
}
