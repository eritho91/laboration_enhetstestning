package se.iths.erikthorell.laboration_enhetstestning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {
    AccountComponent accountComponent;

    @BeforeEach
    void setUp() {
        accountComponent = new AccountComponent();
    }

    @Test
    void testInitBalance() {
        assertEquals(0.0, accountComponent.getBalance());
    }

    @Test
    void testDepositIncreasesBalance(){
        accountComponent.deposit(100);
        assertEquals(100.0, accountComponent.getBalance());
    }

    @Test
    void testDepositAndWithdraw(){
        accountComponent.deposit(100);
        accountComponent.withdraw(75);
        assertEquals(25.0, accountComponent.getBalance());
    }

    @Test
    void testWithdrawDecreasesBalance(){
        accountComponent.withdraw(100);
        assertEquals(-100.0, accountComponent.getBalance());
    }
}
