package F_DefiningClasses.Lab.D_BankAccount;

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
        return this.id;
    }

    double getBalance() {
        return this.balance;
    }

    static void setInterestRate(double interestRate) {
       BankAccount.interestRate = interestRate;
    }

    static double getInterestRate() {
        return BankAccount.interestRate;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    double getInterest(int years) {
        return BankAccount.interestRate * this.balance * years;
    }
}
