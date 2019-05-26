package F_DefiningClasses.Lab.D_BankAccount;

import java.util.NoSuchElementException;
import java.util.Optional;

class CommandGetInterest extends Command {
    static final String NAME = "GetInterest";

    private final int accountId;
    private final int years;

    CommandGetInterest(int accountId, int years) {
        this.accountId = accountId;
        this.years = years;
    }

    @Override
    public void execute() {
        Optional<BankAccount> account = BankAccountStore.getById(this.accountId);

        try {
            double accountInterest = account.get().getInterest(years);

            this.setOutput(String.format("%.2f", accountInterest));
        } catch (NoSuchElementException e) {
            this.setOutput(MISSING_ACCOUNT_MESSAGE);
        }
    }
}
