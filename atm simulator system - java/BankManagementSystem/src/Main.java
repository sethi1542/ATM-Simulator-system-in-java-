import auth.AuthService;
import account.Account;
import transaction.TransactionService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();
        TransactionService ts = new TransactionService();

        while (true) {
            System.out.println("\n----------------INFINITY WARFARE CODING PRESENTS----------------");
            System.out.println("\n----------------BANK / ATM MANAGEMENT SYSTEM----------------");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Account No: ");
                String accNo = sc.next();
                System.out.print("PIN: ");
                String pin = sc.next();

                Account acc = auth.login(accNo, pin);

                if (acc == null) {
                    System.out.println("Invalid Credentials");
                    continue;
                }

                while (true) {
                    System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.Logout");
                    int ch = sc.nextInt();

                    if (ch == 1) {
                        System.out.print("Amount: ");
                        ts.deposit(acc, sc.nextDouble());
                    }
                    else if (ch == 2) {
                        System.out.print("Amount: ");
                        if (!ts.withdraw(acc, sc.nextDouble()))
                            System.out.println("Insufficient Balance");
                    }
                    else if (ch == 3) {
                        System.out.println("Balance: " + acc.getBalance());
                    }
                    else break;
                }
            }

            else if (choice == 2) {
                System.out.print("Name: ");
                String name = sc.next();

                System.out.print("Father Name: ");
                String fatherName = sc.next();

                System.out.print("CNIC (13 digits): ");
                String cnic = sc.next();

                System.out.print("Filer? (yes/no): ");
                boolean filer = sc.next().equalsIgnoreCase("yes");

                System.out.print("Account Type (saving/current): ");
                String type = sc.next();

                System.out.print("Set PIN: ");
                String pin = sc.next();

                Account acc = auth.register(name, fatherName, cnic, filer, type, pin);

                System.out.println("Account Successfully Created");
                System.out.println("Your Account Number: " + acc.getAccountNumber());

            }

            else System.out.println("THANKS FOR CHOOSING OUR BANK / ATM :) ALLAH HAFIZ ");
            break;
        }
    }
}
