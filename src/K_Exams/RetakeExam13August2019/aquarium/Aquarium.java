package K_Exams.RetakeExam13August2019.aquarium;

import java.util.LinkedHashMap;
import java.util.Map;

public class Aquarium {
    private Map<String, Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (fish != null && this.getFishInPool() < this.getCapacity()) {

            fishInPool.putIfAbsent(fish.getName(), fish);
        }
    }

    public boolean remove(String name) {
        if (name == null) {
            return false;
        }
        if (fishInPool.containsKey(name)) {
            fishInPool.remove(name);
            return true;
        }
        return false;
    }

    public Fish findFish(String name) {
        if (name == null){
            return null;
        }
        return this.fishInPool.get(name);
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(String.format("Aquarium: %s ^ Size: %d", this.getName(), this.getSize()));

        for (Fish fish : this.fishInPool.values()) {
            stringBuilder
                    .append(System.lineSeparator())
                    .append(fish.toString());
        }

        return stringBuilder.toString().trim();
    }
}
