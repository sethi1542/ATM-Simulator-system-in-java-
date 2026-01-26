package auth;

import account.Account;
import account.AccountFactory;
import database.DataStore;
import util.AccountNumberGenerator;

public class AuthService {

    private DataStore store = DataStore.getInstance();

    public Account login(String accNo, String pin) {
        Account acc = store.getAccount(accNo);
        if (acc != null && acc.getPin().equals(pin))
            return acc;
        return null;
    }

    public Account register(
            String name,
            String fatherName,
            String cnic,
            boolean filer,
            String type,
            String pin) {

        String accNo = AccountNumberGenerator.generate();
        Account acc = AccountFactory.createAccount(
                type, name, fatherName, cnic, filer, accNo, pin);

        store.addAccount(acc);
        return acc;
    }
}
