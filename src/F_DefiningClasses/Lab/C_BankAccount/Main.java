//03.Bank Account
package F_DefiningClasses.Lab.C_BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        HashMap<String, BankAccount> bankAccounts = new HashMap<>();
        BankAccount bankAccount;

        while (!"End".equals(line = reader.readLine())) {

            String[] commandToken = line.split("\\s+");
            String id;
            double amount;

            switch (commandToken[0]) {
                case "Create" :
                    bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.toString(), bankAccount);
                    System.out.println(String.format("Account %s created", bankAccount.toString()));
                    break;
                case "Deposit":
                    id = commandToken[1];
                    amount = Double.parseDouble(commandToken[2]);

                    if (bankAccounts.containsKey("ID" + id)) {
                        bankAccount = bankAccounts.get("ID" + id);
                        bankAccount.deposit(amount);
                        System.out.println(String.format("Deposited %.2f to %s", amount, bankAccount.toString()));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(commandToken[1]));
                    break;
                case "GetInterest":
                    id = commandToken[1];

                    if (bankAccounts.containsKey("ID" + id)) {
                       int years = Integer.parseInt(commandToken[2]);
                        System.out.println(String.format("%.2f", bankAccounts.get("ID" + id).getInterest(years)));
                    } else {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
}

class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private static int bankAccountsCount = 1;
    private static double interestRate = DEFAULT_INTEREST;

    private int id;
    private double balance;

    BankAccount() {
       this.id = bankAccountsCount++;
       this.balance = 0.0;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterest(int years) {
        return BankAccount.interestRate * this.balance * years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
