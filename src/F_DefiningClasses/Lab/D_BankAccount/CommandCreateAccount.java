// package commands
package F_DefiningClasses.Lab.D_BankAccount;

class CommandCreateAccount extends Command {
    static final String NAME = "Create";

    @Override
    public void execute() {

        BankAccount bankAccount = new BankAccount();
        BankAccountStore.save(bankAccount);

        this.setOutput(String.format("Account ID%d created", bankAccount.getId()));
    }
}
