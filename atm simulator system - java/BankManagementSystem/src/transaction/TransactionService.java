package transaction;

import account.Account;
import statement.MiniStatement;

public class TransactionService {

    public void deposit(Account acc, double amount) {
        acc.deposit(amount);
        MiniStatement.log(acc.getAccountNumber(), "Deposit", amount);
    }

    public boolean withdraw(Account acc, double amount) {
        boolean success = acc.withdraw(amount);
        if (success)
            MiniStatement.log(acc.getAccountNumber(), "Withdraw", amount);
        return success;
    }
}
