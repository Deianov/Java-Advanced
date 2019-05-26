package F_DefiningClasses.Lab.D_BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        BankAccountStore.initializeStore();

        while (!"End".equals(line = reader.readLine())) {

            String[] lineArguments = line.split(" ");
            String commandName = lineArguments[0];

            Command command = CommandFactory.createCommand(commandName, lineArguments);

            if (command == null) {
                continue;
            }

            command.execute();
            String result = command.getOutput();

            if (result != null) {
                System.out.println(result);
            }
        }
    }
}
