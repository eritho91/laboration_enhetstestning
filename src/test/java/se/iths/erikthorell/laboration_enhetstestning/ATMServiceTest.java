package se.iths.erikthorell.laboration_enhetstestning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.iths.erikthorell.laboration_enhetstestning.exception.InsufficientFundsException;
import se.iths.erikthorell.laboration_enhetstestning.exception.InvalidAmountException;
import se.iths.erikthorell.laboration_enhetstestning.exception.MaxWithdrawalExceededException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {
    @Mock
    AccountComponent mockAccount;

    @InjectMocks
    ATMService atmService;

    @Test
    void testInvalidAmountException(){
        when(mockAccount.getBalance()).thenReturn(100.0);

        assertThrows(
                InvalidAmountException.class,
                () -> atmService.withdrawFunds(0.0)
        );
    }

    @Test
    void testMaxWithdrawalExceededException(){

        assertThrows(
                MaxWithdrawalExceededException.class,
                () -> atmService.withdrawFunds(2500.0)
        );
    }

    @Test
    void testInsufficientFundsException(){
        when(mockAccount.getBalance()).thenReturn(100.0);

        assertThrows(
                InsufficientFundsException.class,
                () -> atmService.withdrawFunds(150.0)
        );
    }

    @Test
    void testValidDeposit(){
        assertDoesNotThrow(() -> atmService.depositFunds(500.0));
    }

    @Test
    void testValidWithdraw(){
        when(mockAccount.getBalance()).thenReturn(1000.0);

        assertDoesNotThrow(() -> atmService.withdrawFunds(500.0));

        verify(mockAccount).withdraw(500.0);
    }

    @Test
    void testGetBalance(){
        when(mockAccount.getBalance()).thenReturn(1000.0);

        assertEquals(1000.0, atmService.getBalance());
    }


}
