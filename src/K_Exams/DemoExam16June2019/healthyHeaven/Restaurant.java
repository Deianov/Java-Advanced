package K_Exams.DemoExam16June2019.healthyHeaven;

import java.util.Comparator;
import java.util.LinkedHashMap;

public class Restaurant {
    private String name;
    private LinkedHashMap <String, Salad> data;

    public Restaurant(String name) {
        this.name = name;
        this.data = new LinkedHashMap<>();
    }

    public void add(Salad salad) {
        if (salad == null)
            return;

        this.data.put(salad.getName().toLowerCase(), salad);
    }

    public boolean buy(String name) {

        if (this.data.containsKey(name.toLowerCase())) {
            this.data.remove(name.toLowerCase());
            return true;
        }
        return false;
    }

    public Salad getHealthiestSalad() {
        return data.values()
                .stream()
                .min(Comparator.comparingInt(Salad::getTotalCalories))
                .orElse(null);
    }

    public String generateMenu() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("%s have %d salads:", this.name, this.data.size()));
        for (Salad salad: data.values()) {
            stringBuilder.append(System.lineSeparator());
            stringBuilder.append(salad.toString());
        }
        return stringBuilder.toString().trim();
    }
}
