//02. Company Roster
package F_DefiningClasses.Exercises.E02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        Department.init();

        while (lines-- > 0) {

            String[] data = reader.readLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            String email = null;
            Integer age = null;

            if (data.length == 6) {
                email = data[4];
                age = Integer.parseInt(data[5]);
            } else if (data.length == 5) {
                if (data[4].contains("@")) email = data[4];
                else age = Integer.parseInt(data[4]);
            }
            Department.add(new Employee(name, salary, position, department, email, age));
        }
        Department.printHighest();
    }
}

