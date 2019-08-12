package K_Exams.Exam23June2019.spaceStationRecruitment;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class SpaceStation {
    private Map<String, Astronaut> data;
    private String name;
    private int capacity;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount(){
        return this.data.size();
    }

    public void add(Astronaut astronaut){
        if (astronaut != null && this.getCount() < this.getCapacity()){
            data.putIfAbsent(astronaut.getName(), astronaut);
        }
    }

    public boolean remove(String name){
        if(name == null){
            return false;
        }
        if (data.containsKey(name)){
            this.data.remove(name);
            return true;
        }
        return false;
    }

    public Astronaut getOldestAstronaut(){
        return data.values().stream().max(Comparator.comparingInt(Astronaut::getAge)).orElse(null);
    }

    public Astronaut getAstronaut(String name){
        if(name == null){
            return null;
        }
        return data.get(name);
    }

    public String report(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Astronauts working at Space Station %s:", this.name));
        this.data.values().forEach(a -> stringBuilder
                .append(System.lineSeparator())
                .append(a.toString())
        );
        return stringBuilder.toString().trim();
    }
}
