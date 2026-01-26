package database;

import account.Account;
import java.io.*;
import java.util.HashMap;

public class DataStore {

    private static DataStore instance;
    private HashMap<String, Account> accounts;
    private final String FILE = "accounts.dat";

    private DataStore() {
        load();
    }

    public static DataStore getInstance() {
        if (instance == null)
            instance = new DataStore();
        return instance;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        save();
    }

    public Account getAccount(String accNo) {
        return accounts.get(accNo);
    }

    private void save() {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(accounts);
        } catch (Exception ignored) {}
    }

    private void load() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE))) {
            accounts = (HashMap<String, Account>) ois.readObject();
        } catch (Exception e) {
            accounts = new HashMap<>();
        }
    }
}
