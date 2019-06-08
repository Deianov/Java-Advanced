//08. Pet Clinics
package I_IteratorsAndComparators.Exercises.PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {

            String[] data = reader.readLine().split("\\s+");

            switch (data[0]) {
                case "Create" :
                    switch (data[1]) {
                        case "Pet":
                            new Pet(data[2], Integer.parseInt(data[3]), data[4]);
                            break;
                        case "Clinic":
                            try {
                                new Clinic(data[2], Integer.parseInt(data[3]));
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                    break;
                case "Add" :
                    System.out.println(Clinic.collection.get(data[2]).addGuest(data[1]));
                    break;
                case "Release" :
                    System.out.println(Clinic.collection.get(data[1]).getRooms().release());
                    break;
                case "HasEmptyRooms" :
                    System.out.println(Clinic.collection.get(data[1]).getRooms().hasEmptyRooms());
                    break;
                case "Print" :
                    Clinic.collection.get(data[1]).print(data.length > 2 ? Integer.parseInt(data[2]) : null);
                    break;
            }
        }
    }
}
