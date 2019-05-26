// package store
package F_DefiningClasses.Lab.D_BankAccount;

import java.util.HashMap;
import java.util.Optional;

class BankAccountStore {
    private static HashMap<Integer, BankAccount> accounts;

    static void initializeStore() {
        BankAccountStore.accounts = new HashMap<>();
    }

    static Optional<BankAccount> getById(int id) {
        BankAccount bankAccount = BankAccountStore.accounts.get(id);

        Optional<BankAccount> result = Optional.empty();
        if (bankAccount != null) {
            result = Optional.of(bankAccount);
        }

        return result;
    }

    static void save(BankAccount bankAccount) {
        BankAccountStore.accounts.put(bankAccount.getId(), bankAccount);
    }
}
