package TP0.tests;


import TP0.BankAccount;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testValidDeposit() {
        BankAccount account = new BankAccount(100.0, 0.05);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testInvalidDeposit() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20.0));
    }

    @Test
    public void testValidWithdraw() {
        BankAccount account = new BankAccount(200.0, 0.05);
        account.withdraw(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawTooMuch() {
        BankAccount account = new BankAccount(50.0, 0.05);
        assertThrows(IllegalStateException.class, () -> account.withdraw(100.0));
    }

    @Test
    public void testNegativeWithdraw() {
        BankAccount account = new BankAccount(100.0, 0.05);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }

    @Test
    public void testValidTransfer() {
        BankAccount acc1 = new BankAccount(100.0, 0.05);
        BankAccount acc2 = new BankAccount(50.0, 0.05);
        acc1.transfer(30.0, acc2);
        assertEquals(70.0, acc1.getBalance(), 0.001);
        assertEquals(80.0, acc2.getBalance(), 0.001);
    }

    @Test
    public void testTransferToNull() {
        BankAccount acc1 = new BankAccount(100.0, 0.05);
        assertThrows(NullPointerException.class, () -> acc1.transfer(20.0, null));
    }

    @Test
    public void testTransferInsufficientBalance() {
        BankAccount acc1 = new BankAccount(20.0, 0.05);
        BankAccount acc2 = new BankAccount(50.0, 0.05);
        assertThrows(IllegalStateException.class, () -> acc1.transfer(50.0, acc2));
    }

    @Test
    public void testAddInterest() {
        BankAccount acc = new BankAccount(100.0, 0.10); // 10% interest
        acc.addInterest();
        assertEquals(110.0, acc.getBalance(), 0.001);
    }
}
