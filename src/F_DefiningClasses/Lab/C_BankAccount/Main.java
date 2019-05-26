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

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();
        BankAccount bankAccount = null;

        while (!"End".equals(line = reader.readLine())) {

            String[] commandTokens = line.split("\\s+");

            if (commandTokens.length == 3) {
                bankAccount = bankAccounts.get(Integer.parseInt(commandTokens[1]));

                if (bankAccount == null) {
                    System.out.println("Account does not exist");
                    continue;
                }
            }

            switch (commandTokens[0]) {
                case "Create":
                    bankAccount = new BankAccount();
                    bankAccounts.put(bankAccount.getId(), bankAccount);
                    System.out.println(String.format("Account ID%d created", bankAccount.getId()));
                    break;
                case "Deposit":
                    double amount = Double.parseDouble(commandTokens[2]);
                    bankAccount.deposit(amount);
                    System.out.println(String.format("Deposited %.0f to ID%d", amount, bankAccount.getId()));
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(commandTokens[1]));
                    break;
                case "GetInterest":
                    System.out.println(String.format("%.2f", bankAccount.getInterest(Integer.parseInt(commandTokens[2]))));
                    break;
            }
        }
    }
}

class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;

    private static int bankAccountsCount = 0;
    private static double interestRate = DEFAULT_INTEREST;

    private int id;
    private double balance;

    BankAccount() {
       this.id = ++bankAccountsCount;
       this.balance = 0.0;
    }

    int getId() {
        return id;
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
        return String.format("ID%d", this.id);
    }
}
