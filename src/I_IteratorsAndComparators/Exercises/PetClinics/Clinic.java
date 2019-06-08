package I_IteratorsAndComparators.Exercises.PetClinics;

import java.util.HashMap;
import java.util.Map;

public class Clinic {
    public static Map<String, Clinic> collection = new HashMap<>();

    private String name;
    private Rooms rooms;

    public Clinic(String name, int roomsCount) {
        if (roomsCount % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.name = name;
        this.rooms = new Rooms(roomsCount);

        Clinic.collection.put(name, this);
    }

    public Rooms getRooms() {
        return this.rooms;
    }

    public boolean addGuest(String petName) {

        Pet pet = Pet.collection.get(petName);

        for (Rooms.Room room : this.rooms) {
            if (room.isEmpty()) {
                room.place(pet);
                return true;
            }
        }
        return false;
    }

    public void print(Integer roomNumber) {

        if (roomNumber == null) {
            for (int i = 0; i < this.rooms.count(); i++) {
                System.out.println(this.rooms.getRoom(i));
            }
        } else {
            System.out.println(this.rooms.getRoom(roomNumber - 1));
        }
    }
}
