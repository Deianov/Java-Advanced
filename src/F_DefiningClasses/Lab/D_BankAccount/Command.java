package F_DefiningClasses.Lab.D_BankAccount;

abstract class Command implements Executable {
    static final String MISSING_ACCOUNT_MESSAGE = "Account does not exist";

    private String output;

    @Override
    public String getOutput() {
        return this.output;
    }

    void setOutput(String output) {
        this.output = output;
    }
}
