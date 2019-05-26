package F_DefiningClasses.Lab.D_BankAccount;

class CommandFactory {

    static Command createCommand(String name, String[] arguments) {
        Command result = null;

        int accountId;
        switch (name) {
            case CommandCreateAccount.NAME:
                result = new CommandCreateAccount();
                break;
            case CommandDeposit.NAME:
                accountId = Integer.parseInt(arguments[1]);
                double amount = Double.parseDouble(arguments[2]);
                result = new CommandDeposit(accountId, amount);
                break;
            case CommandGetInterest.NAME:
                accountId = Integer.parseInt(arguments[1]);
                int years = Integer.parseInt(arguments[2]);
                result = new CommandGetInterest(accountId, years);
                break;
            case CommandSetInterestRate.NAME:
                double interestRate = Double.parseDouble(arguments[1]);
                result = new CommandSetInterestRate(interestRate);
                break;
        }
        return result;
    }
}
