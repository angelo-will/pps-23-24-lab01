import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccountWithAtm;

public class SimpleBankAccountWithAtmTest {
    private AccountHolder accountHolder;
    private BankAccount bankAccount;
    private double transactionFee = 1;
    private double initialDepositAmount = 100;

    @BeforeEach
    void beforeEach() {
        int accountId = 1;
        accountHolder = new AccountHolder("Mario", "Rossi", accountId);
        bankAccount = new SimpleBankAccountWithAtm(accountHolder, 0, this.transactionFee);
    }

    @Test
    void testInitialBalance() {
        assertEquals(0, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.getId(), this.initialDepositAmount);
        assertEquals(this.initialDepositAmount, bankAccount.getBalance());
    }

    @Test
    void testDepositWithAtm() {
        bankAccount.depositWithAtm(accountHolder.getId(), this.initialDepositAmount);
        assertEquals(this.initialDepositAmount - this.transactionFee, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int wrongUserID = 2;
        int withdrawAmount = 50;
        bankAccount.deposit(accountHolder.getId(), this.initialDepositAmount);
        bankAccount.deposit(wrongUserID, withdrawAmount);
        assertEquals(this.initialDepositAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {
        double withdrawAmount = 70;
        bankAccount.deposit(accountHolder.getId(), this.initialDepositAmount);
        bankAccount.withdraw(accountHolder.getId(), withdrawAmount);
        assertEquals(this.initialDepositAmount - withdrawAmount, bankAccount.getBalance());
    }

    @Test
    void testWithdrawWithATM(){
        double withdrawAmount = 50;
        int operationWithAtm = 2;
        bankAccount.depositWithAtm(accountHolder.getId(), this.initialDepositAmount);
        bankAccount.withdrawWithAtm(accountHolder.getId(), withdrawAmount);
        assertEquals(this.initialDepositAmount - withdrawAmount - this.transactionFee*operationWithAtm, this.bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        int wrongUserID = 2;
        int withdrawAmount = 70;
        bankAccount.deposit(accountHolder.getId(), this.initialDepositAmount);
        bankAccount.withdraw(wrongUserID, withdrawAmount);
        assertEquals(this.initialDepositAmount, bankAccount.getBalance());
    }
}
