package account;

public class AccountFactory {

    public static Account createAccount(
            String type,
            String name,
            String fatherName,
            String cnic,
            boolean filer,
            String accNo,
            String pin) {

        if (type.equalsIgnoreCase("saving"))
            return new SavingAccount(name, fatherName, cnic, filer, accNo, pin);

        if (type.equalsIgnoreCase("current"))
            return new CurrentAccount(name, fatherName, cnic, filer, accNo, pin);

        return null;
    }
}
