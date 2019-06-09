package I_IteratorsAndComparators.Exercises.PetClinics;

import java.util.Iterator;
import java.util.stream.Stream;

class Rooms implements Iterable<Rooms.Room> {
    private Room[] rooms;

    Rooms(int roomsCount) {
        this.rooms = Stream.generate(Room::new).limit(roomsCount).toArray(Room[]::new);
    }

    int count() {
        return this.rooms.length;
    }
    String getRoom(int number) {
        return rooms[number].toString();
    }


    class Room{
        private Pet guest;

        Room() {
            this.guest = null;
        }

        void place(Pet guest) { this.guest = guest; }
        boolean isEmpty(){
            return this.guest == null;
        }

        @Override
        public String toString() {
            return this.isEmpty() ? "Room empty" : this.guest.toString();
        }
    }

    boolean hasEmptyRooms() {
        for (Room room : this.rooms) {
            if (room.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    boolean release() {
        int length = this.rooms.length;
        int index = length / 2;

        for (int i = 0; i < length; i++) {
            if (index == length) index = 0;

            if (!this.rooms[index].isEmpty()) {
                this.rooms[index].place(null);
                return true;
            }
            index++;
        }
        return false;
    }



    @Override
    public Iterator<Room> iterator() {
        return new Iterator<>() {
            int centerIndex = rooms.length / 2;
            int currentIndex = centerIndex;
            int steps = 0;
            boolean getRight = true;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0 && currentIndex < rooms.length;
            }

            @Override
            public Room next() {

                Room room = rooms[currentIndex];

                if (getRight) {
                    steps++;
                    getRight = false;
                } else {
                    getRight = true;
                }
                currentIndex = centerIndex + (steps * (getRight ? 1 : -1));

                return room;
            }
        };
    }
}
