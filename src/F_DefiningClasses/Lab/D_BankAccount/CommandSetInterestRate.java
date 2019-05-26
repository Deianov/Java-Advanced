package F_DefiningClasses.Lab.D_BankAccount;

class CommandSetInterestRate extends Command {
    static final String NAME = "SetInterest";

    private final double interestRate;

    CommandSetInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void execute() {
        BankAccount.setInterestRate(this.interestRate);
    }
}
